/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Personaje;

/**
 * Clase controladora de la creacion de personaje
 * @author Manuel David Villalba Escamilla
 */
public class ControladorCreadorPJ {

    private int razaSeleccionada = 1;

    private static ControladorCreadorPJ singleton = null;

    private Personaje personaje = null;

    private int puntosPersonaje = 6, fuerza, destreza, intelecto, constitucion;

    private ControladorCreadorPJ() {

    }

    /**
     * Metodo singleton del controlador de creacion de personaje
     * @return 
     */
    public static ControladorCreadorPJ getSingleton() {
        if (singleton == null) {
            singleton = new ControladorCreadorPJ();
        }
        return singleton;
    }

    /**
     * Constructor por defecto
     */
    public void crearPersonaje() {

    }

    /**
     * Metodo inicializador de atributos segun raza del personaje
     * @param razaSeleccionada 
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
        personaje = ControladorBBDD.getSingleton().crearPJBase("temporal", raza);
        fuerza = personaje.getFuerza();
        destreza = personaje.getDestreza();
        intelecto = personaje.getIntelecto();
        constitucion = personaje.getConstitucion();
    }

    /**
     * Metodo incrementa fuerza del personaje
     * @return 
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
     * Metodo decrementa fuerza del personaje
     * @return 
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
     * Metodo incrementa destreza del personaje
     * @return 
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
     * Metodo decrementa destreza del personaje
     * @return 
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
     * Metodo incrementa intelecto del personaje
     * @return 
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
     * Metodo decrementa intelecto del personaje
     * @return 
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
     * Metodo incrementa constitucion del personaje
     * @return 
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
     * Metodo decrementa constitucion del personaje
     * @return 
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
     * Metodo actualiza puntos disponibles para subir atributos
     * @return 
     */
    public int actualizarPuntosDisponibles() {
        return puntosPersonaje;
    }
}
