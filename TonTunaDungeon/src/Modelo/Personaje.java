/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorBBDD;
import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar el Personaje
 * @author Manuel David Villalba Escamilla
 */
public class Personaje {

    
    private Armadura armadura = ControladorBBDD.getSingleton().obtenerArmadura(1);;
    private Arma arma = ControladorBBDD.getSingleton().obtenerArma(1);;
    private int fuerza, destreza, constitucion, intelecto, vidaTotal, nivel, vidaActual, indiceAr = this.armadura.getIndiceArmadura();
    private String descripcion, raza, nombre;
    private ArrayList<Arma> inventarioArma = new ArrayList();
    private ArrayList<Armadura> inventarioArmadura = new ArrayList();
    private ArrayList<Objeto> inventarioObjeto = new ArrayList();

    public Personaje() {

    }

    /**
     * Constructor del Personaje
     * @param nombre
     * @param raza
     * @param fuerza
     * @param constitucion
     * @param destreza
     * @param intelecto
     * @param descripcion
     * @param nivel 
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
        
    }


    /**
     * Metodo para listar los objetos
     * @return 
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
     * @return 
     */
    public Armadura getArmadura() {
        return armadura;
    }

    /**
     * metodo introduce la armadura del personaje
     * @param armadura 
     */
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    /**
     * Metodo devuelve el arma del personaje
     * @return 
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * Metodo introduce el arma del personaje
     * @param arma 
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * Metodo devuelve la fuerza del personaje
     * @return 
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Metodo introduce la fuerza del personaje
     * @param fuerza 
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Metodo devuelve la destreza del personaje
     * @return 
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Metodo introduce la destreza del personaje
     * @param destreza 
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Metodo devuelve la constitucion del personaje
     * @return 
     */
    public int getConstitucion() {
        return constitucion;
    }

    /**
     * Metodo introduce la consitucion del personaje
     * @param constitucion 
     */
    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    /**
     * Metodo devuelve el intelecto del personaje
     * @return 
     */
    public int getIntelecto() {
        return intelecto;
    }

    /**
     * Metodo introduce el intelecto del personaje
     * @param intelecto 
     */
    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    /**
     * Metodo devuelve la descripcion del personaje
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo introduce la descripcion del personaje
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo devuelve la raza del personaje
     * @return 
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Metodo introduce la raza del personaje
     * @param raza 
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Metodo devuelve la vida del personaje
     * @return 
     */
    public int getVidaTotal() {
        return vidaTotal;
    }

    /**
     * Metodo introduce la vida del personaje
     * @param vida 
     */
    public void setVidaTotal(int vida) {
        this.vidaTotal = vida;
    }

    /**
     * Metodo devuelve el nivel del personaje
     * @return 
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Metodo introduce el nivel del personaje
     * @param nivel 
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Metodo devuelve el nombre del personaje
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo introduce el nombre del personaje
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + getNombre() + "fuerza=" + getFuerza() + ", destreza=" + getDestreza() + ", constitucion=" + getConstitucion() + ", intelecto=" + getIntelecto() + ", vida=" + getVidaTotal() + ", nivel=" + getNivel() + ", descripcion=" + getDescripcion() + ", raza=" + getRaza() + ", armadura=" + getArmadura() + ", arma=" + getArma() + '}';
    }

    public void subirNivel(int caracteristica) {
        switch (caracteristica){
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
                this.vidaTotal=this.vidaTotal+Dado.lanza(6);
                break;
        }
    }
    
    /**
     * Metodo para añadir una nueva Arma al inventario de armas del personaje
     * @param nueva 
     */
    public void anadirArma(Arma nueva){
        inventarioArma.add(nueva);
    }
    
    /**
     * Metodo para añadir una nueva Armadura al inventario de armaduras del personaje
     * @param nueva 
     */
    public void anadirArmadura(Armadura nueva){
        inventarioArmadura.add(nueva);
    }
    
    /**
     * Metodo para añadir un nuevo objeto al inventario de objetos del personaje
     * @param nuevo 
     */
    public void añadirObjeto(Objeto nuevo) {
        inventarioObjeto.add(nuevo);
    }
    
    /**
     * Metodo para obtener un objeto que se va a usar en combate y lo elimina del inventario de objetos del personaje
     * @param indice
     * @return 
     */
    public Objeto usarObjeto(int indice){
        Objeto temporal = inventarioObjeto.get(indice);
        inventarioObjeto.remove(indice);
        return temporal;
    }

    /**
     * @return the vidaActual
     */
    public int getVidaActual() {
        return vidaActual;
    }

    /**
     * @param vidaActual the vidaActual to set
     */
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
        if(vidaActual>vidaTotal){
            this.vidaActual = this.vidaTotal;
        }
    }

    public ArrayList<Objeto> getInventarioObjeto() {
        return inventarioObjeto;
    }

    public ArrayList<Arma> getInventarioArma() {
        return inventarioArma;
    }

    public ArrayList<Armadura> getInventarioArmadura() {
        return inventarioArmadura;
    }

    

    public int getIndiceAr() {
        return indiceAr;
    }

    public void setIndiceAr(int indiceAr) {
        if(indiceAr>=0){
            this.indiceAr = indiceAr;
        }
        else{
            this.indiceAr = 0;
        }
    }
    
}
