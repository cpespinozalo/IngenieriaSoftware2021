package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 * Clase de Definicion de Sesiones de la aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Sesion  implements Serializable {
    
    private Integer idSesion;
    private Integer codigoUsuario;
    private String usuarioDes;
    private String nombreUsuario;
    private String genero;
    private Integer crol;
    private String nombreRol;
    private String descripcionRol;   
    private String finicio;
    private String ffin;
    private String resultado;
    private String sistema;
    private boolean isAdministrador;
    
    private static final long serialVersionUID = 1L;
    
    private static final String SQL_IDSESION = "SELECT NVL(MAX(IDSESION),0)+1 FROM TSESION ";
    private static final String SQL_SELECT = "SELECT IDSESION,USUARIO,TO_CHAR(FINICIOSESION,'DD-MM-YYYY HH24:MI:SS'),TO_CHAR(FFINSESION,'DD-MM-YYYY HH24:MI:SS'),RESULTADO,SISTEMA,CUSUARIO FROM TSESION WHERE IDSESION=? ";
    private static final String SQL_INSERT = "INSERT INTO TSESION (IDSESION,USUARIO,FINICIOSESION,RESULTADO,SISTEMA,CUSUARIO) VALUES (?,?,SYSTIMESTAMP,?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE TSESION SET FFINSESION=SYSTIMESTAMP WHERE IDSESION=? ";

    public Sesion(String usuario, Integer cusuario) {
        this.usuarioDes = usuario;
        this.codigoUsuario = cusuario;
    }
    
    
    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public String getUsuario() {
        return usuarioDes;
    }

    public void setUsuario(String usuarioDes) {
        this.usuarioDes = usuarioDes;
    }
    
    public String getFinicio() {
        return finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }
    
    public String getFfin() {
        return ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
    
    public Integer getCusuario() {
        return codigoUsuario;
    }

    public void setCusuario(Integer cusuario) {
        this.codigoUsuario = cusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCrol() {
        return crol;
    }

    public void setCrol(Integer crol) {
        this.crol = crol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public boolean isIsAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }
    
     public void getSesion(Integer codigo){
        
        List<Object> datos;
        Cliente cliente = new Cliente();
        datos = cliente.query(SQL_SELECT, codigo);
        for(Object dato : datos){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.idSesion = codigo;
            this.usuarioDes = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.finicio = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.ffin = arreglo[3] != null ?  arreglo[3].toString() : "";
            this.resultado = arreglo[4] != null ?  arreglo[4].toString() : "";
            this.sistema = arreglo[5] != null ?  arreglo[5].toString() : "";
            this.codigoUsuario = arreglo[6] != null ?  Integer.parseInt(arreglo[6].toString()) : null;
        }
    }
        
    public boolean newSesion(){
        
        setIdeSesion();
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERT, idSesion, usuarioDes, resultado, sistema, codigoUsuario);
        if(registros > 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean updateSesion(){
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, idSesion);
        if(registros > 0){
            return true;
        } else {
            return false;
        }
    }
    
    public void setIdeSesion(){
        
        Cliente cliente = new Cliente();
        this.idSesion = cliente.queryUnique(SQL_IDSESION);
    }
}
