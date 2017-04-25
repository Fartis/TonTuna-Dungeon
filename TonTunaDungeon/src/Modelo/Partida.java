/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase gestiona la partida del juego
 * @author Manuel David Villalba Escamilla
 */
public class Partida {

    private Personaje pj;
    private ArrayList<Habitacion[][]> mazmorra;
    private Habitacion[][] piso;
    private Calendar fecha;

    /**
     * Constructor de la Partida
     * @param pj
     * @param mazmorra
     * @param piso 
     */
    public Partida(Personaje pj, ArrayList<Habitacion[][]> mazmorra, Habitacion[][] piso) {
        this.pj = pj;
        this.mazmorra = mazmorra;
        this.piso = piso;
        this.fecha = Calendar.getInstance();
    }

    /**
     * Metodo devuelve el personaje
     * @return 
     */
    public Personaje getPj() {
        return pj;
    }

    /**
     * Metodo devuelve la mazmorra de la partida
     * @return 
     */
    public ArrayList<Habitacion[][]> getMazmorra() {
        return mazmorra;
    }

    /**
     * Metodo devuelve el piso de la partida
     * @return 
     */
    public Habitacion[][] getPiso() {
        return piso;
    }

    /**
     * Metodo devuelve la fecha de la partida
     * @return 
     */
    public Calendar getFecha() {
        return fecha;
    }
    
    
}
