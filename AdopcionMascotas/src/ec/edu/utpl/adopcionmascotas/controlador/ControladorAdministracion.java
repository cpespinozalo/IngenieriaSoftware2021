package ec.edu.utpl.adopcionmascotas.controlador;

import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Auditoria;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Clase Controlador de Administracion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class ControladorAdministracion {
    
    private Auditoria auditoria;
    
    public Integer cusuario;
    private Integer sesionId;
    private static final String SQL_SELECT_EMPRESAS = "SELECT CEMPRESA,IDENTIFICACION,RAZONSOCIAL,DIRECCION,PAGINAWEB,TELEFONO FROM TEMPRESA ";
    private static final String SQL_SELECT_ROLES = "SELECT CROL,NOMBRE,DESCRIPCION,ACTIVO FROM TROL ";
    private static final String SQL_SELECT_USUARIOS = "SELECT USU.CUSUARIO,USU.USUARIO,USU.NOMBRES || ' ' || USU.APELLIDOS NOMBRELEGAL,USU.IDENTIFICACION,USU.CORREO,(SELECT COUNT(CUSUARIO) FROM TROLUSUARIO WHERE CUSUARIO=USU.CUSUARIO AND ACTIVO=1) ROLES FROM TUSUARIO USU ";
    private static final String SQL_SELECT_MODULOS = "SELECT MOD.CMODULO,MOD.NOMBRE,MOD.DESCRIPCION,(SELECT COUNT(CFUNCIONALIDAD) FROM TMODULOFUNCIONALIDAD WHERE CMODULO=MOD.CMODULO AND ACTIVO=1) FUNC,ACTIVO FROM TMODULO MOD";
    private static final String SQL_SELECT_FUNCIONALIDADES = "SELECT FUN.CFUNCIONALIDAD,FUN.NOMBRE,FUN.DESCRIPCION,ACTIVO EST FROM TFUNCIONALIDAD FUN ";
    private static final String SQL_SELECT_CATALOGOS = "SELECT CAT.CCATALOGO,CAT.NOMBRE,CAT.DESCRIPCION,(SELECT COUNT(CITEM) FROM TITEM WHERE CCATALOGO=CAT.CCATALOGO AND ACTIVO=1),CAT.ACTIVO FROM TCATALOGO CAT";
    
    public ControladorAdministracion(Integer sesionId){
        this.sesionId = sesionId;
        this.auditoria = new Auditoria();
    }
    public void fillTableEmpresas(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Identificacion");
        modelo.addColumn("Razón Social");
        modelo.addColumn("Dirección");
        modelo.addColumn("Página Web");
        modelo.addColumn("Teléfono");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(250);
        List<Object> lista = getDatos(SQL_SELECT_EMPRESAS);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
        setAuditoria("CONSULTA EMPRESAS", lista.size());
    }
    
    
     public void fillTableUsuarios(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Identificación");
        modelo.addColumn("Correo");
        modelo.addColumn("Roles");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(75);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(75);
        columnModel.getColumn(4).setPreferredWidth(150);
        List<Object> lista = getDatos(SQL_SELECT_USUARIOS);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
        setAuditoria("CONSULTA USUARIOS", lista.size());
    }

    public void fillTableRoles(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Activo");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(300);
        List<Object> lista = getDatos(SQL_SELECT_ROLES);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
        setAuditoria("CONSULTA ROLES", lista.size());
    }
     
    public void fillTableModulos(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Funcionalidades");
        modelo.addColumn("Activo");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(250);
        List<Object> lista = getDatos(SQL_SELECT_MODULOS);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
        setAuditoria("CONSULTA MODULOS", lista.size());
    }
    
    public void fillTableFuncionalidades(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Funcionalidad");
        modelo.addColumn("Descripción");
        modelo.addColumn("Activo");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(250);
        List<Object> lista = getDatos(SQL_SELECT_FUNCIONALIDADES);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
        setAuditoria("CONSULTA FUNCIONALIDADES", lista.size());
    }
    
    public void fillTableCatalogos(JTable tabla, DefaultTableModel modelo) throws IOException{
       
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        tabla.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Catálogo");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cantidad de Items");
        modelo.addColumn("Activo");
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(150);
        List<Object> lista = getDatos(SQL_SELECT_CATALOGOS);
        for(Object obj : lista){
            Object []object = (Object []) obj;
            modelo.addRow(object);
        } 
        setAuditoria("CONSULTA FUNCIONALIDADES", lista.size());
    }
    
    public List<Object> getDatos(String consulta){
        
        List<Object> resultado;
        Cliente cliente = new Cliente();
        resultado = cliente.query(consulta);
        return resultado;
    }
    
    private void setAuditoria(String seccion, Integer resultado){
        String tipo= "CONSULTA";
        String accion= "OBTENCION DE INFORMACION";
        String detalle = String.format("%s: %s REGISTROS CONSULTADOS", seccion, resultado);
        auditoria.registrarAuditoria(sesionId, tipo, accion, detalle, "OK");
    }
    
    public void salir(Sesion sesion){
        sesion.updateSesion();
        System.exit(0);
    }
}