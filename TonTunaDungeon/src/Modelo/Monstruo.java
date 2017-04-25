/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;

/**
 * Clase para gestionar el monstruo
 * @author Manuel David Villalba Escamilla
 */
public class Monstruo {
    private int fuerza, destreza, constitucion, intelecto, vida;
    private String nombre, descripcion;
    private Armadura armadura;
    private Arma arma;

    /**
     * Constructor del monstruo
     * @param fuerza
     * @param destreza
     * @param constitucion
     * @param intelecto
     * @param nombre
     * @param descripcion
     * @param armadura
     * @param arma 
     */
    public Monstruo(int fuerza, int destreza, int constitucion, int intelecto, String nombre, String descripcion, Armadura armadura, Arma arma) {
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.intelecto = intelecto;
        establecerVida();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.armadura = armadura;
        this.arma = arma;
    }
    /**
     * Metodo para establecer la vida del monstruo
     */    
    private void establecerVida() {
        int cantidad=0;
        for(int i=0; i<constitucion; i++){
            cantidad = cantidad+Dado.lanza(6);
        }
        this.vida=cantidad;
    }

    /**
     * Metodo devuelve la fuerza del monstruo
     * @return 
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Metodo introducir la fuerza del monstruo
     * @param fuerza 
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Metodo devuelve la destreza del monstruo
     * @return 
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Metodo introduce la destreza del monstruo
     * @param destreza 
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Metodo devuelve la constitucion del monstruo
     * @return 
     */
    public int getConstitucion() {
        return constitucion;
    }

    /**
     * Metodo introduce la constitucion del monstruo
     * @param constitucion 
     */
    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    /**
     * metodo devuelve el intelecto del monstruo
     * @return 
     */
    public int getIntelecto() {
        return intelecto;
    }

    /**
     * metodo introduce el intelecto del monstruo
     * @param intelecto 
     */
    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    /**
     * Metodo devuelve la vida del monstruo
     * @return 
     */
    public int getVida() {
        return vida;
    }

    /**
     * Metodo introduce la vida del monstruo
     * @param vida 
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Metodo devuelve el nombre del monstruo
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo introduce el nombre del monstruo
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo devuelve la descripcion del monstruo
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce la descripcion del monstruo
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo devuelve la armadura del monstruo
     * @return 
     */
    public Armadura getArmadura() {
        return armadura;
    }

    /**
     * Metodo introduce la armadura del monstruo
     * @param armadura 
     */
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    /**
     * Metodo devuelve el arma del monstruo
     * @return 
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * Metodo introduce el arma del monstruo
     * @param arma 
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Monstruo{" + "fuerza=" + fuerza + ", destreza=" + destreza + ", constitucion=" + constitucion + ", intelecto=" + intelecto + ", vida=" + vida + ", nombre=" + nombre + ", descripcion=" + descripcion + ", armadura=" + armadura + ", arma=" + arma + '}';
    }
    
    
    
}
