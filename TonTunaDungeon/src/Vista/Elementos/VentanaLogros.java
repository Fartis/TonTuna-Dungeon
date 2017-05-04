/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Alumno03
 */
public class VentanaLogros extends JPanel{
    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/logros.gif");
    JButton jButtonVolver = new JButton("Volver");
    JList jListLogros = new JList();
    JTextArea descripcionLogro = new JTextArea("");
    JFramePrincipal padre;
    
    public VentanaLogros() {
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
//        jListLogros.addListSelectionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jListLogrosActionPerformed(evt);
//            }
//        });
        this.add(jButtonVolver);
        this.add(jListLogros);
        this.add(descripcionLogro);
    }
    public void setPadre(JFramePrincipal padre) {
            this.padre = padre;
        }
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        this.setBackground(new Color(0, 0, 0, 255));
        jButtonVolver.setBounds(180, 508, 200, 40);
        jListLogros.setBounds(20, 20, 550, 480);
        jListLogros.setBackground(new Color(0,0,0,127));
        descripcionLogro.setBounds(660, 20, 200, 480);
        descripcionLogro.setEditable(false);
        descripcionLogro.setHighlighter(null);
        descripcionLogro.setOpaque(false);
        
        
    }
}