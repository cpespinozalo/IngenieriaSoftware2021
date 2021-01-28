package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Clase de Definicion de Catalogo de la aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Catalogo  implements Serializable {
    
    private Auditoria auditoria;
    
    private static final long serialVersionUID = 1L;
    private Integer sesionId;
    
    private Integer codigoCatalogo;
    private String nombre;
    private String descripcion;
    private String estado;
    
    private static final String SQL_SELECT = "SELECT CCATALOGO,NOMBRE,DESCRIPCION,ACTIVO FROM MASCOTAS.TCATALOGO WHERE CCATALOGO=? ";
    private static final String SQL_INSERT = "INSERT INTO MASCOTAS.TCATALOGO (CCATALOGO,NOMBRE,DESCRIPCION,ACTIVO) VALUES ((SELECT NVL(MAX(CCATALOGO),0)+1 FROM MASCOTAS.TCATALOGO),?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE MASCOTAS.TCATALOGO SET NOMBRE=?,DESCRIPCION=?,ACTIVO=? WHERE CCATALOGO=? ";
    private static final String SQL_DELETE = "DELETE MASCOTAS.TCATALOGO WHERE CCATALOGO=? ";
    private static final String SQL_DELETE_ITEM = "DELETE MASCOTAS.TITEM WHERE CCATALOGO=? ";
    
    
    public Catalogo() {
        
    }
    
      public Catalogo(Integer sesionId) {
        this.sesionId = sesionId;
        this.auditoria = new Auditoria();
    }
      
    public Integer getCodigoCatalogo() {
        return codigoCatalogo;
    }

    public void setCodigoCatalogo(Integer codigoCatalogo) {
        this.codigoCatalogo = codigoCatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     public void getCatalogo(Integer codigo){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT, codigo);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.codigoCatalogo = codigo;
            this.nombre = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.descripcion = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.estado = arreglo[3] != null ?  arreglo[3].toString() : "";
        }
        
        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("CONSULTA CATALOGOS: %s REGISTROS CONSULTADOS", resultado.size());
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
        
    public boolean newCatalogo(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("CREACION CATALOGO - %s:%s", codigoCatalogo, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERT, nombre, descripcion, estado);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean updateCatalogo(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ACTUALIZACION CATALOGO - %s:%s", codigoCatalogo, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, nombre, descripcion, codigoCatalogo);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean deleteCatalogo(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ELIMINACION CATALOGO - %s:%s", codigoCatalogo, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.executeMultiple(SQL_DELETE_ITEM, SQL_DELETE, codigoCatalogo);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public void setComboCatalogo(String catalogo, String padre, JComboBox combo){
        
        combo.removeAllItems();
        List<Object> resultado;
        Cliente cliente = new Cliente();
        if(padre != null) {
           resultado = cliente.query("SELECT IT.NOMBRE FROM MASCOTAS.TCATALOGO CA, MASCOTAS.TITEM IT WHERE CA.CCATALOGO=IT.CCATALOGO AND CA.NOMBRE=? AND IT.CODIGOPADRE=? ", catalogo, padre); 
        } else {
            resultado = cliente.query("SELECT IT.NOMBRE FROM MASCOTAS.TCATALOGO CA, MASCOTAS.TITEM IT WHERE CA.CCATALOGO=IT.CCATALOGO AND CA.NOMBRE=? " , catalogo);
        }
        
        for(Object dato : resultado){
            combo.addItem(dato != null ? dato.toString() : "");
        }
    }
    
    public void setListCatalogo(DefaultListModel modelo, JList<String> listaItems, Integer ccatalogo) {
        listaItems.removeAll();
        modelo= new DefaultListModel();
        listaItems.setModel(modelo);
        
        List<Object> lista;
        Cliente cliente = new Cliente();
        lista = cliente.query("SELECT IT.NOMBRE FROM MASCOTAS.TITEM IT WHERE IT.CCATALOGO=? ", ccatalogo);
        for(Object dato : lista){
            modelo.addElement(dato.toString());
        }
        listaItems.setModel(modelo); 
    }
}
