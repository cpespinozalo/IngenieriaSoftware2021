package ec.edu.utpl.adopcionmascotas.controlador;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import java.io.IOException;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Clase Controlador de Auditoria
 * 
 * @author Cristian Espinoza
 * @version 2.0
 */
public class ControladorAuditoria {
    
    public Integer cusuario;
    private Integer sesionId;
    
    private static final String SQL_SELECT_SESIONES = "SELECT SE.IDSESION,TO_CHAR(SE.FINICIOSESION,'DD-MM-YYYY HH24:MI:SS'),TO_CHAR(SE.FFINSESION,'DD-MM-YYYY HH24:MI:SS'),US.USUARIO,US.NOMBRES||' '||US.APELLIDOS,SE.SISTEMA "
            + "FROM TSESION SE, TUSUARIO US "
            + "WHERE SE.CUSUARIO=US.CUSUARIO "
            + "ORDER BY SE.IDSESION DESC ";
    
    private static final String SQL_SELECT_REGISTRO = "SELECT SE.IDSESION,US.USUARIO,TO_CHAR(AU.FREAL,'DD-MM-YYYY HH24:MI:SS'),AU.TIPO,AU.ACCIONUSUARIO,AU.DETALLEACCION,AU.RESULTADO "
            + "FROM TAUDITORIA AU, TSESION SE, TUSUARIO US "
            + "WHERE AU.IDSESION=SE.IDSESION "
            + "AND SE.CUSUARIO=US.CUSUARIO "
            + "ORDER BY AU.FREAL DESC ";

    public ControladorAuditoria(Integer sesionId){
        this.sesionId = sesionId;
    }
    public void fillDataSesiones(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Id Sesión");
        modelo.addColumn("F. Inicio Sesión");
        modelo.addColumn("F. Fin Sesión");
        modelo.addColumn("Usuario");
        modelo.addColumn("Nombre Usuario");
        modelo.addColumn("Sistema de Ingreso");

        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(150);
        List<Object> lista = getDatos(SQL_SELECT_SESIONES);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
    }
    
    
    public void fillDatosAuditoria(JTable tabla, DefaultTableModel modelo) throws IOException{
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Id Sesión");
        modelo.addColumn("Usuario");
        modelo.addColumn("Fecha Acción");
        modelo.addColumn("Tipo");
        modelo.addColumn("Acción Realizada");
        modelo.addColumn("Resultado");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(150);
        List<Object> lista = getDatos(SQL_SELECT_REGISTRO);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
     }
    
    public List<Object> getDatos(String consulta){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(consulta);
        return resultado;
    }
    
    public void salir(Sesion sesion){
        sesion.updateSesion();
        System.exit(0);
    }
}