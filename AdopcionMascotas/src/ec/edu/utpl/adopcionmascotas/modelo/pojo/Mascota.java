package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.List;


/**
 * Clase de Definicion de Mascotas de la aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Mascota implements Serializable{
    
    private Auditoria auditoria;
    
    private static final long serialVersionUID = 1L;
    private Integer sesionId;
    private Integer cmascota;
    private String identificacion;
    private String nombremascota;
    private String direccion;
    private String web;
    private String telefono;
    private String pais;
    private String provincia;
    private String ciudad;
    private String representante;
    
    private static final String SQL_SELECT = "SELECT CMASCOTA,IDENTIFICACION,RAZONSOCIAL,DIRECCION,PAGINAWEB,TELEFONO,CPAIS,CPROVINCIA,CCIUDAD,REPRESENTANTE_LEGAL FROM MASCOTAS.TMASCOTA WHERE CMASCOTA=? ";
    private static final String SQL_INSERT = "INSERT INTO MASCOTAS.TMASCOTA (CMASCOTA,IDENTIFICACION,RAZONSOCIAL,DIRECCION,PAGINAWEB,TELEFONO,CPAIS,CPROVINCIA,CCIUDAD,REPRESENTANTE_LEGAL) VALUES ((SELECT NVL(MAX(CMASCOTA),0)+1 FROM MASCOTAS.TMASCOTA),?,?,?,?,?,?,?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE MASCOTAS.TMASCOTA SET IDENTIFICACION=?,RAZONSOCIAL=?,DIRECCION=?,PAGINAWEB=?,TELEFONO=?,CPAIS=?,CPROVINCIA=?,CCIUDAD=?,REPRESENTANTE_LEGAL=? WHERE CMASCOTA=? ";
    private static final String SQL_DELETE = "DELETE MASCOTAS.TMASCOTA WHERE CMASCOTA=? ";
    private static final String SQL_UPDATE_USUARIOS= "UPDATE MASCOTAS.TUSUARIO SET CMASCOTA=NULL WHERE CMASCOTA=? ";

    public Mascota(Integer cmascota, String nombremascota) {
        this.cmascota = cmascota;
        this.nombremascota = nombremascota;
    }
    
    public Mascota(Integer sesionId) {
        this.sesionId = sesionId;
        this.auditoria = new Auditoria();
    }
    
    public Integer getCmascota() {
        return cmascota;
    }

    public void setCmascota(Integer cmascota) {
        this.cmascota = cmascota;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
    public void getMascota(Integer codigo){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT, codigo);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.cmascota = codigo;
            this.identificacion = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.nombremascota = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.direccion = arreglo[3] != null ?  arreglo[3].toString() : "";
            this.web = arreglo[4] != null ?  arreglo[4].toString() : "";
            this.telefono = arreglo[5] != null ?  arreglo[5].toString() : "";
            this.pais = arreglo[6] != null ?  arreglo[6].toString() : "";
            this.provincia = arreglo[7] != null ?  arreglo[7].toString() : "";
            this.ciudad = arreglo[8] != null ?  arreglo[8].toString() : "";
            this.representante = arreglo[9] != null ?  arreglo[9].toString() : "";
        }
        
        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("CONSULTA MASCOTAS: %s REGISTROS CONSULTADOS", resultado.size());
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
        
    public boolean newMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("CREACION MASCOTA - %s:%s:%s", cmascota, identificacion, nombremascota);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERT, identificacion, nombremascota, direccion,web,telefono,pais,provincia,ciudad,representante);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean updateMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ACTUALIZACION MASCOTA - %s:%s:%s", cmascota, identificacion, nombremascota);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, identificacion, nombremascota, direccion,web,telefono,pais,provincia,ciudad,representante, cmascota);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean deleteMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ELIMINACION MASCOTA - %s:%s:%s", cmascota, identificacion, nombremascota);
        
        Cliente cliente = new Cliente();
        int registros = cliente.executeMultiple(SQL_UPDATE_USUARIOS, SQL_DELETE, cmascota);
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
        return nombremascota;
    }  
}
