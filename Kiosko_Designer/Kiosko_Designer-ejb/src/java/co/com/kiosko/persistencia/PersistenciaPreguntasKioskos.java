/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Preguntaskioskos;
import co.com.kiosko.persistenciaInterface.PersistenciaPreguntasKioskosInterface;
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

public class PersistenciaPreguntasKioskos implements PersistenciaPreguntasKioskosInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @Override
    public List<Preguntaskioskos> buscarPreguntasKioskos() {
        Query query = em.createQuery("SELECT p FROM Preguntaskioskos p");

        try {
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("PersistenciaEmpresas.buscarPreguntasKioskos " + e);
            return null;

        }

    }

}
