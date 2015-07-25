/**
 * Documentación a cargo de Hugo David Sin Gutiérrez
 */
package co.com.kiosko.persistenciaInterface;

import co.com.kiosko.entidades.ActualUsuario;


/**
 * Interface encargada de determinar las operaciones que se realizan sobre la tabla 'ActualUsuario' 
 * de la base de datos.
 * @author betelgeuse
 */
public interface PersistenciaActualUsuarioInterface {
    /**
     * Método encargado de consultar toda la información del usuario que está usando el aplicativo.
     * @return Retorna el usuario que está usando el aplicativo.
     */
    public ActualUsuario actualUsuarioBD();
    /**
     * Método encargado de consultar el alias del usuario que está usando el aplicativo. 
     * @return Retorna el alias del usuario que está usando el aplicativo.
     */
    public String actualAliasBD();
    /**
     * Método encargado de consultar el alias del usuario que está usando el aplicativo dado el EntityManager,
     * es decir definiendo sobre cual base de datos se busca la información.
     * @param emg EntityManager encargado de la comunicación a la base de datos.
     * @return Retorna el alias del usuario que está usando el aplicativo.
     */
    public String actualAliasBD_EM();
}
