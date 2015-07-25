/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "OPCIONESKIOSKOS")

public class Opcioneskioskos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA")
    private BigDecimal secuencia;
    @Size(max = 1000)
    @Column(name = "AYUDA")
    private String ayuda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CLASE")
    private String clase;
    @Size(max = 20)
    @Column(name = "TIPOREPORTE")
    private String tiporeporte;
    @Size(max = 50)
    @Column(name = "NOMBREARCHIVO")
    private String nombrearchivo;
    @Size(max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    @OneToMany(mappedBy = "opcionkioskopadre")
    private Collection<Opcioneskioskos> opcioneskioskosCollection;
    @JoinColumn(name = "OPCIONKIOSKOPADRE", referencedColumnName = "SECUENCIA")
    @ManyToOne
    private Opcioneskioskos opcionkioskopadre;

    @JoinColumn(name = "EMPRESA", referencedColumnName = "SECUENCIA")
    @ManyToOne
    private Empresas empresa;

    public Opcioneskioskos() {
    }

    public Opcioneskioskos(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public Opcioneskioskos(BigDecimal secuencia, String codigo, String descripcion, String clase) {
        this.secuencia = secuencia;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.clase = clase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTiporeporte() {
        return tiporeporte;
    }

    public void setTiporeporte(String tiporeporte) {
        this.tiporeporte = tiporeporte;
    }

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @XmlTransient
    public Collection<Opcioneskioskos> getOpcioneskioskosCollection() {
        return opcioneskioskosCollection;
    }

    public void setOpcioneskioskosCollection(Collection<Opcioneskioskos> opcioneskioskosCollection) {
        this.opcioneskioskosCollection = opcioneskioskosCollection;
    }

    public Opcioneskioskos getOpcionkioskopadre() {
        return opcionkioskopadre;
    }

    public void setOpcionkioskopadre(Opcioneskioskos opcionkioskopadre) {
        this.opcionkioskopadre = opcionkioskopadre;
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
        if (!(object instanceof Opcioneskioskos)) {
            return false;
        }
        Opcioneskioskos other = (Opcioneskioskos) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Opcioneskioskos[ secuencia=" + secuencia + " ]";
    }

}
