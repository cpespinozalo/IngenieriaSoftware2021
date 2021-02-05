package ec.edu.utpl.adopcionmascotas.vista;

import ec.edu.utpl.adopcionmascotas.controlador.Validacion;
import ec.edu.utpl.adopcionmascotas.modelo.bd.Cliente;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Catalogo;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Sesion;
import ec.edu.utpl.adopcionmascotas.modelo.pojo.Usuario;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Interfaz de Gestión de Usuario
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */

public class GestionUsuario extends javax.swing.JFrame {
    
    private Sesion sesion;
    private Usuario usuario;
    private Validacion validacion;
    private Integer cusuario;
    private String cambio;
    private static final String ACCION_NUEVO = "NUEVO";
    private static final String ACCION_EDITAR = "EDITAR";
    private static final String ACCION_ELIMINAR = "ELIMINAR";
    private static final String CLASS_NAME = GestionUsuario.class.getName();
    
    /* metodo que prepara la sesión pantalla y variables*/
    public GestionUsuario(Sesion sesion, Integer cusuario, String cambio){

        try {
            this.sesion = sesion;
            this.validacion = new Validacion();
            this.usuario = cusuario != null ? new Usuario(sesion.getIdSesion()) : null;
            this.cusuario = cusuario;
            this.cambio = cambio;
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            initComponents();
            setLocationRelativeTo(null);
            loadUsuario();
            setTitulos();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Imposible modificar el tema visual", "Lookandfeel inválido.", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
/* metodo que distingue el tipo de modificación y prepara el texto y datos de usuario de ser necesario*/
    private void setTitulos(){
       if(ACCION_NUEVO.equals(cambio)) {
           lblSubtituloUsuario.setText("Creación de usuario en el Sistema");
           lblDatoUsuario.setText("Nuevo Usuario");
           lblInfoUsuario.setText("Ingrese la información del nuevo usuario:");
           btnAceptarUsuario.setText("CREAR");
       } else if(ACCION_EDITAR.equals(cambio)) {
           lblSubtituloUsuario.setText("Editar el Usuario '"+ usuario.getUsuario() +"' del Sistema");
           lblDatoUsuario.setText(usuario.getNombres() + " " + usuario.getApellidos());
           lblInfoUsuario.setText("Modifique la información que se desea cambiar:");
           btnAceptarUsuario.setText("ACTUALIZAR");
       } else if(ACCION_ELIMINAR.equals(cambio)) {
           lblSubtituloUsuario.setText("Eliminar Usuario '"+ usuario.getUsuario() +"'del Sistema");
           lblDatoUsuario.setText(usuario.getNombres() + " " + usuario.getApellidos());
           lblInfoUsuario.setText("Información del usuario que se desea eliminar:");
           btnAceptarUsuario.setText("ELIMINAR");
       }  
    }
    /* metodo que permite recuperar los datos de un usuario existente*/
    private void loadUsuario() throws Exception{
        
        loadCatalogo();
        if(ACCION_EDITAR.equals(cambio) || ACCION_ELIMINAR.equals(cambio)) {
           getInfoUsuario();
       } 
    }
    
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
        lblCodigoUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblIdentficacionUsuario = new javax.swing.JLabel();
        txtIdentificacionUsuario = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblApellidoUsuario = new javax.swing.JLabel();
        txtApellidosUsuario = new javax.swing.JTextField();
        lblDireccionUsuario = new javax.swing.JLabel();
        txtDireccionUsuario = new javax.swing.JTextField();
        lblProvinciaUsuario = new javax.swing.JLabel();
        cmbProvinciaUsuario = new javax.swing.JComboBox<>();
        lblCiudadUsuario = new javax.swing.JLabel();
        cmbCiudadUsuario = new javax.swing.JComboBox<>();
        lblCorreoUsuario1 = new javax.swing.JLabel();
        txtEmailUsuario = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        radMujer = new javax.swing.JRadioButton();
        radHombre = new javax.swing.JRadioButton();
        lblTelefonoUsuario = new javax.swing.JLabel();
        txtTelefonoUsuario = new javax.swing.JTextField();
        lblDatosUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuarioUsuario = new javax.swing.JTextField();
        lblActivoUsuario = new javax.swing.JLabel();
        cmbActivo = new javax.swing.JComboBox<>();
        cmbEstadoUsuario = new javax.swing.JComboBox<>();
        lblIngresarPass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPasswordConf = new javax.swing.JLabel();
        txtPasswordConf = new javax.swing.JPasswordField();
        lblPreguntasSeguridad = new javax.swing.JLabel();
        lblPregunta1 = new javax.swing.JLabel();
        txtPregunta1 = new javax.swing.JPasswordField();
        lblPregunta2 = new javax.swing.JLabel();
        txtPregunta2 = new javax.swing.JPasswordField();
        lblPregunta3 = new javax.swing.JLabel();
        txtPregunta3 = new javax.swing.JPasswordField();
        lblPregunta4 = new javax.swing.JLabel();
        txtPregunta4 = new javax.swing.JPasswordField();
        panInferior = new javax.swing.JPanel();
        btnAceptarUsuario = new javax.swing.JButton();
        btnRegresarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Usuarios");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 860));
        setName("fraInterfazGrafica"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 860));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTitulo.setBackground(new java.awt.Color(41, 41, 41));
        panTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgLogoPequeño.png"))); // NOI18N
        panTitulo.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 94, 50));

        lblSubTitulo.setBackground(new java.awt.Color(255, 153, 51));
        lblSubTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSubTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTitulo.setText("Sistema");
        panTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 300, 20));

        lblTituloPrincipal.setBackground(new java.awt.Color(255, 153, 51));
        lblTituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("Adopción de Mascotas");
        panTitulo.add(lblTituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 300, 30));

        getContentPane().add(panTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        panSubtitulo.setBackground(new java.awt.Color(255, 54, 54));
        panSubtitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtituloUsuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblSubtituloUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtituloUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtituloUsuario.setText("Creación de Usuario en el Sistema");
        lblSubtituloUsuario.setAlignmentX(0.5F);
        panSubtitulo.add(lblSubtituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 390, -1));

        getContentPane().add(panSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 40));

        panCentral.setBackground(new java.awt.Color(41, 41, 41));
        panCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDatoUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDatoUsuario.setForeground(new java.awt.Color(255, 204, 0));
        lblDatoUsuario.setText("Nuevo Usuario");
        panCentral.add(lblDatoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 440, 25));

        lblInfoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoUsuario.setText("Ingresa los datos del nuevo usuario:");
        panCentral.add(lblInfoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, 20));

        lblFotoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMujer.png"))); // NOI18N
        panCentral.add(lblFotoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 25, 100, 125));

        lblCodigoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCodigoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoUsuario.setText("Codigo Usuario:");
        panCentral.add(lblCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 115, 30));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setToolTipText("Nombre del Usuario");
        txtUsuario.setEnabled(false);
        panCentral.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 150, 30));

        lblIdentficacionUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIdentficacionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblIdentficacionUsuario.setText("Identificación:");
        panCentral.add(lblIdentficacionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 135, 115, 30));

        txtIdentificacionUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtIdentificacionUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdentificacionUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdentificacionUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtIdentificacionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 135, 320, 30));

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombres:");
        panCentral.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 115, 30));

        txtNombreUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 320, 30));

        lblApellidoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellidoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoUsuario.setText("Apellidos:");
        panCentral.add(lblApellidoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 70, 30));

        txtApellidosUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtApellidosUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellidosUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidosUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtApellidosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 320, 30));

        lblDireccionUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccionUsuario.setText("Dirección:");
        panCentral.add(lblDireccionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 115, 30));

        txtDireccionUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccionUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccionUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccionUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtDireccionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 750, 30));

        lblProvinciaUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProvinciaUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinciaUsuario.setText("Provincia:");
        panCentral.add(lblProvinciaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 115, 30));

        cmbProvinciaUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbProvinciaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinciaUsuarioActionPerformed(evt);
            }
        });
        panCentral.add(cmbProvinciaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 220, 30));

        lblCiudadUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCiudadUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblCiudadUsuario.setText("Ciudad:");
        panCentral.add(lblCiudadUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 70, 30));

        cmbCiudadUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbCiudadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadUsuarioActionPerformed(evt);
            }
        });
        panCentral.add(cmbCiudadUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 220, 30));

        lblCorreoUsuario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCorreoUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreoUsuario1.setText("Email:");
        panCentral.add(lblCorreoUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 275, 115, 30));

        txtEmailUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtEmailUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmailUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmailUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtEmailUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 275, 320, 30));

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género:");
        panCentral.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 275, 70, 30));

        ragGenero.add(radMujer);
        radMujer.setForeground(new java.awt.Color(255, 255, 255));
        radMujer.setSelected(true);
        radMujer.setText("Mujer");
        radMujer.setOpaque(false);
        radMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMujerActionPerformed(evt);
            }
        });
        panCentral.add(radMujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 275, -1, 30));

        ragGenero.add(radHombre);
        radHombre.setForeground(new java.awt.Color(255, 255, 255));
        radHombre.setText("Hombre");
        radHombre.setOpaque(false);
        radHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radHombreActionPerformed(evt);
            }
        });
        panCentral.add(radHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 275, -1, 30));

        lblTelefonoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelefonoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoUsuario.setText("Teléfono:");
        panCentral.add(lblTelefonoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 115, 30));

        txtTelefonoUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefonoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefonoUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefonoUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtTelefonoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 220, 30));

        lblDatosUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDatosUsuario.setForeground(new java.awt.Color(255, 204, 0));
        lblDatosUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDatosUsuario.setText("Credenciales de Usuario:");
        panCentral.add(lblDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 355, 880, 30));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario:");
        panCentral.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 115, 30));

        txtUsuarioUsuario.setBackground(new java.awt.Color(255, 255, 204));
        txtUsuarioUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuarioUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuarioUsuario.setToolTipText("Nombre del Usuario");
        panCentral.add(txtUsuarioUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 220, 30));

        lblActivoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblActivoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblActivoUsuario.setText("Usuario Vigente:");
        panCentral.add(lblActivoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 390, 150, 30));

        cmbActivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 110, 30));

        cmbEstadoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panCentral.add(cmbEstadoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 200, 30));

        lblIngresarPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIngresarPass.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresarPass.setText("Contraseña:");
        panCentral.add(lblIngresarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 425, 115, 30));

        txtPassword.setBackground(new java.awt.Color(255, 255, 204));
        panCentral.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 425, 220, 30));

        lblPasswordConf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPasswordConf.setForeground(new java.awt.Color(255, 255, 255));
        lblPasswordConf.setText("Confirmar Contraseña:");
        panCentral.add(lblPasswordConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 425, 150, 30));

        txtPasswordConf.setBackground(new java.awt.Color(255, 255, 204));
        panCentral.add(txtPasswordConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 425, 220, 30));

        lblPreguntasSeguridad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPreguntasSeguridad.setForeground(new java.awt.Color(255, 204, 0));
        lblPreguntasSeguridad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPreguntasSeguridad.setText("Preguntas de Seguridad:");
        panCentral.add(lblPreguntasSeguridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 880, 30));

        lblPregunta1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPregunta1.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta1.setText("¿Cuál es el nombre de su abuela materna?");
        panCentral.add(lblPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 505, 240, 30));

        txtPregunta1.setBackground(new java.awt.Color(255, 255, 204));
        panCentral.add(txtPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 505, 325, 30));

        lblPregunta2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPregunta2.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta2.setText("¿Cuál fue la marca de su primer vehículo?");
        panCentral.add(lblPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 240, 30));

        txtPregunta2.setBackground(new java.awt.Color(255, 255, 204));
        panCentral.add(txtPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 325, 30));

        lblPregunta3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPregunta3.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta3.setText("¿Cuál es su color favorito?");
        panCentral.add(lblPregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 575, 240, 30));

        txtPregunta3.setBackground(new java.awt.Color(255, 255, 204));
        panCentral.add(txtPregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 575, 325, 30));

        lblPregunta4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPregunta4.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta4.setText("¿Cuál es su comida preferida?");
        panCentral.add(lblPregunta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 240, 30));

        txtPregunta4.setBackground(new java.awt.Color(255, 255, 204));
        panCentral.add(txtPregunta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, 325, 30));

        getContentPane().add(panCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 930, 650));

        panInferior.setBackground(new java.awt.Color(255, 54, 54));
        panInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptarUsuario.setText("GUARDAR");
        btnAceptarUsuario.setToolTipText("Gestionar Roles de Usuario");
        btnAceptarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarUsuarioActionPerformed(evt);
            }
        });
        panInferior.add(btnAceptarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 15, 100, 40));
        btnAceptarUsuario.getAccessibleContext().setAccessibleDescription("Nuevo");

        btnRegresarUsuario.setText("CANCELAR");
        btnRegresarUsuario.setToolTipText("Gestionar Roles de Usuario");
        btnRegresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarUsuarioActionPerformed(evt);
            }
        });
        panInferior.add(btnRegresarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 15, 100, 40));
        btnRegresarUsuario.getAccessibleContext().setAccessibleDescription("Editar");

        getContentPane().add(panInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 930, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/* metodo que permite grabar un usuario nuevo o editar existente*/
    private void btnAceptarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarUsuarioActionPerformed
       
        try {
            if(ACCION_NUEVO.equals(cambio)) {
               setInfoUsuario();
               usuario.newUsuario();
               JOptionPane.showMessageDialog(rootPane,"Los datos del usuario se ha creado correctamente.","Usuarios del Sistema",JOptionPane.INFORMATION_MESSAGE);
               volver(sesion, false);
           } else if(ACCION_EDITAR.equals(cambio)) {
               System.out.println("EDITAR " + usuario.getCusuario());
               setInfoUsuario();
               usuario.updateUsuario();
               JOptionPane.showMessageDialog(rootPane,"Se ha actualizado correctamente el usuario.","Usuarios del Sistema",JOptionPane.INFORMATION_MESSAGE);
               volver(sesion, true);
           } else if(ACCION_ELIMINAR.equals(cambio)) {
               if("admin".equals(usuario.getUsuario())){
                   JOptionPane.showMessageDialog(rootPane,"No se puede eliminar el usuario administrador por defecto.","Usuarios del Sistema",JOptionPane.ERROR_MESSAGE);
               } else {
                    usuario.deleteUsuario();
                    JOptionPane.showMessageDialog(rootPane,"Se ha eliminado correctamente el usuario.","Usuarios del Sistema",JOptionPane.INFORMATION_MESSAGE);
                    volver(sesion, true);
               }   
           }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,"Error al gestionar el usuario.","Usuarios del Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnAceptarUsuarioActionPerformed

    private void btnRegresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarUsuarioActionPerformed

        volver(sesion, ACCION_EDITAR.equals(cambio));
    }//GEN-LAST:event_btnRegresarUsuarioActionPerformed

    private void radMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMujerActionPerformed
        lblFotoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMujer.png")));
    }//GEN-LAST:event_radMujerActionPerformed

    private void radHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radHombreActionPerformed
        lblFotoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgHombre.png")));
    }//GEN-LAST:event_radHombreActionPerformed

    private void cmbCiudadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCiudadUsuarioActionPerformed

    private void cmbProvinciaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinciaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProvinciaUsuarioActionPerformed

