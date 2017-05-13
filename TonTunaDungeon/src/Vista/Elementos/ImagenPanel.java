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
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Gonzalez Rodriguez
 */
public class ImagenPanel extends JPanel {

    private Image image;
    private int width, height;
    
    /**
     * Constructor de la clase ImagenPanel()
     */
    public ImagenPanel(){
        
    }

    /**
     * Constructor de la clase ImagenPanel
     * @param width int valor en pixeles del ancho.
     * @param height int valor en pixeles del alto.
     * @param url String con la dirección de la imagen
     */
    public ImagenPanel(int width, int height, String url) {
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
