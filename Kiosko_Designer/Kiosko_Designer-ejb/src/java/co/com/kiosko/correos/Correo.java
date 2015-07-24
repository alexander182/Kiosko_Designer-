package co.com.kiosko.correos;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Correo {

    public boolean enviarCorreo(String correoOrigen, String claveCorreoOrigen, String destinatarios, String destinatariosCopia, String destinatariosCopiaOculta, Properties propiedadesConexion, String mensaje, FileDataSource archivoAdjunto, String asunto) {
        try {
            // Preparamos la sesion
            Session session = Session.getDefaultInstance(propiedadesConexion);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoOrigen));
            MimeMultipart multiParte = new MimeMultipart();

            if (destinatarios != null) {
                String destinoCorreo[];
                destinoCorreo = destinatarios.split(",");
                Address[] receptores = new Address[destinoCorreo.length];
                int l = 0;
                while (l < destinoCorreo.length) {
                    receptores[l] = new InternetAddress(destinoCorreo[l]);
                    l++;
                }
                message.addRecipients(Message.RecipientType.TO, receptores);
            }
            if (destinatariosCopia != null) {
                String destinoCopia[];
                destinoCopia = destinatariosCopia.split(",");
                Address[] receptoresCopia = new Address[destinoCopia.length];
                int l = 0;
                while (l < destinoCopia.length) {
                    receptoresCopia[l] = new InternetAddress(destinoCopia[l]);
                    l++;
                }
                message.addRecipients(Message.RecipientType.CC, receptoresCopia);
            }
            if (destinatariosCopiaOculta != null) {
                String destinoCopiaOculta[];
                destinoCopiaOculta = destinatariosCopiaOculta.split(",");
                Address[] receptoresOcultos = new Address[destinoCopiaOculta.length];
                int k = 0;
                while (k < destinoCopiaOculta.length) {
                    receptoresOcultos[k] = new InternetAddress(destinoCopiaOculta[k]);
                    k++;
                }
                message.addRecipients(Message.RecipientType.BCC, receptoresOcultos);
            }
            //PRUEBA ENVIAR ARCHIVOS ADJUNTOS
            BodyPart texto = new MimeBodyPart();
            if (mensaje != null) {
                texto.setText(mensaje);
                multiParte.addBodyPart(texto);
            }
            if (archivoAdjunto != null) {
                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(new DataHandler(archivoAdjunto));
                adjunto.setFileName(archivoAdjunto.getFile().getName());
                multiParte.addBodyPart(adjunto);
            }

            // Construimos el mensaje
            //direcciones de email a quienes se enviar el correo electronico
            //receptores.
            if (asunto != null) {
                message.setSubject(asunto);
            } else {
                message.setSubject("Sin Asunto");
            }
            message.setContent(multiParte);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(correoOrigen, claveCorreoOrigen);
            if (destinatarios != null) {
                System.out.println("PASA 0");
                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                System.out.println("PASA 1");
                //Transport.send(message, message.getRecipients(Message.RecipientType.TO));
            }
            if (destinatariosCopia != null) {
                t.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
            }
            if (destinatariosCopiaOculta != null) {
                t.sendMessage(message, message.getRecipients(Message.RecipientType.BCC));
            }
            // Cierre de la conexion.
            t.close();

            return true;
        } catch (MessagingException e) {
            System.out.println("Error enviarCorreo: " + e);
            return false;
        }
    }
}
