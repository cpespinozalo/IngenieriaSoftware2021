/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.adopcionmascotas.vista;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author christtian
 */
public class Inicio extends javax.swing.JFrame {

    private List<JPanel> mascotas;
    private int reg;
    private int posX;
    private int posY;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            initComponents();
            reg = 1;
            posX = 10;
            posY = 68;
            mascotas = new ArrayList<>();
            setLocationRelativeTo(null);
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            javax.swing.JOptionPane.showMessageDialog(this.rootPane,"Imposible modificar el tema visual","Lookandfeel inválido.",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crearPanelMascota(String nombre, String fecha, String ciudad, Integer edad, Integer x, Integer y){
        
        JPanel panMascota = new JPanel();
        panMascota.setBackground(new java.awt.Color(255, 255, 255));
        panMascota.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panMascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        JLabel fotoMascota = new JLabel();
        fotoMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/utpl/adopcionmascotas/vista/imgMascota01.png")));
        panMascota.add(fotoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 100, 100));
        
        JLabel nombreMascota = new JLabel();
        nombreMascota.setFont(new java.awt.Font("Tahoma", 1, 24));
        nombreMascota.setForeground(new java.awt.Color(255, 54, 54));
        nombreMascota.setText(nombre);
        panMascota.add(nombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 15, 550, 30));
        
