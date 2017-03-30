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
public class Arma {
    private int bonificador;
    private String nombre, descripcion;
    
    //El tipo de arma se utiliza con un entero:
    //1 = Cuerpo a cuerpo
    //2 = A distancia
    //3 = Magica
    private int tipo;
    
    public Arma(String nombre, int tipo, int bonificador, String descripcion){
        this.nombre=nombre;
        this.tipo=tipo;
        this.bonificador=bonificador;
        this.descripcion=descripcion;
    }
    
}
