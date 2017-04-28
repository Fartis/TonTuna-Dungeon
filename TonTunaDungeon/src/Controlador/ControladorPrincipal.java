/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inventario.Objeto;
import Modelo.Personaje;
import Modelo.RepositorioPartidas;
import Modelo.ReproductorMusica;
import Vista.JFramePrincipal;
import javax.swing.table.DefaultTableModel;

/**
 * Clase gestiona el controlador principal e inicia la aplicacion
 * @author Manuel David Villalba Escamilla
 */
public class ControladorPrincipal {
    
    private Personaje personajeActual= new Personaje();
    private RepositorioPartidas partidasGuardadas;
    private static ControladorPrincipal singleton = null;
    private static ReproductorMusica reproductor = new ReproductorMusica();
    private static boolean musica = true;
    private int nivelActual=0;
    
    /**
     * Metodo inicia aplicacion y musica
     * @param args 
     */
    public static void main(String[]args){
        cambiarEstiloGUI();
        ControladorGUI.getSingleton().menuPrincipal();
    }
    /**
     * Constructor por defecto
     */
    private ControladorPrincipal(){
        
    }
    /**
     * Metodo para cambiar el estilo del interfaz grafico
     */
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
    /**
     * Metodo singleton del controlador principal
     * @return 
     */
    public static ControladorPrincipal getSingleton(){
        if(singleton==null){
            singleton = new ControladorPrincipal();
        }
        return singleton;
    }
    /**
     * Metodo para tener la informacion del personaje
     * @return 
     */    
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
    /**
     * Metodo para tener la informacion de la habitacion
     * @return 
     */
    public String infoHabitación(){
        String info="";
        return info;
    }
    /**
     * Metodo modelo del mapa de la habitacion
     * @return 
     */
    public DefaultTableModel mapaHabitacion(){
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo;
    }
    /**
     * Metodo para iniciar el personaje con sus caracteristicas
     * @param raza
     * @param fuerza
     * @param destreza
     * @param intelecto
     * @param constitucion
     * @param descripcion 
     */
    public void iniciarPJ(String raza, int fuerza, int destreza, int intelecto, int constitucion, String descripcion){
        personajeActual.setRaza(raza);
        personajeActual.setFuerza(fuerza);
        personajeActual.setDestreza(destreza);
        personajeActual.setIntelecto(intelecto);
        personajeActual.setConstitucion(constitucion);
        personajeActual.setDescripcion(descripcion);
        personajeActual.establecerVida();
    }
    /**
     * Metodo para establecer el nombre del personaje
     * @param nombre 
     */
    public void establecerNombrePJ(String nombre){
        personajeActual.setNombre(nombre);
    }
    /**
     * Metodo para comprobar si la musica esta habilitada
     */
    public void setOpcionMusica(){
        if (musica){
            musica=false;
            ControladorGUI.getSingleton().stopMusica();
        }
        else{
            musica=true;            
            ReproductorMusica.getSingleton().play("src/Recursos/Stormlord - Title (Unused).mp3");
        }
    }
    /**
     * Metodo devuelve la opcion de musica
     * @return 
     */
    public boolean getOpcionMusica(){
        return musica;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }
    
        /**
     * Metodo devuelve el nombre del personaje
     * @return 
     */
    public String getPJNombre(){
        return personajeActual.getNombre();
    }
    
    /**
     * Metodo devuelve la vida total del personaje
     * @return
     */
    public int getPJVidaTotal(){
        return personajeActual.getVidaTotal();
    }
    
    /**
     * Metodo para subir un punto una caracteristica del PJ
     * @param caracteristica
     * @param incremento 
     */
    public void subirNivelPJ(int caracteristica){
        personajeActual.subirNivel(caracteristica);
    }
    
    public void añadirObjetoPersonaje(Objeto nuevo){
        personajeActual.añadirObjeto(nuevo);
    }
    
    public void reiniciarJuego(){
        this.personajeActual= new Personaje();
        this.nivelActual=0;
        ControladorMazmorra.getSingleton().reiniciarMazmorra();
    }
    
}
