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

    public int getBonificador() {
        return bonificador;
    }

    public void setBonificador(int bonificador) {
        this.bonificador = bonificador;
    }

    public int getIndiceArmadura() {
        return indiceArmadura;
    }

    public void setIndiceArmadura(int indiceArmadura) {
        this.indiceArmadura = indiceArmadura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Armadura{" + "bonificador=" + bonificador + ", indiceArmadura=" + indiceArmadura + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
