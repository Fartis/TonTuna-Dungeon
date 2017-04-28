/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ReproductorMusica;
import Vista.Elementos.VentanaCombate;
import Vista.Elementos.VentanaLogo;
import Vista.Elementos.VentanaMazmorra;
import Vista.Elementos.VentanaMensajeNuevaPartida;
import Vista.Elementos.VentanaNuevaPartida;
import Vista.JFramePrincipal;

/**
 * Clase para gestionar el controlador de la interfaz
 * @author Manuel David Villalba Escamilla
 */
public class ControladorGUI {

    private static ControladorGUI singleton = null;
    private static JFramePrincipal
            menuPrin = null,
            nuevaPar = null,
            mensajeInicio = null,
            ventanaMazmorra = null,
            ventanaCombate = null;
    
    

    /**
     * Constructor por defecto de la interfaz grafica
     */
    private ControladorGUI() {

    }

    /**
     * Metodo singleton para el controlador de la interfaz
     * @return 
     */
    public static ControladorGUI getSingleton() {
        if (singleton == null) {
            singleton = new ControladorGUI();
        }
        return singleton;
    }

    /**
     * Metodo para gestionar el menu principal y la musica
     */
    public void menuPrincipal() {
        ControladorPrincipal.getSingleton().reiniciarJuego();
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        reproducirMusica("src/Recursos/Stormlord - Title (Unused).mp3", musica);
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

    /**
     * Metodo para gestionar el menu de nueva partida y la musica
     */
    public void menuNuevaPartida() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        reproducirMusica("src/Recursos/Soul Blazer - Intro Theme.mp3", musica);
        VentanaNuevaPartida menu1 = new VentanaNuevaPartida();
        if (nuevaPar == null) {
            nuevaPar = new JFramePrincipal(menu1, "/Recursos/nuevapartida.gif");
        } else {
            nuevaPar.createAndShowUI(menu1, "/Recursos/logoanimado.gif");
        }
        menu1.setPadre(nuevaPar);
    }

    /**
     * Metodo para reproducir musica
     * @param url
     * @param activado 
     */
    private void reproducirMusica(String url, boolean activado) {
        ReproductorMusica.getSingleton().stop();
        if(activado){
            ReproductorMusica.getSingleton().play(url);
        }
    }
    /**
     * Metodo para detener la musica
     */
    public void stopMusica(){
        ReproductorMusica.getSingleton().stop();
    }

    /**
     * Metodo para mostrar mensaje de la nueva partida
     */
    public void menuMensajeNuevaPartida() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        VentanaMensajeNuevaPartida menuMensaje = new VentanaMensajeNuevaPartida();
        if (mensajeInicio == null) {
            mensajeInicio = new JFramePrincipal(menuMensaje);
        } else {
            mensajeInicio.createAndShowUI(menuMensaje);
        }
        menuMensaje.setPadre(mensajeInicio);
    }
    /**
     * Metodo para gestionar la ventana de mazmorra
     */
    public void ventanaMazmorra() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        VentanaMazmorra menuJuego = new VentanaMazmorra();
        if (ventanaMazmorra == null) {
            ventanaMazmorra = new JFramePrincipal(menuJuego);
        } else {
            ventanaMazmorra.createAndShowUI(menuJuego);
        }
        menuJuego.setPadre(ventanaMazmorra);        
    }
    
    /**
     * Metodo para gestrionar la ventana de combate
     */
    public void iniciarCombate() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        VentanaCombate combate = new VentanaCombate();
        if(ventanaCombate == null){
            ventanaCombate = new JFramePrincipal(combate);
        }else{
            ventanaCombate.createAndShowUI(combate);
        }
        combate.setPadre(ventanaCombate);
    }

    /**
     * Metodo para comprobar ventanas ocultas y mostradas
     */
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
