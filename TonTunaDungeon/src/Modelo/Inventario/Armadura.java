/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Inventario;

/**
 * Clase para gestionar la armadura
 * @author Manuel David Villalba Escamilla
 */
public class Armadura {
    private int bonificador;
    private String nombre, descripcion;
    /**
     * Constructor Armadura
     * @param nombre
     * @param bonificador
     * @param indice
     * @param descripcion 
     */
    public Armadura(String nombre, int bonificador, String descripcion){
        this.nombre=nombre;
        this.bonificador=bonificador;
        this.descripcion=descripcion;
    }

    /**
     * Metodo devuelve la bonificacion de la armadura
     * @return 
     */
    public int getBonificador() {
        return bonificador;
    }

    /**
     * Metodo introduce la bonificacion de la armadura
     * @param bonificador 
     */
    public void setBonificador(int bonificador) {
        this.bonificador = bonificador;
    }

    /**
     * Metodo devuelve nombre de armadura
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo introduce nombre de armadura
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo devuelve descripcion de la armadura
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce la descripcion de la armadura
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Armadura{" + "bonificador=" + bonificador + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
