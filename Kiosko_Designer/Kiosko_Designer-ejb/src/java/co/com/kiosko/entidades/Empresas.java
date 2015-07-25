/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexader1
 */
@Entity
@Table(name = "EMPRESAS")

public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA")
    private BigDecimal secuencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private short codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIT")
    private long nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "REGLAMENTO")
    private String reglamento;
    @Lob
    @Column(name = "MANUALADMINISTRATIVO")
    private String manualadministrativo;
    @Size(max = 4)
    @Column(name = "CODIGOALTERNATIVO")
    private String codigoalternativo;
    @Size(max = 50)
    @Column(name = "LOGO")
    private String logo;
    @Column(name = "CONTROLEMPLEADOS")
    private BigInteger controlempleados;
    @Column(name = "CONTROLINICIOPERIODOACTIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date controlinicioperiodoactivo;
    @Column(name = "CONTROLFINPERIODOACTIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date controlfinperiodoactivo;
    @Size(max = 50)
    @Column(name = "PRODUCTO")
    private String producto;
    @Column(name = "FECHAINSTALACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainstalacion;
    @Column(name = "FECHARENOVARSOPORTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharenovarsoporte;
    @Column(name = "CANTIDADUSUARIO")
    private Short cantidadusuario;
    @Column(name = "FECHASALIDAPRODUCCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalidaproduccion;
    @Size(max = 1)
    @Column(name = "PROMEDIOBASICOVACACIONES")
    private String promediobasicovacaciones;
    @Size(max = 1)
    @Column(name = "FECHAHASTAINIVACA")
    private String fechahastainivaca;
    @Column(name = "MEDIAADELANTODTOVACACIONES")
    private BigInteger mediaadelantodtovacaciones;
    @Column(name = "DOCUMENTOCONTABLECDI")
    private BigInteger documentocontablecdi;
    @Size(max = 15)
    @Column(name = "PRESENTACIONPILAINGRET")
    private String presentacionpilaingret;
    @Size(max = 1)
    @Column(name = "ENTREGAPARCIALINTERESCESANTIA")
    private String entregaparcialinterescesantia;
    @Size(max = 1)
    @Column(name = "VARIABLEPROMEDIABASICOCESANTIA")
    private String variablepromediabasicocesantia;
    @Size(max = 1)
    @Column(name = "SALUDACTIVOPENSIONADOIGUAL")
    private String saludactivopensionadoigual;
    @Size(max = 1)
    @Column(name = "USAGRUPOVARIABLEINDEMNIZA")
    private String usagrupovariableindemniza;
    @Size(max = 1)
    @Column(name = "REDONDEAPARAFISCALES")
    private String redondeaparafiscales;
    @Size(max = 1)
    @Column(name = "PROPORCIONTOPESUPERIORIBC")
    private String proporciontopesuperioribc;
    @Size(max = 1)
    @Column(name = "RETENCIONDISMINUYESALUDCONTOPE")
    private String retenciondisminuyesaludcontope;
    @Size(max = 1)
    @Column(name = "PROMEDIO3MVARIABLEVACACIONES")
    private String promedio3mvariablevacaciones;
    @Size(max = 1)
    @Column(name = "VALIDAPARAFISCALESAPORTEMINIMO")
    private String validaparafiscalesaporteminimo;
    @Size(max = 1)
    @Column(name = "PRIMAPROMEDIABASICOSEMESTRE")
    private String primapromediabasicosemestre;
    @Size(max = 1)
    @Column(name = "SUBTRANSPORTEPROMCESAPRIMA")
    private String subtransportepromcesaprima;
    @Size(max = 1)
    @Column(name = "PAGAVACACIONESDIFERENTENOMINA")
    private String pagavacacionesdiferentenomina;
    @Size(max = 1)
    @Column(name = "RETROACTIVOEN1PAGO")
    private String retroactivoen1pago;
    @Size(max = 1)
    @Column(name = "LIMITAPARAFISCALESMAXIMO25SML")
    private String limitaparafiscalesmaximo25sml;
    @Size(max = 100)
    @Column(name = "ODBCSQLSERVER")
    private String odbcsqlserver;
    @Size(max = 1)
    @Column(name = "VERIFICANOVEDADPAGADA")
    private String verificanovedadpagada;
    @Size(max = 1)
    @Column(name = "INTERCONADICIONACENTROCOSTO")
    private String interconadicionacentrocosto;
    @Size(max = 1)
    @Column(name = "PAGOINTCES1QUINCENA")
    private String pagointces1quincena;
    @Size(max = 1)
    @Column(name = "VACARESTADIASNOLABOR")
    private String vacarestadiasnolabor;
    @Size(max = 1)
    @Column(name = "USOIBCSUPERIOR25SMLDIASCOTI")
    private String usoibcsuperior25smldiascoti;
    @Size(max = 1)
    @Column(name = "PARAFISCALESSECTORGOBIERNO")
    private String parafiscalessectorgobierno;
    @Size(max = 1)
    @Column(name = "EXENTORETEFTEINCLUYEPRIMA")
    private String exentoretefteincluyeprima;
    @Size(max = 1)
    @Column(name = "BASERETEFTEMESINDIVIDUAL")
    private String basereteftemesindividual;
    @Size(max = 60)
    @Column(name = "CADENACONEXIONKIOSKO")
    private String cadenaconexionkiosko;
    @Size(max = 20)
    @Column(name = "ARCHIVOFIRMA")
    private String archivofirma;
    @Size(max = 30)
    @Column(name = "SUBLOGO")
    private String sublogo;
    @Size(max = 1)
    @Column(name = "FINVACACIONNEXTDIAHABIL")
    private String finvacacionnextdiahabil;
    @Size(max = 1)
    @Column(name = "PRESENTAPILADIASBENEFICIARIO")
    private String presentapiladiasbeneficiario;
    @Size(max = 1)
    @Column(name = "INTERADICIONACCPREFIJO")
    private String interadicionaccprefijo;
    @Size(max = 20)
    @Column(name = "ODBCFORMATOFECHA")
    private String odbcformatofecha;
    @Size(max = 30)
    @Column(name = "FIRMACIR")
    private String firmacir;
    @Size(max = 1)
    @Column(name = "RETENCIONYSEGSOCXPERSONA")
    private String retencionysegsocxpersona;
    @Size(max = 1)
    @Column(name = "GENERAREPORTEINGRESO")
    private String generareporteingreso;
    @Size(max = 1)
    @Column(name = "PERMITEVALORMVRDEPENDIENTE")
    private String permitevalormvrdependiente;
    @Size(max = 1)
    @Column(name = "RECALCULORETEFTETOPEHISTORICO")
    private String recalculoreteftetopehistorico;
    @Size(max = 1)
    @Column(name = "RECALCULORETEFTETOPEUSADO")
    private String recalculoreteftetopeusado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Collection<Empleados> empleadosCollection;

    public Empresas() {
    }

    public Empresas(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public Empresas(BigDecimal secuencia, short codigo, long nit, String nombre) {
        this.secuencia = secuencia;
        this.codigo = codigo;
        this.nit = nit;
        this.nombre = nombre;
    }

    public BigDecimal getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public String getManualadministrativo() {
        return manualadministrativo;
    }

    public void setManualadministrativo(String manualadministrativo) {
        this.manualadministrativo = manualadministrativo;
    }

    public String getCodigoalternativo() {
        return codigoalternativo;
    }

    public void setCodigoalternativo(String codigoalternativo) {
        this.codigoalternativo = codigoalternativo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public BigInteger getControlempleados() {
        return controlempleados;
    }

    public void setControlempleados(BigInteger controlempleados) {
        this.controlempleados = controlempleados;
    }

    public Date getControlinicioperiodoactivo() {
        return controlinicioperiodoactivo;
    }

    public void setControlinicioperiodoactivo(Date controlinicioperiodoactivo) {
        this.controlinicioperiodoactivo = controlinicioperiodoactivo;
    }

    public Date getControlfinperiodoactivo() {
        return controlfinperiodoactivo;
    }

    public void setControlfinperiodoactivo(Date controlfinperiodoactivo) {
        this.controlfinperiodoactivo = controlfinperiodoactivo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Date getFechainstalacion() {
        return fechainstalacion;
    }

    public void setFechainstalacion(Date fechainstalacion) {
        this.fechainstalacion = fechainstalacion;
    }

    public Date getFecharenovarsoporte() {
        return fecharenovarsoporte;
    }

    public void setFecharenovarsoporte(Date fecharenovarsoporte) {
        this.fecharenovarsoporte = fecharenovarsoporte;
    }

    public Short getCantidadusuario() {
        return cantidadusuario;
    }

    public void setCantidadusuario(Short cantidadusuario) {
        this.cantidadusuario = cantidadusuario;
    }

    public Date getFechasalidaproduccion() {
        return fechasalidaproduccion;
    }

    public void setFechasalidaproduccion(Date fechasalidaproduccion) {
        this.fechasalidaproduccion = fechasalidaproduccion;
    }

    public String getPromediobasicovacaciones() {
        return promediobasicovacaciones;
    }

    public void setPromediobasicovacaciones(String promediobasicovacaciones) {
        this.promediobasicovacaciones = promediobasicovacaciones;
    }

    public String getFechahastainivaca() {
        return fechahastainivaca;
    }

    public void setFechahastainivaca(String fechahastainivaca) {
        this.fechahastainivaca = fechahastainivaca;
    }

    public BigInteger getMediaadelantodtovacaciones() {
        return mediaadelantodtovacaciones;
    }

    public void setMediaadelantodtovacaciones(BigInteger mediaadelantodtovacaciones) {
        this.mediaadelantodtovacaciones = mediaadelantodtovacaciones;
    }

    public BigInteger getDocumentocontablecdi() {
        return documentocontablecdi;
    }

    public void setDocumentocontablecdi(BigInteger documentocontablecdi) {
        this.documentocontablecdi = documentocontablecdi;
    }

    public String getPresentacionpilaingret() {
        return presentacionpilaingret;
    }

    public void setPresentacionpilaingret(String presentacionpilaingret) {
        this.presentacionpilaingret = presentacionpilaingret;
    }

    public String getEntregaparcialinterescesantia() {
        return entregaparcialinterescesantia;
    }

    public void setEntregaparcialinterescesantia(String entregaparcialinterescesantia) {
        this.entregaparcialinterescesantia = entregaparcialinterescesantia;
    }

    public String getVariablepromediabasicocesantia() {
        return variablepromediabasicocesantia;
    }

    public void setVariablepromediabasicocesantia(String variablepromediabasicocesantia) {
        this.variablepromediabasicocesantia = variablepromediabasicocesantia;
    }

    public String getSaludactivopensionadoigual() {
        return saludactivopensionadoigual;
    }

    public void setSaludactivopensionadoigual(String saludactivopensionadoigual) {
        this.saludactivopensionadoigual = saludactivopensionadoigual;
    }

    public String getUsagrupovariableindemniza() {
        return usagrupovariableindemniza;
    }

    public void setUsagrupovariableindemniza(String usagrupovariableindemniza) {
        this.usagrupovariableindemniza = usagrupovariableindemniza;
    }

    public String getRedondeaparafiscales() {
        return redondeaparafiscales;
    }

    public void setRedondeaparafiscales(String redondeaparafiscales) {
        this.redondeaparafiscales = redondeaparafiscales;
    }

    public String getProporciontopesuperioribc() {
        return proporciontopesuperioribc;
    }

    public void setProporciontopesuperioribc(String proporciontopesuperioribc) {
        this.proporciontopesuperioribc = proporciontopesuperioribc;
    }

    public String getRetenciondisminuyesaludcontope() {
        return retenciondisminuyesaludcontope;
    }

    public void setRetenciondisminuyesaludcontope(String retenciondisminuyesaludcontope) {
        this.retenciondisminuyesaludcontope = retenciondisminuyesaludcontope;
    }

    public String getPromedio3mvariablevacaciones() {
        return promedio3mvariablevacaciones;
    }

    public void setPromedio3mvariablevacaciones(String promedio3mvariablevacaciones) {
        this.promedio3mvariablevacaciones = promedio3mvariablevacaciones;
    }

    public String getValidaparafiscalesaporteminimo() {
        return validaparafiscalesaporteminimo;
    }

    public void setValidaparafiscalesaporteminimo(String validaparafiscalesaporteminimo) {
        this.validaparafiscalesaporteminimo = validaparafiscalesaporteminimo;
    }

    public String getPrimapromediabasicosemestre() {
        return primapromediabasicosemestre;
    }

    public void setPrimapromediabasicosemestre(String primapromediabasicosemestre) {
        this.primapromediabasicosemestre = primapromediabasicosemestre;
    }

    public String getSubtransportepromcesaprima() {
        return subtransportepromcesaprima;
    }

    public void setSubtransportepromcesaprima(String subtransportepromcesaprima) {
        this.subtransportepromcesaprima = subtransportepromcesaprima;
    }

    public String getPagavacacionesdiferentenomina() {
        return pagavacacionesdiferentenomina;
    }

    public void setPagavacacionesdiferentenomina(String pagavacacionesdiferentenomina) {
        this.pagavacacionesdiferentenomina = pagavacacionesdiferentenomina;
    }

    public String getRetroactivoen1pago() {
        return retroactivoen1pago;
    }

    public void setRetroactivoen1pago(String retroactivoen1pago) {
        this.retroactivoen1pago = retroactivoen1pago;
    }

    public String getLimitaparafiscalesmaximo25sml() {
        return limitaparafiscalesmaximo25sml;
    }

    public void setLimitaparafiscalesmaximo25sml(String limitaparafiscalesmaximo25sml) {
        this.limitaparafiscalesmaximo25sml = limitaparafiscalesmaximo25sml;
    }

    public String getOdbcsqlserver() {
        return odbcsqlserver;
    }

    public void setOdbcsqlserver(String odbcsqlserver) {
        this.odbcsqlserver = odbcsqlserver;
    }

    public String getVerificanovedadpagada() {
        return verificanovedadpagada;
    }

    public void setVerificanovedadpagada(String verificanovedadpagada) {
        this.verificanovedadpagada = verificanovedadpagada;
    }

    public String getInterconadicionacentrocosto() {
        return interconadicionacentrocosto;
    }

    public void setInterconadicionacentrocosto(String interconadicionacentrocosto) {
        this.interconadicionacentrocosto = interconadicionacentrocosto;
    }

    public String getPagointces1quincena() {
        return pagointces1quincena;
    }

    public void setPagointces1quincena(String pagointces1quincena) {
        this.pagointces1quincena = pagointces1quincena;
    }

    public String getVacarestadiasnolabor() {
        return vacarestadiasnolabor;
    }

    public void setVacarestadiasnolabor(String vacarestadiasnolabor) {
        this.vacarestadiasnolabor = vacarestadiasnolabor;
    }

    public String getUsoibcsuperior25smldiascoti() {
        return usoibcsuperior25smldiascoti;
    }

    public void setUsoibcsuperior25smldiascoti(String usoibcsuperior25smldiascoti) {
        this.usoibcsuperior25smldiascoti = usoibcsuperior25smldiascoti;
    }

    public String getParafiscalessectorgobierno() {
        return parafiscalessectorgobierno;
    }

    public void setParafiscalessectorgobierno(String parafiscalessectorgobierno) {
        this.parafiscalessectorgobierno = parafiscalessectorgobierno;
    }

    public String getExentoretefteincluyeprima() {
        return exentoretefteincluyeprima;
    }

    public void setExentoretefteincluyeprima(String exentoretefteincluyeprima) {
        this.exentoretefteincluyeprima = exentoretefteincluyeprima;
    }

    public String getBasereteftemesindividual() {
        return basereteftemesindividual;
    }

    public void setBasereteftemesindividual(String basereteftemesindividual) {
        this.basereteftemesindividual = basereteftemesindividual;
    }

    public String getCadenaconexionkiosko() {
        return cadenaconexionkiosko;
    }

    public void setCadenaconexionkiosko(String cadenaconexionkiosko) {
        this.cadenaconexionkiosko = cadenaconexionkiosko;
    }

    public String getArchivofirma() {
        return archivofirma;
    }

    public void setArchivofirma(String archivofirma) {
        this.archivofirma = archivofirma;
    }

    public String getSublogo() {
        return sublogo;
    }

    public void setSublogo(String sublogo) {
        this.sublogo = sublogo;
    }

    public String getFinvacacionnextdiahabil() {
        return finvacacionnextdiahabil;
    }

    public void setFinvacacionnextdiahabil(String finvacacionnextdiahabil) {
        this.finvacacionnextdiahabil = finvacacionnextdiahabil;
    }

    public String getPresentapiladiasbeneficiario() {
        return presentapiladiasbeneficiario;
    }

    public void setPresentapiladiasbeneficiario(String presentapiladiasbeneficiario) {
        this.presentapiladiasbeneficiario = presentapiladiasbeneficiario;
    }

    public String getInteradicionaccprefijo() {
        return interadicionaccprefijo;
    }

    public void setInteradicionaccprefijo(String interadicionaccprefijo) {
        this.interadicionaccprefijo = interadicionaccprefijo;
    }

    public String getOdbcformatofecha() {
        return odbcformatofecha;
    }

    public void setOdbcformatofecha(String odbcformatofecha) {
        this.odbcformatofecha = odbcformatofecha;
    }

    public String getFirmacir() {
        return firmacir;
    }

    public void setFirmacir(String firmacir) {
        this.firmacir = firmacir;
    }

    public String getRetencionysegsocxpersona() {
        return retencionysegsocxpersona;
    }

    public void setRetencionysegsocxpersona(String retencionysegsocxpersona) {
        this.retencionysegsocxpersona = retencionysegsocxpersona;
    }

    public String getGenerareporteingreso() {
        return generareporteingreso;
    }

    public void setGenerareporteingreso(String generareporteingreso) {
        this.generareporteingreso = generareporteingreso;
    }

    public String getPermitevalormvrdependiente() {
        return permitevalormvrdependiente;
    }

    public void setPermitevalormvrdependiente(String permitevalormvrdependiente) {
        this.permitevalormvrdependiente = permitevalormvrdependiente;
    }

    public String getRecalculoreteftetopehistorico() {
        return recalculoreteftetopehistorico;
    }

    public void setRecalculoreteftetopehistorico(String recalculoreteftetopehistorico) {
        this.recalculoreteftetopehistorico = recalculoreteftetopehistorico;
    }

    public String getRecalculoreteftetopeusado() {
        return recalculoreteftetopeusado;
    }

    public void setRecalculoreteftetopeusado(String recalculoreteftetopeusado) {
        this.recalculoreteftetopeusado = recalculoreteftetopeusado;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
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
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empresas[ secuencia=" + secuencia + " ]";
    }

}
