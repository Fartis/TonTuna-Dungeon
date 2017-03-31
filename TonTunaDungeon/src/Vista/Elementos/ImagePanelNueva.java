/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Vista.JFramePrincipal;
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
public class ImagePanelNueva extends JPanel {

    private Image image;
    JButton jButtonIniciar = new JButton("Iniciar Partida");
    JButton jButtonCargar = new JButton("Cargar Partida");
    JButton jButtonSalir = new JButton("Salir");
    JFramePrincipal padre;

    public ImagePanelNueva(Image image, JFramePrincipal padre) {
        this.image = image;
        this.padre = padre;

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
