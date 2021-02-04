package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
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
    private String descripcion;
    private String cusuariopublicacion;
    private String fpublicacion;
    private String estadomascota;
    private String desestadomascota;
    private String propietario;
    private String direccion;
    private String provincia;
    private String ciudad;
    private String telefono;
    private String correo;
    private String cadopcion;
    private String cusuarioadopcion;
    private String usuarioadopcion;
    private String nombreusuarioadopcion;
    private String fadopcion;
    private String desestadoadopcion;
    private String estadoadopcion;
    
    private static final String SQL_SELECT = "SELECT MAS.CMASCOTA,MAS.NOMBRE,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.TIPOMASCOTA AND CCATALOGO=5007),MAS.EDAD,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.UNIDADEDAD AND CCATALOGO=5001) UNIDADEDAD,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.GENERO AND CCATALOGO=5008) GENERO,MAS.DESCRIPCION,(SELECT USUARIO FROM TUSUARIO WHERE CUSUARIO=MAS.CUSUARIOPUBLICACION) CUSUARIOPUBLICACION,TO_CHAR(MAS.FPUBLICACION,'dd-mm-yyyy HH24:MI:SS') FPUBLICACION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.ESTADO AND CCATALOGO=5006) ESTADO,USU.NOMBRES || ' ' || USU.APELLIDOS PROPIETARIO,USU.DIRECCION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002) PROVINCIA,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003) CIUDAD,USU.TELEFONO,USU.CORREO,(SELECT TO_CHAR(FADOPCION,'dd-mm-yyyy HH24:MI:SS') FROM TADOPCION WHERE CMASCOTA=MAS.CMASCOTA AND ESTADOADOPCION IN ('ING','PRO') AND ACTIVO=1) FADOPCION, NVL((SELECT (SELECT NOMBRE FROM TITEM WHERE CODIGO=ADO.ESTADOADOPCION AND CCATALOGO=5009) ESTADOADOPCION FROM TADOPCION ADO WHERE ADO.CMASCOTA=MAS.CMASCOTA AND ADO.ACTIVO=1),'NOA') ESTADOADOPCION FROM TMASCOTA MAS, TUSUARIO USU WHERE MAS.CUSUARIOPUBLICACION=USU.CUSUARIO AND MAS.CMASCOTA=? ";
    private static final String SQL_INSERT = "INSERT INTO TMASCOTA (CMASCOTA,NOMBRE,TIPOMASCOTA,EDAD,UNIDADEDAD,GENERO,DESCRIPCION,CUSUARIOPUBLICACION,FPUBLICACION,ESTADO,ACTIVO) VALUES ((SELECT NVL(MAX(CMASCOTA),0)+1 FROM TMASCOTA),?,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5007),?,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5001),(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5008),?,(SELECT CUSUARIO FROM TUSUARIO WHERE USUARIO=?),SYSDATE,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5006),1) ";
    private static final String SQL_INSERTADOPCION = "INSERT INTO TADOPCION (CADOPCION,CMASCOTA,CUSUARIOADOPCION,FADOPCION,IDSESION,ESTADOADOPCION,ACTIVO) VALUES ((SELECT NVL(MAX(CADOPCION),0)+1 FROM TADOPCION),?,(SELECT CUSUARIO FROM TUSUARIO WHERE USUARIO=?),SYSDATE,?,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5009),1) ";
    private static final String SQL_UPDATE = "UPDATE TMASCOTA SET NOMBRE=?,TIPOMASCOTA=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5007),EDAD=?,UNIDADEDAD=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5001),GENERO=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5008),DESCRIPCION=?,CUSUARIOPUBLICACION=(SELECT CUSUARIO FROM TUSUARIO WHERE USUARIO=?),FPUBLICACION=SYSDATE,ESTADO=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5006) WHERE CMASCOTA=? ";
    private static final String SQL_UPDATEADOPCION = "UPDATE TADOPCION SET CMASCOTA=?,CUSUARIOADOPCION=(SELECT CUSUARIO FROM TUSUARIO WHERE USUARIO=?),FADOPCION=SYSDATE,IDSESION=?,ESTADOADOPCION=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5009) WHERE CADOPCION=? ";
    private static final String SQL_DELETE = "DELETE TMASCOTA WHERE CMASCOTA=? ";
    private static final String SQL_DELETEADOPCION = "DELETE TADOPCION WHERE CADOPCION=? ";
    private static final String SQL_UPDATE_ADOPCION = "UPDATE TADOPCION SET CMASCOTA=NULL WHERE CMASCOTA=? ";
    private static final String SQL_UPDATE_MASCOTA = "UPDATE TMASCOTA SET ESTADO=? WHERE CMASCOTA=? ";
    private static final String SQL_SELECTUSUARIO = "SELECT USU.NOMBRES || ' ' || USU.APELLIDOS,USU.DIRECCION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002),(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003),USU.TELEFONO,USU.CORREO FROM TUSUARIO USU WHERE USU.CUSUARIO=? ";

    private static final String SQL_LISTADOMASCOTAS = "SELECT MAS.CMASCOTA,MAS.NOMBRE,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.TIPOMASCOTA AND CCATALOGO=5007) TIPOMASCOTA,MAS.EDAD,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.UNIDADEDAD AND CCATALOGO=5001) UNIDADEDAD,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.GENERO AND CCATALOGO=5008) GENERO,MAS.DESCRIPCION,(SELECT USUARIO FROM TUSUARIO WHERE CUSUARIO=MAS.CUSUARIOPUBLICACION) CUSUARIOPUBLICACION,TO_CHAR(MAS.FPUBLICACION,'dd-mm-yyyy HH24:MI:SS') FPUBLICACION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.ESTADO AND CCATALOGO=5006) ESTADO,INITCAP(USU.NOMBRES || ' ' || USU.APELLIDOS),USU.DIRECCION,(SELECT INITCAP(NOMBRE) FROM TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002) PROVINCIA,(SELECT INITCAP(NOMBRE) FROM TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003) CIUDAD,USU.TELEFONO,USU.CORREO,MAS.ESTADO,ADO.CUSUARIOADOPCION,(SELECT USUARIO FROM TUSUARIO WHERE CUSUARIO=ADO.CUSUARIOADOPCION),(SELECT NOMBRES || ' ' || APELLIDOS FROM TUSUARIO WHERE CUSUARIO=ADO.CUSUARIOADOPCION),NVL((SELECT NOMBRE FROM TITEM WHERE CODIGO=ADO.ESTADOADOPCION AND CCATALOGO=5009),'SIN ADOPCION'),NVL(ADO.ESTADOADOPCION,'NOA'),TO_CHAR(ADO.FADOPCION,'DD-MM-YYYY HH24:MI:SS') FROM TMASCOTA MAS, TUSUARIO USU, TADOPCION ADO WHERE MAS.CMASCOTA=ADO.CMASCOTA(+) AND MAS.CUSUARIOPUBLICACION=USU.CUSUARIO ";
    private static final String SQL_LISTADOADOPCIONMASCOTAS = "SELECT MAS.CMASCOTA,MAS.NOMBRE,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.TIPOMASCOTA AND CCATALOGO=5007) TIPOMASCOTA,MAS.EDAD,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.UNIDADEDAD AND CCATALOGO=5001) UNIDADEDAD,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.GENERO AND CCATALOGO=5008) GENERO,MAS.DESCRIPCION,(SELECT USUARIO FROM TUSUARIO WHERE CUSUARIO=MAS.CUSUARIOPUBLICACION) CUSUARIOPUBLICACION,TO_CHAR(MAS.FPUBLICACION,'dd-mm-yyyy HH24:MI:SS') FPUBLICACION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=MAS.ESTADO AND CCATALOGO=5006) ESTADO,INITCAP(USU.NOMBRES || ' ' || USU.APELLIDOS),USU.DIRECCION,(SELECT INITCAP(NOMBRE) FROM TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002) PROVINCIA,(SELECT INITCAP(NOMBRE) FROM TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003) CIUDAD,USU.TELEFONO,USU.CORREO,MAS.ESTADO,ADO.CUSUARIOADOPCION,(SELECT USUARIO FROM TUSUARIO WHERE CUSUARIO=ADO.CUSUARIOADOPCION),(SELECT NOMBRES || ' ' || APELLIDOS FROM TUSUARIO WHERE CUSUARIO=ADO.CUSUARIOADOPCION),(SELECT NOMBRE FROM TITEM WHERE CODIGO=ADO.ESTADOADOPCION AND CCATALOGO=5009),ADO.ESTADOADOPCION,TO_CHAR(ADO.FADOPCION,'DD-MM-YYYY HH24:MI:SS') FROM TMASCOTA MAS, TUSUARIO USU, TADOPCION ADO WHERE MAS.CMASCOTA=ADO.CMASCOTA AND ADO.CUSUARIOADOPCION=USU.CUSUARIO ";
    
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
    
    public String getDesestadomascota() {
        return desestadomascota;
    }

    public void setDesestadomascota(String desestadomascota) {
        this.desestadomascota = desestadomascota;
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

    public String getDesestadoadopcion() {
        return desestadoadopcion;
    }

    public void setDesestadoadopcion(String desestadoadopcion) {
        this.desestadoadopcion = desestadoadopcion;
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

    public String getUsuarioadopcion() {
        return usuarioadopcion;
    }

    public void setUsuarioadopcion(String usuarioadopcion) {
        this.usuarioadopcion = usuarioadopcion;
    }

    public String getNombreusuarioadopcion() {
        return nombreusuarioadopcion;
    }

    public void setNombreusuarioadopcion(String nombreusuarioadopcion) {
        this.nombreusuarioadopcion = nombreusuarioadopcion;
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
    
    public List<Mascota> getListadoMascota(Integer id, String estado, String usuario, Integer tipo){
        
        List<Mascota> listamascotas = new ArrayList<>();
        Cliente cliente = new Cliente();
        List<Object> resultado = new ArrayList<>();
        if(tipo.compareTo(1)==0){
            resultado = cliente.query(SQL_LISTADOMASCOTAS + "AND MAS.ESTADO=?", estado);
        } else if(tipo.compareTo(2)==0){
            resultado = cliente.query(SQL_LISTADOADOPCIONMASCOTAS + "AND MAS.ESTADO=? AND USU.USUARIO=? ", estado, usuario);
        } else if(tipo.compareTo(3)==0){
            resultado = cliente.query(SQL_LISTADOMASCOTAS + "AND USU.USUARIO=? ", usuario);
        } 
        
        for(Object dato : resultado){
            Object [] arreglo = (Object [])dato;
            Mascota mas = new Mascota(sesionId);
            mas.setCmascota(arreglo[0] != null ?  Integer.parseInt(arreglo[0].toString()) : null);
            mas.setNombremascota(arreglo[1] != null ?  arreglo[1].toString() : "");
            mas.setTipomascota(arreglo[2] != null ?  arreglo[2].toString() : "");
            mas.setEdad(arreglo[3] != null ?  arreglo[3].toString() : "");
            mas.setUnidadedad(arreglo[4] != null ?  arreglo[4].toString() : "");
            mas.setGenero(arreglo[5] != null ?  arreglo[5].toString() : "");
            mas.setDescripcion(arreglo[6] != null ?  arreglo[6].toString() : "");
            mas.setCusuariopublicacion(arreglo[7] != null ?  arreglo[7].toString() : "");
            mas.setFpublicacion(arreglo[8] != null ?  arreglo[8].toString() : "");
            mas.setDesestadomascota(arreglo[9] != null ?  arreglo[9].toString() : "");
            mas.setPropietario(arreglo[10] != null ?  arreglo[10].toString() : "");
            mas.setDireccion(arreglo[11] != null ?  arreglo[11].toString() : "");
            mas.setProvincia(arreglo[12] != null ?  arreglo[12].toString() : "");
            mas.setCiudad(arreglo[13] != null ?  arreglo[13].toString() : "");
            mas.setTelefono(arreglo[14] != null ?  arreglo[14].toString() : "");
            mas.setCorreo(arreglo[15] != null ?  arreglo[15].toString() : "");
            mas.setEstadomascota(arreglo[16] != null ?  arreglo[16].toString() : "");
            mas.setCusuarioadopcion(arreglo[17] != null ?  arreglo[17].toString() : "");
            mas.setUsuarioadopcion(arreglo[18] != null ?  arreglo[18].toString() : "");
            mas.setNombreusuarioadopcion(arreglo[19] != null ?  arreglo[19].toString() : "");
            mas.setDesestadoadopcion(arreglo[20] != null ?  arreglo[20].toString() : "");
            mas.setEstadoadopcion(arreglo[21] != null ?  arreglo[21].toString() : "");
            mas.setFadopcion(arreglo[22] != null ?  arreglo[22].toString() : "");
            listamascotas.add(mas);
        }
        return listamascotas;
    }
        
    public boolean newMascota(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = "CREACION MASCOTA";
        
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
        String detalle = "ACTUALIZACION MASCOTA";
        
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
        String detalle = "ELIMINACION MASCOTA";
        
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
        String detalle = "ADOPCION MASCOTA";

        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERTADOPCION, cmascota, cusuarioadopcion, sesionId, "MASCOTA ADOPTADA");
        if(registros > 0){
            Cliente clienteaux = new Cliente();
            clienteaux.execute(SQL_UPDATE_MASCOTA, "A", cmascota); 
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
        String detalle = "ACTUALIZACION ADOPCION MASCOTA";
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATEADOPCION, cmascota, cusuarioadopcion, sesionId, estadoadopcion, cadopcion);
        if(registros > 0){
            if("ADOPCION ANULADA".equals(estadoadopcion)){
                cliente.execute(SQL_UPDATE_MASCOTA, "D", cmascota); 
            }else if("ADOPCION DEVUELTA".equals(estadoadopcion)){
                cliente.execute(SQL_UPDATE_MASCOTA, "R", cmascota); 
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
        String detalle = "ELIMINACION ADOPCION MASCOTA";
        
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
