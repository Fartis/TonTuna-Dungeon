/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * Clase que introduce la imagen dentro del panel
 * @author Manuel David Villalba Escamilla
 */
public class ImagePanel extends JPanel {

    private Image image;
    private int width, height;
    
    public ImagePanel(){
        
    }

    /**
     * Constructor de la imagen
     * @param width
     * @param height
     * @param url 
     */
    public ImagePanel(int width, int height, String url) {
        this.width=width;
        this.height=height;
        this.image = Toolkit.getDefaultToolkit().getImage(url);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height, this);
    }
}
