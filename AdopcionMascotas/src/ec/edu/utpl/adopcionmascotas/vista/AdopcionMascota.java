package ec.edu.utpl.adopcionmascotas.vista;

import ec.edu.utpl.adopcionmascotas.controlador.Validacion;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Catalogo;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Mascota;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Interfaz de Adopcion de Mascota
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class AdopcionMascota extends javax.swing.JFrame {
    
    private Sesion sesion;
    private Mascota mascota;
    private Validacion validacion;
   
    
    public AdopcionMascota(Sesion sesion, Mascota mascota) {

        try {
            this.sesion = sesion;
            this.mascota = mascota;
            this.validacion = new Validacion();  
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            initComponents();
            setLocationRelativeTo(null);
            loadCatalogo();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Imposible modificar el tema visual", "Lookandfeel inválido.", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadCatalogo(){
        Catalogo catalogo = new Catalogo();
        catalogo.setComboCatalogo("CIUDADES", cmbCiudadMascota);
        catalogo.setComboCatalogo("PROVINCIAS", cmbProvinciaMascota);
        getInfoMascota();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTitulo = new javax.swing.JPanel();
        lblSubTitulo = new javax.swing.JLabel();
        lblTituloPrincipal = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        panSubtitulo = new javax.swing.JPanel();
        lblSubtituloAdopcion = new javax.swing.JLabel();
        panCentral = new javax.swing.JPanel();
        txtCodigoMascota = new javax.swing.JTextField();
        txtNombreMascota = new javax.swing.JTextField();
        txtTipoMascota = new javax.swing.JTextField();
        txtEdadMascota = new javax.swing.JTextField();
        txtGeneroMascota = new javax.swing.JTextField();
        scrAdopcionMascota = new javax.swing.JScrollPane();
        txtObservacionesMascota = new javax.swing.JTextPane();
        txtPropietarioMascota = new javax.swing.JTextField();
        txtDireccionMascota = new javax.swing.JTextField();
        txtTelefonoMascota = new javax.swing.JTextField();
        txtCorreoMascota = new javax.swing.JTextField();
        cmbCiudadMascota = new javax.swing.JComboBox<>();
        cmbProvinciaMascota = new javax.swing.JComboBox<>();
        lblDatosMascota = new javax.swing.JLabel();
        lblInfoMascota = new javax.swing.JLabel();
        lblCodigoMascota = new javax.swing.JLabel();
        lblPublicación = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipoMascota = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblUnidadEdad = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        lblPropietario = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        panInferior = new javax.swing.JPanel();
        btnAdoptarMascota = new javax.swing.JButton();
        btnRegresarMascota = new javax.swing.JButton();
        scrFotosMascota = new javax.swing.JScrollPane();
        panFotosMascota = new javax.swing.JPanel();
        lblLogoEmpresa = new javax.swing.JLabel();
        lblLogoEmpresa1 = new javax.swing.JLabel();
        lblLogoEmpresa2 = new javax.swing.JLabel();
        lblLogoEmpresa3 = new javax.swing.JLabel();
        lblInfo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 650));
        setName("fraInterfazGrafica"); // NOI18N
        setUndecorated(true);
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
        lblTituloPrincipal.setText("Adopción de Mascota");
        panTitulo.add(lblTituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 300, 30));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgLogoPequeño.png"))); // NOI18N
        panTitulo.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 94, 50));

        getContentPane().add(panTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 80));

        panSubtitulo.setBackground(new java.awt.Color(255, 54, 54));
        panSubtitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtituloAdopcion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblSubtituloAdopcion.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtituloAdopcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtituloAdopcion.setText("Adopción de Mascota");
        lblSubtituloAdopcion.setAlignmentX(0.5F);
        panSubtitulo.add(lblSubtituloAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 390, -1));

        getContentPane().add(panSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 750, 40));

        panCentral.setBackground(new java.awt.Color(41, 41, 41));
        panCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtCodigoMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigoMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoMascota.setToolTipText("Nombre del Usuario");
        txtCodigoMascota.setEnabled(false);
        panCentral.add(txtCodigoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 30));

        txtNombreMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtNombreMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreMascota.setToolTipText("Nombre del Usuario");
        txtNombreMascota.setEnabled(false);
        panCentral.add(txtNombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 115, 310, 30));

        txtTipoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtTipoMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTipoMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTipoMascota.setToolTipText("Nombre del Usuario");
        txtTipoMascota.setEnabled(false);
        panCentral.add(txtTipoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 115, 120, 30));

        txtEdadMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtEdadMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEdadMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEdadMascota.setToolTipText("Nombre del Usuario");
        txtEdadMascota.setEnabled(false);
        panCentral.add(txtEdadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 30));

        txtGeneroMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtGeneroMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGeneroMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtGeneroMascota.setToolTipText("Nombre del Usuario");
        txtGeneroMascota.setEnabled(false);
        panCentral.add(txtGeneroMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 230, 30));

        txtObservacionesMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtObservacionesMascota.setEnabled(false);
        scrAdopcionMascota.setViewportView(txtObservacionesMascota);

        panCentral.add(scrAdopcionMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 185, 560, 60));

        txtPropietarioMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtPropietarioMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPropietarioMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPropietarioMascota.setToolTipText("Nombre del Usuario");
        txtPropietarioMascota.setEnabled(false);
        panCentral.add(txtPropietarioMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 320, 30));

        txtDireccionMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccionMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccionMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccionMascota.setToolTipText("Nombre del Usuario");
        txtDireccionMascota.setEnabled(false);
        panCentral.add(txtDireccionMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 315, 560, 30));

        txtTelefonoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefonoMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefonoMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefonoMascota.setToolTipText("Nombre del Usuario");
        txtTelefonoMascota.setEnabled(false);
        panCentral.add(txtTelefonoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 385, 230, 30));

        txtCorreoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtCorreoMascota.setEnabled(false);
        panCentral.add(txtCorreoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 385, 230, 30));

        cmbCiudadMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbCiudadMascota.setEnabled(false);
        panCentral.add(cmbCiudadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 230, 30));

        cmbProvinciaMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbProvinciaMascota.setEnabled(false);
        panCentral.add(cmbProvinciaMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 230, 30));

        lblDatosMascota.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDatosMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblDatosMascota.setText("Adoptar Mascota");
        panCentral.add(lblDatosMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 440, 25));

        lblInfoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoMascota.setText("Verifique la información de la mascota en adopción:");
        panCentral.add(lblInfoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 20));

        lblCodigoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoMascota.setText("Codigo Mascota:");
        panCentral.add(lblCodigoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 115, 30));

        lblPublicación.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPublicación.setForeground(new java.awt.Color(255, 255, 255));
        lblPublicación.setText("Publicación:");
        panCentral.add(lblPublicación, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 90, 30));

        lblFechaIngreso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaIngreso.setText("15/05/2020");
        panCentral.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 120, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        panCentral.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 115, 115, 30));

        lblTipoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoMascota.setText("Tipo mascota:");
        panCentral.add(lblTipoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 115, 90, 30));

        lblEdad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("Edad:");
        panCentral.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 115, 30));

        lblUnidadEdad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUnidadEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblUnidadEdad.setText("meses");
        panCentral.add(lblUnidadEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 80, 30));

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género:");
        panCentral.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 70, 30));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setForeground(new java.awt.Color(255, 255, 255));
        lblObservaciones.setText("Observaciones:");
        panCentral.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 115, 30));

        lblPropietario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPropietario.setForeground(new java.awt.Color(255, 255, 255));
        lblPropietario.setText("Propietario:");
        panCentral.add(lblPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 115, 30));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección:");
        panCentral.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 315, 115, 30));

        lblCiudad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(255, 255, 255));
        lblCiudad.setText("Ciudad:");
        panCentral.add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 115, 30));

        lblProvincia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblProvincia.setForeground(new java.awt.Color(255, 255, 255));
        lblProvincia.setText("Provincia:");
        panCentral.add(lblProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 60, 30));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono:");
        panCentral.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 385, 115, 30));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");
        panCentral.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 385, 60, 30));

        getContentPane().add(panCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 750, 430));

        panInferior.setBackground(new java.awt.Color(255, 54, 54));
        panInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdoptarMascota.setText("ADOPTAR");
        btnAdoptarMascota.setToolTipText("Gestionar Roles de Usuario");
        btnAdoptarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptarMascotaActionPerformed(evt);
            }
        });
        panInferior.add(btnAdoptarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 40));
        btnAdoptarMascota.getAccessibleContext().setAccessibleDescription("Nuevo");

        btnRegresarMascota.setText("CANCELAR");
        btnRegresarMascota.setToolTipText("Gestionar Roles de Usuario");
        btnRegresarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMascotaActionPerformed(evt);
            }
        });
        panInferior.add(btnRegresarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 100, 40));
        btnRegresarMascota.getAccessibleContext().setAccessibleDescription("Editar");

        getContentPane().add(panInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 750, 70));

        scrFotosMascota.setBackground(new java.awt.Color(41, 41, 41));

        panFotosMascota.setBackground(new java.awt.Color(41, 41, 41));
        panFotosMascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMascota01.png"))); // NOI18N
        panFotosMascota.add(lblLogoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        lblLogoEmpresa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMascota01.png"))); // NOI18N
        panFotosMascota.add(lblLogoEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lblLogoEmpresa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMascota01.png"))); // NOI18N
        panFotosMascota.add(lblLogoEmpresa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        lblLogoEmpresa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMascota01.png"))); // NOI18N
        panFotosMascota.add(lblLogoEmpresa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        lblInfo1.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo1.setText("Fotos de la mascota:");
        panFotosMascota.add(lblInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 300, 20));

        scrFotosMascota.setViewportView(panFotosMascota);

        getContentPane().add(scrFotosMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 750, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdoptarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptarMascotaActionPerformed
           setInfoMascota();
           mascota.newMascota();
           JOptionPane.showMessageDialog(rootPane,"Se ha adoptado correctamente la mascota.","Adopcion de Mascotas",JOptionPane.INFORMATION_MESSAGE);
           volver(sesion);
    }//GEN-LAST:event_btnAdoptarMascotaActionPerformed

    private void btnRegresarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMascotaActionPerformed
        volver(sesion);
    }//GEN-LAST:event_btnRegresarMascotaActionPerformed

    
    private void setInfoMascota(){

        mascota.setIdentificacion(txtNombreMascota.getText());
        mascota.setNombremascota(txtPropietarioMascota.getText());
        mascota.setDireccion(txtDireccionMascota.getText());
        mascota.setWeb(txtTipoMascota.getText());
        mascota.setTelefono(txtTelefonoMascota.getText());

    }
    
    private void getInfoMascota(){
        if(this.mascota != null){
            txtCodigoMascota.setText(mascota.getCmascota().toString());
            txtNombreMascota.setText(mascota.getIdentificacion());
            txtPropietarioMascota.setText(mascota.getNombremascota());
            txtDireccionMascota.setText(mascota.getDireccion());
            txtTipoMascota.setText(mascota.getWeb());
            txtTelefonoMascota.setText(mascota.getTelefono());

        } 
    }
    
        public void volver(Sesion sesion){
            Inicio inicio = new Inicio();
            inicio.setIsLogged(true);
            //inicio.setSesion(sesion);
            inicio.disableLogin();
            inicio.setVisible(true);
            this.dispose();      
       }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdoptarMascota;
    private javax.swing.JButton btnRegresarMascota;
    private javax.swing.JComboBox<String> cmbCiudadMascota;
    private javax.swing.JComboBox<String> cmbProvinciaMascota;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCodigoMascota;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDatosMascota;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfoMascota;
    private javax.swing.JLabel lblLogoEmpresa;
    private javax.swing.JLabel lblLogoEmpresa1;
    private javax.swing.JLabel lblLogoEmpresa2;
    private javax.swing.JLabel lblLogoEmpresa3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblPublicación;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubtituloAdopcion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoMascota;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblUnidadEdad;
    private javax.swing.JPanel panCentral;
    private javax.swing.JPanel panFotosMascota;
    private javax.swing.JPanel panInferior;
    private javax.swing.JPanel panSubtitulo;
    private javax.swing.JPanel panTitulo;
    private javax.swing.JScrollPane scrAdopcionMascota;
    private javax.swing.JScrollPane scrFotosMascota;
    private javax.swing.JTextField txtCodigoMascota;
    private javax.swing.JTextField txtCorreoMascota;
    private javax.swing.JTextField txtDireccionMascota;
    private javax.swing.JTextField txtEdadMascota;
    private javax.swing.JTextField txtGeneroMascota;
    private javax.swing.JTextField txtNombreMascota;
    private javax.swing.JTextPane txtObservacionesMascota;
    private javax.swing.JTextField txtPropietarioMascota;
    private javax.swing.JTextField txtTelefonoMascota;
    private javax.swing.JTextField txtTipoMascota;
    // End of variables declaration//GEN-END:variables
}
