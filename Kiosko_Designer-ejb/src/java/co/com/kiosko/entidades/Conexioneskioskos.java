package co.com.kiosko.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "CONEXIONESKIOSKOS")

public class Conexioneskioskos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "SEUDONIMO")
    private String seudonimo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA")
    private BigDecimal secuencia;
    @Lob
    @Column(name = "PWD")
    private byte[] pwd;
    @Column(name = "ACTIVO")
    private String activo;
    @Column(name = "RESPUESTA1")
    private byte[] respuesta1;
    @Column(name = "RESPUESTA2")
    private byte[] respuesta2;
    @Column(name = "RESPUESTA3")
    private String respuesta3;
    @Column(name = "ULTIMACONEXION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaconexion;
    @Column(name = "FECHADESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadesde;
    @Column(name = "FECHAHASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahasta;
    @Column(name = "ENVIOCORREO")
    private String enviocorreo;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "DIRIGIDOA")
    private String dirigidoa;
    //@JoinColumn(name = "PREGUNTA2", referencedColumnName = "SECUENCIA")
    //@ManyToOne
    @Column(name = "PREGUNTA2")
    private BigDecimal pregunta2;
    //@JoinColumn(name = "PREGUNTA3", referencedColumnName = "SECUENCIA")
    //@ManyToOne

    //@JoinColumn(name = "PREGUNTA1", referencedColumnName = "SECUENCIA")
    //@ManyToOne
    @Column(name = "PREGUNTA1")
    private BigDecimal pregunta1;
    @JoinColumn(name = "EMPLEADO", referencedColumnName = "SECUENCIA")
    @ManyToOne
    private Empleados empleado;
    @Transient
    private String respuesta1UI;
    @Transient
    private String respuesta2UI;

    public Conexioneskioskos() {
    }

    public Conexioneskioskos(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public BigDecimal getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public byte[] getPwd() {
        return pwd;
    }

    public void setPwd(byte[] pwd) {
        this.pwd = pwd;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public byte[] getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(byte[] respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public byte[] getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(byte[] respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public Date getUltimaconexion() {
        return ultimaconexion;
    }

    public void setUltimaconexion(Date ultimaconexion) {
        this.ultimaconexion = ultimaconexion;
    }

    public Date getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
    }

    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    public String getEnviocorreo() {
        return enviocorreo;
    }

    public void setEnviocorreo(String enviocorreo) {
        this.enviocorreo = enviocorreo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDirigidoa() {
        return dirigidoa;
    }

    public void setDirigidoa(String dirigidoa) {
        this.dirigidoa = dirigidoa;
    }

    public BigDecimal getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(BigDecimal pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public BigDecimal getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(BigDecimal pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencia != null ? secuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conexioneskioskos)) {
            return false;
        }
        Conexioneskioskos other = (Conexioneskioskos) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Conexioneskioskos[ secuencia=" + secuencia + " ]";
    }

    public String getRespuesta1UI() {
        return respuesta1UI;
    }

    public void setRespuesta1UI(String respuesta1UI) {
        this.respuesta1UI = respuesta1UI;
    }

    public String getRespuesta2UI() {
        return respuesta2UI;
    }

    public void setRespuesta2UI(String respuesta2UI) {
        this.respuesta2UI = respuesta2UI;
    }

}
