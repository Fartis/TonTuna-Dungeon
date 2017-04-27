/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Controlador.ControladorPrincipal;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Clase que gestiona la ventana o panel del menu principal del juego
 * @author Manuel David Villalba Escamilla
 */
public class VentanaLogo extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/logoanimado.gif");
    JButton jButtonIniciar = new JButton("Iniciar Partida");
    JButton jButtonCargar = new JButton("Cargar Partida");
    JButton jButtonLogros = new JButton("Logros");
    JButton jButtonSalir = new JButton("Salir");
    JLabel labelMusica = new JLabel("Musica");
    JRadioButton jOpcionMusica = new JRadioButton();
    JFramePrincipal padre;

    /**
     * Metodo que gestiona las distintas opciones de la ventana principal
     */
    public VentanaLogo() {
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        jButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarActionPerformed(evt);
            }
        });
        jButtonLogros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogrosActionPerformed(evt);
            }
        });
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jOpcionMusica.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpcionMusicaActionPerformed(evt);
            }
        });

        this.add(jButtonIniciar);
        this.add(jButtonCargar);
        this.add(jButtonLogros);
        this.add(jButtonSalir);
        this.add(jOpcionMusica);
        this.add(labelMusica);
        jOpcionMusica.setSelected(ControladorPrincipal.getSingleton().getOpcionMusica());

    }
    /**
     * Metodo 
     * @param padre 
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo para el evento del boton iniciar
     * @param evt 
     */
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuNuevaPartida();
        this.setVisible(false);
        padre.dispose();
        
        
    }
    /**
     * Metodo para el evento del boton musica
     * @param evt 
     */
    private void jOpcionMusicaActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorPrincipal.getSingleton().setOpcionMusica();
    }

    /**
     * Metodo para el evento del boton cargar
     * @param evt 
     */
    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    /**
     * Metodo para el evento del boton logros
     * @param evt 
     */
    private void jButtonLogrosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Tranquilidad, ésta opción aún no está completada", "EN CONSTRUCCIÓN", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo para el evento del boton salir
     * @param evt 
     */
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonIniciar.setBounds(300, 360, 200, 40);
        jButtonCargar.setBounds(300, 410, 200, 40);
        jButtonLogros.setBounds(300, 460, 200, 40);
        jButtonSalir.setBounds(300, 510, 200, 40);
        jOpcionMusica.setBounds(20,540,20,20);
        labelMusica.setBounds(50, 540, 60, 20);
        labelMusica.setFont(new Font("Dialog", Font.BOLD, 15));
        labelMusica.setForeground(Color.white);
    }
}
