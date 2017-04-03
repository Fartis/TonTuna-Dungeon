/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Vista.JFramePrincipal;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class imagePanel extends JPanel {

    private Image image;
    private JFramePrincipal padre;
    private int width, height;

    public imagePanel(int width, int height, String url) {
        this.width=width;
        this.height=height;
        this.image = Toolkit.getDefaultToolkit().getImage("src/Recursos/logoanimado.gif");
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
        g.drawImage(image, 0, 0, width, height, this);
    }
}
