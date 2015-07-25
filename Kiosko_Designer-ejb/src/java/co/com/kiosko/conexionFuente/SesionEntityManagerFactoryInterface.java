/**
 * Documentación a cargo de Hugo David Sin Gutiérrez
 */
package co.com.kiosko.conexionFuente;

import javax.persistence.EntityManagerFactory;

/**
 * Esta Interface tiene la responsabilidad de determinar las acciones sobre las conexiones a la 
 * base de datos que se va a usar. 
 * @author betelgeuse
 */
public interface SesionEntityManagerFactoryInterface {
    /**
     * Método encargado de crear una instancia de la interface EntiyManagerFactory.
     * Esta acción almacena las propiedades que se utilizarán al momento de crear el 
     * EntityManager y retorna un booleano indicando si la conexión se realizo con éxito. 
     * En caso de realizar la conexión el método retorna true.
     * (Ver persistence.xml ya que es el archivo de referencia para conectarse)
     * @param baseDatos Nombre de la base de datos a la que se quiere conectar
     * @return true si la conexión se realizó. 
     */
    public boolean crearFactoryInicial(String baseDatos);
    /**
     * Método encargado de crear una instancia de la interface EntiyManagerFactory.
     * Esta acción permite conectarse con la base de datos de manera persistente y retorna
     * Un booleano indicando si la conexión se realizo con éxito. 
     * En caso de realizar la conexión el método retorna true.
     * (Ver persistence.xml ya que es el archivo de referencia para conectarse)
     * @param usuario Usuario con el que se quieren conectar
     * @param contraseña Contraseña del usuario que se quiere conectar
     * @param baseDatos Nombre de la base de datos a la cual se van a conectar
     * @return true si la conexión se realizó.
     */
    
    /**
     * Método encargado de crear una instancia de la interface EntiyManagerFactory.Esta acción permite conectarse con la base de datos de manera persistente y retorna
 Un booleano indicando si la conexión se realizo con éxito. 
 En caso de realizar la conexión el método retorna true.
 (Ver persistence.xml ya que es el archivo de referencia para conectarse)
     * @return true si la conexión se realizó.
     */
    public EntityManagerFactory getEmf();
    /**
     * Método que cambia la instancia del EntityManagerFactory que se esta usando,
     * por una diferente.
     * @param emf El nuevo EntityManagerFactory que se va a usar.
     */
    public void setEmf(EntityManagerFactory emf);
    /**
     * Método que cierra el EntityManagerFactory Global.
     */
    public void adios();
}
