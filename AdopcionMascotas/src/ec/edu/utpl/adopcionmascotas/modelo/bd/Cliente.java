package ec.edu.utpl.adopcionmascotas.modelo.bd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase de Gestion de Operaciones en la BD
 * 
 * @author Cristian Espinoza
 * @version 2.0
 */
public class Cliente {
      
    private Conexion conexion;
    private Connection conn;
    
    public Cliente(){
      try {
            this.conexion = new Conexion();
            this.conn = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al conectar a la Base de Datos","Conexión a Base de Datos",JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public Integer execute(String consulta, Object... params){
        
        Integer registros = 0;
        try (PreparedStatement pstm = conn.prepareStatement(consulta)) {
            setParametros(pstm, params);
            registros = pstm.executeUpdate();
            conexion.saveConexion(conn, true);
        } catch (SQLException ex) {
            registros = -1;
            conexion.saveConexion(conn, false);
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al ejecutar la operación en la Base de Datos","Operación en Base de Datos",JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.closeConexion(conn);
        }
        return registros;
    }
    
    public Integer executeMultiple(String consHija, String consPadre, Object... params){
        
        Integer registros = 0;
        try (PreparedStatement pstm = conn.prepareStatement(consHija);
                PreparedStatement pstm2 = conn.prepareStatement(consPadre)) {
            setParametros(pstm, params);
            pstm.executeUpdate();
            
            setParametros(pstm2, params);
            registros = pstm2.executeUpdate();
            
            conexion.saveConexion(conn, true);
        } catch (SQLException ex) {
            registros = -1;
            conexion.saveConexion(conn, false);
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al ejecutar la operación en la Base de Datos","Operación en Base de Datos",JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.closeConexion(conn);
        }
        return registros;
    }
    
    public Integer executeMultiple(String consHija, String consHija2, String consPadre, Object... params){
        
        Integer registros = 0;
        try (PreparedStatement pstm = conn.prepareStatement(consHija);
                PreparedStatement pstm2 = conn.prepareStatement(consHija2);
                PreparedStatement pstm3 = conn.prepareStatement(consPadre)) {
            setParametros(pstm, params);
            pstm.executeUpdate();
            
            setParametros(pstm2, params);
            pstm2.executeUpdate();
            
            setParametros(pstm3, params);
            registros = pstm3.executeUpdate();
            
            conexion.saveConexion(conn, true);
        } catch (SQLException ex) {
            registros = -1;
            conexion.saveConexion(conn, false);
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al ejecutar la operación en la Base de Datos","Operación en Base de Datos",JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.closeConexion(conn);
        }
        return registros;
    }
    
    public List<Object> query(String consulta, Object... params){
       
        ResultSet rs = null;
        List<Object> registros = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(consulta)) {
            setParametros(pstm, params);
            rs = pstm.executeQuery();
            if(isObjectNotNull(rs)){
                getResultado(registros, rs);
            }
            closeResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al ejecutar la consulta en la Base de Datos","Operación en Base de Datos",JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResultSet(rs);
            conexion.closeConexion(conn);
        }
        return registros;
    }

    public Integer queryUnique(String consulta, Object... params){
       
        ResultSet rs = null;
        Integer registro = null;
        try (PreparedStatement pstm = conn.prepareStatement(consulta)) {
            setParametros(pstm, params);
            rs = pstm.executeQuery();
            while(rs.next()){
                registro = rs.getInt(1);
            }
            closeResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al ejecutar la consulta en la Base de Datos","Operación en Base de Datos",JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResultSet(rs);
            conexion.closeConexion(conn);
        }
        return registro;
    }
    
    private void setParametros(PreparedStatement pstm, Object... params){
        
        int index = 1;
        try {
            for(Object object : params){
                if(object instanceof String){
                    pstm.setString(index, (String) object);
                } else if(object instanceof Integer){
                    pstm.setInt(index, (Integer) object);
                } else if(object instanceof Long){
                    pstm.setLong(index, (Long) object);
                } else if(object instanceof Double){
                    pstm.setDouble(index, (Double) object);
                } else if(object instanceof BigDecimal){
                    pstm.setBigDecimal(index, (BigDecimal) object);
                } else {
                    throw new ClassCastException("No es posible la conversion de parametros");
                }
                index++;
            }
        } catch (SQLException | ClassCastException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getResultado(List <Object> resultado, ResultSet rs){
        try {
            while(rs.next()){
                final int columnas = rs.getMetaData().getColumnCount();
                Object[] fila = new Object[columnas];
                if(columnas>1){
                    for(int i=0; i<columnas;i++){
                       fila[i] = rs.getObject(i+1);
                    }
                    resultado.add(fila);
                }else{
                    resultado.add(rs.getObject(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closeResultSet(ResultSet rs){
        
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    private boolean isObjectNotNull(Object objeto){
        return objeto != null;
    }
}
