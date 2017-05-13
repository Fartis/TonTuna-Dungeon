/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Inventario;

/**
 * Clase para gestionar las armas
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public class Arma {
    private int bonificador;
    private String nombre, descripcion;
    
    //El tipo de arma se utiliza con un entero:
    //1 = Cuerpo a cuerpo
    //2 = A distancia
    //3 = Mágica
    private int tipo;
    /**
     * Constructor Arma
     * @param nombre string del nombre del arma
     * @param tipo entero del tipo de arma
     * @param bonificador int del bonificador del arma
     * @param descripcion String descripcion
     */
    public Arma(String nombre, int tipo, int bonificador, String descripcion){
        this.nombre=nombre;
        this.tipo=tipo;
        this.bonificador=bonificador;
        this.descripcion=descripcion;
    }

    /**
     * Metodo devuelve la bonificacion del arma
     * @return 
     */
    public int getBonificador() {
        return bonificador;
    }

    /**
     * Metodo introduce la bonificacion del arma
     * @param bonificador entero bonificador del arma
     */
    public void setBonificador(int bonificador) {
        this.bonificador = bonificador;
    }

    /**
     * Metodo devuelve el nombre del arma
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo introduce el nombre del arma
     * @param nombre String del nombre del arma
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo devuelve la descripcion del arma
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce la descripcion del arma
     * @param descripcion String de la descripcion del arma
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo devuelve el tipo del arma
     * @return 
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Metodo introduce el tipo de arma
     * @param tipo entero del tipo de arma
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Arma{" + "bonificador=" + bonificador + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
    
}
