/**
 * Documentación a cargo de Hugo David Sin Gutiérrez
 */
package co.com.kiosko.conexionFuente;

import java.io.Serializable;
import javax.ejb.Remove;
import javax.ejb.Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase de tipo singleton. <br>
 * Esta clase tiene la responsabilidad de crear y controlar las conexiones a la
 * base de datos que se están usando. Al ser ‘singleton’ solo permite crear una
 * instancia a la base de datos.
 *
 * @author Felipe Triviño
 */
@Singleton
public class SesionEntityManagerFactory implements SesionEntityManagerFactoryInterface, Serializable {

    /**
     * Atributo EntityManagerFactory.
     */
    private EntityManagerFactory emf;

    @Override
    public boolean crearFactoryInicial(String baseDatos) {
        try {
            System.out.println("Entro y la bd es: " + baseDatos);
            emf = Persistence.createEntityManagerFactory(baseDatos);
            return true;
        } catch (Exception e) {
            System.out.println("Se estallo... PUM!");
            System.out.println(e);
            return false;
        }
    }

   

    @Override
    public EntityManagerFactory getEmf() {
        return emf;
    }

    @Override
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Remove
    @Override
    public void adios() {
        System.out.println("Cerrando xD");
    }
}
