package ec.edu.utpl.adopcionmascotas.modelo.pojo;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import java.io.Serializable;


/**
 * Clase de Auditoria de la aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class Auditoria  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final String SQL_INSERT = "INSERT INTO MASCOTAS.TAUDITORIA (CAUDITORIA,FREAL,TIPO,ACCIONUSUARIO,DETALLEACCION,RESULTADO,IDSESION) VALUES ((SELECT NVL(MAX(CAUDITORIA),0)+1 FROM MASCOTAS.TAUDITORIA),SYSTIMESTAMP,?,?,?,?,?) ";

    
    public Auditoria() {
    
    }
         
    public boolean registrarAuditoria(Integer idsesion, String tipo, String accion, String detalle, String resultado){
        
        Cliente cliente = new Cliente();
        int registros = cliente.execute(SQL_INSERT, tipo, accion, detalle, resultado, idsesion);
        if(registros > 0){
            return true;
        } else {
            return false;
        }
    }
    
}
