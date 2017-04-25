/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Controlador.ControladorPrincipal;
import Vista.JFramePrincipal;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaMazmorra extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/dungeon.gif");
    JFramePrincipal padre;

    public VentanaMazmorra() {
    }
    
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuNuevaPartida(ControladorPrincipal.getSingleton().getOpcionMusica());
        this.setVisible(false);
        padre.dispose();
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
    }
}
