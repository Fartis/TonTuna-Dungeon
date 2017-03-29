/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class Partida {

    private Personaje pj;
    private ArrayList<Habitacion[][]> mazmorra;
    private Habitacion[][] piso;
    private Calendar fecha;

    public Partida(Personaje pj, ArrayList<Habitacion[][]> mazmorra, Habitacion[][] piso) {
        this.pj = pj;
        this.mazmorra = mazmorra;
        this.piso = piso;
        this.fecha = Calendar.getInstance();
    }

    public Personaje getPj() {
        return pj;
    }

    public ArrayList<Habitacion[][]> getMazmorra() {
        return mazmorra;
    }

    public Habitacion[][] getPiso() {
        return piso;
    }

    public Calendar getFecha() {
        return fecha;
    }
    
    
}
