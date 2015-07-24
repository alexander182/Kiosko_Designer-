/**
 * Documentación a cargo de Hugo David Sin Gutiérrez
 */
package co.com.kiosko.persistencia;

import co.com.kiosko.persistenciaInterface.PersistenciaConexionInicialInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * Clase Stateless. <br>
 * Clase encargada de realizar operaciones referentes al ingreso al aplicativo
 * de la base de datos
 *
 * @author Andrés Pineda
 */
@Stateless
public class PersistenciaConexionInicial implements PersistenciaConexionInicialInterface {

    /**
     * Atributo EntityManager. Representa la comunicación con la base de datos.
     */
    private EntityManager em;

    @Override
    public void accesoDefault(EntityManager eManager) {
        em = eManager;
        em.getTransaction().begin();
        String sqlQuery = "SET ROLE ROLENTRADA";
        Query query = em.createNativeQuery(sqlQuery);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    /**
     * Metodo encargado de retornar el ultimo error que se capturo en los try -
     * catch.
     *
     * @param e Exception
     * @return Retorna el ultimo error capturado.
     */
    private Throwable getLastThrowable(Exception e) {
        Throwable t;
        for (t = e.getCause(); t.getCause() != null; t = t.getCause());
        return t;
    }

    @Override
    public void setearUsuario(EntityManager eManager, String rol, String pwd) {
        String texto = "SET ROLE " + rol + " IDENTIFIED BY " + pwd;
        em = eManager;
        em.getTransaction().begin();
        String sqlQuery = texto;
        Query query = em.createNativeQuery(sqlQuery);
        query.setParameter(1, rol);
        query.setParameter(2, pwd);
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
