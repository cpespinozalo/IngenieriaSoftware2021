package ec.edu.utpl.adopcionmascotas.vista;

import javax.swing.JOptionPane;

public class GestionMascota extends javax.swing.JFrame {
    
    private static final String ACCION_NUEVO = "NUEVO";
    private static final String ACCION_EDITAR = "EDITAR";
    private static final String ACCION_ELIMINAR = "ELIMINAR";
    private static final String CLASS_NAME = GestionMascota.class.getName();
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ragGenero = new javax.swing.ButtonGroup();
        panTitulo = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblSubTitulo = new javax.swing.JLabel();
        lblTituloPrincipal = new javax.swing.JLabel();
        panSubtitulo = new javax.swing.JPanel();
        lblSubtituloUsuario = new javax.swing.JLabel();
        panCentral = new javax.swing.JPanel();
        lblDatoUsuario = new javax.swing.JLabel();
        lblInfoUsuario = new javax.swing.JLabel();
        lblFotoPersona = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblApellidoUsuario = new javax.swing.JLabel();
        txtApellidosUsuario = new javax.swing.JTextField();
        lblCorreoUsuario1 = new javax.swing.JLabel();
        lblIngresarPass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cmbEstadoUsuario = new javax.swing.JComboBox<>();
        panInferior = new javax.swing.JPanel();
        btnAceptarEmpresa = new javax.swing.JButton();
        btnRegresarEmpresa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Usuarios");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 860));
        setName("fraInterfazGrafica"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTitulo.setBackground(new java.awt.Color(35, 35, 45));
        panTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgIconoUtpl.png"))); // NOI18N
        panTitulo.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 50, 50));

        lblSubTitulo.setBackground(new java.awt.Color(255, 153, 51));
        lblSubTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSubTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTitulo.setText("Sistema");
        panTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, 300, 20));

        lblTituloPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        lblTituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("Adopción de mascotas UTPL");
        panTitulo.add(lblTituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 35, 300, 30));

        getContentPane().add(panTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        panSubtitulo.setBackground(new java.awt.Color(255, 54, 54));
        panSubtitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtituloUsuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblSubtituloUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtituloUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtituloUsuario.setText("Creación de mascota");
        lblSubtituloUsuario.setAlignmentX(0.5F);
        panSubtitulo.add(lblSubtituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 390, -1));

        getContentPane().add(panSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 40));

        panCentral.setBackground(new java.awt.Color(35, 35, 45));
        panCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDatoUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDatoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblDatoUsuario.setText("Nueva Mascota");
        panCentral.add(lblDatoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 440, 25));

        lblInfoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoUsuario.setText("Ingrese la información de la mascota:");
        panCentral.add(lblInfoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, 20));

        lblFotoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMujer.png"))); // NOI18N
        panCentral.add(lblFotoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 100, 125));

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombre:");
        panCentral.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 115, 30));

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 320, 30));

        lblApellidoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellidoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoUsuario.setText("Edad:");
        panCentral.add(lblApellidoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 110, 30));

        txtApellidosUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellidosUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidosUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtApellidosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 110, 30));

        lblCorreoUsuario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCorreoUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreoUsuario1.setText("Ciudad:");
        panCentral.add(lblCorreoUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 115, 30));

        lblIngresarPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIngresarPass.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresarPass.setText("Tipo:");
        panCentral.add(lblIngresarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, 30));
        panCentral.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 220, 30));

        cmbEstadoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbEstadoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 180, 30));

        getContentPane().add(panCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1000, 650));

        panInferior.setBackground(new java.awt.Color(255, 54, 54));
        panInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptarEmpresa.setText("GUARDAR");
        btnAceptarEmpresa.setToolTipText("Gestionar Roles de Usuario");
        btnAceptarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEmpresaActionPerformed(evt);
            }
        });
        panInferior.add(btnAceptarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 15, 100, 40));
        btnAceptarEmpresa.getAccessibleContext().setAccessibleDescription("Nuevo");

        btnRegresarEmpresa.setText("CANCELAR");
        btnRegresarEmpresa.setToolTipText("Gestionar Roles de Usuario");
        btnRegresarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarEmpresaActionPerformed(evt);
            }
        });
        panInferior.add(btnRegresarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 15, 100, 40));
        btnRegresarEmpresa.getAccessibleContext().setAccessibleDescription("Editar");

        getContentPane().add(panInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 1000, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEmpresaActionPerformed
       
        try {
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Error al gestionar la Mascota.","Gestion de Macota",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnAceptarEmpresaActionPerformed

    private void btnRegresarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarEmpresaActionPerformed
        
    }//GEN-LAST:event_btnRegresarEmpresaActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarEmpresa;
    private javax.swing.JButton btnRegresarEmpresa;
    private javax.swing.JComboBox<String> cmbEstadoUsuario;
    private javax.swing.JLabel lblApellidoUsuario;
    private javax.swing.JLabel lblCorreoUsuario1;
    private javax.swing.JLabel lblDatoUsuario;
    private javax.swing.JLabel lblFotoPersona;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblInfoUsuario;
    private javax.swing.JLabel lblIngresarPass;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubtituloUsuario;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panCentral;
    private javax.swing.JPanel panInferior;
    private javax.swing.JPanel panSubtitulo;
    private javax.swing.JPanel panTitulo;
    private javax.swing.ButtonGroup ragGenero;
    private javax.swing.JTextField txtApellidosUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
