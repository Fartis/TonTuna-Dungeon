/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Controlador.ControladorPrincipal;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Clase que gestiona la ventana o panel del menu principal del juego
 * @author Manuel David Villalba Escamilla
 */
public class VentanaCombate extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/logoanimado.gif");
    JButton jButtonAtacar = new JButton("Atacar");
    JButton jButtonObjeto = new JButton("Objeto");
    JFramePrincipal padre;

    /**
     * Metodo que gestiona las distintas opciones de la ventana principal
     */
    public VentanaCombate() {
        jButtonAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtacarActionPerformed(evt);
            }
        });
        jButtonObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObjetoActionPerformed(evt);
            }
        });
        this.add(jButtonAtacar);
        this.add(jButtonObjeto);

    }
    /**
     * Metodo 
     * @param padre 
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo para el evento del boton iniciar
     * @param evt 
     */
    private void jButtonAtacarActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
    }
    /**
     * Metodo para el evento del boton iniciar
     * @param evt 
     */
    private void jButtonObjetoActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonAtacar.setBounds(300, 360, 200, 40);
        jButtonObjeto.setBounds(300, 410, 200, 40);
    }
}
