/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author farti
 */
public class JPanelLogo extends javax.swing.JPanel {
 
	private Image background;
 
        @Override
	public void paintComponent(Graphics g) {
 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
		}
 
                this.setOpaque(false);
		super.paintComponent(g);
	}
 
	public void setBackground(String imagePath) {
		
		this.setOpaque(false);
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}
 
    
}
