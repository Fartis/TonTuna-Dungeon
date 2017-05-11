/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InputOutputBBDD;
import Modelo.Dado;
import Modelo.Monstruo;
import Modelo.Personaje;
import Vista.Elementos.VentanaCombate;
import Vista.Elementos.ImagenPanel;
import Vista.JFramePrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;

/**
 * Clase controla el combate de la aplicacion
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorCombate {

    
    private Monstruo monstruo = InputOutputBBDD.getSingleton().obtenerMonstruo(ControladorPrincipal.getSingleton().getNivelActual()+1);
    private Personaje personaje = ControladorPrincipal.getSingleton().getPJ();
    private int bonFuerza = 0, bonDestreza = 0, bonIntelecto = 0;
    private JFramePrincipal padrej;
    private boolean fin = false;
    

    public ControladorCombate() {
    }

    /**
     * Metodo establece el texto de las acciones de combate
     * @param texto 
     */
    public void accionAtaque( VentanaCombate texto) {
        int dado = Dado.lanza(2);
        if (dado == 0) {
            ataque(personaje.getArma().getTipo(), true, texto);
            ataque(monstruo.getArma().getTipo(), false, texto);
        } else {
            ataque(monstruo.getArma().getTipo(), false, texto);
            ataque(personaje.getArma().getTipo(), true, texto);
        }
    }

    /**
     * Metodo para establecer la accion ataque del combate
     *
     * @param atr
     * @param wep
     * @param obj
     * @param con
     * @param def
     * @param bon2
     * @param obj2
     * @return
     */
    private void ataque(int tipoArma, boolean objetivo, VentanaCombate texto) {
        if (objetivo) {
            int ataquePJ = 0;
            switch (tipoArma) {
                case 1:
                    ataquePJ = personaje.getFuerza() + bonFuerza;
                    break;
                case 2:
                    ataquePJ = personaje.getDestreza() + bonDestreza;
                    break;
                case 3:
                    ataquePJ = personaje.getIntelecto() + bonIntelecto;
                    break;
            }
            int daño = (ataquePJ + personaje.getArma().getBonificador() + Dado.lanza(10)) - (monstruo.getConstitucion() + monstruo.getArmadura().getBonificador() + Dado.lanza(10));
            if (daño <= 0) {
                daño = 1;
            }
            if (monstruo.getIndiceAr()<daño){
                daño = daño-monstruo.getIndiceAr();
                monstruo.setIndiceAr(0);
            }
            else{
                monstruo.setIndiceAr(monstruo.getIndiceAr()-daño);
            }
            monstruo.setVidaActual(monstruo.getVidaActual()- daño);
            texto.escribirTexto("Le has hecho: "+daño+" de daño");
        } else {
            int ataqueMon = 0;
            switch (tipoArma) {
                case 1:
                    ataqueMon = monstruo.getFuerza();
                    break;
                case 2:
                    ataqueMon = monstruo.getDestreza();
                    break;
                case 3:
                    ataqueMon = monstruo.getIntelecto();
                    break;
            }
            int daño = (ataqueMon + monstruo.getArma().getBonificador() + Dado.lanza(10)) - (personaje.getConstitucion() + personaje.getArmadura().getBonificador() + Dado.lanza(10));
            if (daño <= 0) {
                daño = 1;
            }
            personaje.setVidaActual(personaje.getVidaActual() - daño);
            texto.escribirTexto(monstruo.getNombre()+" te ha hecho: "+daño+" de daño");
        }
        if(!fin) comprobarFin(texto);
    }
    
    /**
     * Metodo para comprobar si el combate ha finalizado
     */
    private void comprobarFin(VentanaCombate padre){
        if(personaje.getVidaActual()<=0){
            CombatePerdido perder = new CombatePerdido(padrej);
            padre.dispose();
            ControladorGUI.getSingleton().finalizarJuego();
            this.fin = true;
        }
        if(monstruo.getVidaActual()<=0){
            CombateGanado ganar = new CombateGanado(padrej);
            padre.dispose();
            ControladorGUI.getSingleton().finalizarCombate();
            this.fin = true;
        }
    }
    
    public int vidaPJActual(){
        return personaje.getVidaActual();
    }
    
    public int vidaPJTotal(){
        return personaje.getVidaTotal();
    }
    
    public int vidaMONActual(){
        return monstruo.getVidaActual();
    }
    
    public int vidaMONTotal(){
        return monstruo.getVida();
    }

    public String indiceMONActual() {
        return Integer.toString(monstruo.getIndiceAr());
    }

    public String indiceMONTotal() {
        return Integer.toString(monstruo.getArmadura().getIndiceArmadura());
    }

    public String getMonNombre() {
        return monstruo.getNombre();
    }

    public String indicePJActual() {
        return Integer.toString(personaje.getIndiceAr());
    }

    public String indicePJTotal() {
        return Integer.toString(personaje.getArmadura().getIndiceArmadura());
    }
    
    private class CombateGanado extends JDialog {
        JFramePrincipal padre;
        ImagenPanel panel;
        public CombateGanado(JFramePrincipal padre) {
            super(padre, true);
            boolean pulsado = false;
            this.setLayout(null);
            this.padre = padre;
            this.setBounds(0, 0, 400, 280);
            panel= new ImagenPanel(400, 280, "src/Recursos/victoria.gif");
            panel.setBounds(0, 0, 400, 280);
            panel.setBackground(new Color(124, 124, 124, 255));
            this.add(panel);
            panel.setVisible(true);
            setVisible(true);
            
        } 
    }
    
    private class CombatePerdido extends JDialog {
        JFramePrincipal padre;
        ImagenPanel panel;
        public CombatePerdido(JFramePrincipal padre) {
            super(padre, true);
            boolean pulsado = false;
            this.setLayout(null);
            this.padre = padre;
            this.setBounds(0, 0, 400, 280);
            panel= new ImagenPanel(400, 280, "src/Recursos/youdied.gif");
            panel.setBounds(0, 0, 400, 280);
            panel.setBackground(new Color(124, 124, 124, 255));
            this.add(panel);
            panel.setVisible(true);
            setVisible(true);
            
        }
    }

}
