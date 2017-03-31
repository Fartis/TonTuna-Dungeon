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
public class ImagePanelNueva extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/nuevapartida.gif");
    JButton jButtonIniciar = new JButton("Iniciar Partida");
    JFramePrincipal padre;

    public ImagePanelNueva() {
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        this.add(jButtonIniciar);
    }
    
    
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }
    
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonIniciar.setBounds(300, 380, 200, 40);
    }
}
