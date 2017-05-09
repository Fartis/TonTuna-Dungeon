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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author SeñorPelos
 */
public class VentanaCargar extends JPanel {
    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/cargar.gif");
    JButton jButtonAtras = new JButton("Atrás");
    JButton jButtonCargar = new JButton("Cargar");
    JButton jButtonBorrar = new JButton("Borrar");
    JTable jTabla = new JTable();
    JFramePrincipal padre;
    
    
    /**
     * Metodo que gestiona las distintas opciones de la ventana de carga
     */
    public VentanaCargar() {
        jButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartida1ActionPerformed(evt);
            }
        });
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartida2ActionPerformed(evt);
            }
        });
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        
        setText();
        this.add(jButtonCargar);
        this.add(jButtonBorrar);
        this.add(jButtonAtras);
        this.add(jTabla);
        jTabla.setModel(ControladorPrincipal.getSingleton().obtenerInfoPartidas());
        jTabla.setCellSelectionEnabled(false);
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
    
    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonCargar.setBounds(50, 500, 200, 40);
        jButtonBorrar.setBounds(300, 500, 200, 40);
        jButtonAtras.setBounds(550, 500, 200, 40);
        jTabla.setBounds(20,20,740,450);
        jTabla.setBackground(new Color(0,0,0,144));
        jTabla.setAutoCreateColumnsFromModel(true);
        jTabla.setForeground(Color.white);
    }
    
    public void setText(){
    }
}
