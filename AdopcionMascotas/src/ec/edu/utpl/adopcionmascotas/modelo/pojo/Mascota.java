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
    private String nombremascota;
    private String tipomascota;
    private String edad;
    private String unidadedad;
    private String genero;
    private String propietario;
    private String direccion;
    private String provincia;
    private String descripcion;
    private String cusuariopublicacion;
    private String fpublicacion;
    private String estadomascota;
    private String ciudad;
    private String telefono;
    private String correo;
    private String cadopcion;
    private String cusuarioadopcion;
    private String fadopcion;
    private String estadoadopcion;
    
    private static final String SQL_SELECT = "SELECT MAS.CMASCOTA,MAS.NOMBRE,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=MAS.TIPOMASCOTA AND CCATALOGO=5007) TIPOMASCOTA,MAS.EDAD,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=MAS.UNIDADEDAD AND CCATALOGO=5001) UNIDADEDAD,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=MAS.GENERO AND CCATALOGO=5008) GENERO,MAS.DESCRIPCION,(SELECT USUARIO FROM MASCOTAS.TUSUARIO WHERE CUSUARIO=MAS.CUSUARIOPUBLICACION) CUSUARIOPUBLICACION,TO_DATE(MAS.FPUBLICACION,'dd-mm-yyyy hh24:mi:ss') FPUBLICACION,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=MAS.ESTADO AND CCATALOGO=5006) ESTADO,USU.NOMBRES || ' ' || USU.APELLIDOS PROPIETARIO,USU.DIRECCION,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002) PROVINCIA,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003) CIUDAD,USU.TELEFONO,USU.CORREO,(SELECT TO_DATE(FADOPCION,'dd-mm-yyyy hh24:mi:ss') FROM MASCOTAS.TADOPCION WHERE CMASCOTA=MAS.CMASCOTA AND ESTADOADOPCION IN ('ING','PRO') AND ACTIVO=1) FADOPCION, NVL((SELECT (SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=ADO.ESTADOADOPCION AND CCATALOGO=5009) ESTADOADOPCION FROM MASCOTAS.TADOPCION ADO WHERE ADO.CMASCOTA=MAS.CMASCOTA AND ADO.ACTIVO=1),'NOA') ESTADOADOPCION FROM MASCOTAS.TMASCOTA MAS, MASCOTAS.TUSUARIO USU WHERE MAS.CUSUARIOPUBLICACION=USU.CUSUARIO AND MAS.CMASCOTA=? ";
    private static final String SQL_INSERT = "INSERT INTO MASCOTAS.TMASCOTA (CMASCOTA,NOMBRE,TIPOMASCOTA,EDAD,UNIDADEDAD,GENERO,DESCRIPCION,CUSUARIOPUBLICACION,FPUBLICACION,ESTADO,ACTIVO) VALUES ((SELECT NVL(MAX(CMASCOTA),0)+1 FROM MASCOTAS.TMASCOTA),?,(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5007),?,(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5001),(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5008),?,(SELECT CUSUARIO FROM MASCOTAS.TUSUARIO WHERE USUARIO=?),SYSDATE,(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5006),1) ";
    private static final String SQL_INSERTADOPCION = "INSERT INTO MASCOTAS.TADOPCION (CADOPCION,CMASCOTA,CUSUARIOADOPCION,FADOPCION,IDSESION,ESTADOADOPCION,ACTIVO) VALUES ((SELECT NVL(MAX(CADOPCION),0)+1 FROM MASCOTAS.TADOPCION),?,(SELECT CUSUARIO FROM MASCOTAS.TUSUARIO WHERE USUARIO=?),SYSDATE,?,(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5009),1) ";
    private static final String SQL_UPDATE = "UPDATE MASCOTAS.TMASCOTA SET NOMBRE=?,TIPOMASCOTA=(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5007),EDAD=?,UNIDADEDAD=(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5001),GENERO=(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5008),DESCRIPCION=?,CUSUARIOPUBLICACION=(SELECT CUSUARIO FROM MASCOTAS.TUSUARIO WHERE USUARIO=?),FPUBLICACION=SYSDATE,ESTADO=(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5006) WHERE CMASCOTA=? ";
    private static final String SQL_UPDATEADOPCION = "UPDATE MASCOTAS.TADOPCION SET CMASCOTA=?,CUSUARIOADOPCION=(SELECT CUSUARIO FROM MASCOTAS.TUSUARIO WHERE USUARIO=?),FADOPCION=SYSDATE,IDSESION=?,ESTADOADOPCION=(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5009) WHERE CADOPCION=? ";
    private static final String SQL_DELETE = "DELETE MASCOTAS.TMASCOTA WHERE CMASCOTA=? ";
    private static final String SQL_DELETEADOPCION = "DELETE MASCOTAS.TADOPCION WHERE CADOPCION=? ";
    private static final String SQL_UPDATE_ADOPCION = "UPDATE MASCOTAS.TADOPCION SET CMASCOTA=NULL WHERE CMASCOTA=? ";
    private static final String SQL_UPDATE_MASCOTA = "UPDATE MASCOTAS.TMASCOTA SET ESTADO=(SELECT CODIGO FROM MASCOTAS.TITEM WHERE NOMBRE=? AND CCATALOGO=5006) WHERE CMASCOTA=? ";
    private static final String SQL_SELECTUSUARIO = "SELECT USU.NOMBRES || ' ' || USU.APELLIDOS,USU.DIRECCION,(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002),(SELECT NOMBRE FROM MASCOTAS.TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003),USU.TELEFONO,USU.CORREO FROM MASCOTAS.TUSUARIO USU WHERE USU.CUSUARIO=? ";

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

    public String getTipomascota() {
        return tipomascota;
    }

    public void setTipomascota(String tipomascota) {
        this.tipomascota = tipomascota;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getUnidadedad() {
        return unidadedad;
    }

    public void setUnidadedad(String unidadedad) {
        this.unidadedad = unidadedad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCusuariopublicacion() {
        return cusuariopublicacion;
    }

    public void setCusuariopublicacion(String cusuariopublicacion) {
        this.cusuariopublicacion = cusuariopublicacion;
    }

    public String getFpublicacion() {
        return fpublicacion;
    }

    public void setFpublicacion(String fpublicacion) {
        this.fpublicacion = fpublicacion;
    }

    public String getEstadomascota() {
        return estadomascota;
    }

    public void setEstadomascota(String estadomascota) {
        this.estadomascota = estadomascota;
    }

    public String getFadopcion() {
        return fadopcion;
    }

    public void setFadopcion(String fadopcion) {
        this.fadopcion = fadopcion;
    }

    public String getEstadoadopcion() {
        return estadoadopcion;
    }

    public void setEstadoadopcion(String estadoadopcion) {
        this.estadoadopcion = estadoadopcion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCadopcion() {
        return cadopcion;
    }

    public void setCadopcion(String cadopcion) {
        this.cadopcion = cadopcion;
    }

    public String getCusuarioadopcion() {
        return cusuarioadopcion;
    }

    public void setCusuarioadopcion(String cusuarioadopcion) {
        this.cusuarioadopcion = cusuarioadopcion;
    }
     
    public void getMascota(Integer codigo){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT, codigo);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.cmascota = codigo;
            this.nombremascota = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.tipomascota = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.edad = arreglo[3] != null ?  arreglo[3].toString() : "";
            this.unidadedad = arreglo[4] != null ?  arreglo[4].toString() : "";
            this.genero = arreglo[5] != null ?  arreglo[5].toString() : "";
            this.descripcion = arreglo[6] != null ?  arreglo[6].toString() : "";
            this.cusuariopublicacion = arreglo[7] != null ?  arreglo[7].toString() : "";
            this.fpublicacion = arreglo[8] != null ?  arreglo[8].toString() : "";
            this.estadomascota = arreglo[9] != null ?  arreglo[9].toString() : "";
            this.propietario = arreglo[10] != null ?  arreglo[10].toString() : "";
            this.direccion = arreglo[11] != null ?  arreglo[11].toString() : "";
            this.provincia = arreglo[12] != null ?  arreglo[12].toString() : "";
            this.ciudad = arreglo[13] != null ?  arreglo[13].toString() : "";
            this.telefono = arreglo[14] != null ?  arreglo[14].toString() : "";
            this.correo = arreglo[15] != null ?  arreglo[15].toString() : "";
            this.fadopcion = arreglo[16] != null ?  arreglo[16].toString() : "";
            this.estadoadopcion = arreglo[17] != null ?  arreglo[17].toString() : "";
            
        }
        
        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("CONSULTA MASCOTAS: %s REGISTROS CONSULTADOS", resultado.size());
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
        
    public boolean newMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("CREACION MASCOTA - %s:%s:%s", nombremascota, tipomascota, edad);

        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERT, nombremascota, tipomascota, edad, unidadedad, genero, descripcion, cusuariopublicacion, estadomascota);
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
        String detalle = String.format("ACTUALIZACION MASCOTA - %s:%s:%s", cmascota, nombremascota, tipomascota);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, nombremascota, tipomascota, edad, unidadedad, genero, descripcion, cusuariopublicacion, estadomascota, cmascota);
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
        String detalle = String.format("ELIMINACION MASCOTA - %s:%s:%s", cmascota, nombremascota, tipomascota);
        
        Cliente cliente = new Cliente();
        int registros = cliente.executeMultiple(SQL_UPDATE_ADOPCION, SQL_DELETE, cmascota);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    } 
    
    public boolean newAdopcionMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ADOPCION MASCOTA - %s:%s:%s", cmascota, nombremascota, tipomascota);

        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERTADOPCION, cadopcion, cmascota, cusuarioadopcion, sesionId, estadoadopcion);
        if(registros > 0){
            cliente.execute(SQL_UPDATE_MASCOTA, "A", cmascota); 
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean updateAdopcionMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ACTUALIZACION ADOPCION MASCOTA - %s:%s:%s", cadopcion, cmascota, nombremascota);
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATEADOPCION, cmascota, cusuarioadopcion, sesionId, estadoadopcion, cadopcion);
        if(registros > 0){
            if("ANU".equals(estadoadopcion)){
                cliente.execute(SQL_UPDATE_MASCOTA, "D", cmascota); 
            }else if("DEV".equals(estadoadopcion)){
                cliente.execute(SQL_UPDATE_MASCOTA, "R", cmascota); 
            } else {
                cliente.execute(SQL_UPDATE_MASCOTA, "A", cmascota);
            }
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean deleteAdopcionMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ELIMINACION ADOPCION MASCOTA - %s:%s:%s", cadopcion, cmascota, nombremascota);
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_DELETEADOPCION, cadopcion);
        if(registros > 0){
            cliente = new Cliente();
            cliente.execute(SQL_UPDATE_MASCOTA, "D", cmascota);       
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
