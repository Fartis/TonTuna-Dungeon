/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import java.awt.Graphics;
import java.awt.Image;
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
    JButton jButton1 = new JButton("Iniciar Partida");
        public ImagePanel(Image image) {
            this.image = image;
            
            
            this.add(jButton1);
            
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image,0,0,800,600,this);
        }
    }
