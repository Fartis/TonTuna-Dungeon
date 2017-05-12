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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Clase que gestiona la ventana o panel del menu principal del juego
 * @author Manuel David Villalba Escamilla
 */
public class VentanaSubirNivel extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/subirNivel.png");
    JButton jButtonFuerza = new JButton("Fuerza");
    JButton jButtonDestreza = new JButton("Destreza");
    JButton jButtonIntelecto = new JButton("Intelecto");
    JButton jButtonConstitucion = new JButton("Constitucion");
    JFramePrincipal padre;

    /**
     * Metodo que gestiona las distintas opciones de la ventana principal
     */
    public VentanaSubirNivel() {
        jButtonFuerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuerzaActionPerformed(evt);
            }
        });
        jButtonDestreza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDestrezaActionPerformed(evt);
            }
        });
        jButtonIntelecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIntelectoActionPerformed(evt);
            }
        });
        jButtonConstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConstitucionActionPerformed(evt);
            }
        });

        this.add(jButtonFuerza);
        this.add(jButtonDestreza);
        this.add(jButtonIntelecto);
        this.add(jButtonConstitucion);

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
    private void jButtonFuerzaActionPerformed(java.awt.event.ActionEvent evt){
        
    }

    /**
     * Metodo para el evento del boton cargar
     * @param evt 
     */
    private void jButtonDestrezaActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    /**
     * Metodo para el evento del boton cargar
     * @param evt 
     */
    private void jButtonIntelectoActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    /**
     * Metodo para el evento del boton cargar
     * @param evt 
     */
    private void jButtonConstitucionActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    /**
     * Metodo para el evento del boton logros
     * @param evt 
     */
    private void jButtonLogrosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Tranquilidad, ésta opción aún no está completada", "EN CONSTRUCCIÓN", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo para el evento del boton salir
     * @param evt 
     */
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonFuerza.setBounds(300, 410, 200, 40);
        jButtonDestreza.setBounds(300, 460, 200, 40);
        jButtonIntelecto.setBounds(300, 510, 200, 40);
    }
}
