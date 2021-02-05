package ec.edu.utpl.adopcionmascotas.controlador;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;


/**
 * Clase para gestion de Reportes
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Reportes {
    
    private Conexion conexion;
    private Connection conn;
    private Map<String, Object> parametros;
    
    public Boolean generarReporte(JFrame contenedor, String reporte, boolean logo) {
        
        boolean valido = false;
        try {
            this.conexion = new Conexion();
            this.conn = conexion.getConexion();
            
            URL archivoReporte = this.getClass().getResource(String.format("/reportes/%s.jasper",reporte));
            JasperReport jasperReport =  (JasperReport) JRLoader.loadObject(archivoReporte); 
            
            if(logo){
                URL archivoLogo = this.getClass().getResource("/images/imgLogoPrincipal.png");
                parametros.put("LOGO_PATH", archivoLogo);
            }
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
            contenedor.getContentPane().removeAll();
            contenedor.getContentPane().add(new JRViewer(jasperPrint));
            contenedor.setLocationRelativeTo(null);
            contenedor.setVisible(true);
            valido = true;
        } catch (SQLException | JRException e) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexion.closeConexion(conn);
        }
        return valido;
    }

    public void setParametros(Map<String, Object> parametros) {
        this.parametros = parametros;
    }
    
    
    
}
