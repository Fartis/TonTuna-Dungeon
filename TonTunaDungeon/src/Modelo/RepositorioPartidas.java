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
 *
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

    private RepositorioPartidas() throws IOException, ClassNotFoundException {
        file = new File("partidasGuardadas.bin");
        if(!file.exists()) file.createNewFile();
        fileOut = new FileOutputStream(file);
        salida = new ObjectOutputStream(fileOut);
        fileIn = new FileInputStream(file);
        entrada = new ObjectInputStream(fileIn);
        if(file.exists()) partidasGuardadas = (Partida[]) entrada.readObject();
    }

    public RepositorioPartidas getSingleton() throws IOException, ClassNotFoundException {
        if (singleton == null) {
            singleton = new RepositorioPartidas();
        }
        return singleton;
    }

    public void guardarPartida(int indice, Partida juego) throws IOException {
        partidasGuardadas[indice] = juego;
        ControladorBBDD.getSingleton().guardarInfoPJ(juego.getPj());
        salida.writeObject(partidasGuardadas);
    }

    public Partida cargarPartida(int indice) {
        return partidasGuardadas[indice];
    }

    public String[][] infoPartidas(){
        String[][] informacion = new String[4][4];
        for(int i=0; i<informacion.length; i++){
            
        }
        return informacion;
    }

    
}
