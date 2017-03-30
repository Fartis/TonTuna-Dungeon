/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class Monstruo {
    private int fuerza, destreza, constitucion, intelecto, vida;
    private String nombre, descripcion;
    private Armadura armadura;
    private Arma arma;

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
        
    private void establecerVida() {
        int cantidad=0;
        for(int i=0; i<constitucion; i++){
            cantidad = cantidad+Dado.lanza(4);
        }
        this.vida=cantidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getIntelecto() {
        return intelecto;
    }

    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Monstruo{" + "fuerza=" + fuerza + ", destreza=" + destreza + ", constitucion=" + constitucion + ", intelecto=" + intelecto + ", vida=" + vida + ", nombre=" + nombre + ", descripcion=" + descripcion + ", armadura=" + armadura + ", arma=" + arma + '}';
    }
    
    
    
}
