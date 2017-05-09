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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SeñorPelos
 */
public class VentanaCargar extends JPanel {

    private Image image = Toolkit.getDefaultToolkit().getImage("src/Recursos/cargar.gif");
    private JButton jButtonAtras = new JButton("Atrás");
    private JButton jButtonCargar = new JButton("Cargar");
    private JButton jButtonBorrar = new JButton("Borrar");
    private DefaultTableModel modelo = ControladorPrincipal.getSingleton().obtenerInfoPartidas();
    private JLabel titulo = new JLabel("Partidas guardadas."),
            nombre = new JLabel("Nombre"),
            raza = new JLabel("Raza"),
            nivel = new JLabel("Nivel"),
            fecha = new JLabel("Fecha de creación");
    private JTable jTabla = new JTable();
    private JFramePrincipal padre;

    /**
     * Metodo que gestiona las distintas opciones de la ventana de carga
     */
    public VentanaCargar() {
        jButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarActionPerformed(evt);
            }
        });
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        this.add(jButtonCargar);
        this.add(jButtonBorrar);
        this.add(jButtonAtras);
        this.add(jTabla);
        this.add(titulo);
        this.add(nombre);
        this.add(raza);
        this.add(nivel);
        this.add(fecha);
        modelo.setColumnCount(4);
        jTabla.setModel(modelo);
        jTabla.getColumn("Nombre").setPreferredWidth(300);
        jTabla.getColumn("Raza").setPreferredWidth(100);
        jTabla.getColumn("Nivel").setPreferredWidth(50);
        jTabla.getColumn("Fecha de creación").setPreferredWidth(291);
    }

    /**
     * Metodo
     *
     * @param padre
     */
    public void setPadre(JFramePrincipal padre) {
        this.padre = padre;
    }

    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:     
        ControladorPrincipal.getSingleton().cargarPartida(jTabla.getSelectedRow());
    }

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:        
    }

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ControladorGUI.getSingleton().menuPrincipal();
        this.setVisible(false);
        padre.dispose();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 800, 600, this);
        jButtonCargar.setBounds(50, 500, 200, 40);
        jButtonBorrar.setBounds(300, 500, 200, 40);
        jButtonAtras.setBounds(550, 500, 200, 40);
        jTabla.setBounds(20, 100, 740, 350);
        jTabla.setBackground(new Color(0, 0, 0, 144));
        jTabla.setAutoCreateColumnsFromModel(true);
        jTabla.setForeground(Color.white);
        titulo.setBounds(250, 20, 300, 50);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Dialog", Font.BOLD, 30));

        nombre.setBounds(20, 80, 300, 20);
        nombre.setForeground(Color.white);
        nombre.setFont(new Font("Dialog", Font.BOLD, 12));

        raza.setBounds(320, 80, 300, 20);
        raza.setForeground(Color.white);
        raza.setFont(new Font("Dialog", Font.BOLD, 12));

        nivel.setBounds(420, 80, 300, 20);
        nivel.setForeground(Color.white);
        nivel.setFont(new Font("Dialog", Font.BOLD, 12));

        fecha.setBounds(470, 80, 300, 20);
        fecha.setForeground(Color.white);
        fecha.setFont(new Font("Dialog", Font.BOLD, 12));
    }

}
