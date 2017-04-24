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
public class Objeto {
    private String nombre, descripcion;
    int valor;
    
    //El tipo de objeto se utiliza con un entero:
    //1 = Curación
    //2 = Apoyo
    //3 = Daño
    private int tipo;

    public Objeto(String nombre, String descripcion, int valor, int tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.tipo = tipo;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Objeto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", valor=" + valor + ", tipo=" + tipo + '}';
    }
    
}
