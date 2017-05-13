/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import java.util.ArrayList;

/**
 * Clase para gestionar el Personaje
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public class Personaje {

    private Armadura armadura = InputOutputBBDD.getSingleton().obtenerArmadura(1);
    ;
    private Arma arma = InputOutputBBDD.getSingleton().obtenerArma(1);
    ;
    private int fuerza, destreza, constitucion, intelecto, vidaTotal, nivel, vidaActual;
    private String descripcion, raza, nombre;
    private ArrayList<Arma> inventarioArma = new ArrayList();
    private ArrayList<Armadura> inventarioArmadura = new ArrayList();
    private ArrayList<Objeto> inventarioObjeto = new ArrayList<Objeto>();

    public Personaje() {

    }

    /**
     * Constructor del Personaje
     *
     * @param nombre String del nombre del personaje
     * @param raza String de la raza del personaje
     * @param fuerza entero de la fuerza del personaje
     * @param constitucion entero de la constitucion del personaje
     * @param destreza entero de la destreza del personaje
     * @param intelecto entero del intelecto del personaje
     * @param descripcion String de la descripcion del personaje
     * @param nivel entero del nivel del personaje
     */
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
        this.inventarioObjeto.clear();
    }

    /**
     * Metodo para listar los objetos
     *
     * @return lista objetos
     */
    public ArrayList<String> listarObjetos() {
        ArrayList<String> lista = new ArrayList();
        if (!inventarioObjeto.isEmpty()) {
            for (int i = 0; i < inventarioObjeto.size(); i++) {
                lista.add(inventarioObjeto.get(i).getNombre());
            }
        }
        return lista;
    }

    /**
     * Metodo para establecer la lista del personaje
     */
    public void establecerVida() {
        int cantidad = 0;
        for (int i = 0; i < getConstitucion(); i++) {
            cantidad = cantidad + Dado.lanza(6);
        }
        this.setVidaTotal(cantidad);
        this.setVidaActual(this.vidaTotal);
    }

    /**
     * Metodo devuelve la armadura del personaje
     *
     * @return objeto armadura
     */
    public Armadura getArmadura() {
        return armadura;
    }

    /**
     * metodo introduce la armadura del personaje
     *
     * @param armadura objeto armadura del personaje
     */
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    /**
     * Metodo devuelve el arma del personaje
     *
     * @return objeto arma
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * Metodo introduce el arma del personaje
     *
     * @param arma objeto arma del personaje
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * Metodo devuelve la fuerza del personaje
     *
     * @return int fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Metodo introduce la fuerza del personaje
     *
     * @param fuerza entero de la fuerza del personaje
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Metodo devuelve la destreza del personaje
     *
     * @return int destreza
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Metodo introduce la destreza del personaje
     *
     * @param destreza entero de la destreza del personaje
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Metodo devuelve la constitucion del personaje
     *
     * @return int constitucion
     */
    public int getConstitucion() {
        return constitucion;
    }

    /**
     * Metodo introduce la consitucion del personaje
     *
     * @param constitucion entero de la constitucion del personaje
     */
    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    /**
     * Metodo devuelve el intelecto del personaje
     *
     * @return int intelecto
     */
    public int getIntelecto() {
        return intelecto;
    }

    /**
     * Metodo introduce el intelecto del personaje
     *
     * @param intelecto entero del intelecto del personaje
     */
    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    /**
     * Metodo devuelve la descripcion del personaje
     *
     * @return string descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce la descripcion del personaje
     *
     * @param descripcion string de la descripcion del personaje
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo devuelve la raza del personaje
     *
     * @return string raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Metodo introduce la raza del personaje
     *
     * @param raza string de la raza del personaje
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Metodo devuelve la vida del personaje
     *
     * @return int vida total
     */
    public int getVidaTotal() {
        return vidaTotal;
    }

    /**
     * Metodo introduce la vida del personaje
     *
     * @param vida entero de la vida del personaje
     */
    public void setVidaTotal(int vida) {
        this.vidaTotal = vida;
    }

    /**
     * Metodo devuelve el nivel del personaje
     *
     * @return int nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Metodo introduce el nivel del personaje
     *
     * @param nivel entero del nivel del personaje
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Metodo devuelve el nombre del personaje
     *
     * @return string nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo introduce el nombre del personaje
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + getNombre() + "fuerza=" + getFuerza() + ", destreza=" + getDestreza() + ", constitucion=" + getConstitucion() + ", intelecto=" + getIntelecto() + ", vida=" + getVidaTotal() + ", nivel=" + getNivel() + ", descripcion=" + getDescripcion() + ", raza=" + getRaza() + ", armadura=" + getArmadura() + ", arma=" + getArma() + '}';
    }

    /**
     * Metodo para subir de nivel al personaje
     * @param caracteristica entero que aumenta una de las caracteristicas del personaje
     */
    public void subirNivel(int caracteristica) {
        switch (caracteristica) {
            case 1:
                this.fuerza++;
                break;
            case 2:
                this.destreza++;
                break;
            case 3:
                this.intelecto++;
                break;
            case 4:
                this.constitucion++;
                this.vidaTotal = this.vidaTotal + Dado.lanza(6);
                break;
        }
    }

    /**
     * Metodo para añadir una nueva Arma al inventario de armas del personaje
     *
     * @param nueva objeto de tipo arma del personaje
     */
    public void anadirArma(Arma nueva) {
        inventarioArma.add(nueva);
    }

    /**
     * Metodo para añadir una nueva Armadura al inventario de armaduras del
     * personaje
     *
     * @param nueva objeto de tipo armadura del personaje
     */
    public void anadirArmadura(Armadura nueva) {
        inventarioArmadura.add(nueva);
    }

    /**
     * Metodo para añadir un nuevo objeto al inventario de objetos del personaje
     *
     * @param nuevo objeto de tipo Objeto del personaje
     */
    public void añadirObjeto(Objeto nuevo) {
        inventarioObjeto.add(nuevo);
    }

    /**
     * Metodo para obtener un objeto que se va a usar en combate y lo elimina
     * del inventario de objetos del personaje
     * @param indice entero del indice del objeto a usar
     * @param consumir booleano que establece si el objeto ha sido usado
     * @return objeto del inventario
     */
    public Objeto usarObjeto(int indice, boolean consumir) {
        Objeto temporal = inventarioObjeto.get(indice);
        if(consumir){
            inventarioObjeto.remove(indice);
        }
        return temporal;
    }

    /**
     * Metodo devuelve la vida actual del personaje
     * @return the vidaActual
     */
    public int getVidaActual() {
        return vidaActual;
    }

    /**
     * Metodo introduce la vida actual del personaje
     * @param vidaActual the vidaActual to set
     */
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
        if (vidaActual > vidaTotal) {
            this.vidaActual = this.vidaTotal;
        }
    }

    /**
     * Metodo devuelve el array de los objetos del inventario
     * @return objeto inventario
     */
    public ArrayList<Objeto> getInventarioObjeto() {
        return inventarioObjeto;
    }

    /**
     * Metodo devuelve el array de las armas del inventario
     * @return arma inventario
     */
    public ArrayList<Arma> getInventarioArma() {
        return inventarioArma;
    }

    /**
     * Metodo devuelve el array de las armaduras del inventario
     * @return armadura inventario
     */
    public ArrayList<Armadura> getInventarioArmadura() {
        return inventarioArmadura;
    }

    /**
     * Metodo envia el objeto al arraylist del inventario
     * @param obtenerObjeto 
     */
    public void setInventario(ArrayList<Objeto> obtenerObjeto) {
        this.inventarioObjeto.addAll(obtenerObjeto);
    }

}
