package co.com.kiosko.persistenciaInterface;

import co.com.kiosko.entidades.Generales;

/**
 *
 * @author Felipphe Triviño
 */
public interface PersistenciaGeneralesInterface {

    /**
     * Método encargado de consultar en la base de datos las rutas que se
     * encuentran en generales.
     *
     * @return Retorna una entidad de tipo Generales que contiene las rutas.
     */
    public Generales obtenerRutas();

    public String obtenerPathServidorWeb();

}
