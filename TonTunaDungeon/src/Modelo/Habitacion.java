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

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class Habitacion {

    //El tipo de contenido se utiliza con un entero:
    //0 = Habitacion de inicio.
    //1 = Objeto
    //2 = Arma
    //3 = Armadura
    //4 = Monstruo
    //5 = Cama
    //6 = Nada
    private int tipo=6;
    private Objeto objeto;
    private Arma arma;
    private Armadura armadura;
    private Monstruo monstruo;
    private String descripcion;
    boolean[] puertas = new boolean[4];
    boolean accesible=false, puntoGuardado=false;

    public Habitacion(int tipo) {
        this.tipo = tipo;
        this.accesible = true;
        switch (tipo) {
            case 0:
                this.accesible = true;
                for (int i = 0; i < puertas.length; i++) {
                    puertas[i] = true;
                }
                break;
            case 1:
                this.objeto = ControladorBBDD.obtenerObjeto();
                break;
            case 2:
                this.arma = ControladorBBDD.obtenerArma();
                break;
            case 3:
                this.armadura = ControladorBBDD.obtenerArmadura();
                break;
            case 4:
                this.monstruo = ControladorBBDD.obtenerMonstruo();
                break;
            case 5:
                this.puntoGuardado = true;
                break;
        }
    }

    public Habitacion(boolean accesible) {
        if(!accesible){
            this.accesible=accesible;
        }else{
            throw new IllegalArgumentException("Fallo al generar habitación vacia.");
        }
    }

}
