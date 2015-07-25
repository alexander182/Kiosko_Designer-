package co.com.kiosko.controlador;

import co.com.kiosko.administrarInterface.AdministrarClaveInterface;
import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Empleados;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ControladorClave implements Serializable {

    @EJB
    private AdministrarClaveInterface administrarClave;

    private Empleados empleado;
    private Conexioneskioskos conexionEmpleado;
    private String clave;
    private String confirmacionClave;

    public ControladorClave() {
        this.conexionEmpleado = new Conexioneskioskos();
    }

    @PostConstruct
    public void init() {

    }

    public void obtenerEmpleado(Empleados empleadoLogueado) {
        this.empleado = empleadoLogueado;
        this.conexionEmpleado = administrarClave.obtenerEmpleado(empleado.getSecuencia());
    }

    public void registrarClave() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        if (clave.equals(confirmacionClave)) {
            conexionEmpleado.setPwd(administrarClave.encriptarClaveUsuario(clave));
            if (administrarClave.crearClaveUsuario(conexionEmpleado)) {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La clave fue generada con exito. ", ""));
            } else {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La clave no fue generada con exito. ", ""));
            }
        } else {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las claves no coinciden. ", ""));
        }
    }

    public Date obtenerUltimoDiaMes(Date fecha) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();

    }

    public Date obtenerPrimerDiaMes(Date fecha) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();

    }

    public AdministrarClaveInterface getAdministrarClave() {
        return administrarClave;
    }

    public void setAdministrarClave(AdministrarClaveInterface administrarClave) {
        this.administrarClave = administrarClave;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Conexioneskioskos getConexionEmpleado() {
        return conexionEmpleado;
    }

    public void setConexionEmpleado(Conexioneskioskos conexionEmpleado) {
        this.conexionEmpleado = conexionEmpleado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConfirmacionClave() {
        return confirmacionClave;
    }

    public void setConfirmacionClave(String confirmacionClave) {
        this.confirmacionClave = confirmacionClave;
    }

}
