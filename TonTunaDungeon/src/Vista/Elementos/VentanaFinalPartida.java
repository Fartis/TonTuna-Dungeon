/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Clase para la ventana de final de la aventura.
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Gonzalez Rodriguez
 */
public class VentanaFinalPartida extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/trovador.gif");
    JButton jButtonFin = new JButton("Fin");
    JPanel filtro = new JPanel();
    JTextArea mensajeInicio = new JTextArea("\"CONGRATULATION\n Has finalizado el juego.");
    JTextArea mensajeFirmado = new JTextArea("See you next mission, Dungeon Crawler.");
    JFramePrincipal padre;

    /**
     * Constructor de la clase VentanaFinalPartida
     */
    public VentanaFinalPartida() {
        jButtonFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        this.add(filtro);
        filtro.add(jButtonFin);
        filtro.add(mensajeInicio);
        filtro.add(mensajeFirmado);
    }

    /**
     * Metodo que establece el JFramePrincipal que contiene a VentanaFinalPartida
     *
     * @param padre JFramePrincipal contenedor
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo para la accion del boton de iniciar partida
     *
     * @param evt
     */
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
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
        jButtonFin.setBounds(580, 500, 200, 40);
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
