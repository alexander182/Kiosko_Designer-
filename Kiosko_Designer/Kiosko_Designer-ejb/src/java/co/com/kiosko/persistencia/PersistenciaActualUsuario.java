/**
 * Alexander Gil Tafur 
 */
package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.ActualUsuario;
import co.com.kiosko.persistenciaInterface.PersistenciaActualUsuarioInterface;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase Stateless. <br>
 * Clase encargada de realizar operaciones sobre la tabla 'ActualUsuario' de la base de datos.
 * @author betelgeuse
 */
@Stateless
public class PersistenciaActualUsuario implements PersistenciaActualUsuarioInterface {
    
       /**
     * Atributo EntityManager. Representa la comunicación con la base de datos
     */
    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @Override
    public ActualUsuario actualUsuarioBD() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT au FROM ActualUsuario au");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            ActualUsuario actualUsuario;
            actualUsuario = (ActualUsuario) query.getSingleResult();
            return actualUsuario;
        } catch (Exception e) {
            System.out.println("PersistenciaActualUsuario.ActualUsuario"+ e);
            return null;
        }
    }
    
    @Override
    public String actualAliasBD() {
        try {
            em.clear();
            String sqlQuery = "SELECT au.ALIAS FROM VWActualUsuario au";
            Query query = em.createNativeQuery(sqlQuery);
            String alias;
            alias = (String) query.getSingleResult();
            return alias;
        } catch (Exception e) {
           System.out.println("PersistenciaActualUsuario.ActualAlias"+ e);
            return null;
        }
    }
    
    @Override
    public String actualAliasBD_EM() {
        try {
            em.clear();
            String sqlQuery = "SELECT au.ALIAS FROM VWActualUsuario au";
            Query query = em.createNativeQuery(sqlQuery);
            String alias;
            alias = (String) query.getSingleResult();
            return alias;
        } catch (Exception e) {
            System.out.println("PersistenciaActualUsuario.ActualAlias"+ e);
            return null;
        }
    }
}