/*metodo que graba los datos de usuario*/    
    private void setInfoUsuario(){

        char clave[] = txtPassword.getPassword();
        String password = new String(clave);
        if(sesion==null){
            sesion = new Sesion("invitado", 0);
            sesion.setIdeSesion();
        }
        if(usuario==null){
            usuario = new Usuario(sesion.getIdSesion());
        }
        System.out.println(">>Sesion: " + sesion + " - Usuario: " + usuario);
        usuario.setIdentificacion(txtIdentificacionUsuario.getText());
        usuario.setNombres(txtNombreUsuario.getText());
        usuario.setApellidos(txtApellidosUsuario.getText());
        usuario.setDireccion(txtDireccionUsuario.getText());
        usuario.setProvincia(cmbProvinciaUsuario.getSelectedItem().toString());
        usuario.setCiudad(cmbCiudadUsuario.getSelectedItem().toString());
        usuario.setCorreo(txtEmailUsuario.getText());
        if(radMujer.isSelected()){
            usuario.setGenero("F");
        } else {
            usuario.setGenero("M");
        }
        usuario.setTelefono(txtTelefonoUsuario.getText());
        usuario.setUsuario(txtUsuarioUsuario.getText());
        usuario.setEstado(cmbEstadoUsuario.getSelectedItem().toString());
        usuario.setDactivo(cmbActivo.getSelectedItem().toString());
        usuario.setPassword(password);
        setIcon();
        
        char resp1[] = txtPregunta1.getPassword();
        String respuesta1 = new String(resp1);
        usuario.setRespuesta1(respuesta1);
        char resp2[] = txtPregunta2.getPassword();
        String respuesta2 = new String(resp2);
        usuario.setRespuesta2(respuesta2);
        char resp3[] = txtPregunta3.getPassword();
        String respuesta3 = new String(resp3);
        usuario.setRespuesta3(respuesta3);
        char resp4[] = txtPregunta1.getPassword();
        String respuesta4 = new String(resp4);
        usuario.setRespuesta4(respuesta4);
    }
    /*metodo que recupera los datos de usuario existente*/
    private void getInfoUsuario() throws Exception {
        if(this.usuario != null){
            usuario.getUsuario(this.cusuario);
            txtUsuario.setText(usuario.getCusuario().toString());
            txtIdentificacionUsuario.setText(usuario.getIdentificacion());
            txtNombreUsuario.setText(usuario.getNombres());
            txtApellidosUsuario.setText(usuario.getApellidos());
            txtDireccionUsuario.setText(usuario.getDireccion());
            cmbProvinciaUsuario.setSelectedItem(usuario.getProvincia());
            cmbCiudadUsuario.setSelectedItem(usuario.getCiudad());
            txtEmailUsuario.setText(usuario.getCorreo());
            txtTelefonoUsuario.setText(usuario.getTelefono());
            txtUsuarioUsuario.setText(usuario.getUsuario());
            txtPassword.setText(usuario.getPassword());
            txtPasswordConf.setText(usuario.getPassword());            
            if("F".equals(usuario.getGenero())){
                radMujer.setSelected(true);
                radHombre.setSelected(false);
            } else {
                radMujer.setSelected(false);
                radHombre.setSelected(true);
            }  
            setIcon();
            cmbActivo.setSelectedItem(usuario.getDactivo());
            cmbEstadoUsuario.setSelectedItem(usuario.getEstado());
            setIcon();        
            txtPregunta1.setText(usuario.getRespuesta1());
            txtPregunta2.setText(usuario.getRespuesta2());
            txtPregunta3.setText(usuario.getRespuesta3());
            txtPregunta4.setText(usuario.getRespuesta4());
            
            lblPregunta1.setText(usuario.getPregunta1());
            lblPregunta2.setText(usuario.getPregunta2());
            lblPregunta3.setText(usuario.getPregunta3());
            lblPregunta4.setText(usuario.getPregunta4());
            
            setListRoles(this.panCentral, this.cusuario, this.usuario.getUsuario());
        }else
            JOptionPane.showMessageDialog(rootPane,"Error al recuperar los datos del usuario.","Usuarios del Sistema",JOptionPane.ERROR_MESSAGE);
    }
   /*metodo que despliega los roles existentes*/    
    public void setListRoles(JPanel panel, Integer cusuario, String usuario) {
        
        Integer coordenadaY = 505;
        JLabel rolesUsuario = new JLabel();
        rolesUsuario.setFont(new java.awt.Font("Tahoma", 1, 14));
        rolesUsuario.setText("Roles del usuario: ");
        rolesUsuario.setForeground(new java.awt.Color(255, 204, 0));
        panel.add(rolesUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 300, 30));
        
        List<Object> lista;
        Cliente cliente = new Cliente();
        lista = cliente.query("SELECT NVL2(RU.CROL,1,0) ACTIVO, RO.DESCRIPCION, RO.NOMBRE FROM TROLUSUARIO RU, TROL RO WHERE RO.CROL=RU.CROL(+) AND RU.ACTIVO(+)=1 AND RO.ACTIVO=1 AND RU.CUSUARIO(+)=? ", cusuario);
        for(Object dato : lista){
            Object [] arreglo;
            arreglo = (Object [])dato;
            JCheckBox chkRol = new JCheckBox(arreglo[1].toString());
            chkRol.setBackground(new java.awt.Color(255, 255, 255));
            chkRol.setFont(new java.awt.Font("Tahoma", 0, 14));
            chkRol.setForeground(new java.awt.Color(255, 255, 255));
            chkRol.setOpaque(false);
            chkRol.setSelected(true);
            chkRol.setEnabled(false);
            panel.add(chkRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, coordenadaY, 300, 30));
            coordenadaY=coordenadaY+30;
        }
    }
