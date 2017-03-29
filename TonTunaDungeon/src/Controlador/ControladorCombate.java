/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dado;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorCombate {
    
    private static int ataque(int con, int wep, int obj, int con2, int def, int bon2, int obj2) {
        int daño = (con + wep + obj + Dado.lanza(10)) - (con2 + def + bon2 + obj2 + Dado.lanza(10));
        if (daño <= 0) {
            daño = 1;
        }
        return daño;
    }

}
