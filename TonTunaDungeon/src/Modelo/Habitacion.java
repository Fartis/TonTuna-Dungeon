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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar la habitacion
 *
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
     *
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
            case 2:
                this.accesible = true;
                 {
                    try {
                        this.objeto = ControladorBBDD.getSingleton().obtenerObjeto();
                    } catch (SQLException ex) {
                        System.out.println("Ha sido imposible generar habitación con monstruo");
                    }
                }
                break;
            case 1:
                this.accesible = true;
                try {
                    if (Dado.lanza(3) == Dado.lanza(3) || Dado.lanza(3) == Dado.lanza(5)) {
                        this.monstruo = ControladorBBDD.getSingleton().obtenerMonstruo(nivel);
                    }
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
     *
     * @param accesible
     */
    public Habitacion(boolean accesible) {
        if (!accesible) {
            this.accesible = accesible;
        } else {
            throw new IllegalArgumentException("Fallo al generar habitación vacia.");
        }
    }

    @Override
    public String toString() {
        return "Habitacion{" + "tipo=" + tipo + ", objeto=" + objeto + ", arma=" + arma + ", armadura=" + armadura + ", monstruo=" + monstruo + ", descripcion=" + descripcion + ", puertas=" + puertas + ", accesible=" + accesible + ", puntoGuardado=" + puntoGuardado + ", escalera=" + escalera + '}';
    }

}
