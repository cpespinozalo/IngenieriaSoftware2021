package ec.edu.utpl.adopcionmascotas.vista;

import ec.edu.utpl.adopcionmascotas.controlador.Utilitarios;
import ec.edu.utpl.adopcionmascotas.controlador.Validacion;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Catalogo;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Mascota;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Usuario;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Interfaz de Adopcion de Mascota
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class GestionMascota extends javax.swing.JFrame {
    
    private Sesion sesion;
    private Mascota mascota;
    private Validacion validacion;
    private Utilitarios util;
   
    private String accion;
    private static final String ACCION_NUEVO = "PUBLICAR";
    private static final String ACCION_EDITAR = "EDITAR";
    private static final String ACCION_CONSULTAR = "CONSULTAR";
    
    public GestionMascota(Sesion sesion, Mascota mascota, String accion) {

        try {
            this.sesion = sesion;
            this.mascota = mascota;
            this.validacion = new Validacion();  
            this.util = new Utilitarios();  
            this.accion = accion;
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            initComponents();
            setLocationRelativeTo(null);
            setData();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Imposible modificar el tema visual", "Lookandfeel inválido.", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadCatalogo(){
        
        Catalogo catalogo = new Catalogo();  
        catalogo.setComboCatalogo("PROVINCIAS", null, cmbProvinciaMascota);
        catalogo.setComboCatalogo("CIUDADES", "01", cmbCiudadMascota);
        catalogo.setComboCatalogo("TIPOMASCOTA", null, cmbTipoMascota);
        catalogo.setComboCatalogo("UNIDADES", null, cmbUnidadMascota);
        catalogo.setComboCatalogo("ESTADOMASCOTA", null, cmbEstadoMascota);
        catalogo.setComboCatalogo("GENEROMASCOTA", null, cmbGenero);
        catalogo.setComboCatalogo("ESTADOADOPCION", null, cmbEstadoAdopcion);
    }
    
    private void setData(){
       
       loadCatalogo();
       if(ACCION_NUEVO.equals(accion)) {
           lblSubtituloAdopcion.setText("Publicar una Mascota");
           lblDatosMascota.setText("Nueva Mascota");
           lblInfoMascota.setText("Ingrese la información de la nueva mascota:");
           lblAdopcion.setText("");
           lblFechaAdopcion.setText("");
           btnAceptarMascota.setText("PUBLICAR");
           btnCancelarMascota.setText("CANCELAR");
           cmbEstadoMascota.setSelectedItem("DISPONIBLE");
           cmbEstadoMascota.setEnabled(false);  
           btnEliminarMascota.setEnabled(false);
           txtPersonaAdopcion.setEnabled(false); 
           cmbEstadoAdopcion.setEnabled(false); 
           btnAceptarMascota.setEnabled(false);
           btnAgregarFoto.setEnabled(true);
           getInfoUsuario();
       } else if(ACCION_EDITAR.equals(accion)) {
           lblSubtituloAdopcion.setText("Gestionar una Mascota");
           lblDatosMascota.setText("Edición de Mascota");
           lblInfoMascota.setText("Modifique la información de la mascota:");
           btnAceptarMascota.setText("EDITAR");
           btnCancelarMascota.setText("CANCELAR");
           cmbEstadoMascota.setEnabled(true);  
           btnAgregarFoto.setEnabled(true);
           txtPersonaAdopcion.setEnabled(false); 
           cmbEstadoAdopcion.setEnabled(false); 
           btnAceptarMascota.setEnabled(true);
           getInfoMascota();
       } else if(ACCION_CONSULTAR.equals(accion)) {
           lblSubtituloAdopcion.setText("Ver una Mascota");
           lblDatosMascota.setText("Consulta de Mascota");
           lblInfoMascota.setText("Consulte la información de la mascota:");
           btnAceptarMascota.setText("EDITAR");
           btnCancelarMascota.setText("REGRESAR");
           txtNombreMascota.setEnabled(false);
           cmbTipoMascota.setEnabled(false);
           txtEdadMascota.setEnabled(false);
           cmbUnidadMascota.setEnabled(false);
           cmbGenero.setEnabled(false);
           txtObservacionesMascota.setEnabled(false);
           cmbEstadoMascota.setEnabled(false);  
           txtPersonaAdopcion.setEnabled(false); 
           cmbEstadoAdopcion.setEnabled(false); 
           btnAceptarMascota.setEnabled(false);
           btnEliminarMascota.setEnabled(false);
           btnAgregarFoto.setEnabled(false);
           getInfoMascota();
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
        lblSubtituloAdopcion = new javax.swing.JLabel();
        panCentral = new javax.swing.JPanel();
        lblDatosMascota = new javax.swing.JLabel();
        lblInfoMascota = new javax.swing.JLabel();
        lblCodigoMascota = new javax.swing.JLabel();
        txtCodigoMascota = new javax.swing.JTextField();
        lblPublicacion = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombreMascota = new javax.swing.JTextField();
        lblTipoMascota = new javax.swing.JLabel();
        cmbTipoMascota = new javax.swing.JComboBox<>();
        lblEdad = new javax.swing.JLabel();
        txtEdadMascota = new javax.swing.JTextField();
        cmbUnidadMascota = new javax.swing.JComboBox<>();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        lblObservaciones = new javax.swing.JLabel();
        scrAdopcionMascota = new javax.swing.JScrollPane();
        txtObservacionesMascota = new javax.swing.JTextPane();
        lblInfoPropietario = new javax.swing.JLabel();
        lblPropietario = new javax.swing.JLabel();
        txtPropietarioMascota = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccionMascota = new javax.swing.JTextField();
        lblProvincia = new javax.swing.JLabel();
        cmbProvinciaMascota = new javax.swing.JComboBox<>();
        lblCiudad = new javax.swing.JLabel();
        cmbCiudadMascota = new javax.swing.JComboBox<>();
        lblTelefono = new javax.swing.JLabel();
        txtTelefonoMascota = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreoMascota = new javax.swing.JTextField();
        lblEstadoMascota = new javax.swing.JLabel();
        cmbEstadoMascota = new javax.swing.JComboBox<>();
        lblInfoAdopcion = new javax.swing.JLabel();
        lblPersonaAdopcion = new javax.swing.JLabel();
        txtPersonaAdopcion = new javax.swing.JTextField();
        lblAdopcion = new javax.swing.JLabel();
        lblFechaAdopcion = new javax.swing.JLabel();
        lblEstadoAdopcion = new javax.swing.JLabel();
        cmbEstadoAdopcion = new javax.swing.JComboBox<>();
        panInferior = new javax.swing.JPanel();
        btnAceptarMascota = new javax.swing.JButton();
        btnCancelarMascota = new javax.swing.JButton();
        btnEliminarMascota = new javax.swing.JButton();
        scrFotosMascota = new javax.swing.JScrollPane();
        panFotosMascota = new javax.swing.JPanel();
        lblLogoEmpresa1 = new javax.swing.JLabel();
        lblInfo1 = new javax.swing.JLabel();
        panBoton = new javax.swing.JPanel();
        btnAgregarFoto = new javax.swing.JButton();

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
        lblSubtituloAdopcion.setText("Publicar una Mascota");
        lblSubtituloAdopcion.setAlignmentX(0.5F);
        panSubtitulo.add(lblSubtituloAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 390, -1));

        getContentPane().add(panSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 750, 40));

        panCentral.setBackground(new java.awt.Color(41, 41, 41));
        panCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDatosMascota.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDatosMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblDatosMascota.setText("Publicar una Mascota");
        panCentral.add(lblDatosMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 440, 25));

        lblInfoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoMascota.setText("Ingrese la información de la mascota en adopción:");
        panCentral.add(lblInfoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 20));

        lblCodigoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoMascota.setText("Codigo Mascota:");
        panCentral.add(lblCodigoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 115, 30));

        txtCodigoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtCodigoMascota.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCodigoMascota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoMascota.setToolTipText("Nombre del Usuario");
        txtCodigoMascota.setEnabled(false);
        panCentral.add(txtCodigoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 30));

        lblPublicacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPublicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblPublicacion.setText("Fecha Publicación:");
        panCentral.add(lblPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 110, 30));

        lblFechaIngreso.setForeground(new java.awt.Color(255, 204, 0));
        lblFechaIngreso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaIngreso.setText("15/05/2020 17:25:36");
        panCentral.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 120, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        panCentral.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 115, 115, 30));

        txtNombreMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtNombreMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreMascota.setToolTipText("Nombre del Usuario");
        panCentral.add(txtNombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 115, 310, 30));

        lblTipoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoMascota.setText("Tipo mascota:");
        panCentral.add(lblTipoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 115, 90, 30));

        cmbTipoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbTipoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 115, 140, 30));

        lblEdad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("Edad:");
        panCentral.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 115, 30));

        txtEdadMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtEdadMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEdadMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEdadMascota.setToolTipText("Nombre del Usuario");
        panCentral.add(txtEdadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 110, 30));

        cmbUnidadMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbUnidadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 110, 30));

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género:");
        panCentral.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 70, 30));

        cmbGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 230, 30));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setForeground(new java.awt.Color(255, 255, 255));
        lblObservaciones.setText("Observaciones:");
        panCentral.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 115, 30));

        txtObservacionesMascota.setBackground(new java.awt.Color(255, 255, 204));
        scrAdopcionMascota.setViewportView(txtObservacionesMascota);

        panCentral.add(scrAdopcionMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 185, 560, 60));

        lblInfoPropietario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInfoPropietario.setForeground(new java.awt.Color(255, 204, 0));
        lblInfoPropietario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoPropietario.setText("Información del propietario:");
        panCentral.add(lblInfoPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 680, 20));

        lblPropietario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPropietario.setForeground(new java.awt.Color(255, 255, 255));
        lblPropietario.setText("Propietario:");
        panCentral.add(lblPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 115, 30));

        txtPropietarioMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtPropietarioMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPropietarioMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPropietarioMascota.setToolTipText("Nombre del Usuario");
        txtPropietarioMascota.setEnabled(false);
        panCentral.add(txtPropietarioMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 320, 30));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección:");
        panCentral.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 325, 115, 30));

        txtDireccionMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccionMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccionMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccionMascota.setToolTipText("Nombre del Usuario");
        txtDireccionMascota.setEnabled(false);
        panCentral.add(txtDireccionMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 325, 560, 30));

        lblProvincia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblProvincia.setForeground(new java.awt.Color(255, 255, 255));
        lblProvincia.setText("Provincia:");
        panCentral.add(lblProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 60, 30));

        cmbProvinciaMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbProvinciaMascota.setEnabled(false);
        panCentral.add(cmbProvinciaMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 230, 30));

        lblCiudad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(255, 255, 255));
        lblCiudad.setText("Ciudad:");
        panCentral.add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 115, 30));

        cmbCiudadMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbCiudadMascota.setEnabled(false);
        panCentral.add(cmbCiudadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 230, 30));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono:");
        panCentral.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, 115, 30));

        txtTelefonoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefonoMascota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefonoMascota.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefonoMascota.setToolTipText("Nombre del Usuario");
        txtTelefonoMascota.setEnabled(false);
        panCentral.add(txtTelefonoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 395, 230, 30));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");
        panCentral.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 395, 60, 30));

        txtCorreoMascota.setBackground(new java.awt.Color(255, 255, 204));
        txtCorreoMascota.setEnabled(false);
        panCentral.add(txtCorreoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 395, 230, 30));

        lblEstadoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstadoMascota.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoMascota.setText("Estado de Mascota:");
        panCentral.add(lblEstadoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 115, 30));

        cmbEstadoMascota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbEstadoMascota.setEnabled(false);
        panCentral.add(cmbEstadoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 230, 30));

        lblInfoAdopcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInfoAdopcion.setForeground(new java.awt.Color(255, 204, 0));
        lblInfoAdopcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoAdopcion.setText("Información de adopción:");
        panCentral.add(lblInfoAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 680, 20));

        lblPersonaAdopcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersonaAdopcion.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonaAdopcion.setText("Persona Adopcion:");
        panCentral.add(lblPersonaAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 115, 30));

        txtPersonaAdopcion.setBackground(new java.awt.Color(255, 255, 204));
        txtPersonaAdopcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPersonaAdopcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPersonaAdopcion.setToolTipText("Nombre del Usuario");
        txtPersonaAdopcion.setEnabled(false);
        panCentral.add(txtPersonaAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 320, 30));

        lblAdopcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAdopcion.setForeground(new java.awt.Color(255, 255, 255));
        lblAdopcion.setText("Fecha Adopción:");
        panCentral.add(lblAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 110, 30));

        lblFechaAdopcion.setForeground(new java.awt.Color(255, 204, 0));
        lblFechaAdopcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaAdopcion.setText("01/06/2020 11:32:14");
        panCentral.add(lblFechaAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 120, 30));

        lblEstadoAdopcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstadoAdopcion.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoAdopcion.setText("Estado de Adopcion:");
        panCentral.add(lblEstadoAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 115, 30));

        cmbEstadoAdopcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbEstadoAdopcion.setEnabled(false);
        panCentral.add(cmbEstadoAdopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 230, 30));

        getContentPane().add(panCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 750, 600));

        panInferior.setBackground(new java.awt.Color(255, 54, 54));
        panInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptarMascota.setText("PUBLICAR");
        btnAceptarMascota.setToolTipText("Gestionar Roles de Usuario");
        btnAceptarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarMascotaActionPerformed(evt);
            }
        });
        panInferior.add(btnAceptarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 20, 100, 40));
        btnAceptarMascota.getAccessibleContext().setAccessibleDescription("Nuevo");

        btnCancelarMascota.setText("CANCELAR");
        btnCancelarMascota.setToolTipText("Gestionar Roles de Usuario");
        btnCancelarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMascotaActionPerformed(evt);
            }
        });
        panInferior.add(btnCancelarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 20, 100, 40));
        btnCancelarMascota.getAccessibleContext().setAccessibleDescription("Editar");

        btnEliminarMascota.setText("ELIMINAR");
        btnEliminarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMascotaActionPerformed(evt);
            }
        });
        panInferior.add(btnEliminarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 20, 100, 40));

        getContentPane().add(panInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 890, 750, 70));

        scrFotosMascota.setBackground(new java.awt.Color(41, 41, 41));

        panFotosMascota.setBackground(new java.awt.Color(41, 41, 41));
        panFotosMascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoEmpresa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMascota01.png"))); // NOI18N
        panFotosMascota.add(lblLogoEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lblInfo1.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo1.setText("Fotos de la mascota:");
        panFotosMascota.add(lblInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 300, 20));

        scrFotosMascota.setViewportView(panFotosMascota);

        getContentPane().add(scrFotosMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 720, 600, 170));

        panBoton.setBackground(new java.awt.Color(41, 41, 41));
        panBoton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarFoto.setText("AGREGAR FOTOS");
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });
        panBoton.add(btnAgregarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 120, 30));

        getContentPane().add(panBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 150, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarMascotaActionPerformed
        
        if(ACCION_NUEVO.equals(accion)) {
            if(validacion.validarCamposVacios(txtNombreMascota.getText(),txtEdadMascota.getText(),txtObservacionesMascota.getText().trim())){
                mascota = new Mascota(sesion.getIdSesion());
                mascota.setEstadomascota("DISPONIBLE");
                setInfoMascota();
                if(mascota.newMascota()){
                    JOptionPane.showMessageDialog(rootPane,"Se ha publicado correctamente la mascota.","Publicación de Mascotas",JOptionPane.INFORMATION_MESSAGE);
                    volver(sesion);
                }
            } else {
                JOptionPane.showMessageDialog(this.rootPane,"Los campos Nombre Mascota, Edad y Observaciones son obligatorios","Ingreso al Sistema",JOptionPane.WARNING_MESSAGE);
            }
                
       } else if(ACCION_EDITAR.equals(accion)) {
           if(validacion.validarCamposVacios(txtCodigoMascota.getText(),txtNombreMascota.getText(),txtEdadMascota.getText(),txtObservacionesMascota.getText())){
                setInfoMascota();
                if(mascota.updateMascota()){
                    JOptionPane.showMessageDialog(rootPane,"Se ha gestionado correctamente la mascota.","Gestión de Mascotas",JOptionPane.INFORMATION_MESSAGE);
                    volver(sesion);
                } 
            } else {
                JOptionPane.showMessageDialog(this.rootPane,"Los campos Nombre Mascota, Edad y Observaciones son obligatorios","Ingreso al Sistema",JOptionPane.WARNING_MESSAGE);
            }
       } 
    }//GEN-LAST:event_btnAceptarMascotaActionPerformed

    private void btnCancelarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMascotaActionPerformed
        
        volver(sesion);
    }//GEN-LAST:event_btnCancelarMascotaActionPerformed

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        fileChooser.setFileFilter(imgFilter);
        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            File fileName = fileChooser.getSelectedFile();
            if ((fileName == null) || (fileName.getName().equals(""))) {
                System.out.println("...");
            } else {
                System.out.println(fileName.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void btnEliminarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMascotaActionPerformed
        
        if(mascota.deleteMascota()){
            JOptionPane.showMessageDialog(rootPane,"Se ha eliminado correctamente la mascota.","Eliminación de Mascotas",JOptionPane.INFORMATION_MESSAGE);
            volver(sesion);
        }
    }//GEN-LAST:event_btnEliminarMascotaActionPerformed

    
    private void setInfoMascota(){
        
        mascota.setFpublicacion(util.tiempoSistema("dd-MM-yyyy HH:mm:ss"));
        mascota.setNombremascota(txtNombreMascota.getText());
        mascota.setTipomascota(cmbTipoMascota.getSelectedItem().toString());
        mascota.setEdad(txtEdadMascota.getText());
        mascota.setUnidadedad(cmbUnidadMascota.getSelectedItem().toString());
        mascota.setGenero(cmbGenero.getSelectedItem().toString());
        mascota.setDescripcion(txtObservacionesMascota.getText().trim());
        mascota.setPropietario(txtPropietarioMascota.getText());
        mascota.setDireccion(txtDireccionMascota.getText());
        mascota.setCiudad(cmbCiudadMascota.getSelectedItem().toString());
        mascota.setProvincia(cmbProvinciaMascota.getSelectedItem().toString());
        mascota.setTelefono(txtTelefonoMascota.getText());
        mascota.setCorreo(txtCorreoMascota.getText());
        mascota.setCusuariopublicacion(sesion.getUsuario());
    }
    
    private void getInfoMascota(){
   
        try {
            if(this.mascota != null){
                lblFechaIngreso.setText(mascota.getFpublicacion());
                txtCodigoMascota.setText(mascota.getCmascota().toString());
                txtNombreMascota.setText(mascota.getNombremascota());
                cmbTipoMascota.setSelectedItem(mascota.getTipomascota());
                txtEdadMascota.setText(mascota.getEdad());
                cmbUnidadMascota.setSelectedItem(mascota.getUnidadedad());
                cmbGenero.setSelectedItem(mascota.getGenero());
                txtObservacionesMascota.setText(mascota.getDescripcion());
                txtPropietarioMascota.setText(mascota.getNombremascota());
                txtDireccionMascota.setText(mascota.getDireccion());
                cmbCiudadMascota.setSelectedItem(mascota.getCiudad());
                cmbProvinciaMascota.setSelectedItem(mascota.getProvincia());
                txtTelefonoMascota.setText(mascota.getTelefono());
                txtCorreoMascota.setText(mascota.getCorreo());
                cmbEstadoMascota.setSelectedItem(mascota.getEstadomascota());
                lblFechaAdopcion.setText(mascota.getFadopcion());
                cmbEstadoAdopcion.setSelectedItem(mascota.getDesestadoadopcion());
                txtPersonaAdopcion.setText(mascota.getNombreusuarioadopcion());
            }
        } catch (Exception ex) {
            Logger.getLogger(GestionMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getInfoUsuario(){
   
        try {
            Usuario usuario = new Usuario(sesion.getIdSesion());
            usuario.getUsuario(sesion.getUsuario());
                
            txtPropietarioMascota.setText(usuario.getNombres() + " " + usuario.getApellidos());
            txtDireccionMascota.setText(usuario.getDireccion());
            cmbCiudadMascota.setSelectedItem(usuario.getCiudad());
            cmbProvinciaMascota.setSelectedItem(usuario.getProvincia());
            txtTelefonoMascota.setText(usuario.getTelefono());
            txtCorreoMascota.setText(usuario.getCorreo());
        } catch (Exception ex) {
            Logger.getLogger(GestionMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void volver(Sesion sesion){
        
        Inicio inicio = new Inicio();
        inicio.setIsLogged(true);
        inicio.setSesion(sesion);
        inicio.disableLogin();
        inicio.setVisible(true);
        this.dispose();      
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarMascota;
    private javax.swing.JButton btnAgregarFoto;
    private javax.swing.JButton btnCancelarMascota;
    private javax.swing.JButton btnEliminarMascota;
    private javax.swing.JComboBox<String> cmbCiudadMascota;
    private javax.swing.JComboBox<String> cmbEstadoAdopcion;
    private javax.swing.JComboBox<String> cmbEstadoMascota;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbProvinciaMascota;
    private javax.swing.JComboBox<String> cmbTipoMascota;
    private javax.swing.JComboBox<String> cmbUnidadMascota;
    private javax.swing.JLabel lblAdopcion;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCodigoMascota;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDatosMascota;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEstadoAdopcion;
    private javax.swing.JLabel lblEstadoMascota;
    private javax.swing.JLabel lblFechaAdopcion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfoAdopcion;
    private javax.swing.JLabel lblInfoMascota;
    private javax.swing.JLabel lblInfoPropietario;
    private javax.swing.JLabel lblLogoEmpresa1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPersonaAdopcion;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblPublicacion;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubtituloAdopcion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoMascota;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panBoton;
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
    private javax.swing.JTextField txtNombreMascota;
    private javax.swing.JTextPane txtObservacionesMascota;
    private javax.swing.JTextField txtPersonaAdopcion;
    private javax.swing.JTextField txtPropietarioMascota;
    private javax.swing.JTextField txtTelefonoMascota;
    // End of variables declaration//GEN-END:variables
}
