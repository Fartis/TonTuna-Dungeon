/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ImagePanel extends JPanel {

    private Image image;
    JButton jButtonIniciar = new JButton("Iniciar Partida");
    JButton jButtonCargar = new JButton("Cargar Partida");
    JButton jButtonSalir = new JButton("Salir");

    public ImagePanel(Image image) {
        this.image = image;

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
    
    
    
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
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
