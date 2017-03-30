/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dado;
import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Monstruo;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorBBDD {
    
    private Connection con ;
    
    public ControladorBBDD(){
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.105/tontuna", "root","");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } 
    }
    
//    public void logroDesbloqueado(Logro logro){
//        
//    }
//       
//        
//    public void guardarInfoPJ(Personaje pj){
//        
//    }
    
//    public Personaje recuperarPJBase(){
//        Personaje pj = new Personaje();
//        return pj;
//    }
    
    public Arma obtenerArma() throws SQLException{
        PreparedStatement consulta = con.prepareStatement("select * from arma;");
        ResultSet rs = consulta.executeQuery();
        for(int i=0; i<Dado.lanza(3); i++) rs.next();
        Arma nueva = new Arma(rs.getString("nombre"), Integer.parseInt(rs.getString("tipo")), Integer.parseInt(rs.getString("bonificador")), rs.getString("descripcion"));
        return nueva;
    }
    
//    public Objeto obtenerObjeto() throws SQLException{
//        PreparedStatement consulta = con.prepareStatement("select * from objeto where;");
//        ResultSet rs = consulta.executeQuery();
//        for(int i=0; i<Dado.lanza(50); i++) rs.next();
//        Objeto objeto = new Objeto();
//        return objeto;
//    }
    
    public Armadura obtenerArmadura() throws SQLException{
        PreparedStatement consulta = con.prepareStatement("select * from armadura;");
        ResultSet rs = consulta.executeQuery();
        for(int i=0; i<Dado.lanza(3); i++) rs.next();
        Armadura armadura = new Armadura(rs.getString("nombre"), Integer.parseInt(rs.getString("bonificador")), Integer.parseInt(rs.getString("indice")), rs.getString("descripcion"));
        return armadura;
    }
    
    public Monstruo obtenerMonstruo(int nivel) throws SQLException{
        PreparedStatement consulta = con.prepareStatement("select * from monstruo where nivel = "+nivel+";");
        ResultSet rs = consulta.executeQuery();
        System.out.println("hola");
        for(int i=0; i<Dado.lanza(5); i++) rs.next();
        int fuerza=Integer.parseInt(rs.getString("fuerza"));
        int destreza=Integer.parseInt(rs.getString("fuerza"));
        int constitucion=Integer.parseInt(rs.getString("fuerza"));
        int intelecto=Integer.parseInt(rs.getString("fuerza"));
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Armadura armadura = obtenerArmadura();
        Arma arma = obtenerArma();        
        Monstruo monstruo = new Monstruo(fuerza,destreza,constitucion,intelecto,nombre,descripcion,armadura,arma);
        System.out.println(monstruo);
        return monstruo;
    }
    
}
