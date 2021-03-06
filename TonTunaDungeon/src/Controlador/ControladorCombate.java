/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InputOutputBBDD;
import Modelo.Dado;
import Modelo.Inventario.Objeto;
import Modelo.Monstruo;
import Modelo.Personaje;
import Vista.Elementos.VentanaCombate;
import Vista.Elementos.ImagenPanel;
import Vista.JFramePrincipal;
import java.awt.Color;
import javax.swing.JDialog;

/**
 * Clase controla el combate de la aplicacion
 *
 * @author Manuel David Villalba Escamilla
 * @author Victor Manuel Gonzalez Rodriguez
 * @author Alberto Gonzalez Rodriguez
 */
public class ControladorCombate {

    
    private Monstruo monstruo = InputOutputBBDD.getSingleton().obtenerMonstruo(ControladorPrincipal.getSingleton().getNivelActual()+1);
    private Personaje personaje = ControladorPrincipal.getSingleton().getPJ();
    private int bonFuerza = 0, bonDestreza = 0, bonIntelecto = 0;
    private JFramePrincipal padrej;
    private boolean fin = false;
    
    /**
     * Constructor clase ControladorCombate
     */
    public ControladorCombate() {
    }

    /**
     * Método establece el texto de las acciones de combate
     * @param texto Instancia de VentanaCombate que ha creado el controlador.
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
     * Método ataque, este hace que el personaje o el monstruo resulte afectado por un ataque.
     * @param tipoArma Indica que tipo de arma ataca; 1 = Fuerza, 2 = Destreza, 3 = Intelecto.
     * @param objetivo Booleano para indicar quien ataca; true = personaje, false = monstruo
     * @param texto Instancia de VentanaCombate para añadir el texto del resultado.
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
     * Método usarObjeto, este metodo permite utilizar un objeto por parte del personaje.
     * @param indice Indica que objeto utiliza de la lista del inventario.
     * @param consumir Booleano que indica si el objeto se consume o permanece en el inventario; true = desaparece, false = se mantiene.
     * @param texto Instancia de VentanaCombate para añadir el texto del resultado.
     */
    public void usarObjeto(int indice, boolean consumir, VentanaCombate texto) {
        Objeto objeto = personaje.usarObjeto(indice, consumir);
        switch(objeto.getTipo()){
            case 1:
                personaje.setVidaActual(personaje.getVidaActual()+objeto.getValor());
                
                texto.escribirTexto("Has usado "+objeto.getNombre()+" y te has recuperado "+objeto.getValor()+" puntos de vitalidad.");
                break;
            case 2:
                if( objeto.getNombre().contains("Fuerza")){
                    bonFuerza = objeto.getValor();
                }
                if( objeto.getNombre().contains("Destreza")){
                    bonDestreza = objeto.getValor();
                }
                if( objeto.getNombre().contains("Intelecto")){
                    bonIntelecto = objeto.getValor();
                }                
                texto.escribirTexto("Has usado "+objeto.getNombre()+".");
                break;
            case 3: 
                monstruo.setVidaActual(monstruo.getVidaActual()- objeto.getValor());
                texto.escribirTexto("Le has hecho: "+objeto.getValor()+" de daño");
                if(!fin) comprobarFin(texto);
                break;
        }
    }
    
    /**
     * Metodo que comprueba si el personaje o el monstruo tiene vida igual o inferior a 0 para finalizar el combate.
     * @param padre Instancia de VentanaCombate para mostrar el resultado en él.
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
    
    /**
     * Método que retorna la vida actual del personaje.
     * @return int vidaPJActual
     */
    public int vidaPJActual(){
        return personaje.getVidaActual();
    }
    
    /**
     * Método que retorna la vida total del personaje.
     * @return int vidaPJTotal
     */
    public int vidaPJTotal(){
        return personaje.getVidaTotal();
    }
    
    /**
     * Método que retorna la vida actual del monstruo.
     * @return int vidaMONActual
     */
    public int vidaMONActual(){
        return monstruo.getVidaActual();
    }
    
    /**
     * Método que retorna la vida total del monstruo.
     * @return int vidaMONTotal
     */
    public int vidaMONTotal(){
        return monstruo.getVida();
    }

    /**
     * Método que retorna el nombre del monstruo generado para el combate.
     * @return String MonstruoNombre
     */
    public String getMonNombre() {
        return monstruo.getNombre();
    }
    
    /**
     * Inner Class ComabateGanado, es una clase hija de JDialog que muestra el resultado del combate a favor de la vitoria.
     */
    private class CombateGanado extends JDialog {
        private JFramePrincipal padre;
        private ImagenPanel panel;
        
        /**
         * Constructor de la clase CombateGanado
         * @param padre Instancia del JFramePrincipal que contiene a VentanaCombate para finalizar el combate.
         */
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
    
    /**
     * Inner Class ComabatePerdido, es una clase hija de JDialog que muestra el resultado del combate a favor de la derrota.
     */
    private class CombatePerdido extends JDialog {
        private JFramePrincipal padre;
        private ImagenPanel panel;
        
        /**
         * Constructor de la clase CombatePerdido
         * @param padre Instancia del JFramePrincipal que contiene a VentanaCombate para finalizar el combate.
         */
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
