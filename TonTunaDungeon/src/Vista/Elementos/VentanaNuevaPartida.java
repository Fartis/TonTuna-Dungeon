/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Elementos;

import Controlador.ControladorCreadorPJ;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaNuevaPartida extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/nuevapartida.gif");
    private JFramePrincipal padre;
    private String[][] infoPJ = ControladorPrincipal.getSingleton().infoPersonajeNuevo();

    //Botones
    private JButton jButtonAtras = new JButton("Atras");
    private JButton jButtonIniciar = new JButton("Iniciar partida");
    private JButton jButtonHumano = new JButton("Humano");
    private JButton jButtonElfo = new JButton("Elfo");
    private JButton jButtonEnano = new JButton("Enano");
    private JButton jButtonMediano = new JButton("Mediano");

    //Paneles
    private JPanel jPanelHumano = new JPanel();
    private JPanel jPanelElfo = new JPanel();
    private JPanel jPanelEnano = new JPanel();
    private JPanel jPanelMediano = new JPanel();
    private JPanel seleccionPersonaje = new JPanel();

    //Paneles con imagenes
    private imagePanel imageHumano = new imagePanel(140, 210, "src/Recursos/razas/humano.jpg");
    private imagePanel imageElfo = new imagePanel(140, 210, "src/Recursos/razas/elfo.jpg");
    private imagePanel imageEnano = new imagePanel(140, 210, "src/Recursos/razas/enano.jpg");
    private imagePanel imageMediano = new imagePanel(140, 210, "src/Recursos/razas/mediano.jpg");

    private imagePanel imageFuerza = new imagePanel(40, 40, "src/Recursos/atrib/fuerza.png");
    private imagePanel imageDestreza = new imagePanel(40, 40, "src/Recursos/atrib/destreza.png");
    private imagePanel imageIntelecto = new imagePanel(40, 40, "src/Recursos/atrib/intelecto.png");
    private imagePanel imageConstitucion = new imagePanel(40, 40, "src/Recursos/atrib/constitucion.png");

    //Etiquetas
    private JLabel labelFuerza = new JLabel("Fuerza");
    private JLabel labelDestreza = new JLabel("Destreza");
    private JLabel labelIntelecto = new JLabel("Intelecto");
    private JLabel labelConstitucion = new JLabel("Constitucion");

    private JLabel labelHumano = new JLabel("HUMANO");
    private JTextArea descHumano = new JTextArea(infoPJ[2][5]);
    private JLabel labelElfo = new JLabel("ELFO");
    private JTextArea descElfo = new JTextArea(infoPJ[0][5]);
    private JLabel labelEnano = new JLabel("ENANO");
    private JTextArea descEnano = new JTextArea(infoPJ[1][5]);
    private JLabel labelMediano = new JLabel("MEDIANO");
    private JTextArea descMediano = new JTextArea(infoPJ[3][5]);

    public VentanaNuevaPartida() {
        iniciarEventos();

        añadirElementosPaneles();
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }

    private void jButtonHumanoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jPanelHumano.isVisible()) {
            jPanelElfo.setVisible(false);
            jPanelEnano.setVisible(false);
            jPanelMediano.setVisible(false);
            jPanelHumano.setVisible(true);
            jPanelHumano.add(imageFuerza);
            jPanelHumano.add(imageDestreza);
            jPanelHumano.add(imageIntelecto);
            jPanelHumano.add(imageConstitucion);
            jPanelHumano.add(labelFuerza);
            jPanelHumano.add(labelDestreza);
            jPanelHumano.add(labelIntelecto);
            jPanelHumano.add(labelConstitucion);
        }
        ControladorCreadorPJ.getSingleton().setRaza(1);
    }

    private void jButtonElfoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jPanelElfo.isVisible()) {
            jPanelElfo.setVisible(true);
            jPanelEnano.setVisible(false);
            jPanelMediano.setVisible(false);
            jPanelHumano.setVisible(false);
            jPanelElfo.add(imageFuerza);
            jPanelElfo.add(imageDestreza);
            jPanelElfo.add(imageIntelecto);
            jPanelElfo.add(imageConstitucion);
            jPanelElfo.add(labelFuerza);
            jPanelElfo.add(labelDestreza);
            jPanelElfo.add(labelIntelecto);
            jPanelElfo.add(labelConstitucion);
        }
        ControladorCreadorPJ.getSingleton().setRaza(2);
    }

    private void jButtonEnanoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jPanelEnano.isVisible()) {
            jPanelElfo.setVisible(false);
            jPanelEnano.setVisible(true);
            jPanelMediano.setVisible(false);
            jPanelHumano.setVisible(false);
            jPanelEnano.add(imageFuerza);
            jPanelEnano.add(imageDestreza);
            jPanelEnano.add(imageIntelecto);
            jPanelEnano.add(imageConstitucion);
            jPanelEnano.add(labelFuerza);
            jPanelEnano.add(labelDestreza);
            jPanelEnano.add(labelIntelecto);
            jPanelEnano.add(labelConstitucion);
        }
        ControladorCreadorPJ.getSingleton().setRaza(3);
    }

    private void jButtonMedianoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jPanelMediano.isVisible()) {
            jPanelElfo.setVisible(false);
            jPanelEnano.setVisible(false);
            jPanelMediano.setVisible(true);
            jPanelHumano.setVisible(false);
            jPanelMediano.add(imageFuerza);
            jPanelMediano.add(imageDestreza);
            jPanelMediano.add(imageIntelecto);
            jPanelMediano.add(imageConstitucion);
            jPanelMediano.add(labelFuerza);
            jPanelMediano.add(labelDestreza);
            jPanelMediano.add(labelIntelecto);
            jPanelMediano.add(labelConstitucion);
        }
        ControladorCreadorPJ.getSingleton().setRaza(4);
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }


    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, 800, 600, this);
        //Botones
        jButtonAtras.setBounds(180, 508, 200, 40);
        jButtonIniciar.setBounds(580, 508, 200, 40);
        jButtonHumano.setBounds(20, 20, 100, 107);
        jButtonElfo.setBounds(20, 147, 100, 107);
        jButtonEnano.setBounds(20, 274, 100, 107);
        jButtonMediano.setBounds(20, 401, 100, 107);
        //Paneles
        seleccionPersonaje.setBounds(20, 20, 140, 530);
        jPanelHumano.setBounds(180, 20, 600, 460);
        jPanelElfo.setBounds(180, 20, 600, 460);
        jPanelEnano.setBounds(180, 20, 600, 460);
        jPanelMediano.setBounds(180, 20, 600, 460);
        //Estableciendo transparencias de los paneles
        seleccionPersonaje.setBackground(new Color(0, 0, 0, 125));
        jPanelHumano.setBackground(new Color(0, 0, 0, 125));
        jPanelElfo.setBackground(new Color(0, 0, 0, 125));
        jPanelEnano.setBackground(new Color(0, 0, 0, 125));
        jPanelMediano.setBackground(new Color(0, 0, 0, 125));

        //Estableciendo elementos de los paneles internos de razas
        imageHumano.setBounds(440, 20, 140, 210);
        labelHumano.setBounds(20, 20, 280, 50);
        descHumano.setBounds(20, 90, 400, 210);
        descHumano.setOpaque(false);
        descHumano.setEditable(false);
        imageElfo.setBounds(440, 20, 140, 210);
        labelElfo.setBounds(20, 20, 280, 50);
        descElfo.setBounds(20, 90, 400, 210);
        descElfo.setOpaque(false);
        descElfo.setEditable(false);
        imageEnano.setBounds(440, 20, 140, 210);
        labelEnano.setBounds(20, 20, 280, 50);
        descEnano.setBounds(20, 90, 400, 210);
        descEnano.setOpaque(false);
        descEnano.setEditable(false);
        imageMediano.setBounds(440, 20, 140, 210);
        labelMediano.setBounds(20, 20, 280, 50);
        descMediano.setBounds(20, 90, 400, 210);
        descMediano.setOpaque(false);
        descMediano.setEditable(false);

        imageFuerza.setBounds(20, 280, 40, 40);
        imageFuerza.setOpaque(false);
        imageDestreza.setBounds(240, 280, 40, 40);
        imageDestreza.setOpaque(false);
        imageIntelecto.setBounds(20, 380, 40, 40);
        imageIntelecto.setOpaque(false);
        imageConstitucion.setBounds(240, 380, 40, 40);
        imageConstitucion.setOpaque(false);

        labelFuerza.setFont(new Font("Dialog", Font.BOLD, 15));
        labelFuerza.setForeground(Color.white);
        labelFuerza.setBounds(70, 220, 100, 80);
        labelDestreza.setFont(new Font("Dialog", Font.BOLD, 15));
        labelDestreza.setForeground(Color.white);
        labelDestreza.setBounds(310, 220, 100, 80);
        labelIntelecto.setFont(new Font("Dialog", Font.BOLD, 15));
        labelIntelecto.setForeground(Color.white);
        labelIntelecto.setBounds(70, 320, 100, 80);
        labelConstitucion.setFont(new Font("Dialog", Font.BOLD, 15));
        labelConstitucion.setForeground(Color.white);
        labelConstitucion.setBounds(310, 320, 100, 80);
        
        
    }

    private void iniciarEventos() {

        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        jButtonHumano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHumanoActionPerformed(evt);
            }
        });
        jButtonElfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElfoActionPerformed(evt);
            }
        });
        jButtonEnano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnanoActionPerformed(evt);
            }
        });
        jButtonMediano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedianoActionPerformed(evt);
            }
        });
    }

    private void añadirElementosPaneles() {
        this.add(jButtonAtras);
        this.add(jButtonIniciar);
        this.add(seleccionPersonaje);
        this.add(jPanelHumano);
        this.add(jPanelElfo);
        this.add(jPanelEnano);
        this.add(jPanelMediano);
        jPanelElfo.setVisible(false);
        jPanelEnano.setVisible(false);
        jPanelMediano.setVisible(false);
        seleccionPersonaje.add(jButtonHumano);
        seleccionPersonaje.add(jButtonElfo);
        seleccionPersonaje.add(jButtonEnano);
        seleccionPersonaje.add(jButtonMediano);

        //Elementos panel Humano
        jPanelHumano.add(imageHumano);
        jPanelHumano.add(labelHumano);
        jPanelHumano.add(descHumano);
        jPanelHumano.add(imageFuerza);
        jPanelHumano.add(imageDestreza);
        jPanelHumano.add(imageIntelecto);
        jPanelHumano.add(imageConstitucion);
        jPanelHumano.add(labelFuerza);
        jPanelHumano.add(labelDestreza);
        jPanelHumano.add(labelIntelecto);
        jPanelHumano.add(labelConstitucion);
        descHumano.setFont(new Font("Dialog", Font.BOLD, 15));
        descHumano.setForeground(Color.white);
        descHumano.setLineWrap(true);
        descHumano.setWrapStyleWord(true);
        descHumano.setHighlighter(null);
        labelHumano.setFont(new Font("Dialog", Font.BOLD, 38));
        labelHumano.setForeground(Color.white);
        imageHumano.setVisible(true);
        //Elementos panel Elfo
        jPanelElfo.add(imageElfo);
        jPanelElfo.add(labelElfo);
        jPanelElfo.add(descElfo);
        descElfo.setFont(new Font("Dialog", Font.BOLD, 15));
        descElfo.setForeground(Color.white);
        descElfo.setLineWrap(true);
        descElfo.setWrapStyleWord(true);
        descElfo.setHighlighter(null);
        labelElfo.setFont(new Font("Dialog", Font.BOLD, 38));
        labelElfo.setForeground(Color.white);
        imageElfo.setVisible(true);
        //Elementos panel Enano
        jPanelEnano.add(imageEnano);
        jPanelEnano.add(labelEnano);
        jPanelEnano.add(descEnano);
        descEnano.setFont(new Font("Dialog", Font.BOLD, 15));
        descEnano.setForeground(Color.white);
        descEnano.setLineWrap(true);
        descEnano.setWrapStyleWord(true);
        descEnano.setHighlighter(null);
        labelEnano.setFont(new Font("Dialog", Font.BOLD, 38));
        labelEnano.setForeground(Color.white);
        imageEnano.setVisible(true);
        //Elementos panel Mediano
        jPanelMediano.add(imageMediano);
        jPanelMediano.add(labelMediano);
        jPanelMediano.add(descMediano);
        descMediano.setFont(new Font("Dialog", Font.BOLD, 15));
        descMediano.setForeground(Color.white);
        descMediano.setLineWrap(true);
        descMediano.setWrapStyleWord(true);
        descMediano.setHighlighter(null);
        labelMediano.setFont(new Font("Dialog", Font.BOLD, 38));
        labelMediano.setForeground(Color.white);
        imageMediano.setVisible(true);

    }
}
