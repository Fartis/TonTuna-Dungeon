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
    private Calendar fecha;
    private int nivelActual;

    /**
     * Constructor de la Partida
     * @param pj
     * @param mazmorra
     * @param piso 
     */
    public Partida(Personaje pj, ArrayList<Habitacion[][]> mazmorra, int nivelActual) {
        this.pj = pj;
        this.mazmorra = mazmorra;
        this.fecha = Calendar.getInstance();
        this.nivelActual = nivelActual;
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
    
    public int getNivel(){
        return nivelActual;
    }
    
    public Calendar getFecha(){
        return fecha;
    }
}
