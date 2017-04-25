/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorBBDD;
import Modelo.Inventario.Objeto;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Arma;
import java.sql.SQLException;

/**
 * Clase para gestionar la habitacion
 * @author Manuel David Villalba Escamilla
 */
public class Habitacion {

    //El tipo de contenido se utiliza con un entero:
    //0 = Vacia.
    //1 = Normal
    //2 = Tesoro
    //3 = Guardado
    //4 = Siguiente nivel
    private int tipo;
    private Objeto objeto;
    private Arma arma;
    private Armadura armadura;
    private Monstruo monstruo;
    private String descripcion;
    boolean[] puertas = new boolean[4];
    boolean accesible = false, puntoGuardado = false, escalera = false;

    /**
     * Metodo establece el tipo de habitacion y nivel
     * @param tipo
     * @param nivel
     * @param tesoro 
     */
    public Habitacion(int tipo, int nivel, int tesoro) {
        this.tipo = tipo;
        this.accesible = true;
        switch (tipo) {
            case 0:
                this.accesible = false;
                break;
            case 1:
                this.accesible = true;
                try {
                    switch (tesoro){
                        case 1: this.objeto = ControladorBBDD.getSingleton().obtenerObjeto(); break;
                        case 2: this.arma = ControladorBBDD.getSingleton().obtenerArma(nivel);
                    }
                } catch (SQLException ex) {
                    System.out.println("Ha sido imposible generar habitación con objeto.");
                }
                break;
            case 2:
                this.accesible = true;
                try {
                    this.monstruo = ControladorBBDD.getSingleton().obtenerMonstruo(nivel);
                } catch (SQLException ex) {
                    System.out.println("Ha sido imposible generar habitación con monstruo.");
                }
                break;
            case 3:
                this.accesible = true;
                this.puntoGuardado = true;
                break;
            case 4:
                this.accesible = true;
                this.escalera = true;
                break;
            case 5:
                this.accesible = true;
                break;
        }
    }

    /**
     * Metodo genera puertas de habitacion
     */
    private void generarPuertas() {
        for (int i = 0; i < puertas.length; i++) {
            puertas[i] = false;
        }
    }

    /**
     * Metodo comprueba si la habitacion es accesible y genera
     * @param accesible 
     */
    public Habitacion(boolean accesible) {
        if (!accesible) {
            this.accesible = accesible;
        } else {
            throw new IllegalArgumentException("Fallo al generar habitación vacia.");
        }
    }

}
