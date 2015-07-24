/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.kiosko.persistenciaInterface;

import co.com.kiosko.entidades.Opcioneskioskos;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author user
 */
public interface PersistenciaOpcionesKioskosInterface {

   

   

    public Opcioneskioskos ObtenerOpcionPadre(BigDecimal secuenciaEmpresa);

    public List<Opcioneskioskos> obtenerOpcionesHijas(BigDecimal secuenciaEmpresa, BigDecimal secuenciaPadre);
    
}
