/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dado;
import Modelo.Monstruo;
import Modelo.Personaje;

/**
 * Clase controla el combate de la aplicacion
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorCombate {

    private Monstruo monstruo;
    private Personaje personaje;
    private int bonFuerza = 0, bonDestreza = 0, bonIntelecto = 0;

    public void Combate(Monstruo monster, Personaje pj) {
        this.personaje = pj;
        this.monstruo = monster;
    }

    public void accionAtaque() {
        int dado = Dado.lanza(2);
        if (dado == 0) {
            ataque(personaje.getArma().getTipo(), true);
            ataque(monstruo.getArma().getTipo(), false);
        } else {
            ataque(monstruo.getArma().getTipo(), false);
            ataque(personaje.getArma().getTipo(), true);
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
    private void ataque(int tipoArma, boolean objetivo) {
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
            monstruo.setVida(monstruo.getVida() - daño);
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
        }
    }

}
