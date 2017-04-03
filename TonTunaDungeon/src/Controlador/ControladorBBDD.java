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
import Modelo.Personaje;
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

    private static ControladorBBDD singleton = null;

    private ControladorBBDD() {
    }

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
            System.out.println("SQL Exception: " + e.toString());
            return null;
        }
        return listaPersonajes;
    }

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
            System.out.println("SQL Exception: " + e.toString());
            return null;
        }
    }

    public Arma obtenerArma() throws SQLException {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from arma;");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < Dado.lanza(3); i++) {
                rs.next();
            }
            Arma nueva = new Arma(rs.getString("nombre"), Integer.parseInt(rs.getString("tipo")), Integer.parseInt(rs.getString("bonificador")), rs.getString("descripcion"));
            return nueva;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            return null;
        }
    }

//    public Objeto obtenerObjeto() throws SQLException{
//        PreparedStatement consulta = con.prepareStatement("select * from objeto where;");
//        ResultSet rs = consulta.executeQuery();
//        for(int i=0; i<Dado.lanza(50); i++) rs.next();
//        Objeto objeto = new Objeto();
//        return objeto;
//    }
    public Armadura obtenerArmadura() throws SQLException {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from armadura;");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < Dado.lanza(3); i++) {
                rs.next();
            }
            Armadura armadura = new Armadura(rs.getString("nombre"), Integer.parseInt(rs.getString("bonificador")), Integer.parseInt(rs.getString("indice")), rs.getString("descripcion"));
            return armadura;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            return null;
        }
    }

    public Monstruo obtenerMonstruo(int nivel) throws SQLException {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from monstruo where nivel = " + nivel + ";");
            ResultSet rs = consulta.executeQuery();
            for (int i = 0; i < Dado.lanza(5); i++) {
                rs.next();
            }
            int fuerza = Integer.parseInt(rs.getString("fuerza"));
            int destreza = Integer.parseInt(rs.getString("destreza"));
            int constitucion = Integer.parseInt(rs.getString("constitucion"));
            int intelecto = Integer.parseInt(rs.getString("intelecto"));
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            Armadura armadura = obtenerArmadura();
            Arma arma = obtenerArma();
            Monstruo monstruo = new Monstruo(fuerza, destreza, constitucion, intelecto, nombre, descripcion, armadura, arma);
            con.close();
            return monstruo;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            return null;
        }
    }

}
