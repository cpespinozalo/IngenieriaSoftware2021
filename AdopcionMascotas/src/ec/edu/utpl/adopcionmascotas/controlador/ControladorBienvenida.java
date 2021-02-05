package ec.edu.utpl.adopcionmascotas.controlador;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;


/**
 * Clase Controlador de Bienvenida
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class ControladorBienvenida implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Utilitarios util;
    private Sesion sesion;
    private Integer cusuario;
    private String usuario;

    
    private static final String SQL_SELECT_SESION = "SELECT INITCAP(USU.NOMBRES || ' ' || USU.APELLIDOS) NOMBRELEGAL, USU.GENERO "
            + "FROM TUSUARIO USU "
            + "WHERE USU.USUARIO=? ";
    
    private static final String SQL_SELECT_ROLES = "SELECT ROL.CROL, ROL.NOMBRE, ROL.DESCRIPCION "
            + "FROM TROLUSUARIO TRU, TROL ROL "
            + "WHERE TRU.CUSUARIO=? "
            + "AND TRU.CROL=ROL.CROL";
/*metodo que inicia los datos de sesion en la bienvenida*/
    public ControladorBienvenida(Sesion sesion, Integer cusuario, String usuario) {

        this.sesion = sesion;
        this.util = new Utilitarios();
        this.cusuario = cusuario;
        this.usuario = usuario;
        setSesion();
    }
/*metodo que genera el id de sesión*/
    private void setSesion(){
        
        List<Object> datos =  getDatosSesion(usuario);
        for(Object dato : datos){
            Object [] arreglo;
            arreglo = (Object [])dato;
            
            sesion.setNombreUsuario(arreglo[0].toString());
            sesion.setGenero(arreglo[1].toString());
        } 
        sesion.setSistema("Sistema Operativo: " + System.getProperty("os.name") + " - Arquitectura: " + System.getProperty("os.arch"));
        sesion.setFinicio(util.tiempoSistema("dd-MM-yyyy HH:mm:ss"));
        sesion.setResultado("LOGIN EXITOSO");
        sesion.newSesion();
    }
    /* metodo que despliega el combo de roles*/
    public void getDatosCombo(JComboBox<String> combo) {
       
        List<Object> datos =  getRolUsuario(cusuario);
        for(Object dato : datos){
            Object [] arreglo;
            arreglo = (Object [])dato;
            sesion.setCrol(Integer.parseInt(arreglo[0].toString()));
            sesion.setNombreRol(arreglo[1].toString());
            sesion.setDescripcionRol(arreglo[2].toString());
            combo.addItem(arreglo[2].toString());
        }
    }
    /*metodo que devuelve los datos de sesión*/
    public List<Object> getDatosSesion(String usuario){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_SESION, usuario);
        return resultado;
    }
    /*metodo que devuelve el rol asignado al usuario*/
    public List<Object> getRolUsuario(Integer cusuario){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(SQL_SELECT_ROLES, cusuario);
        return resultado;
    }   
}
