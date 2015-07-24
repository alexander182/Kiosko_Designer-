package co.com.kiosko.reportes;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JExcelApiMetadataExporter;
import net.sf.jasperreports.engine.export.JRCsvMetadataExporter;
import net.sf.jasperreports.engine.export.JRCsvMetadataExporterParameter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.fill.AsynchronousFillHandle;
import net.sf.jasperreports.engine.util.JRLoader;

public class IniciarReporte implements Serializable {

    Connection conexion = null;
    AsynchronousFillHandle handle;

    public String ejecutarReporte(String nombreReporte, String rutaReporte, String rutaGenerado, String nombreArchivo, String tipoReporte, Connection cxn, BigDecimal secuenciaEmpleado) {
        try {
            //inicarC();
            System.out.println("INICIARREPORTE NombreReporte: " + nombreReporte);
            System.out.println("INICIARREPORTE rutaReporte: " + rutaReporte);
            System.out.println("INICIARREPORTE rutaGenerado: " + rutaGenerado);
            System.out.println("INICIARREPORTE nombreArchivo: " + nombreArchivo);
            System.out.println("INICIARREPORTE tipoReporte: " + tipoReporte);
            File archivo = new File(rutaReporte + nombreReporte + ".jasper");
            JasperReport masterReport;
            masterReport = (JasperReport) JRLoader.loadObject(archivo);

            HashMap map = new HashMap();
            map.put("SECUENCIAEMPLEADO", secuenciaEmpleado);
            JasperPrint imprimir = JasperFillManager.fillReport(masterReport, map, cxn);
            //JasperPrint imprimir = JasperFillManager.fillReport(masterReport, null, conexion);
            String outFileName = rutaGenerado + nombreArchivo;
            System.out.println("INICIARREPORTE outFileName: " + outFileName);
            JRExporter exporter = null;
            if (tipoReporte.equals("PDF")) {
                exporter = new JRPdfExporter();

            } else if (tipoReporte.equals("XLSX")) {
                exporter = new JRXlsxExporter();
            } else if (tipoReporte.equals("XLS")) {
                exporter = new JExcelApiMetadataExporter();
                exporter.setParameter(JExcelApiExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporter.setParameter(JExcelApiExporterParameter.IS_IGNORE_CELL_BACKGROUND, Boolean.TRUE);
            } else if (tipoReporte.equals("CSV")) {
                exporter = new JRCsvMetadataExporter();
                exporter.setParameter(JRCsvMetadataExporterParameter.CHARACTER_ENCODING, "ISO-8859-1");
            } else if (tipoReporte.equals("HTML")) {
                exporter = new JRXhtmlExporter();
                exporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.FALSE);
            } else if (tipoReporte.equals("DOCX")) {
                //exporter = new JRDocxExporter();
                exporter = new JRRtfExporter();
                //exporter.setParameter(JRDocxExporterParameter., Boolean.FALSE);
            }
            if (exporter != null) {
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, imprimir);
                //exporter.
                exporter.exportReport();
            }
            //cerrarConexion();
            return outFileName;
        } catch (JRException e) {
            System.out.println("Error IniciarReporte.ejecutarReporte: " + e);
            //System.out.println(e.getStackTrace());
            System.out.println("************************************");
            //e.printStackTrace();
            if (e.getCause() != null) {
                return "Error: " + e.toString() + "\n" + e.getCause().toString();
            } else {
                return "Error: " + e.toString();
            }
        }
    }

}
