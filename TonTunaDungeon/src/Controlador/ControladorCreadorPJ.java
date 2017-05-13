/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InputOutputBBDD;
import Modelo.Personaje;

/**
 * Clase controladora de la creacion de personaje
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Gonzalez Rodriguez
 */
public class ControladorCreadorPJ {

    private int razaSeleccionada = 1;

    private static ControladorCreadorPJ singleton = null;

    private Personaje personaje = null;

    private int puntosPersonaje = 6, fuerza, destreza, intelecto, constitucion;

    /**
     * Constructor de la clase ControladorCreadorPJ
     */
    private ControladorCreadorPJ() {

    }

    /**
     * Método singleton del controlador de creacion de personaje
     * @return instancia singleton de ControladorCreadorPJ
     */
    public static ControladorCreadorPJ getSingleton() {
        if (singleton == null) {
            singleton = new ControladorCreadorPJ();
        }
        return singleton;
    }

    /**
     * Método inicializador de atributos según raza del personaje
     * @param razaSeleccionada selecciona que tipo de raza va a ser el personaje, 1 = humano, 2 = elfo, 3 = enano, 4 = mediano.
     */
    public void iniciarAtributosPersonajes(int razaSeleccionada) {
        String raza = "humano";
        switch (razaSeleccionada) {
            case 1:
                raza = "humano";
                break;
            case 2:
                raza = "elfo";
                break;
            case 3:
                raza = "enano";
                break;
            case 4:
                raza = "mediano";
                break;
        }
        puntosPersonaje = 6;
        personaje = InputOutputBBDD.getSingleton().crearPJBase("temporal", raza);
        fuerza = personaje.getFuerza();
        destreza = personaje.getDestreza();
        intelecto = personaje.getIntelecto();
        constitucion = personaje.getConstitucion();
    }

    /**
     * Método incrementa fuerza del personaje
     * @return int nuevo valor de fuerza.
     */
    public int subirFuerza() {
        if (puntosPersonaje > 0) {
            fuerza++;
            puntosPersonaje--;
            return fuerza;
        } else {
            return fuerza;
        }
    }

    /**
     * Método decrementa fuerza del personaje
     * @@return int nuevo valor de fuerza.
     */
    public int bajarFuerza() {
        if (puntosPersonaje <= 6 && fuerza > personaje.getFuerza()) {
            fuerza--;
            puntosPersonaje++;
            return fuerza;
        } else {
            return fuerza;
        }
    }

    /**
     * Método incrementa destreza del personaje
     * @return int nuevo valor de destreza. 
     */
    public int subirDestreza() {
        if (puntosPersonaje > 0) {
            destreza++;
            puntosPersonaje--;
            return destreza;
        } else {
            return destreza;
        }

    }

    /**
     * Método decrementa destreza del personaje
     * @@return int nuevo valor de destreza. 
     */
    public int bajarDestreza() {
        if (puntosPersonaje <= 6 && destreza > personaje.getDestreza()) {
            destreza--;
            puntosPersonaje++;
            return destreza;
        } else {
            return destreza;
        }

    }

    /**
     * Método incrementa intelecto del personaje
     * @return int nuevo valor de intelecto.
     */
    public int subirIntelecto() {
        if (puntosPersonaje > 0) {
            intelecto++;
            puntosPersonaje--;
            return intelecto;
        } else {
            return intelecto;
        }

    }

    /**
     * Método decrementa intelecto del personaje
     * @@return int nuevo valor de intelecto.
     */
    public int bajarIntelecto() {
        if (puntosPersonaje <= 6 && intelecto > personaje.getIntelecto()) {
            intelecto--;
            puntosPersonaje++;
            return intelecto;
        } else {
            return intelecto;
        }

    }

    /**
     * Método incrementa constitución del personaje
     * @@return int nuevo valor de constitución.
     */
    public int subirConstitucion() {
        if (puntosPersonaje > 0) {
            constitucion++;
            puntosPersonaje--;
            return constitucion;
        } else {
            return constitucion;
        }

    }

    /**
     * Método decrementa constitución del personaje
     * @@return int nuevo valor de constitución.
     */
    public int bajarConstitucion() {
        if (puntosPersonaje <= 6 && constitucion > personaje.getConstitucion()) {
            constitucion--;
            puntosPersonaje++;
            return constitucion;
        } else {
            return constitucion;
        }

    }

    /**
     * Método actualiza puntos disponibles para subir atributos
     * @return int cantidad de puntos disponibles.
     */
    public int actualizarPuntosDisponibles() {
        return puntosPersonaje;
    }
}
