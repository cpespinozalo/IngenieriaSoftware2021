package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;


/**
 * Clase de Definicion de Roles de la aplicacion
 * 
 * @author Cristian Espinoza
 * @version 2.0
 */
public class Rol implements Serializable {
    
    private Auditoria auditoria;
        
    private static final long serialVersionUID = 1L;
    private Integer sesionId;
    private Integer codigoRol;
    private String nombre;
    private String descripcion;
    private String estado;
    
    private static final String SQL_SELECT = "SELECT CROL,NOMBRE,DESCRIPCION,ACTIVO FROM TROL WHERE CROL=? ";
    private static final String SQL_INSERT = "INSERT INTO TROL (CROL,NOMBRE,DESCRIPCION,ACTIVO) VALUES ((SELECT NVL(MAX(CROL),0)+1 FROM TROL),?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE TROL SET NOMBRE=?,DESCRIPCION=?,ACTIVO=? WHERE CROL=? ";
    private static final String SQL_DELETE = "DELETE TROL WHERE CROL=? ";
    private static final String SQL_DELETE_USUARIO = "DELETE TROLUSUARIO WHERE CROL=? ";
    private static final String SQL_DELETE_MODULO = "DELETE TROLMODULO WHERE CROL=? ";
    
    public Rol(Integer sesionId) {
        this.sesionId = sesionId;
        this.auditoria = new Auditoria();
    }

    public Integer getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(Integer codigoRol) {
        this.codigoRol = codigoRol;
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
    
    public void getRol(Integer codigo){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT, codigo);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.codigoRol = codigo;
            this.nombre = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.descripcion = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.estado = arreglo[3] != null ?  arreglo[3].toString() : "";
        }
        
        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("CONSULTA ROLES: %s REGISTROS CONSULTADOS", resultado.size());
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
        
    public boolean newRol(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("CREACION ROL - %s:%s", codigoRol, nombre);
        
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
    
    public boolean updateRol(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ACTUALIZACION ROL - %s:%s", codigoRol, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, nombre, descripcion, estado, codigoRol);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean deleteRol(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ELIMINACION ROL - %s:%s", codigoRol, nombre);
        
        Cliente cliente = new Cliente();
        int registros = cliente.executeMultiple(SQL_DELETE_USUARIO, SQL_DELETE_MODULO, SQL_DELETE, codigoRol);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
}
