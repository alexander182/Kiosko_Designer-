
package co.com.kiosko.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CORREOSCONEXIONES")

public class Correosconexiones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA")
    private BigDecimal secuencia;
    @Column(name = "EMPRESA")
    private BigInteger empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "SMTP_HOST")
    private String smtpHost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SMTP_PUERTO")
    private String smtpPuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SMTP_SENDER")
    private String smtpSender;
    @Size(max = 500)
    @Column(name = "SMTP_DOMAIN")
    private String smtpDomain;
    @Size(max = 200)
    @Column(name = "SMTP_USUARIO")
    private String smtpUsuario;
    @Size(max = 200)
    @Column(name = "SMTP_CONTRASENA")
    private String smtpContrasena;
    @Size(max = 200)
    @Column(name = "SMTP_METODOAUTH")
    private String smtpMetodoauth;

    public Correosconexiones() {
    }

    public Correosconexiones(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public Correosconexiones(BigDecimal secuencia, String smtpHost, String smtpPuerto, String smtpSender) {
        this.secuencia = secuencia;
        this.smtpHost = smtpHost;
        this.smtpPuerto = smtpPuerto;
        this.smtpSender = smtpSender;
    }

    public BigDecimal getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public BigInteger getEmpresa() {
        return empresa;
    }

    public void setEmpresa(BigInteger empresa) {
        this.empresa = empresa;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpPuerto() {
        return smtpPuerto;
    }

    public void setSmtpPuerto(String smtpPuerto) {
        this.smtpPuerto = smtpPuerto;
    }

    public String getSmtpSender() {
        return smtpSender;
    }

    public void setSmtpSender(String smtpSender) {
        this.smtpSender = smtpSender;
    }

    public String getSmtpDomain() {
        return smtpDomain;
    }

    public void setSmtpDomain(String smtpDomain) {
        this.smtpDomain = smtpDomain;
    }

    public String getSmtpUsuario() {
        return smtpUsuario;
    }

    public void setSmtpUsuario(String smtpUsuario) {
        this.smtpUsuario = smtpUsuario;
    }

    public String getSmtpContrasena() {
        return smtpContrasena;
    }

    public void setSmtpContrasena(String smtpContrasena) {
        this.smtpContrasena = smtpContrasena;
    }

    public String getSmtpMetodoauth() {
        return smtpMetodoauth;
    }

    public void setSmtpMetodoauth(String smtpMetodoauth) {
        this.smtpMetodoauth = smtpMetodoauth;
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
        if (!(object instanceof Correosconexiones)) {
            return false;
        }
        Correosconexiones other = (Correosconexiones) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.kiosko.entidades.Correosconexiones[ secuencia=" + secuencia + " ]";
    }
    
}
