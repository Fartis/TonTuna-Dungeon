/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Partida;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase del repositorio de partidas almacenadas
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorPartidas implements Serializable {

    private Partida[] partidasGuardadas = new Partida[4];
    private static ControladorPartidas singleton = null;
    File file;
    FileOutputStream fileOut;
    FileInputStream fileIn;
    ObjectOutputStream salida;
    ObjectInputStream entrada;

    /**
     * Metodo para crear el archivo de partidas guardadas
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private ControladorPartidas() throws IOException, ClassNotFoundException {
        file = new File("partidasGuardadas.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        fileOut = new FileOutputStream(file);
        salida = new ObjectOutputStream(fileOut);
        fileIn = new FileInputStream(file);
        entrada = new ObjectInputStream(fileIn);
        if (file.exists()) {
            partidasGuardadas = (Partida[]) entrada.readObject();
        }
    }

    /**
     * Metodo singleton del repositorio de partidas guardadas
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ControladorPartidas getSingleton() {
        if (singleton == null) {
            try {
                singleton = new ControladorPartidas();
            } catch (IOException ex) {
                Logger.getLogger(ControladorPartidas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorPartidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return singleton;
    }

    /**
     * Metodo para guardar las partidas junto con el indice
     *
     * @param indice
     * @param juego
     * @throws IOException
     */
    public void guardarPartida(int indice) throws IOException {
        partidasGuardadas[indice] = new Partida(ControladorPrincipal.getSingleton().getPJ(), ControladorMazmorra.getSingleton().getMazmorra(), ControladorPrincipal.getSingleton().getNivelActual());
        ControladorBBDD.getSingleton().guardarInfoPJ(ControladorPrincipal.getSingleton().getPJ());
        salida.writeObject(partidasGuardadas);
        salida.flush();
        fileOut.flush();
    }

    /**
     * Metodo para cargar las partidas guardadas
     *
     * @param indice
     * @return
     */
    public Partida cargarPartida(int indice) {
        return partidasGuardadas[indice];
    }

    /**
     * Metodo para tener la informacion de las partidas
     *
     * @return
     */
    public String[][] infoPartidas() {
        String[][] informacion = new String[4][3];
        for (int i = 0; i < informacion.length; i++) {
            informacion[i][0] = partidasGuardadas[i].getPj().getNombre();
            informacion[i][1] = Integer.toString(partidasGuardadas[i].getNivel());
            informacion[i][2] = partidasGuardadas[i].getFecha().toString();
        }
        return informacion;
    }

    public boolean existePartida(int indice) {
        if (partidasGuardadas[indice] != null) {
            return true;
        } else {
            return false;
        }
    }

}
