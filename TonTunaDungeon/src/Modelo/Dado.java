/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public abstract class Dado {
    
    /**
     * Metodo lanza
     * Este metodo lanzara un dado de las caras indicadas.
     * @param caras
     * @return int
     */
    public static int lanza(int caras){
        return (int) Math.floor(Math.random()*caras+1);
    }
        
    /**
     * Metodo aleatorioEntreDos
     * Este metodo genera un numero aleatorio entre dos numeros, incluidos ellos.
     * @param inicio
     * @param fin
     * @return int
     */
    public static int aleatorioEntreDos(int inicio, int fin){
        return (int) Math.floor(Math.random()*(fin-inicio+1)+fin);
    }
}
