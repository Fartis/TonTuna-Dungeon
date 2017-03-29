/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import Modelo.Logro;
import Modelo.Monstruo;
import Modelo.Personaje;
import Modelo.RepositorioPartidas;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorBBDD {
    
    private static Connection con ;
    
    public ControladorBBDD(){
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontuna", "root","");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } 
    }
    
    public static void logroDesbloqueado(Logro logro){
        
    }
       
        
    public static void guardarInfoPJ(Personaje pj){
        
    }
    
    public static Personaje recuperarPJBase(){
        Personaje pj = new Personaje();
        return pj;
    }
    
    public static Arma obtenerArma(){
        Arma nueva = new Arma();
        return nueva;
    }
    
    public static Objeto obtenerObjeto(){
        Objeto objeto = new Objeto();
        return objeto;
    }
    
    public static Armadura obtenerArmadura(){
        Armadura armadura = new Armadura();
        return armadura;
    }
    
    public static Monstruo obtenerMonstruo(){
        Monstruo monstruo = new Monstruo();
        return monstruo;
    }
    
}
