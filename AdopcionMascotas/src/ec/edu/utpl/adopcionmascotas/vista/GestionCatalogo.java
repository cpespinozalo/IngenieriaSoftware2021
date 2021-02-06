package ec.edu.utpl.adopcionmascotas.vista;

import ec.edu.utpl.adopcionmascotas.controlador.Validacion;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Catalogo;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class GestionCatalogo extends javax.swing.JFrame {
    
    private Sesion sesion;
    private Catalogo catalogo;
    private Validacion validacion;
    private DefaultListModel modeloLista;
    
    private Integer ccatalogo;
    private String cambio;
    private static final String ACCION_NUEVO = "NUEVO";
    private static final String ACCION_EDITAR = "EDITAR";
    private static final String ACCION_ELIMINAR = "ELIMINAR";
    private static final String CLASS_NAME = GestionCatalogo.class.getName();
    
    
    public GestionCatalogo(Sesion sesion, Integer ccatalogo, String cambio) {

        try {
            this.sesion = sesion;
            this.validacion = new Validacion();
            this.catalogo = new Catalogo(sesion.getIdSesion());
            this.ccatalogo = ccatalogo;
            this.cambio = cambio;
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            initComponents();
            setLocationRelativeTo(null);
            loadCatalogo();
            setTitulos();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Imposible modificar el tema visual", "Lookandfeel inválido.", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setTitulos(){
       if(ACCION_NUEVO.equals(cambio)) {
           lblSubtituloEmpresa.setText("Creación de Catálogo en el Sistema");
           lblDato.setText("Nuevo Catálogo");
           lblInfo.setText("Ingrese la información del nuevo catálogo:");
           btnAceptarEmpresa.setText("CREAR");
       } else if(ACCION_EDITAR.equals(cambio)) {
           lblSubtituloEmpresa.setText("Editar Catálogo del Sistema");
           lblDato.setText(catalogo.getDescripcion());
           lblInfo.setText("Modifique la información que se desea cambiar:");
           btnAceptarEmpresa.setText("ACTUALIZAR");
       } else if(ACCION_ELIMINAR.equals(cambio)) {
           lblSubtituloEmpresa.setText("Eliminar Catálogo del Sistema");
           lblDato.setText(catalogo.getDescripcion());
           lblInfo.setText("Información del catálogo que se desea eliminar:");
           btnAceptarEmpresa.setText("ELIMINAR");
       }  
    }
    
    private void loadCatalogo(){
        //catalogo.setComboCatalogo("ACTIVO", cmbEstado);
        if(ACCION_EDITAR.equals(cambio) || ACCION_ELIMINAR.equals(cambio)) {
           getInfoCatalogo();
           catalogo.setListCatalogo(modeloLista, lstModulos, ccatalogo);
       }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTitulo = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblSubTitulo = new javax.swing.JLabel();
        lblTituloPrincipal = new javax.swing.JLabel();
        panSubtitulo = new javax.swing.JPanel();
        lblSubtituloEmpresa = new javax.swing.JLabel();
        panCentral = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        lblDato = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblElementos = new javax.swing.JLabel();
        scrLista = new javax.swing.JScrollPane();
        lstModulos = new javax.swing.JList<>();
        panInferior = new javax.swing.JPanel();
        btnAceptarEmpresa = new javax.swing.JButton();
        btnRegresarEmpresa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Catálogos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 650));
        setName("fraInterfazGrafica"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTitulo.setBackground(new java.awt.Color(41, 41, 41));
        panTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgIconoUtpl.png"))); // NOI18N
        panTitulo.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 125, 50));

        lblSubTitulo.setBackground(new java.awt.Color(255, 153, 51));
        lblSubTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSubTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTitulo.setText("Sistema");
        panTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, 300, 20));

        lblTituloPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        lblTituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("Adopcion de Mascotas");
        panTitulo.add(lblTituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 35, 300, 30));

        getContentPane().add(panTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 80));

        panSubtitulo.setBackground(new java.awt.Color(255, 54, 54));
        panSubtitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtituloEmpresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblSubtituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtituloEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtituloEmpresa.setText("Creación de Catálogos en el Sistema");
        lblSubtituloEmpresa.setAlignmentX(0.5F);
        panSubtitulo.add(lblSubtituloEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 390, -1));

        getContentPane().add(panSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 40));

        panCentral.setBackground(new java.awt.Color(41, 41, 41));
        panCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setBackground(new java.awt.Color(255, 255, 204));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigo.setToolTipText("Nombre del Usuario");
        txtCodigo.setEnabled(false);
        panCentral.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 30));

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setToolTipText("Nombre del Usuario");
        panCentral.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 115, 150, 30));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcion.setToolTipText("Nombre del Usuario");
        panCentral.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 320, 30));

        cmbEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 185, 150, 30));

        lblDato.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDato.setForeground(new java.awt.Color(255, 255, 255));
        lblDato.setText("Nuevo Catálogo");
        panCentral.add(lblDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 300, 25));

        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Ingrese la información del nuevo catálogo:");
        panCentral.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 20));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMantenimiento.png"))); // NOI18N
        panCentral.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 100, 100));

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("Codigo Catálogo:");
        panCentral.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 115, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        panCentral.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 115, 115, 30));

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripción:");
        panCentral.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 115, 30));

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado:");
        panCentral.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, 115, 30));

        lblElementos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblElementos.setForeground(new java.awt.Color(255, 255, 255));
        lblElementos.setText("Items Asignados:");
        panCentral.add(lblElementos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 115, 30));

        scrLista.setViewportView(lstModulos);

        panCentral.add(scrLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 230, 170));

        getContentPane().add(panCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, 430));

        panInferior.setBackground(new java.awt.Color(255, 54, 54));
        panInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptarEmpresa.setText("GUARDAR");
        btnAceptarEmpresa.setToolTipText("Gestionar Roles de Usuario");
        btnAceptarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEmpresaActionPerformed(evt);
            }
        });
        panInferior.add(btnAceptarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, 100, 40));
        btnAceptarEmpresa.getAccessibleContext().setAccessibleDescription("Nuevo");

        btnRegresarEmpresa.setText("CANCELAR");
        btnRegresarEmpresa.setToolTipText("Gestionar Roles de Usuario");
        btnRegresarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarEmpresaActionPerformed(evt);
            }
        });
        panInferior.add(btnRegresarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 15, 100, 40));
        btnRegresarEmpresa.getAccessibleContext().setAccessibleDescription("Editar");

        getContentPane().add(panInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 500, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEmpresaActionPerformed
       if(ACCION_NUEVO.equals(cambio)) {
           setInfoCatalogo();
           catalogo.newCatalogo();
           JOptionPane.showMessageDialog(rootPane,"Se ha creado correctamente el catálogo.","Catálogos del Sistema",JOptionPane.INFORMATION_MESSAGE); 
       } else if(ACCION_EDITAR.equals(cambio)) {
           setInfoCatalogo();
           catalogo.updateCatalogo();
           JOptionPane.showMessageDialog(rootPane,"Se ha actualizado correctamente el catálogo.","Catálogos del Sistema",JOptionPane.INFORMATION_MESSAGE); 
       } else if(ACCION_ELIMINAR.equals(cambio)) {
           catalogo.deleteCatalogo();
           JOptionPane.showMessageDialog(rootPane,"Se ha eliminado correctamente el catálogo.","Catálogos del Sistema",JOptionPane.INFORMATION_MESSAGE); 
       }
       volver(sesion);
    }//GEN-LAST:event_btnAceptarEmpresaActionPerformed

    private void btnRegresarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarEmpresaActionPerformed
        Administracion administracion = new Administracion(sesion);
        administracion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarEmpresaActionPerformed

    
    private void setInfoCatalogo(){
        catalogo.setNombre(txtNombre.getText());
        catalogo.setDescripcion(txtDescripcion.getText());
        catalogo.setEstado(cmbEstado.getSelectedItem().toString());

    }
    
    private void getInfoCatalogo(){
        if(this.catalogo != null){
            catalogo.getCatalogo(this.ccatalogo);
            txtCodigo.setText(this.ccatalogo.toString());
            txtNombre.setText(catalogo.getNombre());
            txtDescripcion.setText(catalogo.getDescripcion());
            cmbEstado.setSelectedItem(catalogo.getEstado());
        } 
    }
    
    private void volver(Sesion sesion){
           Administracion administracion = new Administracion(sesion);
           administracion.setVisible(true);
           this.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarEmpresa;
    private javax.swing.JButton btnRegresarEmpresa;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblElementos;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubtituloEmpresa;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JList<String> lstModulos;
    private javax.swing.JPanel panCentral;
    private javax.swing.JPanel panInferior;
    private javax.swing.JPanel panSubtitulo;
    private javax.swing.JPanel panTitulo;
    private javax.swing.JScrollPane scrLista;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
