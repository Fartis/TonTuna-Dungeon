/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Inventario.Objeto;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Arma;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class Habitacion {
    
    //El tipo de contenido se utiliza con un entero:
    //0 = Nada
    //1 = Objeto
    //2 = Arma
    //3 = Armadura
    //4 = Monstruo
    //5 = Cama
    private int tipo;
    private Objeto objeto;
    private Arma arma;
    private Armadura armadura;
    private Monstruo monstruo;
    private String descripcion;
    boolean[] puertas = new boolean[4];
    
    public Habitacion(int tipo){
        this.tipo = tipo;
        switch(tipo){
            case 1:
                break;
            default:
                break;
        }
    }
    
}
