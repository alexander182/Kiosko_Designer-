package co.com.kiosko.persistenciaInterface;

import co.com.kiosko.entidades.Correosconexiones;
import java.math.BigDecimal;

public interface PersistenciaCorreosConexionesInterface {

    public Correosconexiones obtenerConfiguracionServidorCorreo(BigDecimal secuenciaEmpresa);

}
