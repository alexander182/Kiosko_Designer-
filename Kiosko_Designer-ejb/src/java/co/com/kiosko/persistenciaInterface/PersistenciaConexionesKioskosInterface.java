/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.persistenciaInterface;

import co.com.kiosko.entidades.Conexioneskioskos;
import java.math.BigDecimal;

/**
 *
 * @author user
 */
public interface PersistenciaConexionesKioskosInterface {

    public boolean validarEmpleadoConexionesKioskos(BigDecimal secuenciaEmpleado);

    public boolean validarClaveConexionesKioskos(String clave, BigDecimal secuenciaEmpleado);

    public String desencriptarClave(String clave);

    public Conexioneskioskos obtenerEmpleadoConexionesKioskos(BigDecimal secuenciaEmpleado);

    public boolean validarExistenciaEmpleado(BigDecimal secuenciaEmpleado);

    public byte[] encriptarClave(String clave);

    public boolean insertarConexionKiosko(Conexioneskioskos conexion);
    
    public boolean insertarClaveEmpleado(Conexioneskioskos conexion);

}
