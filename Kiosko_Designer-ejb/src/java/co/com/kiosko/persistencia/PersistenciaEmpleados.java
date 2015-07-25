/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.persistencia;

import co.com.kiosko.entidades.Empleados;
import co.com.kiosko.persistenciaInterface.PersistenciaEmpleadosInterface;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless

public class PersistenciaEmpleados implements PersistenciaEmpleadosInterface {

    @PersistenceContext(unitName = "Login-ejbPU")
    private EntityManager em;

    @Override
    public Empleados buscarEmpleadosPorCodigoEmpleado(Long codigoEmpleado, BigDecimal secuenciaEmpresa) {
        Query query = em.createQuery("SELECT e FROM Empleados e WHERE e.codigoempleado = :codigoEmpleado AND e.empresa.secuencia = :secuenciaEmpresa");
        query.setParameter("codigoEmpleado", codigoEmpleado);
        query.setParameter("secuenciaEmpresa", secuenciaEmpresa);
        try {
           
            
            return (Empleados) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("PersistenciaEmpleados.buscarEmpleadosPorCodigoEmpleado" + e);
            return null;

        }

    }
}
