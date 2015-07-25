package co.com.kiosko.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "VWACTUALUSUARIO")
@Cacheable(true)
public class ActualUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA")
    @Id
    private BigInteger secuencia;
    @Column(name = "PERFIL")
    private BigInteger perfil;
    @Size(max = 1)
    @Column(name = "ACTIVO")
    private String activo;
    @Size(max = 15)
    @Column(name = "ALIAS")
    private String alias;
    @Size(max = 1)
    @Column(name = "PROPIETARIO")
    private String propietario;
    @Column(name = "PANTALLAINICIO")
    private BigInteger pantallainicio;
    @JoinColumn(name = "PERSONA", referencedColumnName = "SECUENCIA")
    @ManyToOne(optional = false)
    private Personas persona;

    public ActualUsuario() {
    }

    public BigInteger getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigInteger secuencia) {
        this.secuencia = secuencia;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public BigInteger getPerfil() {
        return perfil;
    }

    public void setPerfil(BigInteger perfil) {
        this.perfil = perfil;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public BigInteger getPantallainicio() {
        return pantallainicio;
    }

    public void setPantallainicio(BigInteger pantallainicio) {
        this.pantallainicio = pantallainicio;
    }
    
}