/*metodo que carga los catalofos provincia, ciudad, estado*/    
    private void loadCatalogo(){
        
        Catalogo catalogo = new Catalogo();  
        catalogo.setComboCatalogo("PROVINCIAS", null, cmbProvinciaUsuario);
        catalogo.setComboCatalogo("CIUDADES", "01", cmbCiudadUsuario);
        catalogo.setComboCatalogo("ACTIVO", null, cmbActivo);
        catalogo.setComboCatalogo("ESTADOUSUARIO", null, cmbEstadoUsuario);
    }
    
    private void setIcon(){
        
        String icon = "";
        if("F".equals(usuario.getGenero())){
            icon = "/images/imgMujer.png";
        } else {
            icon = "/images/imgHombre.png";
        }
        lblFotoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource(icon)));
    }
 /*metodo que retorna o cierra la pantalla sin acciones*/   
    private void volver(Sesion sesion, boolean logged){
        Inicio inicio = new Inicio();
        inicio.setIsLogged(logged);
        if(logged){
            inicio.setSesion(sesion);
            inicio.disableLogin();
        }  
        inicio.setVisible(true);
        this.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarUsuario;
    private javax.swing.JButton btnRegresarUsuario;
    private javax.swing.JComboBox<String> cmbActivo;
    private javax.swing.JComboBox<String> cmbCiudadUsuario;
    private javax.swing.JComboBox<String> cmbEstadoUsuario;
    private javax.swing.JComboBox<String> cmbProvinciaUsuario;
    private javax.swing.JLabel lblActivoUsuario;
    private javax.swing.JLabel lblApellidoUsuario;
    private javax.swing.JLabel lblCiudadUsuario;
    private javax.swing.JLabel lblCodigoUsuario;
    private javax.swing.JLabel lblCorreoUsuario1;
    private javax.swing.JLabel lblDatoUsuario;
    private javax.swing.JLabel lblDatosUsuario;
    private javax.swing.JLabel lblDireccionUsuario;
    private javax.swing.JLabel lblFotoPersona;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblIdentficacionUsuario;
    private javax.swing.JLabel lblInfoUsuario;
    private javax.swing.JLabel lblIngresarPass;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPasswordConf;
    private javax.swing.JLabel lblPregunta1;
    private javax.swing.JLabel lblPregunta2;
    private javax.swing.JLabel lblPregunta3;
    private javax.swing.JLabel lblPregunta4;
    private javax.swing.JLabel lblPreguntasSeguridad;
    private javax.swing.JLabel lblProvinciaUsuario;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubtituloUsuario;
    private javax.swing.JLabel lblTelefonoUsuario;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panCentral;
    private javax.swing.JPanel panInferior;
    private javax.swing.JPanel panSubtitulo;
    private javax.swing.JPanel panTitulo;
    private javax.swing.JRadioButton radHombre;
    private javax.swing.JRadioButton radMujer;
    private javax.swing.ButtonGroup ragGenero;
    private javax.swing.JTextField txtApellidosUsuario;
    private javax.swing.JTextField txtDireccionUsuario;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtIdentificacionUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConf;
    private javax.swing.JPasswordField txtPregunta1;
    private javax.swing.JPasswordField txtPregunta2;
    private javax.swing.JPasswordField txtPregunta3;
    private javax.swing.JPasswordField txtPregunta4;
    private javax.swing.JTextField txtTelefonoUsuario;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioUsuario;
    // End of variables declaration//GEN-END:variables
}
