/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Empresas;
import co.com.kiosko.persistenciaInterface.PersistenciaEmpresasInterface;
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

public class PersistenciaEmpresas implements PersistenciaEmpresasInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @Override
    public List<Empresas> buscarEmpresas() {
        Query query = em.createQuery("SELECT e FROM Empresas e");

        try {
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("PersistenciaEmpresas.buscarEmpresas " + e);
            return null;

        }

    }

}
