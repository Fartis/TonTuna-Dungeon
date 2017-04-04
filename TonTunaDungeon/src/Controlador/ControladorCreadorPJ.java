/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Personaje;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorCreadorPJ {

    private int razaSeleccionada = 1;

    private static ControladorCreadorPJ singleton = null;

    private Personaje personaje = null;
    
    private int puntosPersonaje = 6, fuerza, destreza, intelecto, constitucion;
    
    private ControladorCreadorPJ() {
        
    }

    public static ControladorCreadorPJ getSingleton() {
        if (singleton == null) {
            singleton = new ControladorCreadorPJ();
        }
        return singleton;
    }

    public void setRaza(int i) {
        razaSeleccionada = i;
    }

    public void crearPersonaje(){
        
    }
}
