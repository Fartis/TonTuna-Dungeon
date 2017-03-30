/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Inventario;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class Armadura {
    private int bonificador, indiceArmadura;
    private String nombre, descripcion;
    
    public Armadura(String nombre, int bonificador, int indice, String descripcion){
        this.nombre=nombre;
        this.bonificador=bonificador;
        this.indiceArmadura=indice;
        this.descripcion=descripcion;
    }
}
