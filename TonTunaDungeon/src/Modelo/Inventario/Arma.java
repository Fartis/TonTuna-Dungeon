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
    //3 = Mágica
    private int tipo;
    
    public Arma(String nombre, int tipo, int bonificador, String descripcion){
        this.nombre=nombre;
        this.tipo=tipo;
        this.bonificador=bonificador;
        this.descripcion=descripcion;
    }

    public int getBonificador() {
        return bonificador;
    }

    public void setBonificador(int bonificador) {
        this.bonificador = bonificador;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Arma{" + "bonificador=" + bonificador + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
    
}
