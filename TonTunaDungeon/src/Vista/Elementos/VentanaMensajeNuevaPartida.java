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
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaMensajeNuevaPartida extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/logoanimado.gif");
    JButton jButtonIniciar = new JButton("Alle voy");
    JTextArea mensajeInicio = new JTextArea("Estando en tu casa y harto de que el partido"
            + " político que está en el gobierno con sus decisiones te impida tener una"
            + " vida laboral plena decides ir en busca de tesoros para poder vivir una"
            + " vida de gula y lujuria, llevado por este deseo irrefrenable de aventuras"
            + " decides escribirle una carta a tu querida madre:\n" + "\n" + "\"MAMA, que me"
            + " voy de aventuras, estoy harto de ser un nini, he decidido que quiero ser"
            + " aventurero y saqueador de mazmorras, volveré para la hora de cenar, guárdame"
            + " la comida y me la caliento en el microondas.\n PD: Me llevo 5€ pa' tabaco.");
    JTextArea mensajeFirmado = new JTextArea("Firmado:");
    JTextArea mensajeComilla = new JTextArea("\"");
    JTextField textFieldNombre = new JTextField("");
    JFramePrincipal padre;

    public VentanaMensajeNuevaPartida() {
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        this.add(jButtonIniciar);
        this.add(mensajeInicio);
        this.add(mensajeFirmado);
        this.add(mensajeComilla);
        this.add(textFieldNombre);
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!textFieldNombre.getText().isEmpty()) {
            ControladorPrincipal.getSingleton().establecerNombrePJ(textFieldNombre.getText());
//            ControladorGUI.getSingleton().menuNuevaPartida();
//            this.setVisible(false);
//            padre.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No has puesto ningun nombre.");
        }
    }

    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jButtonLogrosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(0, 0, 0, 255));
        jButtonIniciar.setBounds(580, 500, 200, 40);
        mensajeInicio.setFont(new Font("Dialog", Font.BOLD, 22));
        mensajeInicio.setLineWrap(true);
        mensajeInicio.setWrapStyleWord(true);
        mensajeInicio.setForeground(Color.white);
        mensajeInicio.setBounds(20, 20, 640, 380);
        mensajeInicio.setOpaque(false);
        mensajeFirmado.setFont(new Font("Dialog", Font.BOLD, 22));
        mensajeFirmado.setLineWrap(true);
        mensajeFirmado.setWrapStyleWord(true);
        mensajeFirmado.setForeground(Color.white);
        mensajeFirmado.setBounds(400, 400, 100, 40);
        mensajeFirmado.setOpaque(false);
        mensajeComilla.setFont(new Font("Dialog", Font.BOLD, 22));
        mensajeComilla.setLineWrap(true);
        mensajeComilla.setWrapStyleWord(true);
        mensajeComilla.setForeground(Color.white);
        mensajeComilla.setBounds(715, 400, 20, 20);
        mensajeComilla.setOpaque(false);
        textFieldNombre.setBounds(500, 400, 210, 40);
    }
}
