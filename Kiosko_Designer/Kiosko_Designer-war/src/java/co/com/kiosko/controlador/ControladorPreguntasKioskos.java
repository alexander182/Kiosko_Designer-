package co.com.kiosko.controlador;

import co.com.kiosko.administrarInterface.AdministrarPreguntasKioskosInterface;
import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Empleados;
import co.com.kiosko.entidades.Preguntaskioskos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class ControladorPreguntasKioskos implements Serializable {

    @EJB
    private AdministrarPreguntasKioskosInterface administrarPreguntasKioskos;

    private List<Preguntaskioskos> listaPreguntas;
    private Empleados empleado;
    private Conexioneskioskos conexionEmpleado;

    public ControladorPreguntasKioskos() {
        this.conexionEmpleado = new Conexioneskioskos();

    }

    @PostConstruct
    public void init() {
        listaPreguntas = administrarPreguntasKioskos.obtenerPreguntasKioskos();

    }

    public void iniciarPreguntasKiosko(Empleados empleadoLogueado) {
        this.empleado = empleadoLogueado;
    }

    public List<Preguntaskioskos> obtenerListas() {
        return administrarPreguntasKioskos.obtenerPreguntasKioskos();

    }

    public void registrarRespuestas() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        if (conexionEmpleado.getPregunta1() != null && conexionEmpleado.getPregunta2() != null) {
            if (conexionEmpleado.getPregunta1().compareTo(conexionEmpleado.getPregunta2()) != 0) {
                if (conexionEmpleado.getRespuesta1UI() != null && !conexionEmpleado.getRespuesta1UI().isEmpty() && conexionEmpleado.getRespuesta2UI() != null && !conexionEmpleado.getRespuesta2UI().isEmpty()) {
                    conexionEmpleado.setSecuencia(BigDecimal.ZERO);
                    conexionEmpleado.setEmpleado(empleado);
                    conexionEmpleado.setPwd(administrarPreguntasKioskos.encriptar(empleado.getCodigoempleado().toString()));
                    conexionEmpleado.setActivo("S");
                    conexionEmpleado.setFechadesde(obtenerPrimerDiaMes(new Date()));
                    conexionEmpleado.setFechahasta(obtenerUltimoDiaMes(new Date()));
                    conexionEmpleado.setEnviocorreo("N");
                    conexionEmpleado.setRespuesta1(administrarPreguntasKioskos.encriptar(conexionEmpleado.getRespuesta1UI()));
                    conexionEmpleado.setRespuesta2(administrarPreguntasKioskos.encriptar(conexionEmpleado.getRespuesta2UI()));
                    if (administrarPreguntasKioskos.crearConexionKiosko(conexionEmpleado)) {
                        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Las preguntas fueron guardadas exitosamente. Le recomendamos generar una contraseña nueva.", ""));
                    } else {
                        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las preguntas no fueron guardadas.", ""));
                    }
                } else {
                    contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las respuestas no pueden estar vacias.", ""));

                }
            } else {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las preguntas deben ser diferentes.", ""));

            }
        } else {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Es necesario que se seleccionen dos preguntas.", ""));
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

    public List<Preguntaskioskos> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Preguntaskioskos> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public Conexioneskioskos getConexionEmpleado() {
        return conexionEmpleado;
    }

    public void setConexionEmpleado(Conexioneskioskos conexionEmpleado) {
        this.conexionEmpleado = conexionEmpleado;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

}
