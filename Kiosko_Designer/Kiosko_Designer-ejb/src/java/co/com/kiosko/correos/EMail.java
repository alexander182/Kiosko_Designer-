package co.com.kiosko.correos;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EMail {

    private String from;
    private String[] to;
    private String subject;
    private String text;

    public EMail(String from, String[] to, String subject, String text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public void send(String host, String port, String userName, String password, boolean starttls) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");

        if (starttls) {
            props.put("mail.smtp.starttls.enable", "true");
        }
        Session mailSession = null;
        try {
            mailSession = Session.getInstance(props, new SMTPAuthenticator(userName, password));
        } catch (Exception ex) {
            throw ex;
        }
        Message simpleMessage = new MimeMessage(mailSession);
        InternetAddress fromAddress = null;
        InternetAddress[] toAddress = new InternetAddress[to.length];
        try {
            fromAddress = new InternetAddress(from);
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
        } catch (AddressException ex) {
            throw ex;
        }
        try {
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipients(RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);

            // contentPart is the content to be sent. It is divided in bodyContent and attachmentContent
            MimeMultipart contentPart = new MimeMultipart("mixed");
            // Message body in txt and html format
            MimeMultipart bodyPart = new MimeMultipart("alternative");
            // Creates html message
            BodyPart bodyHtml = new MimeBodyPart();
            bodyHtml.setContent(text, "text/html");
//            bodyPart.addBodyPart(bodyTxt);
            bodyPart.addBodyPart(bodyHtml);

            // Wrapper for bodyTxt and bodyHtml
            MimeBodyPart bodyContent = new MimeBodyPart();
            bodyContent.setContent(bodyPart);

            // At this point, contentPart contains bodyTxt and bodyHtml wrapped in a multipart/alternative
            contentPart.addBodyPart(bodyContent);

            simpleMessage.setContent(contentPart);
            Transport.send(simpleMessage);
            for (String t : to) {
                System.out.println("Mensaje enviado a " + t);
            }
        } catch (MessagingException ex) {
            throw new Exception("Por favor verifique los datos digitados");
        }
    }
}

class SMTPAuthenticator extends Authenticator {

    private String userName, password;

    public SMTPAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }

}
