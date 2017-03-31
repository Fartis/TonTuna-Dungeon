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
    
    public void generarPersonaje(String nombre, String raza){
        personajeActual = ControladorBBDD.getSingleton().crearPJBase(nombre, raza);
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
