/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ReproductorMusica;
import Vista.Elementos.VentanaCargar;
import Vista.Elementos.VentanaCombate;
import Vista.Elementos.VentanaLogo;
import Vista.Elementos.VentanaMazmorra;
import Vista.Elementos.VentanaFinalPartida;
import Vista.Elementos.VentanaMensajeNuevaPartida;
import Vista.Elementos.VentanaNuevaPartida;
import Vista.Elementos.VentanaSubirNivel;
import Vista.JFramePrincipal;
import javax.swing.JFrame;

/**
 * Clase para gestionar el controlador de la interfaz
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Gonzalez Rodriguez
 */
public class ControladorGUI {

    private static ControladorGUI singleton = null;
    private static JFramePrincipal menuPrin = null,
            nuevaPar = null,
            cargarPar = null,
            mensajeInicio = null,
            ventanaMazmorra = null,
            ventanaCombate = null,
            ventanaSubirNivel = null,
            mensajeFin = null;

    /**
     * Constructor por defecto del controlador de la interfaz gráfica
     */
    private ControladorGUI() {

    }

    /**
     * Metodo singleton para el controlador de la interfaz
     *
     * @return instancia de la clase ControladorGUI
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
        ReproductorMusica.getSingleton().pararMusica();
        reproducirMusica("src/Recursos/intro.mp3", musica);
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
        ReproductorMusica.getSingleton().pararMusica();
        reproducirMusica("src/Recursos/seleccionPersonaje.mp3", musica);
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
     *
     * @param url String directorio del archivo de música.
     * @param activado Boolean, true = musica activada, false = musica
     * desactivada.
     */
    public void reproducirMusica(String url, boolean activado) {
        ReproductorMusica.getSingleton().pararMusica();
        if (activado) {
            ReproductorMusica.getSingleton().playMusica(url);
        }
    }

    /**
     * Metodo para detener la musica.
     */
    public void stopMusica() {
        ReproductorMusica.getSingleton().pararMusica();
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
     * Metodo para gestionar la ventana de mazmorra y la música
     */
    public void ventanaMazmorra() {
        ControladorMazmorra.getSingleton().generarPiso();
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        ReproductorMusica.getSingleton().pararMusica();
        reproducirMusica("src/Recursos/mazmorra.mp3", musica);
        VentanaMazmorra menuJuego = new VentanaMazmorra();
        if (ventanaMazmorra == null) {
            ventanaMazmorra = new JFramePrincipal(menuJuego);
        } else {
            ventanaMazmorra.createAndShowUI(menuJuego);
        }
        menuJuego.setPadre(ventanaMazmorra);
    }

    /**
     * Metodo para gestrionar la ventana de combate y la música
     */
    public void iniciarCombate() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        ReproductorMusica.getSingleton().pararMusica();
        reproducirMusica("src/Recursos/combate.mp3", musica);
        VentanaCombate combate = new VentanaCombate(new ControladorCombate());
        if (ventanaCombate == null) {
            ventanaCombate = new JFramePrincipal(combate);
        } else {
            ventanaCombate.createAndShowUI(combate);
        }
        combate.setPadre(ventanaCombate);
        combate.setText();
    }

    /**
     * Metodo para finalizar el combate y continuar con el juego.
     */
    public void finalizarCombate() {
        ocultar();
        ventanaMazmorra();
    }

    /**
     * Método para finalizar el combate y reiniciar el juego.
     */
    public void finalizarJuego() {
        ocultar();
        menuPrincipal();
        ControladorPrincipal.getSingleton().reiniciarJuego();
    }

    /**
     * Método para gestionar la ventana de carga de partidas y la música
     */
    public void cargarPartida() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        ReproductorMusica.getSingleton().pararMusica();
        reproducirMusica("src/Recursos/cargarPartida.mp3", musica);
        VentanaCargar carga = new VentanaCargar();
        if (cargarPar == null) {
            cargarPar = new JFramePrincipal(carga, "/Recursos/cargar.gif");
        } else {
            cargarPar.createAndShowUI(carga, "/Recursos/cargar.gif");
        }
        carga.setPadre(cargarPar);
    }

    /**
     * Metodo para gestionar la ventana de subir nivel y la música
     */
    void menuSubirNivel() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        ReproductorMusica.getSingleton().pararMusica();
        reproducirMusica("src/Recursos/combate.mp3", musica);
        VentanaSubirNivel subir = new VentanaSubirNivel();
        if (ventanaSubirNivel == null) {
            ventanaSubirNivel = new JFramePrincipal(subir);
        } else {
            ventanaSubirNivel.createAndShowUI(subir);
        }
        subir.setPadre(ventanaSubirNivel);
    }

    /**
     * Metodo para comprobar ventanas ocultas y mostradas, para ocultar las que no se utilizan.
     */
    private void ocultar() {
        if (nuevaPar != null) {
            nuevaPar.visible(false);
        }
        if (menuPrin != null) {
            menuPrin.visible(false);
        }
        if (cargarPar != null) {
            cargarPar.visible(false);
        }
        if (mensajeInicio != null) {
            mensajeInicio.visible(false);
        }
        if (ventanaMazmorra != null) {
            ventanaMazmorra.visible(false);
        }
        if (ventanaCombate != null) {
            ventanaCombate.visible(false);
        }
        if (ventanaSubirNivel != null) {
            ventanaSubirNivel.visible(false);
        }
        if (mensajeFin != null) {
            mensajeFin.visible(false);
        }
    }

    /**
     * Metodo para gestionar la ventana de mensaje de fin de partida.
     */
    void menuMensajeFinPartida() {
        boolean musica = ControladorPrincipal.getSingleton().getOpcionMusica();
        ocultar();
        VentanaFinalPartida menuMensaje = new VentanaFinalPartida();
        if (mensajeFin == null) {
            mensajeFin = new JFramePrincipal(menuMensaje);
        } else {
            mensajeFin.createAndShowUI(menuMensaje);
        }
        menuMensaje.setPadre(mensajeFin);
    }
}
