/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorBBDD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase del repositorio de partidas almacenadas
 * @author Manuel David Villalba Escamilla
 */
public class RepositorioPartidas implements Serializable{

    private Partida[] partidasGuardadas = new Partida[4];
    private static RepositorioPartidas singleton = null;
    File file;
    FileOutputStream fileOut;
    FileInputStream fileIn;
    ObjectOutputStream salida;
    ObjectInputStream entrada;

    /**
     * Metodo para crear el archivo de partidas guardadas
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private RepositorioPartidas() throws IOException, ClassNotFoundException {
        file = new File("partidasGuardadas.bin");
        if(!file.exists()) file.createNewFile();
        fileOut = new FileOutputStream(file);
        salida = new ObjectOutputStream(fileOut);
        fileIn = new FileInputStream(file);
        entrada = new ObjectInputStream(fileIn);
        if(file.exists()) partidasGuardadas = (Partida[]) entrada.readObject();
    }

    /**
     * Metodo singleton del repositorio de partidas guardadas
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public RepositorioPartidas getSingleton() throws IOException, ClassNotFoundException {
        if (singleton == null) {
            singleton = new RepositorioPartidas();
        }
        return singleton;
    }

    /**
     * Metodo para guardar las partidas junto con el indice
     * @param indice
     * @param juego
     * @throws IOException 
     */
    public void guardarPartida(int indice, Partida juego) throws IOException {
        partidasGuardadas[indice] = juego;
        ControladorBBDD.getSingleton().guardarInfoPJ(juego.getPj());
        salida.writeObject(partidasGuardadas);
    }

    /**
     * Metodo para cargar las partidas guardadas
     * @param indice
     * @return 
     */
    public Partida cargarPartida(int indice) {
        return partidasGuardadas[indice];
    }

    /**
     * Metodo para tener la informacion de las partidas
     * @return 
     */
    public String[][] infoPartidas(){
        String[][] informacion = new String[4][4];
        for(int i=0; i<informacion.length; i++){
            
        }
        return informacion;
    }

    
}
