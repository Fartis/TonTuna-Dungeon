/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorGUI;
import Controlador.ControladorMazmorra;
import Controlador.ControladorPrincipal;
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
 * Clase que gestiona la ventana o panel del menu principal del juego
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public class VentanaSubirNivel extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/subirNivel.png");
    JButton jButtonFuerza = new JButton("Fuerza");
    JButton jButtonDestreza = new JButton("Destreza");
    JButton jButtonIntelecto = new JButton("Intelecto");
    JButton jButtonConstitucion = new JButton("Constitucion");
    ImagenPanel fuerza = new ImagenPanel(140, 140, "src/Recursos/atrib/fuerza.png"),
            destreza = new ImagenPanel(140, 140, "src/Recursos/atrib/destreza.png"),
            intelecto = new ImagenPanel(140, 140, "src/Recursos/atrib/intelecto.png"),
            constitucion = new ImagenPanel(140, 140, "src/Recursos/atrib/constitucion.png");
    JFramePrincipal padre;

    JTextArea mensaje = new JTextArea("\"Sr." + ControladorPrincipal.getSingleton().getPJNombre() + " habéis encontrado una escalera, pero, parece que os aguardan más peligros allí abajo, mejor que descanséis.\"\n - dijo el trovador mientras notabas que tus habilidades habían mejorado. ¿Cúal de ellas ha mejorado?");

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

        this.add(fuerza);
        this.add(destreza);
        this.add(intelecto);
        this.add(constitucion);
        this.add(mensaje);
        fuerza.add(jButtonFuerza);
        destreza.add(jButtonDestreza);
        intelecto.add(jButtonIntelecto);
        constitucion.add(jButtonConstitucion);

    }

    /**
     * Metodo que establece el JFramePrincipal que contiene a VentanaSubirNivel
     *
     * @param padre JFramePrincipal contenedor
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo para el evento del boton iniciar
     *
     * @param evt
     */
    private void jButtonFuerzaActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorPrincipal.getSingleton().subirNivelPJ(1);
        ControladorMazmorra.getSingleton().reiniciarPosicion();
        ControladorGUI.getSingleton().ventanaMazmorra();
    }

    /**
     * Metodo para el evento del boton cargar
     *
     * @param evt
     */
    private void jButtonDestrezaActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorPrincipal.getSingleton().subirNivelPJ(2);
        ControladorMazmorra.getSingleton().reiniciarPosicion();
        ControladorGUI.getSingleton().ventanaMazmorra();
    }

    /**
     * Metodo para el evento del boton cargar
     *
     * @param evt
     */
    private void jButtonIntelectoActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorPrincipal.getSingleton().subirNivelPJ(3);
        ControladorMazmorra.getSingleton().reiniciarPosicion();
        ControladorGUI.getSingleton().ventanaMazmorra();
    }

    /**
     * Metodo para el evento del boton cargar
     *
     * @param evt
     */
    private void jButtonConstitucionActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorPrincipal.getSingleton().subirNivelPJ(4);
        ControladorMazmorra.getSingleton().reiniciarPosicion();
        ControladorGUI.getSingleton().ventanaMazmorra();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonFuerza.setBounds(0, 0, 140, 140);
        jButtonDestreza.setBounds(0, 0, 140, 140);
        jButtonIntelecto.setBounds(0, 0, 140, 140);
        jButtonConstitucion.setBounds(0, 0, 140, 140);
        fuerza.setBackground(new Color(255, 255, 255, 100));
        destreza.setBackground(new Color(255, 255, 255, 100));
        intelecto.setBackground(new Color(255, 255, 255, 100));
        constitucion.setBackground(new Color(255, 255, 255, 100));
        jButtonFuerza.setOpaque(false);
        jButtonDestreza.setOpaque(false);
        jButtonIntelecto.setOpaque(false);
        jButtonConstitucion.setOpaque(false);
        jButtonFuerza.setFont(new Font("Dialog", Font.BOLD, 18));
        jButtonDestreza.setFont(new Font("Dialog", Font.BOLD, 18));
        jButtonIntelecto.setFont(new Font("Dialog", Font.BOLD, 18));
        jButtonConstitucion.setFont(new Font("Dialog", Font.BOLD, 18));
        jButtonFuerza.setBackground(new Color(0, 0, 0, 0));
        jButtonDestreza.setBackground(new Color(0, 0, 0, 0));
        jButtonIntelecto.setBackground(new Color(0, 0, 0, 0));
        jButtonConstitucion.setBackground(new Color(0, 0, 0, 0));
        fuerza.setBounds(48, 405, 140, 140);
        destreza.setBounds(236, 405, 140, 140);
        intelecto.setBounds(424, 405, 140, 140);
        constitucion.setBounds(612, 405, 140, 140);
        mensaje.setEditable(false);
        mensaje.setLineWrap(true);
        mensaje.setWrapStyleWord(true);
        mensaje.setHighlighter(null);
        mensaje.setOpaque(false);
        mensaje.setBounds(20, 20, 760, 400);
        mensaje.setForeground(Color.white);
        mensaje.setFont(new Font("Dialog", Font.BOLD, 30));
    }
}
