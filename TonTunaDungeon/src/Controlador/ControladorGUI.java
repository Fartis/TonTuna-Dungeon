/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ReproductorMusica;
import Vista.Elementos.VentanaLogo;
import Vista.Elementos.VentanaMazmorra;
import Vista.Elementos.VentanaMensajeNuevaPartida;
import Vista.Elementos.VentanaNuevaPartida;
import Vista.JFramePrincipal;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorGUI {

    private static ControladorGUI singleton = null;
    private static JFramePrincipal
            menuPrin = null,
            nuevaPar = null,
            mensajeInicio = null,
            ventanaMazmorra = null;

    private ControladorGUI() {

    }

    public static ControladorGUI getSingleton() {
        if (singleton == null) {
            singleton = new ControladorGUI();
        }
        return singleton;
    }

    public void menuPrincipal() {
        ocultar();
        ReproductorMusica.getSingleton().stop();
        ReproductorMusica.getSingleton().play("src/Recursos/Stormlord - Title (Unused).mp3");
        if (nuevaPar != null) {
            nuevaPar.visible(false);
        }
        VentanaLogo menu1 = new VentanaLogo();
        if (menuPrin == null) {
            menuPrin = new JFramePrincipal(menu1, "/Recursos/logoanimado.gif");
        } else {
            menuPrin.createAndShowUI(menu1, "/Recursos/logoanimado.gif");
        }
        menu1.setPadre(menuPrin);
    }

    public void menuNuevaPartida() {
        ocultar();
        ReproductorMusica.getSingleton().stop();
        ReproductorMusica.getSingleton().play("src/Recursos/Soul Blazer - Intro Theme.mp3");
        VentanaNuevaPartida menu1 = new VentanaNuevaPartida();
        if (nuevaPar == null) {
            nuevaPar = new JFramePrincipal(menu1, "/Recursos/nuevapartida.gif");
        } else {
            nuevaPar.createAndShowUI(menu1, "/Recursos/logoanimado.gif");
        }
        menu1.setPadre(nuevaPar);
    }

    public void menuMensajeNuevaPartida() {
        ocultar();
        VentanaMensajeNuevaPartida menuMensaje = new VentanaMensajeNuevaPartida();
        if (mensajeInicio == null) {
            mensajeInicio = new JFramePrincipal(menuMensaje);
        } else {
            mensajeInicio.createAndShowUI(menuMensaje);
        }
        menuMensaje.setPadre(mensajeInicio);
    }
    
    public void ventanaMazmorra() {
        ocultar();
        VentanaMazmorra menuJuego = new VentanaMazmorra();
        if (ventanaMazmorra == null) {
            ventanaMazmorra = new JFramePrincipal(menuJuego);
        } else {
            ventanaMazmorra.createAndShowUI(menuJuego);
        }
        menuJuego.setPadre(ventanaMazmorra);
        
    }

    private void ocultar() {
        if (nuevaPar != null) {
            nuevaPar.visible(false);
        }
        if (menuPrin != null) {
            menuPrin.visible(false);
        }
        if (mensajeInicio != null) {
            mensajeInicio.visible(false);
        }
        if (ventanaMazmorra != null) {
            ventanaMazmorra.visible(false);
        }
    }
}
