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

/**
 *
 * @author SeñorPelos
 */
public class VentanaCargar extends JPanel {
    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/cargar.gif");
    JButton jButtonAtras = new JButton("Atrás");
    JButton jButtonPartida1 = new JButton("Partida 1");
    JButton jButtonPartida2 = new JButton("Partida 2");
    JButton jButtonPartida3 = new JButton("Partida 3");
    JButton jButtonPartida4 = new JButton("Partida 4");
    JFramePrincipal padre;
    
    /**
     * Metodo que gestiona las distintas opciones de la ventana de carga
     */
    public VentanaCargar() {
        jButtonPartida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartida1ActionPerformed(evt);
            }
        });
        jButtonPartida2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartida2ActionPerformed(evt);
            }
        });
        jButtonPartida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartida3ActionPerformed(evt);
            }
        });
        jButtonPartida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartida4ActionPerformed(evt);
            }
        });
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        
        setText();

        this.add(jButtonPartida1);
        this.add(jButtonPartida2);
        this.add(jButtonPartida3);
        this.add(jButtonPartida4);
        this.add(jButtonAtras);
    }
    
    /**
     * Metodo 
     * @param padre 
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }
    
    private void jButtonPartida1ActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:        
    }
    private void jButtonPartida2ActionPerformed(java.awt.event.ActionEvent evt){
    // TODO add your handling code here:        
    }
    private void jButtonPartida3ActionPerformed(java.awt.event.ActionEvent evt){
    // TODO add your handling code here:        
    }
    private void jButtonPartida4ActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:        
    }
    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonPartida1.setBounds(75, 75, 300, 150);
        jButtonPartida2.setBounds(425, 75, 300, 150);
        jButtonPartida3.setBounds(75, 275, 300, 150);
        jButtonPartida4.setBounds(425, 275, 300, 150);
        jButtonAtras.setBounds(180, 500, 200, 40);
        jButtonPartida1.setBackground(new Color(0,0,0,127));
        jButtonPartida2.setBackground(new Color(0,0,0,127));
        jButtonPartida3.setBackground(new Color(0,0,0,127));
        jButtonPartida4.setBackground(new Color(0,0,0,127));
        jButtonPartida1.setForeground(Color.white);
        jButtonPartida2.setForeground(Color.white);
        jButtonPartida3.setForeground(Color.white);
        jButtonPartida4.setForeground(Color.white);
    }
    
    public void setText(){
        
    }
}
