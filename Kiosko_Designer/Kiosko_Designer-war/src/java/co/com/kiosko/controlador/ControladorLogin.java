package co.com.kiosko.controlador;

import co.com.kiosko.administrarInterface.AdministrarLoginInterface;
import co.com.kiosko.entidades.Empleados;
import co.com.kiosko.entidades.Empresas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class ControladorLogin implements Serializable {

    @EJB
    private AdministrarLoginInterface administrarLogin;
    // Simple user database :)
    private Long username;
    private String password;

    private boolean loggedIn;

    private Empleados empleadoLogueado;

    /**
     * La lista de todas las empresas
     */
    private List<Empresas> listaEmpresas;

    /**
     * La empresa seleccionada en el "selectOneMenu"
     */
    private BigDecimal empreseaSeleccionada;

    @PostConstruct
    public void init() {
        listaEmpresas = administrarLogin.obtenerEmpresas();
        empreseaSeleccionada = null;
    }

    public void doLogin() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Si se digito el nombre de usuario (codigo empleado) y la contraseña...

        if (username != null && username != 0 && password != null && !password.isEmpty() && empreseaSeleccionada != null) {

            //Obtener los empleados segun el codigo del empleado
            empleadoLogueado = administrarLogin.validarEmpleado(username, empreseaSeleccionada);
            if (empleadoLogueado != null) {

                //EMPLEADO EXISTE Y ESTA EN LA EMPRESA SELECCIONADA
                if (administrarLogin.validarPrimerIngreso(empleadoLogueado.getSecuencia())) {
                    if (empleadoLogueado.getCodigoempleado().compareTo(new Long(password))== 0) {
                        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido " + empleadoLogueado.getPersona().getNombre() + ".", ""));
                        RequestContext.getCurrentInstance().execute("informacionPrimerIngreso.show()");
                    } else {

                        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La contraseña es incorrecta", ""));

                    }

                } else {

                    if (administrarLogin.validarEmpleadoClave(password, empleadoLogueado.getSecuencia())) {
                        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido " + empleadoLogueado.getPersona().getNombre() + ".", ""));
                        RequestContext.getCurrentInstance().execute("irInicioKiosko();");

                    } else {

                        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La contraseña es incorrecta", ""));
                    }
                }
            } else {

                //EMPLEADO NO EXISTE O NO CORRESPONDE A LA EMPRESA SELECCIONADA
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El empleado no existe o no corresponde a la empresa seleccionada. ", ""));

            }

            //EMPLEADO INGRESA POR PRIMERA VEZ Y TIENE QUE REGISTRAR SU CONTRASEÑA EN PREGUNTASKIOSKOS
        } else {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Existen campos obligatorios vacios. ", ""));
        }
    }

    public String doLogout() {
        // Cuando el logueo no es correcto 
        loggedIn = false;

        // mensaje de error
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        empreseaSeleccionada = null;

        return "login";
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Empresas> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresas> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public BigDecimal getEmpreseaSeleccionada() {
        return empreseaSeleccionada;
    }

    public void setEmpreseaSeleccionada(BigDecimal empreseaSeleccionada) {
        this.empreseaSeleccionada = empreseaSeleccionada;
    }

    public Empleados getEmpleadoLogueado() {
        return empleadoLogueado;
    }

}
