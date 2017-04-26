/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Inventario;

/**
 * Clase para gestionar los objetos
 * @author Manuel David Villalba Escamilla
 */
public class Objeto {
    private String nombre, descripcion;
    int valor;
    
    //El tipo de objeto se utiliza con un entero:
    //1 = Curación
    //2 = Apoyo
    //3 = Daño
    private int tipo;

    /**
     * Constructor del objeto
     * @param nombre
     * @param descripcion
     * @param valor
     * @param tipo 
     */
    public Objeto(String nombre, String descripcion, int valor, int tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.tipo = tipo;
    }

    /**
     * Metodo devuelve el nombre del objeto
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo introduce el nombre del objeto
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo devuelve la descripcion 
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce descripcion del objeto
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo devuelve valor del objeto
     * @return 
     */
    public int getValor() {
        return valor;
    }

    /**
     * Metodo introduce valor del objeto
     * @param valor 
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Metodo devuelve el tipo del objeto
     * @return 
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Metodo introduce el tipo del objeto
     * @param tipo 
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Objeto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", valor=" + valor + ", tipo=" + tipo + '}';
    }
    
}
