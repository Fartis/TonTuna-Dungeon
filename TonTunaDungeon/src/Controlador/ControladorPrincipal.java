/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Personaje;
import Modelo.RepositorioPartidas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorPrincipal {
    
    private Personaje personajeActual=null;
    private RepositorioPartidas partidasGuardadas;
    
    
    public static void main(String[]args){
        ControladorGUI.getSingleton().menuPrincipal();
    }
    
    public void crearPersonaje(String nombre, String raza){
        personajeActual = ControladorBBDD.getSingleton().crearPJBase(nombre, raza);
    }
    
    public String[][] infoPersonajeNuevo(){
        String[][] personaje = new String[4][6];
        Personaje[] listaPersonajes = ControladorBBDD.getSingleton().listaPersonajesBase();
        for(int i=0; i<personaje.length;i++){
            personaje[i][1] = listaPersonajes[i].getRaza();
            personaje[i][2] = Integer.toString(listaPersonajes[i].getFuerza());
            personaje[i][3] = Integer.toString(listaPersonajes[i].getDestreza());
            personaje[i][4] = Integer.toString(listaPersonajes[i].getIntelecto());
            personaje[i][5] = Integer.toString(listaPersonajes[i].getConstitucion());
            personaje[i][6] = listaPersonajes[i].getDescripcion();
        }
        return personaje;
    }
    
    public String infoHabitación(){
        String info="";
        return info;
    }
    
    public DefaultTableModel mapaHabitacion(){
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo;
    }
    
    
}
