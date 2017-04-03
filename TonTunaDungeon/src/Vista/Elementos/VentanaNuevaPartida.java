/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaNuevaPartida extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/nuevapartida.gif");
    private JButton jButtonAtras = new JButton("Atras");
    private JButton jButtonIniciar = new JButton("Iniciar partida");
    private JButton jButtonHumano = new JButton("Humano");
    private JButton jButtonElfo = new JButton("Elfo");
    private JButton jButtonEnano = new JButton("Enano");
    private JButton jButtonMediano = new JButton("Mediano");
    private JPanel jPanelHumano = new JPanel();
    private JPanel jPanelElfo = new JPanel();
    private JPanel jPanelEnano = new JPanel();
    private JPanel jPanelMediano = new JPanel();

    private JPanel seleccionPersonaje = new JPanel();
    private JFramePrincipal padre;

    public VentanaNuevaPartida() {
        iniciarEventos();
        añadirElementosPaneles();
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }
    private void jButtonHumanoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(!jPanelHumano.isVisible()){
            jPanelElfo.setVisible(false);
            jPanelEnano.setVisible(false);
            jPanelMediano.setVisible(false);
            jPanelHumano.setVisible(true);
        }
    }
    private void jButtonElfoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(!jPanelElfo.isVisible()){
            jPanelElfo.setVisible(true);
            jPanelEnano.setVisible(false);
            jPanelMediano.setVisible(false);
            jPanelHumano.setVisible(false);
        }
    }
    private void jButtonEnanoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(!jPanelEnano.isVisible()){
            jPanelElfo.setVisible(false);
            jPanelEnano.setVisible(true);
            jPanelMediano.setVisible(false);
            jPanelHumano.setVisible(false);
        }
    }
    private void jButtonMedianoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(!jPanelMediano.isVisible()){
            jPanelElfo.setVisible(false);
            jPanelEnano.setVisible(false);
            jPanelMediano.setVisible(true);
            jPanelHumano.setVisible(false);
        }
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonAtras.setBounds(180, 508, 200, 40);
        jButtonIniciar.setBounds(580, 508, 200, 40);
        seleccionPersonaje.setBounds(20, 20, 140, 530);
        jButtonHumano.setBounds(20, 20, 100, 107);
        jButtonElfo.setBounds(20, 147, 100, 107);
        jButtonEnano.setBounds(20, 274, 100, 107);
        jButtonMediano.setBounds(20, 401, 100, 107);
        jPanelHumano.setBounds(180, 20, 600, 460);
        jPanelElfo.setBounds(180, 20, 600, 460);
        jPanelEnano.setBounds(180, 20, 600, 460);
        jPanelMediano.setBounds(180, 20, 600, 460);
        seleccionPersonaje.setBackground(new Color(0, 0, 0, 125));
        jPanelHumano.setBackground(new Color(0, 0, 0, 125));
        jPanelElfo.setBackground(new Color(0, 0, 0, 125));
        jPanelEnano.setBackground(new Color(0, 0, 0, 125));
        jPanelMediano.setBackground(new Color(0, 0, 0, 125));
    }
    
    private void iniciarEventos(){
        
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        jButtonHumano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHumanoActionPerformed(evt);
            }
        });
        jButtonElfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElfoActionPerformed(evt);
            }
        });
        jButtonEnano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnanoActionPerformed(evt);
            }
        });
        jButtonMediano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedianoActionPerformed(evt);
            }
        });
    }
    
    private void añadirElementosPaneles(){        
        this.add(jButtonAtras);
        this.add(jButtonIniciar);
        this.add(seleccionPersonaje);
        this.add(jPanelHumano);
        this.add(jPanelElfo);
        this.add(jPanelEnano);
        this.add(jPanelMediano);
        jPanelElfo.setVisible(false);
        jPanelEnano.setVisible(false);
        jPanelMediano.setVisible(false);
        seleccionPersonaje.add(jButtonHumano);
        seleccionPersonaje.add(jButtonElfo);
        seleccionPersonaje.add(jButtonEnano);
        seleccionPersonaje.add(jButtonMediano);
        
    }
}
