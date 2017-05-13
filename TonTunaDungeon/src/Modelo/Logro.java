/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase para gestionar los logros desbloqueados
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public class Logro {
    private String nombre, descripcion;
    boolean desbloqueado;
    /**
     * Metodo constructor para el logro
     * @param nombre String nombre del logro
     * @param descripcion String descripcion del logro
     * @param desbloqueado booleano, true esta desbloqueado, false esta bloqueado.
     */
    public Logro(String nombre, String descripcion, boolean desbloqueado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desbloqueado = desbloqueado;
    }

    /**
     * Metodo devuelve el nombre del logro
     * @return string nombre del logro
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo introduce el nombre del logro
     * @param nombre nombre del logro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo devuelve la descripcion del logro
     * @return String de la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce la descripcion del logro
     * @param descripcion descripcion de la habitacion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo comprueba si el logro esta desbloqueado
     * @return boolean estado del logro
     */
    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    /**
     * Metodo introduce si es desbloqueado
     * @param desbloqueado booleanos si esta desbloqueado o no
     */
    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }
    
}
