package co.com.kiosko.administrarInterface;

import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Preguntaskioskos;
import java.util.List;

/**
 *
 * @author user
 */
public interface AdministrarPreguntasKioskosInterface {

    public List<Preguntaskioskos> obtenerPreguntasKioskos();

    public boolean crearConexionKiosko(Conexioneskioskos conexion);

    public byte[] encriptar(String valor);

}
