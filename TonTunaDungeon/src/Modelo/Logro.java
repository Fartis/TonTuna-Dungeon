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
public class Logro {
    private String nombre, descripcion;
    boolean desbloqueado;
    
    public Logro(String nombre, String descripcion, boolean desbloqueado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desbloqueado = desbloqueado;
    }
    
}
