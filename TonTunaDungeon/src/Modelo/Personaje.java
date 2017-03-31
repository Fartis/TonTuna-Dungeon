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
public class Personaje {

    private int fuerza, destreza, constitucion, intelecto, vida, nivel;
    private String descripcion, raza, nombre;
    private Armadura armadura;
    private Arma arma;

    public Personaje(String nombre, String raza, int fuerza, int constitucion, int destreza, int intelecto, String descripcion, int nivel) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.constitucion = constitucion;
        this.destreza = destreza;
        this.intelecto = intelecto;
        this.descripcion = descripcion;
        this.nivel = nivel;
        establecerVida();
    }

    private void establecerVida() {
        int cantidad=0;
        for(int i=0; i<constitucion; i++){
            cantidad = cantidad+Dado.lanza(6);
        }
        this.vida=cantidad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + "fuerza=" + fuerza + ", destreza=" + destreza + ", constitucion=" + constitucion + ", intelecto=" + intelecto + ", vida=" + vida + ", nivel=" + nivel + ", descripcion=" + descripcion + ", raza=" + raza + ", armadura=" + armadura + ", arma=" + arma + '}';
    }

    
}
