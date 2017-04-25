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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaMazmorra extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/dungeon.gif");
    private JFramePrincipal padre;
    private JTextArea jTextoAventura = new JTextArea();
    private JLabel jLabelMapa = new JLabel("Mapa"),
            jLabelNombre = new JLabel(ControladorPrincipal.getSingleton().getPJNombre()),
            jLabelVida = new JLabel("Vida: "+ControladorPrincipal.getSingleton().getPJVidaTotal()),
            jLabelArmadura = new JLabel("Armadura");
    private JButton jArriba = new JButton("↑"),
            jAbajo = new JButton("↓"),
            jDerecha = new JButton("→"),
            jIzquierda = new JButton("←"),
            jButtonSalir = new JButton("Salir"),
            jButtonGuardar = new JButton("Guardar"),
            jButtonAbrir = new JButton("Abrir");
    private JTable jTableMapa = new JTable();

    public VentanaMazmorra() {
        this.add(jTextoAventura);
        this.add(jArriba);
        this.add(jAbajo);
        this.add(jDerecha);
        this.add(jIzquierda);
        this.add(jLabelMapa);
        this.add(jTableMapa);
        this.add(jButtonSalir);
        escribirTexto(ControladorPrincipal.getSingleton().getPJNombre()
                + " acabas de adentrarte en la mazmorra en busca de tesoros, adelante.");

        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    public void escribirTexto(String linea) {
        String total = jTextoAventura.getText() + "\n" + linea;
        jTextoAventura.setText(total);
    }

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        int salir = JOptionPane.showConfirmDialog(this, "¿Realmente deseas salir?", "¿Salir?", JOptionPane.OK_CANCEL_OPTION);
        if (salir == 0) {
            ControladorGUI.getSingleton().menuPrincipal();
            this.setVisible(false);
            padre.dispose();
        }
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
        jTableMapa.setBounds(440, 20, 340, 340);
        jArriba.setBounds(580, 400, 60, 60);
        jAbajo.setBounds(580, 460, 60, 60);
        jDerecha.setBounds(640, 430, 60, 60);
        jIzquierda.setBounds(520, 430, 60, 60);
        jButtonSalir.setBounds(680, 520, 100, 40);
    }
}
