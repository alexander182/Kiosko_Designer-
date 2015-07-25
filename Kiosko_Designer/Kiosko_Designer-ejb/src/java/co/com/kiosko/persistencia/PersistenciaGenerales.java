package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Generales;
import co.com.kiosko.persistenciaInterface.PersistenciaGeneralesInterface;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PersistenciaGenerales implements PersistenciaGeneralesInterface {

    /**
     * Atributo EntityManager. Representa la comunicación con la base de datos.
     * @param em
     */
    @PersistenceContext(unitName = "Login-ejbPU")
     private EntityManager em;
    @Override
    public Generales obtenerRutas() {
        try {
            em.clear();
            
            Query query = em.createQuery("SELECT g FROM Generales g");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Generales> listaGenerales = query.getResultList();
            if (listaGenerales != null && !listaGenerales.isEmpty()) {
                System.out.println("PersistenciaGenerales obtenerRutas Tamaño listaGenerales : " + listaGenerales.size());
                System.out.println("PersistenciaGenerales obtenerRutas Tamaño listaGenerales.getPathreportes : " + listaGenerales.get(0).getPathreportes());
                return listaGenerales.get(0);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error PersistenciaGenerales.obtenerRutas " + e);
            return null;
        }
    }

    
    @Override
    public String obtenerPathServidorWeb() {
        try {
            em.clear();
            String sql = "select pathservidorweb \n"
                    + "  from  generales\n"
                    + "  group by pathservidorweb";
            Query query = em.createNativeQuery(sql);
            String path = (String) query.getSingleResult();
            path = path + "\\";
            return path;
        } catch (Exception e) {
            System.out.println("Error obtenerPathServidorWeb PersistenciaGenerales : " + e.toString());
            return null;
        }
    }

   
}
