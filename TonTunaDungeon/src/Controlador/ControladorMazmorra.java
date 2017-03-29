/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dado;
import Modelo.Habitacion;
import java.util.ArrayList;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorMazmorra {
    private final ArrayList<Habitacion[][]> mazmorra;
    private Habitacion[][] piso;
    int nivelPiso=0;

    public ControladorMazmorra() {
        this.mazmorra = new ArrayList();
    }
    
    private void generarPiso(){
        piso = new Habitacion[10][10];
        rellenarBorde();
        
        mazmorra.add(piso);
    }
    

    private void rellenarBorde(){        
        piso[0][0]=new Habitacion(false);
        piso[1][0]=new Habitacion(false);
        piso[2][0]=new Habitacion(false);
        piso[3][0]=new Habitacion(false);
        piso[4][0]=new Habitacion(false);
        piso[5][0]=new Habitacion(false);
        piso[6][0]=new Habitacion(false);
        piso[7][0]=new Habitacion(false);
        piso[8][0]=new Habitacion(false);
        piso[9][0]=new Habitacion(false);
        piso[0][1]=new Habitacion(false);
        piso[0][2]=new Habitacion(false);
        piso[0][3]=new Habitacion(false);
        piso[0][4]=new Habitacion(false);
        piso[0][5]=new Habitacion(false);
        piso[0][6]=new Habitacion(false);
        piso[0][7]=new Habitacion(false);
        piso[0][8]=new Habitacion(false);
        piso[0][9]=new Habitacion(false);
        piso[1][9]=new Habitacion(false);
        piso[2][9]=new Habitacion(false);
        piso[3][9]=new Habitacion(false);
        piso[4][9]=new Habitacion(false);
        piso[5][9]=new Habitacion(false);
        piso[6][9]=new Habitacion(false);
        piso[7][9]=new Habitacion(false);
        piso[8][9]=new Habitacion(false);
        piso[9][9]=new Habitacion(false);
        piso[9][1]=new Habitacion(false);
        piso[9][2]=new Habitacion(false);
        piso[9][3]=new Habitacion(false);
        piso[9][4]=new Habitacion(false);
        piso[9][5]=new Habitacion(false);
        piso[9][6]=new Habitacion(false);
        piso[9][7]=new Habitacion(false);
        piso[9][8]=new Habitacion(false);
    }
}
