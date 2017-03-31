/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Vista.JFramePrincipal;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ImagePanel extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/logoanimado.gif");
    JButton jButtonIniciar = new JButton("Iniciar Partida");
    JButton jButtonCargar = new JButton("Cargar Partida");
    JButton jButtonSalir = new JButton("Salir");
    JFramePrincipal padre;

    public ImagePanel() {
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
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        this.add(jButtonIniciar);
        this.add(jButtonCargar);
        this.add(jButtonSalir);

    }
    
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuNuevaPartida();
        this.setVisible(false);
        padre.dispose();
        
        
    }

    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonIniciar.setBounds(300, 380, 200, 40);
        jButtonCargar.setBounds(300, 430, 200, 40);
        jButtonSalir.setBounds(300, 480, 200, 40);
    }
}
