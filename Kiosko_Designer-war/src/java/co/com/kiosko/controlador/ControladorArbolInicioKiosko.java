/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.controlador;

import co.com.kiosko.administrarInterface.AdministrarInicioKioskoInterface;
import co.com.kiosko.correos.Correo;
import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Correosconexiones;
import co.com.kiosko.entidades.Empleados;
import co.com.kiosko.entidades.Opcioneskioskos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Properties;
import javax.activation.FileDataSource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class ControladorArbolInicioKiosko implements Serializable {

    @EJB
    private AdministrarInicioKioskoInterface administrarInicioKiosko;

    private TreeNode opcionesKiosko;
    private TreeNode opcionSeleccionada;
    private Opcioneskioskos opcionActual;
    private Empleados empleado;
    private String rutaArchivoSalida;
    private StreamedContent reporte;
    private String cabezeraVisor;
    private boolean habilitarEnviarCorreo;
    private Conexioneskioskos conexionEmpleado;

    public void iniciarOpcionesKiosko(Empleados empleadoLogueado) {

        opcionesKiosko = administrarInicioKiosko.obtenerArbol(empleadoLogueado.getEmpresa().getSecuencia());

        conexionEmpleado = administrarInicioKiosko.obtenerEmpleadoConexionesKioskos(empleadoLogueado.getSecuencia());

        this.empleado = empleadoLogueado;
    }

    public void asignarOpcionActual() {
        opcionActual = (Opcioneskioskos) opcionSeleccionada.getData();
    }

    public void ejecutarOpcion() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        if (opcionActual != null) {
            if (opcionActual.getClase().equals("REPORTE")) {
                rutaArchivoSalida = administrarInicioKiosko.generarReporte(opcionActual.getNombrearchivo(), "PDF", empleado.getSecuencia());
                System.out.println("rutaArchivoSalida" + rutaArchivoSalida);
                if (rutaArchivoSalida != null) {
                    validarDescargaReporte();
                    if (conexionEmpleado.getEnviocorreo().equals("S")) {

                        Correosconexiones conexion = administrarInicioKiosko.obtenerConfiguracionServidorCorreo(empleado.getEmpresa().getSecuencia());
                        if (conexion != null) {
                            Correo correo = new Correo();
                            Properties propiedadesConexion = new Properties();
                            propiedadesConexion.setProperty("mail.smtp.host", conexion.getSmtpHost());
                            propiedadesConexion.setProperty("mail.smtp.starttls.enable", "true");
                            propiedadesConexion.setProperty("mail.smtp.port", conexion.getSmtpPuerto());
                            propiedadesConexion.setProperty("mail.smtp.auth", "true");
                            propiedadesConexion.setProperty("mail.smtp.ssl.trust", "*");

                            if (correo.enviarCorreo(conexion.getSmtpUsuario(), conexion.getSmtpContrasena(), conexionEmpleado.getDirigidoa(), null, null, propiedadesConexion, null, new FileDataSource(rutaArchivoSalida), null)) {
                                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correo enviado exitosamente.", ""));
                            } else {
                                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo no pudo ser enviado.", ""));
                            }
                            rutaArchivoSalida = null;
                        } else {

                        }
                    }

                }
            } else {
            }

            RequestContext.getCurrentInstance().update("Inicio-Kiosko:growl");

        }

    }

    public void validarDescargaReporte() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("generandoReporte.hide();");
        if (rutaArchivoSalida != null && !rutaArchivoSalida.startsWith("Error:")) {
            FileInputStream fis;
            try {
                fis = new FileInputStream(new File(rutaArchivoSalida));
                reporte = new DefaultStreamedContent(fis, "application/pdf");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getCause());
                reporte = null;
            }
            if (reporte != null) {
                cabezeraVisor = "Reporte - " + opcionActual.getDescripcion();
                context.update("formularioDialogos:verReportePDF");
                context.execute("verReportePDF.show();");
            }
            if (conexionEmpleado.getEnviocorreo().equals("N")) {
                rutaArchivoSalida = null;
            }
        } else {
            context.update("formularioDialogos:errorGenerandoReporte");
            context.execute("errorGenerandoReporte.show();");
        }
    }

    public void reiniciarStreamedContent() {
        reporte = null;
    }

    public Conexioneskioskos getConexionEmpleado() {
        return conexionEmpleado;
    }

    public void setConexionEmpleado(Conexioneskioskos conexionEmpleado) {
        this.conexionEmpleado = conexionEmpleado;
    }

    public boolean isHabilitarEnviarCorreo() {

        return habilitarEnviarCorreo;
    }

    public void setHabilitarEnviarCorreo(boolean habilitarEnviarCorreo) {
        this.habilitarEnviarCorreo = habilitarEnviarCorreo;
        if (habilitarEnviarCorreo) {
            conexionEmpleado.setEnviocorreo("S");

        } else {
            conexionEmpleado.setEnviocorreo("N");

        }

    }

    public String getRutaArchivoSalida() {
        return rutaArchivoSalida;
    }

    public StreamedContent getReporte() {
        return reporte;
    }

    public void setReporte(StreamedContent reporte) {
        this.reporte = reporte;
    }

    public String getCabezeraVisor() {
        return cabezeraVisor;
    }

    public void setCabezeraVisor(String cabezeraVisor) {
        this.cabezeraVisor = cabezeraVisor;
    }

    public TreeNode getOpcionesKiosko() {
        return opcionesKiosko;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public TreeNode getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(TreeNode opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public Opcioneskioskos getOpcionActual() {
        return opcionActual;
    }

}
