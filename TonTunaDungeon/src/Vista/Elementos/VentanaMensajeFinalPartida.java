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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Clase para la ventana de comienzo aventura e introduccion de nombre
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaMensajeFinalPartida extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/trovador.gif");
    JButton jButtonIniciar = new JButton("Alle voy");
    JPanel filtro = new JPanel();
    JTextArea mensajeInicio = new JTextArea("\"Enhorabuena caballero,\n"
            + "vos habeis conseguido\n"
            + "un grandioso tesoro,\n"
            + "que es completar este\n"
            + "misterioso juego.\n"
            + "Pero esto no es suficiente\n"
            + "mas peligros os acecha\n"
            + "en las siguientes aventuras.\n");
    JTextArea mensajeFirmado = new JTextArea("See you, Dungeon Crawler.");
    JFramePrincipal padre;

    /**
     *
     */
    public VentanaMensajeFinalPartida() {
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        this.add(filtro);
        filtro.add(jButtonIniciar);
        filtro.add(mensajeInicio);
        filtro.add(mensajeFirmado);
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo para la accion del boton de iniciar partida
     *
     * @param evt
     */
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        this.setBackground(new Color(0, 0, 0, 255));
        filtro.setBounds(0, 0, 800, 600);
        filtro.setBackground(new Color(0, 0, 0, 125));
        jButtonIniciar.setBounds(580, 500, 200, 40);
        mensajeInicio.setFont(new Font("Dialog", Font.BOLD, 30));
        mensajeInicio.setLineWrap(true);
        mensajeInicio.setWrapStyleWord(true);
        mensajeInicio.setForeground(Color.white);
        mensajeInicio.setBounds(20, 20, 660, 400);
        mensajeInicio.setOpaque(false);
        mensajeInicio.setEditable(false);
        mensajeInicio.setHighlighter(null);
        mensajeFirmado.setFont(new Font("Dialog", Font.BOLD, 22));
        mensajeFirmado.setLineWrap(true);
        mensajeFirmado.setWrapStyleWord(true);
        mensajeFirmado.setHighlighter(null);
        mensajeFirmado.setForeground(Color.white);
        mensajeFirmado.setBounds(280, 420, 220, 60);
        mensajeFirmado.setOpaque(false);
        mensajeFirmado.setEditable(false);
    }
}
