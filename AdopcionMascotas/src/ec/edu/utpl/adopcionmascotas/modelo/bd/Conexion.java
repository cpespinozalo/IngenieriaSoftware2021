package ec.edu.utpl.adopcionmascotas.modelo.bd;

import ec.edu.utpl.adopcionmascotas.controlador.Utilitarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase de Gestion de Conecciones con la BD
 * 
 * @author Cristian Espinoza
 * @version 2.0
 */
public class Conexion {
    
    private static final String BD_PROPERTIES = "BD.properties";
    private Connection conexion;
   
    public Conexion() throws SQLException{
        
        try {
            Utilitarios util = new Utilitarios();
            final String driver = util.getPropiedad("bd.driver", BD_PROPERTIES);
            final String url = util.getPropiedad("bd.url", BD_PROPERTIES);
            final String host = util.getPropiedad("bd.host", BD_PROPERTIES);
            final String port = util.getPropiedad("bd.port", BD_PROPERTIES);
            final String sid = util.getPropiedad("bd.sid", BD_PROPERTIES);
            final String user = util.getPropiedad("bd.user", BD_PROPERTIES);
            final String password = util.getPropiedad("bd.password", BD_PROPERTIES);
              
            Class.forName(driver);
            final String conectionUrl = String.format("%s:@%s:%s:%s", url, host, port, sid);
            this.conexion = java.sql.DriverManager.getConnection(conectionUrl, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al establecer los datos de conexión con la Base de Datos","Conexión a Base de Datos",JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConexion() {
        try {
            conexion.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
   
    public void closeConexion(Connection conn) {
        
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al cerrar la conexión con la Base de Datos","Conexión a Base de Datos",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void saveConexion(Connection conn, Boolean guardar){
        
        try {
            if(conn != null){
                if(guardar){
                    conn.commit();
                } else {
                    conn.rollback();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
