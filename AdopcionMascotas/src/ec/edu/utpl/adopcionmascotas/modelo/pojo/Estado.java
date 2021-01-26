package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import java.io.Serializable;

/**
 * Clase de Definicion de Estado para los Usuarios
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Estado implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    private String cestado;
    private String estado;

    public Estado(String cestado, String estado) {
        this.cestado = cestado;
        this.estado = estado;
    }
    
    public String getCestado() {
        return cestado;
    }

    public void setCestado(String cestado) {
        this.cestado = cestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return estado;
    }  
}
