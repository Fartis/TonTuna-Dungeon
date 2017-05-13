/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Inventario.Objeto;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Arma;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar la habitacion
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public class Habitacion {

    //El tipo de contenido se utiliza con un entero:
    //0 = Vacia.
    //1 = Normal
    //2 = Tesoro
    //3 = Guardado
    //4 = Siguiente nivel
    private int tipo;
    private Objeto objeto = InputOutputBBDD.getSingleton().obtenerObjeto();
    private Arma arma;
    private Armadura armadura;
    private String descripcion;
    private boolean boolMonstruo = false, boolObjeto = false;
    boolean[] puertas = new boolean[4];
    boolean accesible = false, puntoGuardado = false, escalera = false;

    public static void main(String[]args){
        Habitacion temporal = new Habitacion(1,1,1,null);
        System.out.println(temporal);
    }
    
    /**
     * Metodo establece el tipo de habitacion y nivel
     *
     * @param tipo tipo de habitacion en la que se encuentra
     * @param nivel nivel donde se encuentra la habitacion
     * @param tesoro tesoro que posee la habitacion
     * @param caminos boolean[]
     */
    public Habitacion(int tipo, int nivel, int tesoro, boolean[] caminos) {
        this.tipo = tipo;
        this.accesible = true;
        switch (tipo) {
            case 0:
                this.accesible = false;
                break;
            case 2:
                this.accesible = true;
                 {
                     boolObjeto = true;
                }
                break;
            case 1:
                this.accesible = true;
                if (Dado.lanza(2)==Dado.lanza(2)) {
                    boolMonstruo = true;
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
        this.puertas = caminos;
        try {
            establecerDescripcion();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que establece la descripcion que se genera al entrar en la habitacion
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void establecerDescripcion() throws FileNotFoundException, IOException {
        if(tipo!=0){
            File archivo = new File("src/Recursos/xmlPisos/descripcionTipo" + this.tipo + ".txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < Dado.lanza(10); i++) {
                br.readLine();
            }
            descripcion = br.readLine();
        }
    }

    /**
     * Metodo devuelve el tipo de habitacion
     * @return int del tipo del objeto
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Metodo devuelve la direccion que te permite tomar en cada habitacion
     * @param direccion entero que indica la direccion disponible
     * @return boolean de la direcciones que permiten en la habitacion
     */
    public boolean direccionPermitida(int direccion) {
        return puertas[direccion];
    }
    
    /**
     * Metodo devuelve la descripcion de la habitacion
     * @return string de la descripcion
     */
    public String getDescripcion(){
        return descripcion;
    }
    /**
     * Metodo devuelve boolean si hay monstruo en la habitacion
     * @return boolean de la existencia de monstruo
     */
    public boolean existeMonstruo(){
        return boolMonstruo;
    }
    /**
     * Metodo que establece cuando se elimina un monstruo
     */
    public void eliminarMonstruo(){
        this.boolMonstruo = false;
    }
    /**
     * Metodo devuelve boolean si hay objeto
     * @return boolean de la existencia de objeto
     */
    public boolean existeObjeto(){
        return boolObjeto;
    }
    /**
     * Metodo devuelve el objeto de la habitacion
     * @return Objeto de tipo objeto
     */
    public Objeto recogerObjeto(){
        this.boolObjeto = false;
        return objeto;
    }



}
