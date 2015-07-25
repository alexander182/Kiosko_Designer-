/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Opcioneskioskos;
import co.com.kiosko.persistenciaInterface.PersistenciaOpcionesKioskosInterface;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless

public class PersistenciaOpcionesKioskos implements PersistenciaOpcionesKioskosInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @Override
    public List<Opcioneskioskos> obtenerOpcionesHijas(BigDecimal secuenciaEmpresa, BigDecimal secuenciaPadre) {

        Query query = em.createQuery("SELECT o FROM Opcioneskioskos o WHERE o.empresa.secuencia= :secuenciaEmpresa AND o.opcionkioskopadre.secuencia = :secuenciaPadre");
        query.setParameter("secuenciaEmpresa", secuenciaEmpresa);
        query.setParameter("secuenciaPadre", secuenciaPadre);
        try {
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("PersistenciaOpcionesKioskos.buscarOpcioneskioskos " + e);
            return null;

        }

    }

    @Override
    public Opcioneskioskos ObtenerOpcionPadre(BigDecimal secuenciaEmpresa) {
        System.out.println("secuencia empresa " + secuenciaEmpresa);
        Query query = em.createQuery("SELECT o FROM Opcioneskioskos o WHERE o.empresa.secuencia = :secuenciaEmpresa AND o.opcionkioskopadre IS NULL");
        query.setParameter("secuenciaEmpresa", secuenciaEmpresa);
        try {
            return (Opcioneskioskos) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("PersistenciaOpcionesKioskos.ObtenerOpcionPadre " + e);
            return null;

        }

    }

    
    
    
    
}
