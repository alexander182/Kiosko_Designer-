/**
 * Documentación a cargo de Hugo David Sin Gutiérrez
 */
package co.com.kiosko.persistenciaInterface;

import javax.persistence.EntityManager;

/**
 * Interface encargada de determinar las operaciones que se realizan para la
 * conexión inicial al aplicativo. de la base de datos.
 *
 * @author betelgeuse
 */
public interface PersistenciaConexionInicialInterface {

    public void setearUsuario(EntityManager eManager, String rol, String pwd);

    public void accesoDefault(EntityManager eManager);

}
