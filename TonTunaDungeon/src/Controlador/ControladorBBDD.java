/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import Modelo.Monstruo;
import Modelo.Personaje;
import com.mysql.jdbc.Connection;
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
    
    public void guardarInfoPJ(Personaje pj){
        
    }
    
    public void logroDesbloqueado(Logro logro){
        
    }
    
    
    
    public Personaje recuperarPJBase(){
        
    }
    
    public Arma obtenerArma(){
        Arma nueva = new Arma();
        return nueva;
    }
    
    public Objeto obtenerObjeto(){
        
    }
    
    public Armadura obtenerArmadura(){
        
    }
    
    public Monstruo obtenerMonstruo(){
        
    }
    
}
