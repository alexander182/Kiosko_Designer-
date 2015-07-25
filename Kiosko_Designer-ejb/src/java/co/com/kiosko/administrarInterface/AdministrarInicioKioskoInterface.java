/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kiosko.administrarInterface;

import co.com.kiosko.entidades.Conexioneskioskos;
import co.com.kiosko.entidades.Correosconexiones;
import java.math.BigDecimal;
import org.primefaces.model.TreeNode;

/**
 *
 * @author user
 */
public interface AdministrarInicioKioskoInterface {

    public TreeNode obtenerArbol(BigDecimal secuenciaEmpresa);

    public void consultarDatosConexion();

    public String generarReporte(String nombreReporte, String tipoReporte, BigDecimal secuenciaEmpleado);

    public Correosconexiones obtenerConfiguracionServidorCorreo(BigDecimal secuenciaEmpresa);

    public Conexioneskioskos obtenerEmpleadoConexionesKioskos(BigDecimal secuenciaEmpleado);

}
