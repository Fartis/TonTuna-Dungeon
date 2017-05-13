/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * Clase para gestionar las canciones del juego
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Jose Gonzalez Rodriguez
 */
public class ReproductorMusica {

    private static ReproductorMusica singleton = null;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private AdvancedPlayer player;
    private boolean loop;
    private Thread musica;

    private void ReproductorMusica() {

    }

    /**
     * Metodo getSingleton.
     *
     * @return ReproductorMusica
     */
    public static ReproductorMusica getSingleton() {
        if (singleton == null) {
            singleton = new ReproductorMusica();
        }
        return singleton;
    }

    /**
     * Metodo playMusica, le mandas una url o dirección de un archivo de musica
     * mp3 y lo reproduce.
     *
     * @param urlMusica String de la direccion de la musica
     */
    public void playMusica(final String urlMusica) {
        loop = true;

        musica = new Thread() {
            public void run() {
                try {
                    do {
                        fis = new FileInputStream(urlMusica);
                        bis = new BufferedInputStream(fis);
                        player = new AdvancedPlayer(bis);
                        player.play();
                    } while (loop);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ReproductorMusica.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(ReproductorMusica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        musica.start();

    }

    /**
     * Metodo pararMusica, si esta reproduciendo un archivo de musica lo
     * interrumpe.
     */
    public void pararMusica() {
        if (player != null) {
            player.close();
            player = null;
            musica.stop(); //Utilizamos un metodo deprecado porque no hay alternativas.
        }
        loop = false;
    }

}
