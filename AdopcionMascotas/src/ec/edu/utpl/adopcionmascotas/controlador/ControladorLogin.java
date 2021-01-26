package ec.edu.utpl.adopcionmascotas.controlador;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Controlador de Login de la Aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class ControladorLogin {
    
    public Integer cusuario;
    private List<Object> datos;
    
    private static final String SQL_SELECT_USUARIO = "SELECT USU.CUSUARIO, USU.USUARIO, USU.PASSWORD, TPU.RESPUESTA "
            + "FROM MASCOTAS.TUSUARIO USU, MASCOTAS.TPREGUNTASUSUARIO TPU "
            + "WHERE USU.CUSUARIO=TPU.CUSUARIO "
            + "AND USU.USUARIO=? "
            + "AND USU.ACTIVO=1 "
            + "AND TPU.CPREGUNTA=? "
            + "AND TPU.ACTIVO=1 ";
    
    private static final String SQL_SELECT_PREGUNTA = "SELECT PREGUNTA "
            + "FROM MASCOTAS.TPREGUNTA "
            + "WHERE CPREGUNTA=? "
            + "AND ACTIVO=1 ";
    
    private List<Object> getDatosUsuario(String usuario, Integer cpregunta){
        
        /*List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_USUARIO, usuario, cpregunta);
        return resultado;*/
        
        List<Object> resultado = new ArrayList<>();
        Object[] fila = {"cpespinoza","Cristian Espinoza López","123456","123456"};
        resultado.add(fila);
        return resultado;
    }
    
    public boolean existeUsuario(String usuario, Integer cpregunta){
        
        /*boolean existe = false;
        this.datos =  getDatosUsuario(usuario, cpregunta);
        if(!datos.isEmpty()){
            existe = true;
        }
        return existe;*/
        this.datos = getDatosUsuario("", 1);
        return true;
    }
    
    public boolean loginUsuario(String password) throws Exception{
        
        /*CifradoAes aes = new CifradoAes();
        String clavecifrada = aes.encriptar(password);
        boolean login = false;
        for(Object dato : this.datos){
            Object [] arreglo;
            arreglo = (Object [])dato;
            if(clavecifrada.equals(arreglo[2].toString())){
                this.cusuario = Integer.parseInt(arreglo[0].toString());
                login = true;
            }
        }
        return login;*/
        this.cusuario = 1;
        return true;
    }
    
    public boolean validarRespuesta(String respuesta) throws Exception{
        
        /*CifradoAes aes = new CifradoAes();
        String respuestacifrada = aes.encriptar(respuesta);
        boolean resp = false;
        for(Object dato : this.datos){
            Object [] arreglo;
            arreglo = (Object [])dato;
            if(respuestacifrada.equals(arreglo[3].toString())){
                resp = true;
            }
        }
        return resp;*/
        return true;
    }
    
    public String getPregunta(Integer cpregunta){
        
        /*String preguntaDes = "";
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_PREGUNTA, cpregunta);
        if(!resultado.isEmpty()){
            for(Object dato : resultado){
                preguntaDes = dato.toString();
            }
        }
        return preguntaDes;*/
        return "Cual es tu numero favorito";
    }
}