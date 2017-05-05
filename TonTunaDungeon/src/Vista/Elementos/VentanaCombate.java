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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que gestiona la ventana o panel del menu principal del juego
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaCombate extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/batalla/" + Dado.lanza(8) + ".png");
    private ControladorCombate combate = new ControladorCombate();
    private JButton jButtonAtacar = new JButton("Atacar"),
            jButtonObjeto = new JButton("Objeto");
    private JLabel jLabelPJNombre = new JLabel(ControladorPrincipal.getSingleton().getPJNombre()),
            jLabelPJVida = new JLabel("Vida: " + ControladorPrincipal.getSingleton().getPJVidaActual() + " / " + ControladorPrincipal.getSingleton().getPJVidaTotal()),
            jLabelPJIndice = new JLabel("Armadura: " + ControladorPrincipal.getSingleton().getPJInArmAc() + "/" + ControladorPrincipal.getSingleton().getPJInArm());
    private JFramePrincipal padre;

    /**
     * Metodo que gestiona las distintas opciones de la ventana principal
     */
    public VentanaCombate() {
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
        this.add(jButtonAtacar);
        this.add(jButtonObjeto);

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
        ControladorGUI.getSingleton().ventanaMazmorra();
        ControladorGUI.getSingleton().finalizarCombate();
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
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 400, this);
        this.setBackground(Color.BLACK);
        jButtonAtacar.setBounds(620, 420, 160, 40);
        jButtonObjeto.setBounds(620, 500, 160, 40);
    }
}
