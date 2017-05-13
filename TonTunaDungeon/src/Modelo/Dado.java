/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase para gestionar el dado de juego
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public abstract class Dado {
    
    /**
     * Metodo lanza
     * Este metodo lanzara un dado de las caras indicadas.
     * @param caras numero de caras del dado
     * @return int devuelve el valor del dado
     */
    public static int lanza(int caras){
        return (int) Math.floor(Math.random()*caras+1);
    }
        
    /**
     * Metodo aleatorioEntreDos
     * Este metodo genera un numero aleatorio entre dos numeros, incluidos ellos.
     * @param inicio minimo resultado del dado
     * @param fin maximo resultado del dado
     * @return int entero del resultado del dado
     */
    public static int aleatorioEntreDos(int inicio, int fin){
        return (int) Math.floor(Math.random()*(fin-inicio+1));
    }
}
