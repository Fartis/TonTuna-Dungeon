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

    public void crearPersonaje(){
        
    }
    
    public void iniciarAtributos(int razaSeleccionada){
        String raza="humano";
        switch(razaSeleccionada){
            case 1: raza="humano"; break;
            case 2: raza="elfo"; break;
            case 3: raza="enano"; break;
            case 4: raza="mediano"; break;
        }
        personaje=ControladorBBDD.getSingleton().crearPJBase("temporal",raza);
    }
}
