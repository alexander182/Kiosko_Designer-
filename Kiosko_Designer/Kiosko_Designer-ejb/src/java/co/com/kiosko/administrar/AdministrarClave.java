package co.com.kiosko.administrar;

import co.com.kiosko.administrarInterface.AdministrarClaveInterface;
import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.persistenciaInterface.PersistenciaConexionesKioskosInterface;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class AdministrarClave implements AdministrarClaveInterface {

    @EJB
    private PersistenciaConexionesKioskosInterface persistenciaConexionesKioskos;

    @Override
    public boolean crearClaveUsuario(Conexioneskioskos conexion) {
        return persistenciaConexionesKioskos.insertarClaveEmpleado(conexion);

    }

    @Override
    public byte[] encriptarClaveUsuario(String valor) {
        return persistenciaConexionesKioskos.encriptarClave(valor);

    }

    @Override
    public Conexioneskioskos obtenerEmpleado(BigDecimal secuenciaEmpleado) {
        return persistenciaConexionesKioskos.obtenerEmpleadoConexionesKioskos(secuenciaEmpleado);

    }

}
