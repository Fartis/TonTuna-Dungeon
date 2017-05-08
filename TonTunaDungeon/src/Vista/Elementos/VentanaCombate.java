/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorCombate;
import Controlador.ControladorGUI;
import Controlador.ControladorPrincipal;
import Modelo.Dado;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 * Clase que gestiona la ventana o panel del menu principal del juego
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaCombate extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/batalla/" + Dado.lanza(8) + ".png");
    private ControladorCombate combate;
    private JButton jButtonAtacar = new JButton("Atacar"),
            jButtonObjeto = new JButton("Objeto");
    private JLabel jLabelPJNombre = new JLabel(),
            jLabelPJVida = new JLabel(),
            jLabelPJIndice = new JLabel();
    private JLabel jLabelMONNombre = new JLabel(),
            jLabelMONVida = new JLabel(),
            jLabelMONIndice = new JLabel();
    private JFramePrincipal padre;
    private JPanel panelJugador = new JPanel();
    private JPanel panelMonstruo = new JPanel();
    private JTextArea jTextCombate = new JTextArea();

    /**
     * Metodo que gestiona las distintas opciones de la ventana principal
     */
    public VentanaCombate(ControladorCombate combate) {
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
        this.combate = combate;
        this.add(jButtonAtacar);
        this.add(jButtonObjeto);
        this.add(panelJugador);
        this.add(panelMonstruo);
        this.add(jTextCombate);
        panelJugador.add(jLabelPJNombre);
        panelJugador.add(jLabelPJVida);
        panelJugador.add(jLabelPJIndice);
        panelMonstruo.add(jLabelMONNombre);
        panelMonstruo.add(jLabelMONVida);
        panelMonstruo.add(jLabelMONIndice);

    }

    /**
     * Metodo
     *
     * @param padre
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo para el evento del boton iniciar
     *
     * @param evt
     */
    private void jButtonAtacarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        combate.accionAtaque(this);
    }

    /**
     * Metodo para el evento del boton iniciar
     *
     * @param evt
     */
    private void jButtonObjetoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Metodo establece la posicion, color, fondo y fuente de los paneles
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 400, this);
        this.setBackground(Color.BLACK);
        jButtonAtacar.setBounds(620, 420, 160, 40);
        jButtonObjeto.setBounds(620, 500, 160, 40);
        panelJugador.setBounds(520, 300, 274, 100);
        panelJugador.setBackground(new Color(0, 0, 0, 144));
        jLabelPJNombre.setBounds(10, 0, 230, 50);
        jLabelPJNombre.setForeground(new Color(144, 144, 144));
        jLabelPJNombre.setFont(new Font("Dialog", Font.BOLD, 20));
        jLabelPJVida.setBounds(10, 30, 230, 50);
        jLabelPJVida.setForeground(new Color(144, 144, 144));
        jLabelPJVida.setFont(new Font("Dialog", Font.BOLD, 14));
        jLabelPJIndice.setBounds(10, 60, 230, 50);
        jLabelPJIndice.setForeground(new Color(144, 144, 144));
        jLabelPJIndice.setFont(new Font("Dialog", Font.BOLD, 14));

        panelMonstruo.setBounds(0, 0, 274, 100);
        panelMonstruo.setBackground(new Color(0, 0, 0, 144));
        jLabelMONNombre.setBounds(10, 0, 230, 50);
        jLabelMONNombre.setForeground(new Color(144, 144, 144));
        jLabelMONNombre.setFont(new Font("Dialog", Font.BOLD, 20));
        jLabelMONVida.setBounds(10, 30, 230, 50);
        jLabelMONVida.setForeground(new Color(144, 144, 144));
        jLabelMONVida.setFont(new Font("Dialog", Font.BOLD, 14));
        jLabelMONIndice.setBounds(10, 60, 230, 50);
        jLabelMONIndice.setForeground(new Color(144, 144, 144));
        jLabelMONIndice.setFont(new Font("Dialog", Font.BOLD, 14));
        jTextCombate.setBounds(10, 420, 400, 130);
        jTextCombate.setBackground(new Color(180, 180, 180, 140));
        jTextCombate.setForeground(Color.white);
        jTextCombate.setLineWrap(true);
        jTextCombate.setWrapStyleWord(true);
        jTextCombate.setEditable(false);
        jTextCombate.setRows(16);
    }

    /**
     * Metodo establece los jLabel del nombre y caracteristicas del personaje
     * y el monstruo
     */
    public void setText(){
        jLabelPJNombre.setText(ControladorPrincipal.getSingleton().getPJNombre());
        jLabelPJVida.setText("Vida: " + combate.vidaPJActual() + " / " + combate.vidaPJTotal());
        jLabelPJIndice.setText("Armadura: " + combate.indicePJActual() + "/" + combate.indicePJTotal());
        jLabelMONNombre.setText(combate.getMonNombre());
        jLabelMONVida.setText("Vida: " + combate.vidaMONActual() + " / " + combate.vidaMONTotal());
        jLabelMONIndice.setText("Armadura: " + combate.indiceMONActual() + "/" + combate.indiceMONTotal());
        jTextCombate.setText("Un "+combate.getMonNombre()+" salvaje apareció\n");
    }
    /**
     * 
     * @param linea 
     */
    public void escribirTexto(String linea){
        if (jTextCombate.getLineCount() == 9) {
            int end = 0;
            try {
                end = jTextCombate.getLineEndOffset(0);
            } catch (BadLocationException ex) {
                Logger.getLogger(VentanaCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextCombate.replaceRange("", 0, end);
        }
        jTextCombate.append(linea + "\n");
    }
}
