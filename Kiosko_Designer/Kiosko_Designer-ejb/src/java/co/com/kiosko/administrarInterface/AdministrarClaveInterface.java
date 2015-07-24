package co.com.kiosko.administrarInterface;

import co.com.kiosko.entidades.Conexioneskioskos;
import java.math.BigDecimal;

public interface AdministrarClaveInterface {

    public byte[] encriptarClaveUsuario(String valor);

    public boolean crearClaveUsuario(Conexioneskioskos conexion);

    public Conexioneskioskos obtenerEmpleado(BigDecimal secuenciaEmpleado);

}
