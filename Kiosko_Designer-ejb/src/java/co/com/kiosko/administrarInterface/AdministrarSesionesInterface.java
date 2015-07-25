/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.kiosko.administrarInterface;

import co.com.kiosko.clasesAyuda.SessionEntityManager;
import javax.persistence.EntityManager;

/**
 *
 * @author Administrador
 */
public interface AdministrarSesionesInterface {
    public void adicionarSesion(SessionEntityManager session);
    public void consultarSessionesActivas();
    public EntityManager obtenerConexionSesion(String idSesion);
    public void borrarSesion(String idSesion);
}
