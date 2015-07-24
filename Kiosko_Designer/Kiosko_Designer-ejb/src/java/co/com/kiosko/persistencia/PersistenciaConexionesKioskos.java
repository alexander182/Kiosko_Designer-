package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.persistenciaInterface.PersistenciaConexionesKioskosInterface;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PersistenciaConexionesKioskos implements PersistenciaConexionesKioskosInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @Override
    public boolean validarEmpleadoConexionesKioskos(BigDecimal secuenciaEmpleado) {
        Query query = em.createQuery("SELECT COUNT(ck) FROM Conexioneskioskos ck WHERE ck.empleado.secuencia = :secuenciaEmpleado");
        query.setParameter("secuenciaEmpleado", secuenciaEmpleado);
        try {
            Long resultado = (Long) query.getSingleResult();
            return resultado == 0;

        } catch (Exception e) {
            System.out.println("PersistenciaConexionesKioskos.validarEmpleadoConexionesKioskos: " + e);
            return false;

        }

    }

    @Override
    public boolean validarClaveConexionesKioskos(String clave, BigDecimal secuenciaEmpleado) {
        Query query = em.createNativeQuery("SELECT GENERALES_PKG.decrypt(CK.PWD) FROM CONEXIONESKIOSKOS CK WHERE CK.EMPLEADO = ?");
        System.out.println("validando clave de forma correcta");
        query.setParameter(1, secuenciaEmpleado);
        try {
            String resultado = (String) query.getSingleResult();

            if (resultado.equals(clave)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("PersistenciaConexionesKioskos.validarClaveConexionesKioskos: " + e);
            return false;

        }

    }

    @Override
    public byte[] encriptarClave(String clave) {
        try {
            em.clear();

            String sqlQuery = "select GENERALES_PKG.ENCRYPT(?) from dual";
            Query query = em.createNativeQuery(sqlQuery);
            query.setParameter(1, clave);
            return (byte[]) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en encryptar clave: " + e);
            return null;

        }

    }

    @Override
    public String desencriptarClave(String clave) {
        try {
            em.clear();
            String sqlQuery = "call GENERALES_PKG.DECRYPT(?)";
            Query query = em.createNativeQuery(sqlQuery);
            query.setParameter(1, clave);
            query.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en desencryptar clave: " + e);
        }
        return clave;
    }

    @Override
    public Conexioneskioskos obtenerEmpleadoConexionesKioskos(BigDecimal secuenciaEmpleado) {
        System.out.println("secuencia" + secuenciaEmpleado);
        em.flush();
        Query query = em.createQuery("SELECT ck FROM Conexioneskioskos ck WHERE ck.empleado.secuencia = :secuenciaEmpleado");
        query.setParameter("secuenciaEmpleado", secuenciaEmpleado);
        try {
            return (Conexioneskioskos) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("PersistenciaConexionesKioskos.validarEmpleadoConexionesKioskos: " + e);
            return null;

        }

    }

    @Override
    public boolean validarExistenciaEmpleado(BigDecimal secuenciaEmpleado) {
        Query query = em.createQuery("SELECT COUNT(e) FROM Empleados e WHERE e.secuencia = :secuenciaEmpleado");
        query.setParameter("secuenciaEmpleado", secuenciaEmpleado);
        try {
            Long resultado = (Long) query.getSingleResult();
            return resultado == 0;

        } catch (Exception e) {
            System.out.println("PersistenciaConexionesKioskos.validarExistenciaEmpleado: " + e);
            return false;

        }

    }

    @Override
    public boolean insertarConexionKiosko(Conexioneskioskos conexion) {
        try {
            return em.merge(conexion) != null;

        } catch (Exception e) {
            System.out.println("PersistenciaConexionesKioskos.insertarConexionKiosko: " + e);
            return false;

        }

    }

    @Override
    public boolean insertarClaveEmpleado(Conexioneskioskos conexion) {
        try {
            return em.merge(conexion) != null;

        } catch (Exception e) {
            System.out.println("PersistenciaConexionesKioskos.insertarClaveUsuario: " + e);
            return false;
        }

    }

}
