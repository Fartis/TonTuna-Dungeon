/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class Partida {

    private Personaje pj;
    private ArrayList<Habitacion[][]> mazmorra;
    private Habitacion[][] piso;

    public Partida(Personaje pj, ArrayList<Habitacion[][]> mazmorra, Habitacion[][] piso) {
        this.pj = pj;
        this.mazmorra = mazmorra;
        this.piso = piso;
    }
}
