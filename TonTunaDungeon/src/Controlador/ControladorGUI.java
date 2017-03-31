/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Elementos.ImagePanel;
import Vista.Elementos.ImagePanelNueva;
import Vista.JFramePrincipal;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorGUI {

    private static ControladorGUI singleton = null;
    private static JFramePrincipal menuPrin = null, nuevaPar = null;

    private ControladorGUI() {

    }

    public static ControladorGUI getSingleton() {
        if (singleton == null) {
            singleton = new ControladorGUI();
        }
        return singleton;
    }

    public void menuPrincipal() {
        if (nuevaPar!=null){
            nuevaPar.visible(false);
        }
        ImagePanel menu1 = new ImagePanel();
        if (menuPrin == null) {
            menuPrin = new JFramePrincipal(menu1, "/Recursos/logoanimado.gif");
        } else {
            menuPrin.createAndShowUI(menu1, "/Recursos/logoanimado.gif");
        }
        menu1.setPadre(menuPrin);
    }

    public void menuNuevaPartida() {
        menuPrin.visible(false);
        ImagePanelNueva menu1 = new ImagePanelNueva();
        if (nuevaPar == null) {
            nuevaPar = new JFramePrincipal(menu1, "/Recursos/nuevapartida.gif");
        } else {
            nuevaPar.createAndShowUI(menu1, "/Recursos/logoanimado.gif");
        }
        menu1.setPadre(nuevaPar);
    }

}
