package ec.edu.utpl.adopcionmascotas.vista;

import ec.edu.utpl.adopcionmascotas.controlador.Validacion;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Catalogo;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Mascota;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Interfaz de gestión de Mascotas
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class GestionMascotas extends javax.swing.JFrame {
    
    private Sesion sesion;
    private Mascota mascota;
    private Validacion validacion;
    
    private Integer cmascota;
    private String cambio;
    private static final String ACCION_NUEVO = "NUEVO";
    private static final String ACCION_EDITAR = "EDITAR";
    private static final String ACCION_ELIMINAR = "ELIMINAR";
    private static final String CLASS_NAME = GestionMascotas.class.getName();
    
    
    public GestionMascotas(Sesion sesion, Integer cmascota, String cambio) {

        try {
            this.sesion = sesion;
            this.validacion = new Validacion();
            this.mascota = new Mascota(sesion.getIdSesion());
            this.cmascota = cmascota;
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
           lblSubtituloEmpresa.setText("Creación de Mascota en el Sistema");
           lblDatoEmpresa.setText("Nueva mascota");
           lblInfo.setText("Ingrese la información de la nueva mascota:");
           btnAceptarEmpresa.setText("CREAR");
       } else if(ACCION_EDITAR.equals(cambio)) {
           lblSubtituloEmpresa.setText("Editar mascota del Sistema");
           lblDatoEmpresa.setText(mascota.getNombremascota());
           lblInfo.setText("Modifique la información que se desea cambiar:");
           btnAceptarEmpresa.setText("ACTUALIZAR");
       } else if(ACCION_ELIMINAR.equals(cambio)) {
           lblSubtituloEmpresa.setText("Eliminar Macota del Sistema");
           lblDatoEmpresa.setText(mascota.getNombremascota());
           lblInfo.setText("Información de la mascota que se desea eliminar:");
           btnAceptarEmpresa.setText("ELIMINAR");
       }  
    }
    
    private void loadCatalogo(){
        Catalogo catalogo = new Catalogo();
        catalogo.setComboCatalogo("CIUDADES", cmbCiudadEmpresa);
        catalogo.setComboCatalogo("PROVINCIAS", cmbProvinciaEmpresa);
        catalogo.setComboCatalogo("PAISES", cmbPaisEmpresa);
        if(ACCION_EDITAR.equals(cambio) || ACCION_ELIMINAR.equals(cambio)) {
           getInfoEmpresa();
       }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTitulo = new javax.swing.JPanel();
        lblSubTitulo = new javax.swing.JLabel();
        lblTituloPrincipal = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        panSubtitulo = new javax.swing.JPanel();
        lblSubtituloEmpresa = new javax.swing.JLabel();
        panCentral = new javax.swing.JPanel();
        txtCodigoEmpresa = new javax.swing.JTextField();
        txtIdentificacionEmpresa = new javax.swing.JTextField();
        txtRazonSocialEmpresa = new javax.swing.JTextField();
        txtDireccionEmpresa = new javax.swing.JTextField();
        txtRepresentanteEmpresa = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        txtWebEmpresa = new javax.swing.JTextField();
        cmbCiudadEmpresa = new javax.swing.JComboBox<>();
        cmbProvinciaEmpresa = new javax.swing.JComboBox<>();
        cmbPaisEmpresa = new javax.swing.JComboBox<>();
        lblDatoEmpresa = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblLogoEmpresa = new javax.swing.JLabel();
        lblCodigoEmpresa = new javax.swing.JLabel();
        lblIdentficacion = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblRepresentante = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblWeb = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        blPais = new javax.swing.JLabel();
        panInferior = new javax.swing.JPanel();
        btnAceptarEmpresa = new javax.swing.JButton();
        btnRegresarEmpresa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Empresas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 650));
        setName("fraInterfazGrafica"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTitulo.setBackground(new java.awt.Color(41, 41, 41));
        panTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubTitulo.setBackground(new java.awt.Color(255, 153, 51));
        lblSubTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSubTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTitulo.setText("Sistema");
        panTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 300, 20));

        lblTituloPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        lblTituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("Gestión de Mascotas");
        panTitulo.add(lblTituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 300, 30));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgLogoPequeño.png"))); // NOI18N
        panTitulo.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 94, 50));

        getContentPane().add(panTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 80));

        panSubtitulo.setBackground(new java.awt.Color(255, 54, 54));
        panSubtitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtituloEmpresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblSubtituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtituloEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtituloEmpresa.setText("Creación de Mascota en el Sistema");
        lblSubtituloEmpresa.setAlignmentX(0.5F);
        panSubtitulo.add(lblSubtituloEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 390, -1));

        getContentPane().add(panSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 40));

        panCentral.setBackground(new java.awt.Color(35, 35, 45));
        panCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtCodigoEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigoEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoEmpresa.setToolTipText("Nombre del Usuario");
        txtCodigoEmpresa.setEnabled(false);
        panCentral.add(txtCodigoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 30));

        txtIdentificacionEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtIdentificacionEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdentificacionEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdentificacionEmpresa.setToolTipText("Nombre del Usuario");
        panCentral.add(txtIdentificacionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 115, 150, 30));

        txtRazonSocialEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtRazonSocialEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRazonSocialEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRazonSocialEmpresa.setToolTipText("Nombre del Usuario");
        panCentral.add(txtRazonSocialEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 320, 30));

        txtDireccionEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccionEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccionEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccionEmpresa.setToolTipText("Nombre del Usuario");
        panCentral.add(txtDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 185, 320, 30));

        txtRepresentanteEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtRepresentanteEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRepresentanteEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRepresentanteEmpresa.setToolTipText("Nombre del Usuario");
        panCentral.add(txtRepresentanteEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 320, 30));

        txtTelefonoEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefonoEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefonoEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefonoEmpresa.setToolTipText("Nombre del Usuario");
        panCentral.add(txtTelefonoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 255, 150, 30));

        txtWebEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        txtWebEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtWebEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtWebEmpresa.setToolTipText("Nombre del Usuario");
        panCentral.add(txtWebEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 320, 30));

        cmbCiudadEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbCiudadEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 345, 150, 30));

        cmbProvinciaEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbProvinciaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 345, 150, 30));

        cmbPaisEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbPaisEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 150, 30));

        lblDatoEmpresa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDatoEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblDatoEmpresa.setText("Nueva Mascota");
        panCentral.add(lblDatoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 300, 25));

        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Ingrese la información de la nueva mascota:");
        panCentral.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 20));

        lblLogoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgLogoEmpresa.png"))); // NOI18N
        panCentral.add(lblLogoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 100, 100));

        lblCodigoEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigoEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoEmpresa.setText("Codigo Mascota:");
        panCentral.add(lblCodigoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 115, 30));

        lblIdentficacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdentficacion.setForeground(new java.awt.Color(255, 255, 255));
        lblIdentficacion.setText("Identificación:");
        panCentral.add(lblIdentficacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 115, 115, 30));

        lblRazonSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRazonSocial.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonSocial.setText("Nombre:");
        panCentral.add(lblRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 115, 30));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección:");
        panCentral.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, 115, 30));

        lblRepresentante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRepresentante.setForeground(new java.awt.Color(255, 255, 255));
        lblRepresentante.setText("Representante:");
        panCentral.add(lblRepresentante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 115, 30));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono:");
        panCentral.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 255, 115, 30));

        lblWeb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWeb.setForeground(new java.awt.Color(255, 255, 255));
        lblWeb.setText("Página Web:");
        panCentral.add(lblWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 115, 30));

        lblCiudad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(255, 255, 255));
        lblCiudad.setText("Ciudad / Provincia:");
        panCentral.add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 345, 115, 30));

        blPais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        blPais.setForeground(new java.awt.Color(255, 255, 255));
        blPais.setText("Pais:");
        panCentral.add(blPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 115, 30));

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
           setInfoEmpresa();
           mascota.newMascota();
           JOptionPane.showMessageDialog(rootPane,"Se ha creado correctamente la mascota.","Mascotas del Sistema",JOptionPane.INFORMATION_MESSAGE);
           volver(sesion);
       } else if(ACCION_EDITAR.equals(cambio)) {
           setInfoEmpresa();
           mascota.updateMascota();
           JOptionPane.showMessageDialog(rootPane,"Se ha actualizado correctamente la mascota.","Mascotas del Sistema",JOptionPane.INFORMATION_MESSAGE);
           volver(sesion);
       } else if(ACCION_ELIMINAR.equals(cambio)) {
           mascota.deleteMascota();
           JOptionPane.showMessageDialog(rootPane,"Se ha eliminado correctamente la mascota.","Mascotas del Sistema",JOptionPane.INFORMATION_MESSAGE);
           volver(sesion);
       }
    }//GEN-LAST:event_btnAceptarEmpresaActionPerformed

    private void btnRegresarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarEmpresaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarEmpresaActionPerformed

    
    private void setInfoEmpresa(){

        mascota.setIdentificacion(txtIdentificacionEmpresa.getText());
        mascota.setNombremascota(txtRazonSocialEmpresa.getText());
        mascota.setDireccion(txtDireccionEmpresa.getText());
        mascota.setWeb(txtWebEmpresa.getText());
        mascota.setTelefono(txtTelefonoEmpresa.getText());
        mascota.setCiudad(cmbCiudadEmpresa.getSelectedItem().toString());
        mascota.setProvincia(cmbProvinciaEmpresa.getSelectedItem().toString());
        mascota.setPais(cmbPaisEmpresa.getSelectedItem().toString());
        mascota.setRepresentante(txtRepresentanteEmpresa.getText());
    }
    
    private void getInfoEmpresa(){
        if(this.mascota != null){
            txtCodigoEmpresa.setText(this.cmascota.toString());
            txtIdentificacionEmpresa.setText(mascota.getIdentificacion());
            txtRazonSocialEmpresa.setText(mascota.getNombremascota());
            txtDireccionEmpresa.setText(mascota.getDireccion());
            txtWebEmpresa.setText(mascota.getWeb());
            txtTelefonoEmpresa.setText(mascota.getTelefono());
            cmbCiudadEmpresa.setSelectedItem(mascota.getCiudad());
            cmbProvinciaEmpresa.setSelectedItem(mascota.getProvincia());
            cmbPaisEmpresa.setSelectedItem(mascota.getPais());
            txtRepresentanteEmpresa.setText(mascota.getRepresentante());
        } 
    }
    
        public void volver(Sesion sesion){
           
       }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blPais;
    private javax.swing.JButton btnAceptarEmpresa;
    private javax.swing.JButton btnRegresarEmpresa;
    private javax.swing.JComboBox<String> cmbCiudadEmpresa;
    private javax.swing.JComboBox<String> cmbPaisEmpresa;
    private javax.swing.JComboBox<String> cmbProvinciaEmpresa;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCodigoEmpresa;
    private javax.swing.JLabel lblDatoEmpresa;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblIdentficacion;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLogoEmpresa;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRepresentante;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubtituloEmpresa;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblWeb;
    private javax.swing.JPanel panCentral;
    private javax.swing.JPanel panInferior;
    private javax.swing.JPanel panSubtitulo;
    private javax.swing.JPanel panTitulo;
    private javax.swing.JTextField txtCodigoEmpresa;
    private javax.swing.JTextField txtDireccionEmpresa;
    private javax.swing.JTextField txtIdentificacionEmpresa;
    private javax.swing.JTextField txtRazonSocialEmpresa;
    private javax.swing.JTextField txtRepresentanteEmpresa;
    private javax.swing.JTextField txtTelefonoEmpresa;
    private javax.swing.JTextField txtWebEmpresa;
    // End of variables declaration//GEN-END:variables
}
