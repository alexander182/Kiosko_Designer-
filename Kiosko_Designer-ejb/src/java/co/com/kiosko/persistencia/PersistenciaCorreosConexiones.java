package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Correosconexiones;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless

public class PersistenciaCorreosConexiones {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    public Correosconexiones obtenerConfiguracionServidorCorreo(BigDecimal secuenciaEmpresa) {

        Query query = em.createQuery("SELECT cc FROM Correosconexiones cc WHERE cc.empresa = :secuenciaEmpresa");
        query.setParameter("secuenciaEmpresa", secuenciaEmpresa);
        try {

            return (Correosconexiones) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("PersistenciaCorreosconexiones.obtenerConfiguracionServidorCorreo" + e);
            return null;

        }

    }

}
