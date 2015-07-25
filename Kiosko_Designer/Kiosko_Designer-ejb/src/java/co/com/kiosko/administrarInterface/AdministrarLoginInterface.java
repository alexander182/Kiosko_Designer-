/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.administrarInterface;

import co.com.kiosko.entidades.Empleados;
import co.com.kiosko.entidades.Empresas;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author user
 */
public interface AdministrarLoginInterface {

    public List<Empresas> obtenerEmpresas();

    public Empleados validarEmpleado(long codigoEmpleado, BigDecimal secuenciaEmpresa);

    public boolean validarPrimerIngreso(BigDecimal secuenciaEmpleado);

    public boolean validarEmpleadoClave(String clave, BigDecimal secuenciaEmpleado);

    public boolean insertarEmpleadosConexionesKioskos(BigDecimal secuenciaEmpleado, String clave);

    public boolean conexionDefault();

    public boolean conexionInicial(String baseDatos);

    public void cerrarSession(String idSesion);

}
