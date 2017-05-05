/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorBBDD;
import Controlador.ControladorPrincipal;
import Modelo.Inventario.Objeto;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Arma;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private Objeto objeto = ControladorBBDD.getSingleton().obtenerObjeto();
    private Arma arma;
    private Armadura armadura;
    private Monstruo monstruo = ControladorBBDD.getSingleton().obtenerMonstruo(ControladorPrincipal.getSingleton().getNivelActual());
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
     * @param tipo
     * @param nivel
     * @param tesoro
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

    public int getTipo() {
        return tipo;
    }

    public boolean direccionPermitida(int direccion) {
        return puertas[direccion];
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public boolean existeMonstruo(){
        return boolMonstruo;
    }
    
    public void eliminarMonstruo(){
        this.boolMonstruo = false;
    }
    
    public boolean existeObjeto(){
        return boolObjeto;
    }
    
    public Objeto recogerObjeto(){
        this.boolObjeto = false;
        return objeto;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "tipo=" + tipo + ", objeto=" + objeto + ", arma=" + arma + ", armadura=" + armadura + ", monstruo=" + monstruo + ", descripcion=" + descripcion + ", puertas=" + puertas + ", accesible=" + accesible + ", puntoGuardado=" + puntoGuardado + ", escalera=" + escalera + '}';
    }

    public Monstruo getMonstruo() {
        return monstruo;
    }

}
