/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.administrar;

import co.com.kiosko.administrarInterface.AdministrarLoginInterface;
import co.com.kiosko.administrarInterface.AdministrarSesionesInterface;
import co.com.kiosko.conexionFuente.SesionEntityManagerFactory;
import co.com.kiosko.entidades.Empleados;
import co.com.kiosko.entidades.Empresas;
import co.com.kiosko.persistenciaInterface.PersistenciaConexionInicialInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaConexionesKioskosInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaEmpleadosInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaEmpresasInterface;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
@Stateful

public class AdministrarLogin implements AdministrarLoginInterface {

    @EJB
    private PersistenciaConexionesKioskosInterface persistenciaConexionesKioskos;

    @EJB
    private PersistenciaEmpresasInterface persistenciaEmpresas;

    @EJB
    private PersistenciaEmpleadosInterface persistenciaEmpleados;
    @EJB
    PersistenciaConexionInicialInterface persistenciaConexionInicial;
    @EJB
    AdministrarSesionesInterface administrarSessiones;

    private final SesionEntityManagerFactory sessionEMF;
    private EntityManager em;

    public AdministrarLogin() {
        // FactoryGlobal = new EntityManagerGlobal();
        sessionEMF = new SesionEntityManagerFactory();
    }

    @Override
    public Empleados validarEmpleado(long codigoEmpleado, BigDecimal secuenciaEmpresa) {
        return persistenciaEmpleados.buscarEmpleadosPorCodigoEmpleado(codigoEmpleado, secuenciaEmpresa);

    }

    @Override
    public List<Empresas> obtenerEmpresas() {
        return persistenciaEmpresas.buscarEmpresas();
    }

    @Override
    public boolean validarPrimerIngreso(BigDecimal secuenciaEmpleado) {
        return persistenciaConexionesKioskos.validarEmpleadoConexionesKioskos(secuenciaEmpleado);

    }

    @Override
    public boolean validarEmpleadoClave(String clave, BigDecimal secuenciaEmpleado) {

        return persistenciaConexionesKioskos.validarClaveConexionesKioskos(clave, secuenciaEmpleado);

    }

    @Override
    public boolean insertarEmpleadosConexionesKioskos(BigDecimal secuenciaEmpleado, String clave) {
        return persistenciaConexionesKioskos.validarEmpleadoConexionesKioskos(secuenciaEmpleado);

    }

    @Override
    public boolean conexionDefault() {
        try {
            conexionInicial("XE");
            persistenciaConexionInicial.accesoDefault(sessionEMF.getEmf().createEntityManager());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean conexionInicial(String baseDatos) {
        try {
            if (sessionEMF.getEmf() != null && sessionEMF.getEmf().isOpen()) {
                sessionEMF.getEmf().close();
            }
            //emf = Persistence.createEntityManagerFactory(baseDatos);
            if (sessionEMF.crearFactoryInicial(baseDatos)) {
                return true;
            } else {
                //System.out.println("BASE DE DATOS NO EXISTE");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error AdministrarLogin.conexionInicial" + e);
            return false;
        }
    }

    @Override
    public void cerrarSession(String idSesion) {
        if (em.isOpen()) {
            em.getEntityManagerFactory().close();
            administrarSessiones.borrarSesion(idSesion);
        }
    }

}
