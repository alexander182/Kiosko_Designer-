package co.com.kiosko.administrar;

import co.com.kiosko.administrarInterface.AdministrarPreguntasKioskosInterface;
import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Preguntaskioskos;
import co.com.kiosko.persistenciaInterface.PersistenciaConexionesKioskosInterface;
import co.com.kiosko.persistenciaInterface.PersistenciaPreguntasKioskosInterface;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class AdministrarPreguntasKioskos implements AdministrarPreguntasKioskosInterface {

    @EJB
    private PersistenciaConexionesKioskosInterface persistenciaConexionesKioskos;

    @EJB
    private PersistenciaPreguntasKioskosInterface persistenciaPreguntasKioskos;

    @Override
    public List<Preguntaskioskos> obtenerPreguntasKioskos() {

        return persistenciaPreguntasKioskos.buscarPreguntasKioskos();
    }

    @Override
    public boolean crearConexionKiosko(Conexioneskioskos conexion) {
        return persistenciaConexionesKioskos.insertarConexionKiosko(conexion);

    }

    
     @Override
    public byte[] encriptar(String valor) {
        return persistenciaConexionesKioskos.encriptarClave(valor);
        
    }
   

}







