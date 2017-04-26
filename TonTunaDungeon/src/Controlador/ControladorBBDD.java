/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dado;
import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import Modelo.Monstruo;
import Modelo.Personaje;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase controladora de la base de datos del juego
 * @author Manuel David Villalba Escamilla
 */
public class ControladorBBDD {

    private static ControladorBBDD singleton = null;

    private ControladorBBDD() {
    }

    /**
     * metodo singleton para el controlador
     * @return 
     */
    public static ControladorBBDD getSingleton() {
        if (singleton == null) {
            singleton = new ControladorBBDD();
        }
        return singleton;
    }

//    public void logroDesbloqueado(Logro logro){
//        
//    }
//       
//   
    
    
    /**
     * Metodo para guardar la informacion del personaje en la base de datos
     * @param pj 
     */
    public void guardarInfoPJ(Personaje pj) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement insertar = con.prepareStatement("insert into pjcreado (nombre, raza, nivel, fuerza, destreza, intelecto, constitucion) values (?,?,?,?,?,?,?);");
            insertar.setString(1, pj.getNombre());
            insertar.setString(2, pj.getRaza());
            insertar.setString(3, Integer.toString(pj.getNivel()));
            insertar.setString(4, Integer.toString(pj.getFuerza()));
            insertar.setString(5, Integer.toString(pj.getDestreza()));
            insertar.setString(6, Integer.toString(pj.getIntelecto()));
            insertar.setString(7, Integer.toString(pj.getConstitucion()));
            insertar.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para listar los personajes de la base de datos
     * @return 
     */
    public Personaje[] listaPersonajesBase() {
        Personaje[] listaPersonajes = new Personaje[4];
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from personaje;");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < listaPersonajes.length; i++) {
                rs.next();
                int fuerza = Integer.parseInt(rs.getString("fuerza"));
                int destreza = Integer.parseInt(rs.getString("destreza"));
                int constitucion = Integer.parseInt(rs.getString("constitucion"));
                int intelecto = Integer.parseInt(rs.getString("intelecto"));
                String descripcion = rs.getString("descripcion");
                listaPersonajes[i] = new Personaje("temporal", rs.getString("raza"), fuerza, constitucion, destreza, intelecto, descripcion, 1);
            }
            con.close();
        } catch (SQLException e) {
            return null;
        }
        return listaPersonajes;
    }

    /**
     * Metodo para crear el personaje en la base de datos
     * @param nombre
     * @param raza
     * @return 
     */
    public Personaje crearPJBase(String nombre, String raza) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from personaje where raza = \"" + raza + "\";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            int fuerza = Integer.parseInt(rs.getString("fuerza"));
            int destreza = Integer.parseInt(rs.getString("destreza"));
            int constitucion = Integer.parseInt(rs.getString("constitucion"));
            int intelecto = Integer.parseInt(rs.getString("intelecto"));
            String descripcion = rs.getString("descripcion");
            Personaje personaje = new Personaje(nombre, rs.getString("raza"), fuerza, constitucion, destreza, intelecto, descripcion, 1);
            con.close();
            return personaje;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Metodo para obtener el arma de la base de datos
     * @return
     * @throws SQLException 
     */
    public Arma obtenerArma(int nivel) throws SQLException {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from arma;");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < Dado.lanza(6)*nivel; i++) {
                rs.next();
            }
            Arma nueva = new Arma(rs.getString("nombre"), Integer.parseInt(rs.getString("tipo")), Integer.parseInt(rs.getString("bonificador")), rs.getString("descripcion"));
            return nueva;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Metodo para obtener un objeto de la base de datos
     * @param nivel
     * @return
     * @throws SQLException 
     */
    public Objeto obtenerObjeto() throws SQLException{
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
        PreparedStatement consulta = con.prepareStatement("select * from objeto;");
        ResultSet rs = consulta.executeQuery();
        rs.next();
        for(int i=0; i<Dado.lanza(12)-1; i++){
            rs.next();
        }
        int tipo=0;
        switch(rs.getString("tipo")){
            case "curacion":
                tipo=1;
                break;
            case "apoyo":
                tipo=2;
                break;
            case "daño":
                tipo=3;
                break;
        }
        Objeto objeto = new Objeto(rs.getString("nombre"),rs.getString("descripcion"), rs.getInt("bonificador"), tipo);
        return objeto;
    }
    
    /**
     * Metodo para obtener la armadura de la base de datos
     * @param nivel
     * @return
     * @throws SQLException 
     */
    public Armadura obtenerArmadura(int nivel) throws SQLException {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from armadura;");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < Dado.lanza(2)*nivel; i++) {
                rs.next();
            }
            Armadura armadura = new Armadura(rs.getString("nombre"), Integer.parseInt(rs.getString("bonificador")), Integer.parseInt(rs.getString("indice")), rs.getString("descripcion"));
            return armadura;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * metodo obtener la informacion de monstruo de la base de datos
     * @param nivel
     * @return
     * @throws SQLException 
     */
    public Monstruo obtenerMonstruo(int nivel) throws SQLException {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from monstruo where nivel = " + nivel + ";");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < Dado.lanza(5)-1; i++) {
                rs.next();
            }
            int fuerza = Integer.parseInt(rs.getString("fuerza"));
            int destreza = Integer.parseInt(rs.getString("destreza"));
            int constitucion = Integer.parseInt(rs.getString("constitucion"));
            int intelecto = Integer.parseInt(rs.getString("intelecto"));
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            Armadura armadura = obtenerArmadura(Dado.lanza(nivel));
            Arma arma = obtenerArma(Dado.lanza(nivel));
            Monstruo monstruo = new Monstruo(fuerza, destreza, constitucion, intelecto, nombre, descripcion, armadura, arma);
            con.close();
            return monstruo;
        } catch (SQLException e) {
            return null;
        }
    }

}
