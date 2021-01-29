package ec.edu.utpl.adopcionmascotas.controlador;

import javax.swing.JLabel;

/**
 * Control del reloj de la aplicacion
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class ThreadSistema extends Thread {
 
    private Utilitarios util;
    private JLabel reloj;
    private JLabel fecha;
    private JLabel fotoA;
    private JLabel fotoB;
    private JLabel fotoC;
    private String mascaraHora;
    private String mascaraFecha;
    private boolean activo;
    
    private static final Integer INTERVALO = 5;
    
    
    public ThreadSistema(boolean activo, String mascaraHora, String mascaraFecha, JLabel ... label){
        
        this.reloj = label[0];
        this.fecha = label[1];
        this.fotoA = label[2];
        this.fotoB = label[3];
        this.fotoC = label[4];
        this.mascaraHora = mascaraHora;
        this.mascaraFecha = mascaraFecha;
        this.activo = activo;
        this.util = new Utilitarios();
    }
    
    @Override
    public void run(){
        int registro = 1;
        int indice = 1;
        while(activo){
            try {
                reloj.setText(util.tiempoSistema(mascaraHora));
                fecha.setText(util.tiempoSistema(mascaraFecha));
                if(indice>4){
                    indice = 1;
                }
                if(registro>INTERVALO){
                    fotoA.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.format("/images/imgFotoGaleria%s.png", 0 + indice))));
                    fotoB.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.format("/images/imgFotoGaleria%s.png", 4 + indice))));
                    fotoC.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.format("/images/imgFotoGaleria%s.png", 8 + indice))));
                    registro = 1;
                    indice++;
                }
                
                Thread.sleep(1000);
                registro++;
                
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }  
}


