package ec.edu.utpl.adopcionmascotas.controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de utilitarios del sistema
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Utilitarios {
    
    
    public String tiempoSistema(String mascara){

        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat(mascara);
        return formato.format(fecha);
    }
    
    public String getPropiedad(String name, String archivo){
        
        String valor = ""; 
        try (FileInputStream propFile = new FileInputStream(archivo)){ 
            Properties p = new Properties();
            p.load(propFile);
            valor = p.getProperty(name);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
}
