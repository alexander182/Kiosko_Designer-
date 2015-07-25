package co.com.kiosko.administrar;

import co.com.kiosko.administrarInterface.AdministrarInicioKioskoInterface;
import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Correosconexiones;
import co.com.kiosko.entidades.Generales;
import co.com.kiosko.entidades.Opcioneskioskos;
import co.com.kiosko.persistencia.PersistenciaCorreosConexiones;
import co.com.kiosko.persistenciaInterface.PersistenciaActualUsuarioInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaConexionesKioskosInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaGeneralesInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaOpcionesKioskosInterface;
import co.com.kiosko.reportes.IniciarReporte;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author user
 */
@Stateful

public class AdministrarInicioKiosko implements AdministrarInicioKioskoInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @EJB
    private PersistenciaCorreosConexiones persistenciaCorreosConexiones;
    @EJB
    private PersistenciaOpcionesKioskosInterface persistenciaOpcionesKioskos;
    @EJB
    private PersistenciaActualUsuarioInterface persistenciaActualUsuario;
    @EJB
    private PersistenciaGeneralesInterface persistenciaGenerales;
    @EJB
    private PersistenciaConexionesKioskosInterface persistenciaConexionesKioskos;

    private TreeNode arbolOpciones;
    private Opcioneskioskos opcionPadre;
    private List<Opcioneskioskos> opcionHijas1;
    private List<Opcioneskioskos> opcionHijas2;
    private List<Opcioneskioskos> opcionHijas3;
    private List<Opcioneskioskos> opcionHijas4;
    private List<Opcioneskioskos> opcionHijas5;
    private List<Opcioneskioskos> opcionHijas6;
    private List<Opcioneskioskos> opcionHijas7;
    private Connection conexion;
    private IniciarReporte reporte = new IniciarReporte();

    @Override
    public TreeNode obtenerArbol(BigDecimal secuenciaEmpresa) {
        if (arbolOpciones == null) {
            arbolOpciones = (TreeNode) new DefaultTreeNode("arbolOpciones", null);
            opcionPadre = persistenciaOpcionesKioskos.ObtenerOpcionPadre(secuenciaEmpresa);
            if (opcionPadre != null) {
                TreeNode padre = new DefaultTreeNode(opcionPadre, arbolOpciones);
                opcionHijas1 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionPadre.getSecuencia());
                if (opcionHijas1 != null) {
                    for (int j = 0; j < opcionHijas1.size(); j++) {
                        TreeNode hija1 = new DefaultTreeNode(opcionHijas1.get(j), padre);
                        opcionHijas2 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionHijas1.get(j).getSecuencia());
                        if (opcionHijas2 != null) {
                            for (int k = 0; k < opcionHijas2.size(); k++) {
                                TreeNode hija2 = new DefaultTreeNode(opcionHijas2.get(k), hija1);
                                opcionHijas3 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionHijas2.get(k).getSecuencia());
                                if (opcionHijas3 != null) {
                                    for (int l = 0; l < opcionHijas3.size(); l++) {
                                        TreeNode hija3 = new DefaultTreeNode(opcionHijas3.get(l), hija2);
                                        opcionHijas4 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionHijas3.get(l).getSecuencia());
                                        if (opcionHijas4 != null) {
                                            for (int m = 0; m < opcionHijas4.size(); m++) {
                                                TreeNode hija4 = new DefaultTreeNode(opcionHijas4.get(m), hija3);
                                                opcionHijas5 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionHijas4.get(m).getSecuencia());
                                                if (opcionHijas5 != null) {
                                                    for (int f = 0; f < opcionHijas5.size(); f++) {
                                                        TreeNode hija5 = new DefaultTreeNode(opcionHijas5.get(f), hija4);
                                                        opcionHijas6 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionHijas5.get(f).getSecuencia());
                                                        if (opcionHijas6 != null) {
                                                            for (int e = 0; e < opcionHijas6.size(); e++) {
                                                                TreeNode hija6 = new DefaultTreeNode(opcionHijas6.get(e), hija5);
                                                                opcionHijas7 = persistenciaOpcionesKioskos.obtenerOpcionesHijas(secuenciaEmpresa, opcionHijas6.get(e).getSecuencia());
                                                                if (opcionHijas7 != null) {
                                                                    for (int p = 0; p < opcionHijas7.size(); p++) {
                                                                        TreeNode hija7 = new DefaultTreeNode(opcionHijas7.get(p), hija6);

                                                                    }
                                                                }
                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }
        return arbolOpciones;
    }

    @Override
    public String generarReporte(String nombreReporte, String tipoReporte, BigDecimal secuenciaEmpleado) {
        try {
            Generales general = persistenciaGenerales.obtenerRutas();
            String nombreUsuario = persistenciaActualUsuario.actualAliasBD();
            String pathReporteGenerado = null;
            if (general != null && nombreUsuario != null) {
                SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyhhmmss");
                String fechaActual = formato.format(new Date());
                String nombreArchivo = "JR" + nombreUsuario + fechaActual;
                String rutaReporte = general.getPathreportes();
                String rutaGenerado = general.getUbicareportes();
                System.err.println("general.getPathreportes() : " + general.getPathreportes());
                System.err.println("general.getUbicareportes() : " + general.getUbicareportes());
                if (tipoReporte.equals("PDF")) {
                    nombreArchivo = nombreArchivo + ".pdf";
                } else if (tipoReporte.equals("XLSX")) {
                    nombreArchivo = nombreArchivo + ".xlsx";
                } else if (tipoReporte.equals("XLS")) {
                    nombreArchivo = nombreArchivo + ".xls";
                } else if (tipoReporte.equals("CSV")) {
                    nombreArchivo = nombreArchivo + ".csv";
                } else if (tipoReporte.equals("HTML")) {
                    nombreArchivo = nombreArchivo + ".html";
                } else if (tipoReporte.equals("DOCX")) {
                    nombreArchivo = nombreArchivo + ".rtf";
                }
                consultarDatosConexion();
                if (conexion != null && !conexion.isClosed()) {
                    pathReporteGenerado = reporte.ejecutarReporte(nombreReporte, rutaReporte, rutaGenerado, nombreArchivo, tipoReporte, conexion, secuenciaEmpleado);
                    conexion.close();
                    return pathReporteGenerado;
                }
                return pathReporteGenerado;
            }
            return pathReporteGenerado;
        } catch (SQLException ex) {
            System.out.println("Error AdministrarReporte.generarReporte: " + ex);
            return null;
        }
    }

    @Override
    public void consultarDatosConexion() {
        //em.getTransaction().begin();
        conexion = em.unwrap(java.sql.Connection.class);
        //em.getTransaction().commit();
        //em.close();

    }

    @Override
    public Correosconexiones obtenerConfiguracionServidorCorreo(BigDecimal secuenciaEmpresa) {

        return persistenciaCorreosConexiones.obtenerConfiguracionServidorCorreo(secuenciaEmpresa);

    }

    @Override
    public Conexioneskioskos obtenerEmpleadoConexionesKioskos(BigDecimal secuenciaEmpleado) {

        return persistenciaConexionesKioskos.obtenerEmpleadoConexionesKioskos(secuenciaEmpleado);
        
    }

}
