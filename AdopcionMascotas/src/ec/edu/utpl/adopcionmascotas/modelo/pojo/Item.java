package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 * Clase de Definicion de Items de la aplicacion
 * 
 * @author Cristian Espinoza
 * @version 2.0
 */
public class Item  implements Serializable {
    
    private Auditoria auditoria;
    
    private static final long serialVersionUID = 1L;
    private Integer sesionId;

    private Integer codigoItem;
    private String nombre;
    private String estado;
    private Integer codigoCatalogo;
    
    private static final String SQL_SELECT = "SELECT CITEM,NOMBRE,ACTIVO,CCATALOGO FROM TITEM WHERE CCATALOGO=? ";
    private static final String SQL_INSERT = "INSERT INTO TITEM (CITEM,NOMBRE,ACTIVO,CCATALOGO) VALUES ((SELECT NVL(MAX(CITEM),0)+1 FROM TITEM),?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE TITEM SET NOMBRE=?,ACTIVO=? WHERE CITEM=? ";
    private static final String SQL_DELETE = "DELETE TITEM WHERE CITEM=? ";
    private static final String SQL_SELECT_ITEM = "SELECT NOMBRE FROM TITEM WHERE CITEM=? ";
    
    
    public Item(Integer sesionId) {
        this.sesionId = sesionId;
        this.auditoria = new Auditoria();
    }
    
    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Integer getCodigoCatalogo() {
        return codigoCatalogo;
    }

    public void setCodigoCatalogo(Integer codigoCatalogo) {
        this.codigoCatalogo = codigoCatalogo;
    }
    
    public void getItemCatalogo(Integer codigo){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT, codigo);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.codigoItem = arreglo[0] != null ? Integer.parseInt(arreglo[0].toString()) : null;
            this.nombre = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.estado = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.codigoCatalogo = arreglo[3] != null ? Integer.parseInt(arreglo[3].toString()) : null;
        }
        
        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("CONSULTA ITEMS: %s REGISTROS CONSULTADOS", resultado.size());
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
        
    public String getItemCodigo(Integer codigo){
        
        String valor = "";
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_ITEM, codigo);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            valor = arreglo[0] != null ? arreglo[0].toString() : "";
        }
        return valor;
    }
    
    public boolean newCatalogo(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("CREACION ITEM - %s:%s", codigoCatalogo, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERT, nombre, estado, codigoCatalogo);
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
        String detalle = String.format("ACTUALIZACION ITEM - %s:%s", codigoCatalogo, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, nombre, estado, codigoItem);
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
        String detalle = String.format("ELIMINACION ITEM - %s:%s", codigoCatalogo, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_DELETE, codigoItem);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return String.format(nombre);
    }
}

