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

    public static int lanza(int caras){
        return (int)((Math.random()*(caras))+1);
    }
        
}
