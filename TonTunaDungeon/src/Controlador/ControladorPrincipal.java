/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InputOutputBBDD;
import Modelo.Inventario.Objeto;
import Modelo.Personaje;
import Modelo.ReproductorMusica;
import Vista.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Clase gestiona el controlador principal e inicia la aplicacion
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Gonzalez Rodriguez
 */
public class ControladorPrincipal {

    private Personaje personajeActual = new Personaje();
    private static ControladorPrincipal singleton = null;
    private static ReproductorMusica reproductor = new ReproductorMusica();
    private static boolean musica = true;
    private int nivelActual = 0;

    /**
     * Metodo inicia aplicacion y musica
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        cambiarEstiloGUI();
        ControladorGUI.getSingleton().menuPrincipal();

    }

    /**
     * Constructor por defecto
     */
    private ControladorPrincipal() {

    }

    /**
     * Metodo para cambiar el estilo del interfaz grafico
     */
    private static void cambiarEstiloGUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("CDE/Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo singleton del controlador principal
     *
     * @return singleton de la clase ControladorPrincipal
     */
    public static ControladorPrincipal getSingleton() {
        if (singleton == null) {
            singleton = new ControladorPrincipal();
        }
        return singleton;
    }

    /**
     * Metodo para tener la informacion del personaje
     *
     * @return Matriz de string que contiene toda la información de la tabla
     * personaje de la base de datos proporcionada por una instancia de la clase
     * InputOutputBBDD.
     */
    public String[][] infoPersonajeNuevo() {
        String[][] personaje = new String[4][6];
        Personaje[] listaPersonajes = InputOutputBBDD.getSingleton().listaPersonajesBase();
        for (int i = 0; i < personaje.length; i++) {
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
     * Metodo para iniciar el personaje con sus caracteristicas
     *
     * @param raza String con el nombre de la raza del personaje con el que se
     * va a jugar.
     * @param fuerza int valor fuerza
     * @param destreza int valor destreza
     * @param intelecto int valor intelecto
     * @param constitucion int valor constitucion
     * @param descripcion String con la descripcion de la raza del personaje con
     * el que se va a jugar.
     */
    public void iniciarPJ(String raza, int fuerza, int destreza, int intelecto, int constitucion, String descripcion) {
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
     *
     * @param nombre String nuevo nombre para el personaje.
     */
    public void establecerNombrePJ(String nombre) {
        personajeActual.setNombre(nombre);
    }

    /**
     * Metodo para comprobar si la musica esta habilitada
     */
    public void setOpcionMusica() {
        if (musica) {
            musica = false;
            ControladorGUI.getSingleton().stopMusica();
        } else {
            musica = true;
            ControladorGUI.getSingleton().reproducirMusica("src/Recursos/intro.mp3", musica);
        }
    }

    /**
     * Metodo devuelve la opcion de musica
     *
     * @return booleano, true = musica activada, false = musica desactivada.
     */
    public boolean getOpcionMusica() {
        return musica;
    }

    /**
     * Metodo que devuelve el nivel actual.
     *
     * @return int nivelActual
     */
    public int getNivelActual() {
        return nivelActual;
    }

    /**
     * Metodo que establece el nivel actual
     *
     * @param nivelActual int nuevo valor actual.
     */
    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    /**
     * Metodo devuelve el nombre del personaje
     *
     * @return String con el nombre del personaje
     */
    public String getPJNombre() {
        return personajeActual.getNombre();
    }

    /**
     * Metodo que devuelve el nombre de la armadura del personaje
     *
     * @return String nombre armadura del personaje.
     */
    public String getPJArmadura() {
        return personajeActual.getArmadura().getNombre();
    }

    public String getPJArma() {
        return personajeActual.getArma().getNombre();
    }

    /**
     * Metodo devuelve la vida total del personaje
     *
     * @return int vidaPJTotal
     */
    public int getPJVidaTotal() {
        return personajeActual.getVidaTotal();
    }

    /**
     * Metodo que devuelve la vida actual del personaje
     *
     * @return int vidaPJActual
     */
    public int getPJVidaActual() {
        return personajeActual.getVidaActual();
    }

    /**
     * Metodo para subir un punto una caracteristica del PJ
     *
     * @param caracteristica int; 1= fuerza, 2= destreza, 3= intelecto, 4=
     * constitución
     */
    public void subirNivelPJ(int caracteristica) {
        personajeActual.subirNivel(caracteristica);
        personajeActual.setVidaActual(personajeActual.getVidaTotal());

    }

    /**
     * Metodo para añadir un nuevo objeto en el inventario del personaje.
     *
     * @param nuevo Instancia de la clase del objeto que se añade al personaje.
     */
    public void añadirObjetoPersonaje(Objeto nuevo) {
        personajeActual.añadirObjeto(nuevo);
    }

    /**
     * Metodo para reiniciar el juego.
     */
    public void reiniciarJuego() {
        this.personajeActual = new Personaje();
        this.nivelActual = 0;
        ControladorMazmorra.getSingleton().reiniciarMazmorra();
    }

    /**
     * Metodo que retorna un array de String con el nombre de los objetos del
     * inventario del personaje.
     *
     * @return String[] nombres de los objetos del inventario del personaje.
     */
    public String[] getInventario() {
        String[] inventario = new String[personajeActual.getInventarioObjeto().size()];
        for (int i = 0; i < inventario.length; i++) {
            inventario[i] = personajeActual.getInventarioObjeto().get(i).getNombre();
        }
        return inventario;
    }

    /**
     * Metodo que retorna un array de String con el nombre de las armas del
     * inventario del personaje.
     *
     * @return String[] nombres de las armas del inventario del personaje.
     */
    public String[] getInvArmas() {
        String[] inventario = new String[personajeActual.getInventarioArma().size()];
        for (int i = 0; i < inventario.length; i++) {
            inventario[i] = personajeActual.getInventarioArma().get(i).getNombre();
        }
        return inventario;
    }

    /**
     * Metodo que retorna un array de String con el nombre de las armaduras del
     * inventario del personaje.
     *
     * @return String[] nombres de las armaduras del inventario del personaje.
     */
    public String[] getInvArmaduras() {
        String[] inventario = new String[personajeActual.getInventarioArmadura().size()];
        for (int i = 0; i < inventario.length; i++) {
            inventario[i] = personajeActual.getInventarioArmadura().get(i).getNombre();
        }
        return inventario;
    }

    /**
     * Metodo que retorna la instancia del personaje actual.
     *
     * @return Personaje
     */
    public Personaje getPJ() {
        return personajeActual;
    }

    /**
     * Método que guarda la partida en la base de datos.
     */
    public void guardarPartida() {
        InputOutputBBDD.getSingleton().guardarInfoPJ(personajeActual);
    }

    /**
     * Metodo que permite cargar la partida
     *
     * @param indice int indice de la partida a cargar.
     */
    public void cargarPartida(int indice) {
        String[] info = InputOutputBBDD.getSingleton().cargarPartida(indice);
        Personaje temporal = new Personaje(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]), Integer.parseInt(info[5]), info[6], Integer.parseInt(info[7]));
        temporal.setArma(InputOutputBBDD.getSingleton().obtenerArma(info[8]));
        temporal.setArmadura(InputOutputBBDD.getSingleton().obtenerArmadura(info[9]));
        temporal.setInventario(InputOutputBBDD.getSingleton().obtenerObjeto(info[0], info[1]));
        this.personajeActual = temporal;
        this.nivelActual = temporal.getNivel();
        ControladorGUI.getSingleton().ventanaMazmorra();
    }

    /**
     * Metodo que borra una partida de la base de datos y devuelve la
     * información de las partidas restantes.
     *
     * @param indice int indice de la partida a borrar.
     * @return DefaultTableModel modelo con la información de la partida a
     * mostrar en un JTable.
     */
    public DefaultTableModel borrarPartida(int indice) {
        String[] info = InputOutputBBDD.getSingleton().cargarPartida(indice);
        InputOutputBBDD.getSingleton().borrarPartida(info);
        return obtenerInfoPartidas();
    }

    /**
     * Metodo que obtiene un DefaultTableModel de las partidas disponibles a
     * cargar y borrar.
     *
     * @return DefaultTableModel modelo con la información de la partida a
     * mostrar en un JTable.
     */
    public DefaultTableModel obtenerInfoPartidas() {
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<String[]> info = InputOutputBBDD.getSingleton().obtenerInfoPartida();
        modelo.addColumn("Nombre");
        modelo.addColumn("Raza");
        modelo.addColumn("Nivel");
        modelo.addColumn("Fecha de creación");
        for (int i = 0; i < info.size(); i++) {
            modelo.addRow(info.get(i));
        }
        return modelo;
    }

    /**
     * Metodo para avanzar al siguiente nivel.
     */
    public void siguienteNivel() {
        if (nivelActual < 9) {
            ControladorMazmorra.getSingleton().reiniciarPosicion();
            ControladorGUI.getSingleton().menuSubirNivel();
            this.nivelActual++;
        } else {
            ControladorGUI.getSingleton().menuMensajeFinPartida();
        }
    }

}
