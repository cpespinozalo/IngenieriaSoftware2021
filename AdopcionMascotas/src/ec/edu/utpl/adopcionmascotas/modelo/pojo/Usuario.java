package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.controlador.CifradoAes;
import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase de Definicion de Usuarios de la aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Usuario implements Serializable {
    
    private Auditoria auditoria;
    private static final long serialVersionUID = 1L;
    private Integer sesionId;
    private Integer cusuario;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String provincia;
    private String ciudad;
    private String telefono;
    private String usuario;
    private String seguridad;
    private String cestado;
    private String correo;
    private String genero;
    private String activo;
    private String estado;
    private String dactivo;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4; 
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private String pregunta4;
    
    private static final String  SQL_SELECTCUSUARIO = "SELECT MAX(CUSUARIO) FROM TUSUARIO WHERE USUARIO=? ";
    private static final String SQL_SELECT = "SELECT USU.CUSUARIO,USU.IDENTIFICACION,INITCAP(USU.NOMBRES),INITCAP(USU.APELLIDOS),USU.USUARIO,USU.PASSWORD,USU.CORREO,USU.GENERO,USU.ACTIVO,USU.ESTADO CESTADO, (SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.ESTADO AND CCATALOGO=5010), (SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.ACTIVO AND CCATALOGO=5005), USU.DIRECCION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002) PROVINCIA,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003) CIUDAD,USU.TELEFONO FROM TUSUARIO USU  WHERE USU.CUSUARIO=? ";
    private static final String SQL_SELECTRESUMEN = "SELECT USU.CUSUARIO,INITCAP(USU.NOMBRES),INITCAP(USU.APELLIDOS),USU.DIRECCION,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.PROVINCIA AND CCATALOGO=5002) PROVINCIA,(SELECT NOMBRE FROM TITEM WHERE CODIGO=USU.CIUDAD AND CODIGOPADRE=USU.PROVINCIA AND CCATALOGO=5003),USU.CORREO,USU.TELEFONO FROM TUSUARIO USU  WHERE USU.USUARIO=? ";
    private static final String SQL_INSERT = "INSERT INTO TUSUARIO (CUSUARIO,IDENTIFICACION,NOMBRES,APELLIDOS,USUARIO,PASSWORD,ESTADO,CORREO,GENERO,ACTIVO,DIRECCION,TELEFONO,PROVINCIA,CIUDAD) VALUES ((SELECT NVL(MAX(CUSUARIO),0)+1 FROM TUSUARIO),?,?,?,?,?,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5010),?,?,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5005),?,?,(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5002),(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5003)) ";
    private static final String SQL_UPDATE = "UPDATE TUSUARIO SET IDENTIFICACION=?,NOMBRES=?,APELLIDOS=?,USUARIO=?,PASSWORD=?,ESTADO=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5010),CORREO=?,GENERO=?,ACTIVO=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5005),DIRECCION=?,TELEFONO=?,PROVINCIA=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5002),CIUDAD=(SELECT CODIGO FROM TITEM WHERE NOMBRE=? AND CCATALOGO=5003) WHERE CUSUARIO=? ";
    private static final String SQL_DELETE_DEP = "DELETE TROLUSUARIO WHERE CUSUARIO=? ";
    private static final String SQL_DELETE_PRE = "DELETE TPREGUNTASUSUARIO WHERE CUSUARIO=? ";
    private static final String SQL_DELETE = "DELETE TUSUARIO WHERE CUSUARIO=? ";
    private static final String SQL_SELECT_PREGUNTAS = "SELECT CPREGUNTA,PREGUNTA FROM TPREGUNTA WHERE ACTIVO=? ";
    private static final String SQL_SELECT_PREGUNTASUSUARIO = "SELECT CPREGUNTA, RESPUESTA FROM TPREGUNTASUSUARIO WHERE CUSUARIO=? ";
    private static final String SQL_INSERT_PREGUNTASUSUARIO = "INSERT INTO TPREGUNTASUSUARIO(CPREGUNTA,CUSUARIO,RESPUESTA,FMODIFICACION,ACTIVO) VALUES (?,?,?,SYSDATE,1) ";
    private static final String SQL_UPDATE_PREGUNTASUSUARIO = "UPDATE TPREGUNTASUSUARIO SET RESPUESTA=?,FMODIFICACION=SYSDATE WHERE CPREGUNTA=? AND CUSUARIO=? ";
    
    private static final String SQL_INSERT_ROLES = "MERGE INTO TROLUSUARIO A USING (SELECT CROL, ? CUSUARIO, 1 ACTIVO FROM TROL WHERE DESCRIPCION=?) B ON (A.CROL=B.CROL AND A.CUSUARIO=B.CUSUARIO) WHEN NOT MATCHED THEN INSERT (CROL,CUSUARIO,ACTIVO) VALUES (B.CROL, B.CUSUARIO, B.ACTIVO)";
    
    
    public Usuario(Integer sesionId) {
        this.sesionId = sesionId;
        this.auditoria = new Auditoria();
    }

    
    public Integer getCusuario() {
        return cusuario;
    }

    public void setCusuario(Integer cusuario) {
        this.cusuario = cusuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
     public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public String getCestado() {
        return cestado;
    }

    public void setCestado(String cestado) {
        this.cestado = cestado;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDactivo() {
        return dactivo;
    }

    public void setDactivo(String dactivo) {
        this.dactivo = dactivo;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public String getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public String getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(String pregunta4) {
        this.pregunta4 = pregunta4;
    }

    
    public void getUsuario(Integer codigo) {
        
        CifradoAes aes = new CifradoAes();
        List<Object> resultado = new ArrayList<>();
        List<Object> resultadoRes;
        List<Object> resultadoPre;
        
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT, codigo);
        for(Object dato : resultado){
           
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.cusuario = codigo;
            this.identificacion = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.nombres = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.apellidos = arreglo[3] != null ?  arreglo[3].toString() : "";
            this.usuario = arreglo[4] != null ?  arreglo[4].toString() : "";
            this.seguridad = arreglo[5] != null ?  aes.desencriptar(arreglo[5].toString()) : "";
            this.correo = arreglo[6] != null ?  arreglo[6].toString() : "";
            this.genero = arreglo[7] != null ?  arreglo[7].toString() : "";
            this.activo = arreglo[8] != null ?  arreglo[8].toString() : "";
            this.cestado = arreglo[9] != null ?  arreglo[9].toString() : "";
            this.estado = arreglo[10] != null ?  arreglo[10].toString() : "";
            this.dactivo = arreglo[11] != null ?  arreglo[11].toString() : "";
            this.direccion = arreglo[12] != null ?  arreglo[12].toString() : "";
            this.provincia = arreglo[13] != null ?  arreglo[13].toString() : "";
            this.ciudad = arreglo[14] != null ?  arreglo[14].toString() : "";
            this.telefono = arreglo[15] != null ?  arreglo[15].toString() : "";  
        }

        Cliente clienteRes = new Cliente();
        resultadoRes = clienteRes.query(SQL_SELECT_PREGUNTASUSUARIO, codigo);
        for(Object dato : resultadoRes){
            Object [] arreglo;
            arreglo = (Object [])dato;
            String cpregunta = arreglo[0] != null ?  arreglo[0].toString() : "";
            if("1".equals(cpregunta)){
                this.respuesta1 = arreglo[1] != null ?  aes.desencriptar(arreglo[1].toString()) : "";
            } else if("2".equals(cpregunta)){
                this.respuesta2 = arreglo[1] != null ?  aes.desencriptar(arreglo[1].toString()) : "";
            } else if("3".equals(cpregunta)){
                this.respuesta3 = arreglo[1] != null ?  aes.desencriptar(arreglo[1].toString()) : "";
            } else if("4".equals(cpregunta)){ 
                this.respuesta4 = arreglo[1] != null ?  aes.desencriptar(arreglo[1].toString()) : "";
            }
        }
        
        Cliente clientePre = new Cliente();
        resultadoPre = clientePre.query(SQL_SELECT_PREGUNTAS, 1);
        for(Object dato : resultadoPre){
            Object [] arreglo;
            arreglo = (Object [])dato;
            String cpregunta = arreglo[0] != null ?  arreglo[0].toString() : "";
            if("1".equals(cpregunta)){
                this.pregunta1 = arreglo[1] != null ?  arreglo[1].toString() : "";
            } else if("2".equals(cpregunta)){
                this.pregunta2 = arreglo[1] != null ?  arreglo[1].toString() : "";
            } else if("3".equals(cpregunta)){
                this.pregunta3 = arreglo[1] != null ?  arreglo[1].toString() : "";
            } else if("4".equals(cpregunta)){ 
                this.pregunta4 = arreglo[1] != null ?  arreglo[1].toString() : "";
            }
        }

        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("CONSULTA USUARIOS: %s REGISTROS CONSULTADOS", resultado.size());
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
      
    public void getUsuario(String usuario) {
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECTRESUMEN, usuario);
        for(Object dato : resultado){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.cusuario = arreglo[0] != null ?  Integer.parseInt(arreglo[0].toString()) : null;
            this.nombres = arreglo[1] != null ?  arreglo[1].toString() : "";
            this.apellidos = arreglo[2] != null ?  arreglo[2].toString() : "";
            this.direccion = arreglo[3] != null ?  arreglo[3].toString() : "";
            this.provincia = arreglo[4] != null ?  arreglo[4].toString() : "";
            this.ciudad = arreglo[5] != null ?  arreglo[5].toString() : "";
            this.correo = arreglo[6] != null ?  arreglo[6].toString() : "";
            this.telefono = arreglo[7] != null ?  arreglo[7].toString() : "";
        }
    }
    
    public void setNewCusuario(String usuario) {
        
        Cliente cliente = new Cliente();
        this.cusuario = cliente.queryUnique(SQL_SELECTCUSUARIO, usuario);
    }
    
    public boolean newUsuario() {
        
        boolean creacion = false;
            CifradoAes aes = new CifradoAes();

            Cliente cliente = new Cliente();
            int registros = cliente.execute(SQL_INSERT, identificacion, nombres, apellidos, usuario, aes.encriptar(seguridad), estado, correo, genero, dactivo, direccion, telefono, provincia, ciudad);

            if(registros > 0){
                setNewCusuario(usuario);
                if(cusuario!=null){
                    Cliente cliente0 = new Cliente();
                    cliente0.execute(SQL_INSERT_ROLES, cusuario, "Usuario de Adopciones");

                    Cliente cliente1 = new Cliente();
                    cliente1.execute(SQL_INSERT_PREGUNTASUSUARIO, 1, cusuario, aes.encriptar(respuesta1));

                    Cliente cliente2 = new Cliente();
                    cliente2.execute(SQL_INSERT_PREGUNTASUSUARIO, 2, cusuario, aes.encriptar(respuesta2));

                    Cliente cliente3 = new Cliente();
                    cliente3.execute(SQL_INSERT_PREGUNTASUSUARIO, 3, cusuario, aes.encriptar(respuesta3));

                    Cliente cliente4 = new Cliente();
                    cliente4.execute(SQL_INSERT_PREGUNTASUSUARIO, 4, cusuario, aes.encriptar(respuesta4));

                    creacion = true;
                }
            } else {
                return false;
            }
        return creacion;
    }
    
    public boolean updateUsuario() {
        
        CifradoAes aes = new CifradoAes();
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ACTUALIZACION USUARIO - %s:%s:%s %s", cusuario, identificacion, nombres, apellidos);

        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_UPDATE, identificacion, nombres, apellidos, usuario, aes.encriptar(seguridad), estado, correo, genero, dactivo, direccion, telefono, provincia, ciudad, cusuario);

        Cliente cliente1 = new Cliente();
        cliente1.execute(SQL_UPDATE_PREGUNTASUSUARIO, aes.encriptar(respuesta1), 1, cusuario);

        Cliente cliente2 = new Cliente();
        cliente2.execute(SQL_UPDATE_PREGUNTASUSUARIO, aes.encriptar(respuesta2), 2, cusuario);

        Cliente cliente3 = new Cliente();
        cliente3.execute(SQL_UPDATE_PREGUNTASUSUARIO, aes.encriptar(respuesta3), 3, cusuario);

        Cliente cliente4 = new Cliente();
        cliente4.execute(SQL_UPDATE_PREGUNTASUSUARIO, aes.encriptar(respuesta4), 4, cusuario);

        Cliente cliente5 = new Cliente();
        cliente5.execute(SQL_DELETE_DEP, cusuario);

        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }
    
    public boolean deleteUsuario(){
        
        String tipo= "MODIFICACION";
        String accion= "CAMBIOS EN EL SISTEMA";
        String detalle = String.format("ELIMINACION USUARIO - %s:%s:%s %s", cusuario, identificacion, nombres, apellidos);
        
        
        Cliente cliente = new Cliente();
        int registros = cliente.executeMultiple(SQL_DELETE_DEP, SQL_DELETE_PRE, SQL_DELETE, cusuario);
        if(registros > 0){
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
            return true;
        } else {
            auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "ERROR");
            return false;
        }
    }

}
       