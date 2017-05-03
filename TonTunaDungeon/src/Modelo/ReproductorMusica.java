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
import javazoom.jl.player.Player;

/**
 * Clase para gestionar las canciones del juego
 *
 * @author Manuel David Villalba Escamilla
 */
public class ReproductorMusica {

    private static ReproductorMusica singleton = null;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private Player player;
    private boolean loop = true;

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
     * @param urlMusica
     */
    public void playMusica(String urlMusica) {
        try {
            fis = new FileInputStream(urlMusica);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReproductorMusica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(ReproductorMusica.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Thread() {
            public void run() {
                try {
                    player.play();
                    do {
                        if (player.isComplete()) {
                            pararMusica();
                            playMusica(urlMusica);
                        }
                    } while (loop);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
        
        
    }

    /**
     * Metodo pararMusica, si esta reproduciendo un archivo de musica lo
     * interrumpe.
     */
    public void pararMusica() {
        if (player != null) {
            player.close();
        }
    }

}
