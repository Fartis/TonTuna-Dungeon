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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 * Clase que genera la ventana de mazmorra en el JFramePrincipal
 *
 * @author Manuel David Villalba Escamilla
 */
public class VentanaMazmorra extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/dungeon.gif");
    private JFramePrincipal padre;
    private JTextArea jTextoAventura = new JTextArea();
    private JLabel jLabelMapa = new JLabel("Mapa"),
            jLabelNombre = new JLabel(ControladorPrincipal.getSingleton().getPJNombre()),
            jLabelVida = new JLabel("Vida: " + ControladorPrincipal.getSingleton().getPJVidaActual() + " / " + ControladorPrincipal.getSingleton().getPJVidaTotal());
    private JButton jArriba = new JButton("↑"),
            jAbajo = new JButton("↓"),
            jDerecha = new JButton("→"),
            jIzquierda = new JButton("←"),
            jButtonSalir = new JButton("Salir"),
            jButtonGuardar = new JButton("Guardar"),
            jButtonSiguiente = new JButton("Bajar"),
            jButtonEquipo = new JButton("Equipo"),
            jButtonMochila = new JButton("Mochila");
    private JPanel panelGuardar = new JPanel();
    private JPanel panelSiguiente = new JPanel();
    private FormatoMapa jMapa = new FormatoMapa();

    //JLabel para mapa.
    /**
     * Genera los JLabel de los botones, texto, mapa...etc
     */
    public VentanaMazmorra() {
        this.add(jTextoAventura);
        this.add(jArriba);
        this.add(jAbajo);
        this.add(jDerecha);
        this.add(jIzquierda);
        this.add(jLabelMapa);
        this.add(jMapa);
        this.add(jButtonSalir);
        this.add(panelGuardar);
        this.add(panelSiguiente);
        panelGuardar.add(jButtonGuardar);
        panelGuardar.setVisible(false);
        panelSiguiente.add(jButtonSiguiente);
        panelSiguiente.setVisible(false);
        this.add(jButtonEquipo);
        this.add(jButtonMochila);
        this.add(jLabelNombre);
        this.add(jLabelVida);
        ControladorMazmorra.getSingleton().generarPiso();
        jMapa.pintarMapa();

        escribirTexto(ControladorPrincipal.getSingleton().getPJNombre()
                + " acabas de adentrarte en la mazmorra en busca de tesoros, adelante.");

        escribirTexto(ControladorMazmorra.getSingleton().descripcionHabitacion());

        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jArribaActionPerformed(evt);
            }
        });
        jAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbajoActionPerformed(evt);
            }
        });
        jDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDerechaActionPerformed(evt);
            }
        });
        jIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIzquierdaActionPerformed(evt);
            }
        });
        jButtonEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEquipoActionPerformed(evt);
            }
        });
        jButtonMochila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMochilaActionPerformed(evt);
            }
        });
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
    }

    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    /**
     * Metodo introduce el texto del proceso en el juego
     *
     * @param linea
     */
    public void escribirTexto(String linea) {
        if (jTextoAventura.getLineCount() == 9) {
            int end = 0;
            try {
                end = jTextoAventura.getLineEndOffset(0);
            } catch (BadLocationException ex) {
                Logger.getLogger(VentanaMazmorra.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextoAventura.replaceRange("", 0, end);
        }
        jTextoAventura.append(linea + "\n");
    }

    /**
     * Metodo accion boton salir
     *
     * @param evt
     */
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        int salir = JOptionPane.showConfirmDialog(this, "¿Realmente deseas salir?", "¿Salir?", JOptionPane.OK_CANCEL_OPTION);
        if (salir == 0) {
            ControladorGUI.getSingleton().menuPrincipal();
            this.setVisible(false);
            padre.dispose();
        }
    }

    private void jArribaActionPerformed(java.awt.event.ActionEvent evt) {
        jMapa.pintarPosicion(ControladorMazmorra.getSingleton().moverPersonaje(0));
        ControladorMazmorra.getSingleton().getEventoHabitacion();
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 3) {
            panelGuardar.setVisible(true);
        } else {
            panelGuardar.setVisible(false);
        }
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 4) {
            panelSiguiente.setVisible(true);
        } else {
            panelSiguiente.setVisible(false);
        }
        escribirTexto(ControladorMazmorra.getSingleton().descripcionHabitacion());
    }

    private void jAbajoActionPerformed(java.awt.event.ActionEvent evt) {
        jMapa.pintarPosicion(ControladorMazmorra.getSingleton().moverPersonaje(1));
        ControladorMazmorra.getSingleton().getEventoHabitacion();
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 3) {
            panelGuardar.setVisible(true);
        } else {
            panelGuardar.setVisible(false);
        }
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 4) {
            panelSiguiente.setVisible(true);
        } else {
            panelSiguiente.setVisible(false);
        }
        escribirTexto(ControladorMazmorra.getSingleton().descripcionHabitacion());
    }

    private void jDerechaActionPerformed(java.awt.event.ActionEvent evt) {
        jMapa.pintarPosicion(ControladorMazmorra.getSingleton().moverPersonaje(2));
        ControladorMazmorra.getSingleton().getEventoHabitacion();
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 3) {
            panelGuardar.setVisible(true);
        } else {
            panelGuardar.setVisible(false);
        }
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 4) {
            panelSiguiente.setVisible(true);
        } else {
            panelSiguiente.setVisible(false);
        }
        escribirTexto(ControladorMazmorra.getSingleton().descripcionHabitacion());
    }

    private void jIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {
        jMapa.pintarPosicion(ControladorMazmorra.getSingleton().moverPersonaje(3));
        ControladorMazmorra.getSingleton().getEventoHabitacion();
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 3) {
            panelGuardar.setVisible(true);
        } else {
            panelGuardar.setVisible(false);
        }
        if (ControladorMazmorra.getSingleton().getTipoHabitacion() == 4) {
            panelSiguiente.setVisible(true);
        } else {
            panelSiguiente.setVisible(false);
        }
        escribirTexto(ControladorMazmorra.getSingleton().descripcionHabitacion());
    }

    private void jButtonEquipoActionPerformed(java.awt.event.ActionEvent evt) {
        Inventario inventario = new Inventario(padre);
    }

    private void jButtonMochilaActionPerformed(java.awt.event.ActionEvent evt) {
        Mochila mochila = new Mochila(padre);
    }
    
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorPrincipal.getSingleton().guardarPartida();
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
        jTextoAventura.setRows(16);
        jMapa.setBounds(440, 50, 340, 340);
        jArriba.setBounds(580, 400, 60, 60);
        jAbajo.setBounds(580, 460, 60, 60);
        jDerecha.setBounds(640, 430, 60, 60);
        jIzquierda.setBounds(520, 430, 60, 60);
        jButtonSalir.setBounds(680, 520, 100, 40);
        panelGuardar.setBounds(350, 460, 100, 100);
        panelGuardar.setBackground(new Color(0, 0, 0, 144));
        panelSiguiente.setBounds(350, 460, 100, 100);
        panelSiguiente.setBackground(new Color(0, 0, 0, 144));
        jButtonSiguiente.setBounds(10, 10, 80, 80);
        jButtonSiguiente.setVisible(true);
        jButtonGuardar.setBounds(10, 10, 80, 80);
        jButtonGuardar.setVisible(true);
        jButtonMochila.setBounds(20, 460, 100, 100);
        jButtonEquipo.setBounds(200, 460, 100, 100);
        jLabelMapa.setBounds(610, 20, 80, 20);
        jLabelMapa.setForeground(Color.white);
        jLabelMapa.setFont(new Font("Dialog", Font.BOLD, 15));
        jLabelNombre.setBounds(20, 320, 400, 60);
        jLabelNombre.setFont(new Font("Dialog", Font.BOLD, 40));
        jLabelNombre.setForeground(Color.white);
        jLabelVida.setBounds(20, 400, 100, 20);
        jLabelVida.setFont(new Font("Dialog", Font.BOLD, 15));
        jLabelVida.setForeground(Color.white);
    }

    private class Inventario extends JDialog {

        public Inventario(JFramePrincipal padre) {
            super(padre, true);
            this.setLayout(null);
            this.setBounds(0, 0, 400, 280);
            imagePanel panel = new imagePanel(200, 180, "src/Recursos/mochila.gif");
            panel.setBounds(0, 0, 400, 280);
            panel.setBackground(new Color(124, 124, 124, 255));
            JList arma = new JList();
            DefaultListModel modeloArmas = new DefaultListModel();
            String[] listaArmas = ControladorPrincipal.getSingleton().getInvArmas();
            for (int i = 0; i < listaArmas.length; i++) {
                modeloArmas.add(i, listaArmas[i]);
            }
            arma.setBounds(200, 50, 180, 100);
            arma.setModel(modeloArmas);
            panel.add(arma);
            arma.setVisible(true);
            JList armaduras = new JList();
            DefaultListModel modeloArmaduras = new DefaultListModel();
            String[] listaArmaduras = ControladorPrincipal.getSingleton().getInvArmaduras();
            for (int i = 0; i < listaArmaduras.length; i++) {
                modeloArmaduras.add(i, listaArmaduras[i]);
            }
            armaduras.setBounds(200, 210, 180, 100);
            armaduras.setModel(modeloArmaduras);
            panel.add(armaduras);
            armaduras.setVisible(true);

            JLabel armaActual = new JLabel(ControladorPrincipal.getSingleton().getPJArma());
            JLabel armaduraActual = new JLabel(ControladorPrincipal.getSingleton().getPJArmadura());
            armaActual.setFont(new Font("Dialog", Font.BOLD, 12));
            armaduraActual.setFont(new Font("Dialog", Font.BOLD, 12));
            armaActual.setForeground(Color.white);
            armaduraActual.setForeground(Color.white);
            armaActual.setBounds(20, 20, 400, 20);
            armaduraActual.setBounds(20, 20, 400, 180);
            panel.add(armaActual);
            panel.add(armaduraActual);

            this.add(panel);
            panel.setVisible(true);
            setVisible(true);
        }
    }

    private class Mochila extends JDialog {

        public Mochila(JFramePrincipal padre) {
            super(padre, true);
            this.setLayout(null);
            this.setBounds(0, 0, 400, 280);
            imagePanel panel = new imagePanel(200, 180, "src/Recursos/mochila.gif");
            panel.setBounds(0, 0, 400, 280);
            panel.setBackground(new Color(124, 124, 124, 255));
            JList lista = new JList();
            DefaultListModel modelo = new DefaultListModel();
            String[] listaObjetos = ControladorPrincipal.getSingleton().getInventario();
            for (int i = 0; i < listaObjetos.length; i++) {
                modelo.add(i, listaObjetos[i]);
            }
            lista.setBounds(200, 20, 180, 240);
            lista.setModel(modelo);
            panel.add(lista);
            lista.setVisible(true);
            this.add(panel);
            panel.setVisible(true);
            setVisible(true);
        }
    }

    private class Guardar extends JDialog {

        public Guardar(JFramePrincipal padre) {
            super(padre, true);
            this.setLayout(null);
            this.setBounds(0, 0, 400, 280);
            imagePanel panel = new imagePanel(200, 180, "src/Recursos/mochila.gif");
            panel.setBounds(0, 0, 400, 280);
            panel.setBackground(new Color(124, 124, 124, 255));
            JList lista = new JList();
            DefaultListModel modelo = new DefaultListModel();
            String[] listaObjetos = ControladorPrincipal.getSingleton().getInventario();
            for (int i = 0; i < listaObjetos.length; i++) {
                modelo.add(i, listaObjetos[i]);
            }
            lista.setBounds(200, 20, 180, 240);
            lista.setModel(modelo);
            panel.add(lista);
            lista.setVisible(true);
            this.add(panel);
            panel.setVisible(true);
            setVisible(true);
        }
    }

}
