package ec.edu.utpl.adopcionmascotas.controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase de Gestion de Validacion de Entrada de Informacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Validacion {
    
    private Pattern pattern;
    
    private static final String EXPRESION_NUMEROS = "[0-9]+";
    private static final String EXPRESION_LETRAS = "[a-zA-Z]+";
    private static final String EXPRESION_ALFANUMERICO = "[\\w\\s\\-\\\\\\/]+";
    
    
    
    public boolean validarCamposVacios(String... listaCampos){
        
        Boolean valido = true;
        for(String campo : listaCampos){
            if(campo == null || "".equals(campo.trim())){
                valido = false;
            }
        } 
        return valido;
    }
    
    public boolean validarTexto(String nombreCampo, JTextField campo){

        if(!validarExpresion("LET", campo)){
            JOptionPane.showMessageDialog(null,"El campo "+ nombreCampo + " solo permite letras.","Validacion de informacion",JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public boolean validarNumero(String nombreCampo, JTextField campo){

        if(!validarExpresion("NUM", campo)){
            JOptionPane.showMessageDialog(null,"El campo "+ nombreCampo + " solo permite numeros.","Validacion de informacion",JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public boolean validarTextoNumero(String nombreCampo, JTextField campo){

        if(!validarExpresion("ALF", campo)){
            JOptionPane.showMessageDialog(null,"El campo "+ nombreCampo + " solo permite letras, numeros, espacios y guiones.","Validacion de informacion",JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public boolean validarExpresion(String tipoExpresion, JTextField... listaCampos){
        
        if("LET".equals(tipoExpresion)){
            pattern = Pattern.compile(EXPRESION_LETRAS);
        } else if("NUM".equals(tipoExpresion)){
            pattern = Pattern.compile(EXPRESION_NUMEROS);
        } else {
           pattern = Pattern.compile(EXPRESION_ALFANUMERICO); 
        }
        
        Boolean valido = true;
        for(JTextField campo : listaCampos){
            Matcher matcher = pattern.matcher(campo.getText());
            valido = matcher.find();
        } 
        return valido;
    }
}
