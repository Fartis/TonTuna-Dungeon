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
        {
            try {
                this.objeto = ControladorBBDD.getSingleton().obtenerObjeto();
            } catch (SQLException ex) {
                Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