        JLabel fechaMascota = new JLabel();
        fechaMascota.setFont(new java.awt.Font("Tahoma", 0, 14));
        fechaMascota.setForeground(new java.awt.Color(102, 102, 102));
        fechaMascota.setText("Fecha Publicación: " + fecha);
        panMascota.add(fechaMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 55, 200, 20));
        
        JLabel ciudadMascota = new JLabel();
        ciudadMascota.setFont(new java.awt.Font("Tahoma", 0, 14));
        ciudadMascota.setText("Ciudad: " + ciudad);
        panMascota.add(ciudadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 75, 200, 20));
        
        JLabel edadMascota = new JLabel();
        edadMascota.setFont(new java.awt.Font("Tahoma", 0, 14));
        edadMascota.setText("Edad: " + edad + " meses");
        panMascota.add(edadMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 95, 200, 20));
        
        JButton btnVerMascota = new JButton();
        btnVerMascota.setOpaque(false);
        btnVerMascota.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnVer.png"));
        btnVerMascota.setToolTipText("Ver la mascota.");
        btnVerMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panMascota.add(btnVerMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 55, 60, 60));
        
        
        JScrollPane scrObservaciones = new JScrollPane();
        scrObservaciones.setBorder(null);
        scrObservaciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrObservaciones.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrObservaciones.setFont(new java.awt.Font("Tahoma", 0, 12));
        
        JTextPane observaciones = new JTextPane();       
        observaciones.setEditable(false);
        observaciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        observaciones.setFont(new java.awt.Font("Tahoma", 0, 12));
        observaciones.setText("Esta mas cota es muy juguetona y cariñosa, tiene todas sus vacunas al dia y está muy sana. Es obediente y tranquila cuando se lo pide. Le encanta salir al parque y...");
        observaciones.setAutoscrolls(false);
        observaciones.setCaretColor(new java.awt.Color(255, 255, 255));
        scrObservaciones.setViewportView(observaciones);
        panMascota.add(observaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 55, 340, 60));
       
        panInicioListadoMascotas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panInicioListadoMascotas.add(panMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, 800, 130));
        panInicioListadoMascotas.updateUI();
        mascotas.add(panMascota);
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panInicioLateral = new javax.swing.JPanel();
        lblLogoPrincipal = new javax.swing.JLabel();
        btnInicioMascotas = new javax.swing.JButton();
        btnInicioAdopciones = new javax.swing.JButton();
        btnInicioUsuarios = new javax.swing.JButton();
        btnInicioVeterinaria = new javax.swing.JButton();
        btnInicioNosotros = new javax.swing.JButton();
        panInicioSuperior = new javax.swing.JPanel();
        lblInicioPortada = new javax.swing.JLabel();
        lblInicioSubtitulo = new javax.swing.JLabel();
        lblInicioTitulo = new javax.swing.JLabel();
        btnInicioLogin = new javax.swing.JButton();
        btnInicioRegistrar = new javax.swing.JButton();
        btnInicioSalir = new javax.swing.JButton();
        lblInicioAvatar = new javax.swing.JLabel();
        lblInicioBienvenida = new javax.swing.JLabel();
        lblInicioNombre = new javax.swing.JLabel();
        panInicioInferior = new javax.swing.JPanel();
        lblInicioUniversidad = new javax.swing.JLabel();
        lblInicioAutores = new javax.swing.JLabel();
        lblIncioUtpl = new javax.swing.JLabel();
        panInicioIntro = new javax.swing.JPanel();
        lblInicioTituloIntro = new javax.swing.JLabel();
        lblFotoPortadaA = new javax.swing.JLabel();
        lblFotoPortadaB = new javax.swing.JLabel();
        lblFotoPortadaC = new javax.swing.JLabel();
        scrInicioIntro = new javax.swing.JScrollPane();
        txpInicioIntro = new javax.swing.JTextPane();
        scrInicioMascotas = new javax.swing.JScrollPane();
        panInicioListadoMascotas = new javax.swing.JPanel();
        lblInicioTituloMascotas = new javax.swing.JLabel();
        lblInicioSubtituloMascotas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panInicioLateral.setBackground(new java.awt.Color(255, 54, 54));
        panInicioLateral.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panInicioLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\imgLogoPrincipal.png")); // NOI18N
        panInicioLateral.add(lblLogoPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 245, 140));

        btnInicioMascotas.setBackground(new java.awt.Color(255, 54, 54));
        btnInicioMascotas.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnNuestrasMascotas.png")); // NOI18N
        btnInicioMascotas.setToolTipText("Conoce las mascotas disponibles.");
        btnInicioMascotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioMascotas.setOpaque(false);
        btnInicioMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioMascotasActionPerformed(evt);
            }
        });
        panInicioLateral.add(btnInicioMascotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 185, 60));

        btnInicioAdopciones.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnAdopciones.png")); // NOI18N
        btnInicioAdopciones.setToolTipText("Inicia una adopción.");
        btnInicioAdopciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioAdopciones.setOpaque(false);
        panInicioLateral.add(btnInicioAdopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 185, 60));

        btnInicioUsuarios.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnUsuarios.png")); // NOI18N
        btnInicioUsuarios.setToolTipText("Conoce nuestros usuarios.");
        btnInicioUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioUsuarios.setOpaque(false);
        panInicioLateral.add(btnInicioUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 185, 60));

        btnInicioVeterinaria.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnVeterinaria.png")); // NOI18N
        btnInicioVeterinaria.setToolTipText("Visita la veterinaria.");
        btnInicioVeterinaria.setBorder(null);
        btnInicioVeterinaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioVeterinaria.setOpaque(false);
        panInicioLateral.add(btnInicioVeterinaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 185, 60));

        btnInicioNosotros.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnNosotros.png")); // NOI18N
        btnInicioNosotros.setToolTipText("Información de los autores.");
        btnInicioNosotros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioNosotros.setOpaque(false);
        btnInicioNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioNosotrosActionPerformed(evt);
            }
        });
        panInicioLateral.add(btnInicioNosotros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, 185, 60));

        getContentPane().add(panInicioLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 245, 1040));

        panInicioSuperior.setBackground(new java.awt.Color(41, 41, 41));
        panInicioSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panInicioSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicioPortada.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\imgFotoPortada.png")); // NOI18N
        panInicioSuperior.add(lblInicioPortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 417, 130));

        lblInicioSubtitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblInicioSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioSubtitulo.setText("plataforma");
        panInicioSuperior.add(lblInicioSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 200, 30));

        lblInicioTitulo.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        lblInicioTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioTitulo.setText("adopción de mascotas");
        panInicioSuperior.add(lblInicioTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 800, 120));

        btnInicioLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnLogin.png")); // NOI18N
        btnInicioLogin.setToolTipText("Login de Usuario");
        btnInicioLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioLogin.setOpaque(false);
        panInicioSuperior.add(btnInicioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1335, 90, 50, 50));

        btnInicioRegistrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnCrear.png")); // NOI18N
        btnInicioRegistrar.setToolTipText("Crear Usuario Nuevo");
        btnInicioRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioRegistrar.setOpaque(false);
        btnInicioRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioRegistrarActionPerformed(evt);
            }
        });
        panInicioSuperior.add(btnInicioRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 90, 50, 50));

        btnInicioSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\btnSalir.png")); // NOI18N
        btnInicioSalir.setText("");
        btnInicioSalir.setToolTipText("Salir de la Aplicación");
        btnInicioSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioSalir.setOpaque(false);
        btnInicioSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSalirActionPerformed(evt);
            }
        });
        panInicioSuperior.add(btnInicioSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1465, 90, 50, 50));

        lblInicioAvatar.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\imgHombre.png")); // NOI18N
        panInicioSuperior.add(lblInicioAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 15, 100, 125));

        lblInicioBienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicioBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioBienvenida.setText("Bienvenido,");
        panInicioSuperior.add(lblInicioBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 20, -1, 20));

        lblInicioNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInicioNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInicioNombre.setText("Cristian Paúl Espinoza");
        panInicioSuperior.add(lblInicioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 40, 330, 20));

        getContentPane().add(panInicioSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 0, 1675, 150));

        panInicioInferior.setBackground(new java.awt.Color(41, 41, 41));
        panInicioInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panInicioInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicioUniversidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInicioUniversidad.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioUniversidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInicioUniversidad.setText("Universidad Técnica Pasticular de Loja");
        panInicioInferior.add(lblInicioUniversidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 400, 32));

        lblInicioAutores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInicioAutores.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioAutores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInicioAutores.setText("[ ESPINOZA - CONTRERAS - GÓMEZ - CEDEÑO - REA ]");
        panInicioInferior.add(lblInicioAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 52, 400, 32));

        lblIncioUtpl.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\imgLogoUtplGrande.png")); // NOI18N
        panInicioInferior.add(lblIncioUtpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1454, 20, 160, 64));

        getContentPane().add(panInicioInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 940, 1675, 100));

        panInicioIntro.setBackground(new java.awt.Color(255, 255, 255));
        panInicioIntro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panInicioIntro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicioTituloIntro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblInicioTituloIntro.setForeground(new java.awt.Color(255, 54, 54));
        lblInicioTituloIntro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInicioTituloIntro.setText("Adopta: ganamos todos !");
        lblInicioTituloIntro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panInicioIntro.add(lblInicioTituloIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 650, 30));

        lblFotoPortadaA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/utpl/adopcionmascotas/vista/imgFotoGaleria1.png"))); // NOI18N
        lblFotoPortadaA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panInicioIntro.add(lblFotoPortadaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 260, 140));

        lblFotoPortadaB.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\imgFotoGaleria2.png")); // NOI18N
        lblFotoPortadaB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panInicioIntro.add(lblFotoPortadaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 260, 140));

        lblFotoPortadaC.setIcon(new javax.swing.ImageIcon("C:\\Users\\christtian\\Fuentes\\IngenieriaSoftware2021\\AdopcionMascotas\\images\\imgFotoGaleria3.png")); // NOI18N
        lblFotoPortadaC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panInicioIntro.add(lblFotoPortadaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, 260, 140));

        scrInicioIntro.setBorder(null);
        scrInicioIntro.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrInicioIntro.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrInicioIntro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txpInicioIntro.setEditable(false);
        txpInicioIntro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txpInicioIntro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txpInicioIntro.setText("A través de la historia, las mascotas han sido grandes compañeras de la vida de las personas, compartiendo alegrías, pero también ayudando a superar momentos difíciles.\n\nAdoptar es un gran paso. Hay muchos aspectos que debes considerar previamente, desde elegir el tipo de mascota más adecuada para tu estilo de vida, hasta decidir dónde o con quién adoptar. Por eso queremos ayudarte para que ésta sea una de las mejores experiencias en tu vida y la de tu próximo amigo de cuatro patas.");
        txpInicioIntro.setAutoscrolls(false);
        txpInicioIntro.setCaretColor(new java.awt.Color(255, 255, 255));
        scrInicioIntro.setViewportView(txpInicioIntro);

        panInicioIntro.add(scrInicioIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 650, 100));

        getContentPane().add(panInicioIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 165, 1645, 160));

        scrInicioMascotas.setBackground(new java.awt.Color(255, 255, 255));

        panInicioListadoMascotas.setBackground(new java.awt.Color(255, 255, 255));
        panInicioListadoMascotas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicioTituloMascotas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblInicioTituloMascotas.setForeground(new java.awt.Color(255, 54, 54));
        lblInicioTituloMascotas.setText("Conoce nuestras mascotas...");
        panInicioListadoMascotas.add(lblInicioTituloMascotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 600, 30));

        lblInicioSubtituloMascotas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInicioSubtituloMascotas.setText("Puedes ver todas las mascotas disponibles para adopción, las cuales tienen todas sus vacunas y estan listas para ir contigo:");
        panInicioListadoMascotas.add(lblInicioSubtituloMascotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 690, 20));

        scrInicioMascotas.setViewportView(panInicioListadoMascotas);

        getContentPane().add(scrInicioMascotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 1640, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioMascotasActionPerformed
        
        
        if(reg % 2 == 0) {
            posX = 810;
        } else {
            posX = 10;
        }
        crearPanelMascota("Negrito", "20/12/2020", "Cuenca", 7, posX, posY);
         if(reg >1 && reg % 2 == 0){
                posY = posY + 130; 
        }
        reg++;
        
        
    }//GEN-LAST:event_btnInicioMascotasActionPerformed

    private void btnInicioNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioNosotrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioNosotrosActionPerformed

    private void btnInicioSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnInicioSalirActionPerformed

    private void btnInicioRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicioAdopciones;
    private javax.swing.JButton btnInicioLogin;
    private javax.swing.JButton btnInicioMascotas;
    private javax.swing.JButton btnInicioNosotros;
    private javax.swing.JButton btnInicioRegistrar;
    private javax.swing.JButton btnInicioSalir;
    private javax.swing.JButton btnInicioUsuarios;
    private javax.swing.JButton btnInicioVeterinaria;
    private javax.swing.JLabel lblFotoPortadaA;
    private javax.swing.JLabel lblFotoPortadaB;
    private javax.swing.JLabel lblFotoPortadaC;
    private javax.swing.JLabel lblIncioUtpl;
    private javax.swing.JLabel lblInicioAutores;
    private javax.swing.JLabel lblInicioAvatar;
    private javax.swing.JLabel lblInicioBienvenida;
    private javax.swing.JLabel lblInicioNombre;
    private javax.swing.JLabel lblInicioPortada;
    private javax.swing.JLabel lblInicioSubtitulo;
    private javax.swing.JLabel lblInicioSubtituloMascotas;
    private javax.swing.JLabel lblInicioTitulo;
    private javax.swing.JLabel lblInicioTituloIntro;
    private javax.swing.JLabel lblInicioTituloMascotas;
    private javax.swing.JLabel lblInicioUniversidad;
    private javax.swing.JLabel lblLogoPrincipal;
    private javax.swing.JPanel panInicioInferior;
    private javax.swing.JPanel panInicioIntro;
    private javax.swing.JPanel panInicioLateral;
    private javax.swing.JPanel panInicioListadoMascotas;
    private javax.swing.JPanel panInicioSuperior;
    private javax.swing.JScrollPane scrInicioIntro;
    private javax.swing.JScrollPane scrInicioMascotas;
    private javax.swing.JTextPane txpInicioIntro;
    // End of variables declaration//GEN-END:variables
}
