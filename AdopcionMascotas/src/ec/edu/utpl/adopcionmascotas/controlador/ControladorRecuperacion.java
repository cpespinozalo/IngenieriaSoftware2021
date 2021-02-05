package ec.edu.utpl.adopcionmascotas.controlador;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.util.List;

/**
 * Clase Controlador de Recuperacion de Contraseña de la Aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class ControladorRecuperacion {
    
   
    private List<Object> datos;
    public Integer cusuario;
    public String usuario;
    public String identificacion;
    public String estado;
    public Integer pregunta;
    public String respuesta;
    /*metodo que genera la cadena que recupera de BDD el usuario*/
    private static final String SQL_SELECT_USUARIO = "SELECT USU.IDENTIFICACION, USU.ESTADO, TPU.RESPUESTA, USU.CUSUARIO "
            + "FROM TUSUARIO USU, TPREGUNTASUSUARIO TPU "
            + "WHERE USU.CUSUARIO=TPU.CUSUARIO "
            + "AND USU.USUARIO=? "
            + "AND TPU.CPREGUNTA=? "
            + "AND USU.ACTIVO=1 "
            + "AND TPU.ACTIVO=1 ";
    /*metodo que genera la cadena que recupera de BDD la pregunta de desafio*/
    private static final String SQL_SELECT_PREGUNTA = "SELECT PREGUNTA "
            + "FROM TPREGUNTA "
            + "WHERE CPREGUNTA=? "
            + "AND ACTIVO=1 ";
    /*metodo que genera la cadena graba o actualiza credenciales de usuario en BDD*/
    private static final String UPDATE_TUSUARIO = "UPDATE TUSUARIO "
            + "SET PASSWORD=? "
            + "WHERE CUSUARIO=? "
            + "AND ACTIVO=1 ";
    /*metodo que recupera pregunta*/
    public ControladorRecuperacion(Integer pregunta) {

        this.pregunta = pregunta;
    }
    /*metodo que recupera datos de usuario*/
    private List<Object> getDatosUsuario(String usuario){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_USUARIO, usuario, pregunta);
        return resultado;
    }
    /*metodo que valida la existencia de un usuario*/
    public boolean existeUsuario(String usuario) throws Exception{
        
        boolean existe = false;
        this.datos =  getDatosUsuario(usuario);
        if(!datos.isEmpty()){
            setUsuarioData(datos);
            existe = true;
        }
        return existe;
    }
    /*metodo que graba el password cifrado*/
    public boolean savePassword(String password) throws Exception{
        
        CifradoAes aes = new CifradoAes();
        String passwordCifrada = aes.encriptar(password);
        Cliente cliente = new Cliente();
        return cliente.execute(UPDATE_TUSUARIO, passwordCifrada, this.cusuario) > 0;
    }
    /*metodo que valida digito verificador de CI*/
    public boolean validarIdentificacion(String id) throws Exception{
        
        return identificacion.equals(id);
    }
/*metodo que valida la pregunta de desafio*/
    public boolean validarRespuesta(String resp) throws Exception{
        
        CifradoAes aes = new CifradoAes();
        String respuestacifrada = aes.encriptar(resp);
        return respuestacifrada.equals(this.respuesta);
    }
    /*metodo que graba los datos de usuario en base*/
    private void setUsuarioData(List<Object> dataList) throws Exception{
        
        for(Object dato : dataList){
            Object [] arreglo;
            arreglo = (Object [])dato;
            this.identificacion = arreglo[0].toString();
            this.estado = arreglo[1].toString();
            this.respuesta = arreglo[2].toString();
            this.cusuario = Integer.parseInt(arreglo[3].toString());
        }
    }
    /*metodo que recupera de BDD la pregunta de desafio*/
    public String getPregunta(){
        
        String preguntaDes = "";
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_PREGUNTA, this.pregunta);
        if(!resultado.isEmpty()){
            for(Object dato : resultado){
                preguntaDes = dato.toString();
            }
        }
        return preguntaDes;
    }

}