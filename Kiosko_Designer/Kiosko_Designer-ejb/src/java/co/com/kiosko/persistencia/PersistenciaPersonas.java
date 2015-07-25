package co.com.kiosko.persistencia;

import co.com.kiosko.persistenciaInterface.PersistenciaPersonasInterface;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenciaPersonas implements PersistenciaPersonasInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    
    
    
}
