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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaMazmorra extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/dungeon.gif");
    private JFramePrincipal padre;
    private JTextArea jTextoAventura = new JTextArea();
    private JLabel jLabelMapa = new JLabel("Mapa");
    private JButton jArriba = new JButton("↑"),
            jAbajo = new JButton("↓"),
            jDerecha = new JButton("→"),
            jIzquierda = new JButton("←");
    private JTable mapa = new JTable();

    public VentanaMazmorra() {
        this.add(jTextoAventura);
        this.add(jArriba);
        this.add(jAbajo);
        this.add(jDerecha);
        this.add(jIzquierda);
        this.add(jLabelMapa);
        this.add(mapa);
        escribirTexto(ControladorPrincipal.getSingleton().getNombre()
                + " acabas de adentrarte en la mazmorra en busca de tesoros, adelante.");
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuNuevaPartida(ControladorPrincipal.getSingleton().getOpcionMusica());
        this.setVisible(false);
        padre.dispose();
    }

    public void escribirTexto(String linea) {
        String total = jTextoAventura.getText() + "\n" + linea;
        jTextoAventura.setText(total);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jTextoAventura.setBounds(20, 20, 400, 300);
        jTextoAventura.setBackground(new Color(0, 0, 0, 125));
        jTextoAventura.setForeground(Color.white);
        jTextoAventura.setLineWrap(true);
        jTextoAventura.setWrapStyleWord(true);
        jTextoAventura.setEditable(false);
        mapa.setBounds(440,20,340,340);
        jArriba.setBounds(580,400,60,60);
        jAbajo.setBounds(580,460,60,60);
        jDerecha.setBounds(640,430,60,60);
        jIzquierda.setBounds(520,430,60,60);
    }
}
