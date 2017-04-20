/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Personaje;
import Modelo.RepositorioPartidas;
import Modelo.ReproductorMusica;
import Vista.JFramePrincipal;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorPrincipal {
    
    private Personaje personajeActual= new Personaje();
    private RepositorioPartidas partidasGuardadas;
    private static ControladorPrincipal singleton = null;
    private static ReproductorMusica reproductor = new ReproductorMusica();
    
    
    public static void main(String[]args){
        cambiarEstiloGUI();
        ControladorGUI.getSingleton().menuPrincipal();
    }
    
    private ControladorPrincipal(){
        
    }
    
    private static void cambiarEstiloGUI(){        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("CDE/Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static ControladorPrincipal getSingleton(){
        if(singleton==null){
            singleton = new ControladorPrincipal();
        }
        return singleton;
    }
        
    public String[][] infoPersonajeNuevo(){
        String[][] personaje = new String[4][6];
        Personaje[] listaPersonajes = ControladorBBDD.getSingleton().listaPersonajesBase();
        for(int i=0; i<personaje.length;i++){
            personaje[i][0] = listaPersonajes[i].getRaza();
            personaje[i][1] = Integer.toString(listaPersonajes[i].getFuerza());
            personaje[i][2] = Integer.toString(listaPersonajes[i].getDestreza());
            personaje[i][3] = Integer.toString(listaPersonajes[i].getIntelecto());
            personaje[i][4] = Integer.toString(listaPersonajes[i].getConstitucion());
            personaje[i][5] = listaPersonajes[i].getDescripcion();
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
    
    public void iniciarPJ(String raza, int fuerza, int destreza, int intelecto, int constitucion, String descripcion){
        personajeActual.setRaza(raza);
        personajeActual.setFuerza(fuerza);
        personajeActual.setDestreza(destreza);
        personajeActual.setIntelecto(intelecto);
        personajeActual.setConstitucion(constitucion);
        personajeActual.setDescripcion(descripcion);
        personajeActual.establecerVida();
    }
    
    public void establecerNombrePJ(String nombre){
        personajeActual.setNombre(nombre);
    }
}
