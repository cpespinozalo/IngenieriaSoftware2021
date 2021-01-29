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
    
    private static final String SQL_SELECT_USUARIO = "SELECT USU.IDENTIFICACION, USU.ESTADO, TPU.RESPUESTA, USU.CUSUARIO "
            + "FROM TUSUARIO USU, TPREGUNTASUSUARIO TPU "
            + "WHERE USU.CUSUARIO=TPU.CUSUARIO "
            + "AND USU.USUARIO=? "
            + "AND TPU.CPREGUNTA=? "
            + "AND USU.ACTIVO=1 "
            + "AND TPU.ACTIVO=1 ";
    
    private static final String SQL_SELECT_PREGUNTA = "SELECT PREGUNTA "
            + "FROM TPREGUNTA "
            + "WHERE CPREGUNTA=? "
            + "AND ACTIVO=1 ";
    
    private static final String UPDATE_TUSUARIO = "UPDATE TUSUARIO "
            + "SET PASSWORD=? "
            + "WHERE CUSUARIO=? "
            + "AND ACTIVO=1 ";
    
    public ControladorRecuperacion(Integer pregunta) {

        this.pregunta = pregunta;
    }
    
    private List<Object> getDatosUsuario(String usuario){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_USUARIO, usuario, pregunta);
        return resultado;
    }
    
    public boolean existeUsuario(String usuario) throws Exception{
        
        boolean existe = false;
        this.datos =  getDatosUsuario(usuario);
        if(!datos.isEmpty()){
            setUsuarioData(datos);
            existe = true;
        }
        return existe;
    }
    
    public boolean savePassword(String password) throws Exception{
        
        CifradoAes aes = new CifradoAes();
        String passwordCifrada = aes.encriptar(password);
        Cliente cliente = new Cliente();
        return cliente.execute(UPDATE_TUSUARIO, passwordCifrada, this.cusuario) > 0;
    }
    
    public boolean validarIdentificacion(String id) throws Exception{
        
        return identificacion.equals(id);
    }

    public boolean validarRespuesta(String resp) throws Exception{
        
        CifradoAes aes = new CifradoAes();
        String respuestacifrada = aes.encriptar(resp);
        return respuestacifrada.equals(this.respuesta);
    }
    
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