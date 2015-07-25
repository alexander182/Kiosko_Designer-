package co.com.kiosko.persistenciaInterface;

import co.com.kiosko.entidades.Empleados;
import java.math.BigDecimal;

public interface PersistenciaEmpleadosInterface {

    public Empleados buscarEmpleadosPorCodigoEmpleado(Long codigoEmpleado, BigDecimal secuenciaEmpresa);

}
