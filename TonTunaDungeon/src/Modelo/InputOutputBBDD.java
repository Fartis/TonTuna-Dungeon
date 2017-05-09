/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase controladora de la base de datos del juego
 *
 * @author Manuel David Villalba Escamilla
 */
public class InputOutputBBDD {

    private static InputOutputBBDD singleton = null;
    private static String variableIP = "localhost";

    private InputOutputBBDD() {
    }

    /**
     * metodo singleton para el controlador
     *
     * @return
     */
    public static InputOutputBBDD getSingleton() {
        if (singleton == null) {
            singleton = new InputOutputBBDD();
        }
        return singleton;
    }

    /**
     * Metodo para guardar la informacion del personaje en la base de datos para
     * recuperarla y continuar con la partida
     *
     * @param pj
     */
    public void guardarInfoPJ(Personaje pj) {
        boolean inventario = false;
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
            PreparedStatement insertar = con.prepareStatement("insert into pjcreado (nombre, raza, nivel, fuerza, destreza, intelecto, constitucion, nombreAR, nombreARDU) values (?,?,?,?,?,?,?,?,?);");
            insertar.setString(1, pj.getNombre());
            insertar.setString(2, pj.getRaza());
            insertar.setString(3, Integer.toString(pj.getNivel()));
            insertar.setString(4, Integer.toString(pj.getFuerza()));
            insertar.setString(5, Integer.toString(pj.getDestreza()));
            insertar.setString(6, Integer.toString(pj.getIntelecto()));
            insertar.setString(7, Integer.toString(pj.getConstitucion()));
            insertar.setString(8, pj.getArma().getNombre());
            insertar.setString(9, pj.getArmadura().getNombre());
            insertar.executeUpdate();
            con.close();
            inventario = true;
        } catch (SQLException e) {
            try {
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
                PreparedStatement insertar = con.prepareStatement("update pjcreado"
                        + " set fuerza=" + pj.getFuerza()
                        + ", intelecto=" + pj.getIntelecto()
                        + ", constitucion=" + pj.getConstitucion()
                        + ", destreza=" + pj.getDestreza()
                        + ", nivel=" + pj.getNivel()
                        + ", nombreAR=\"" + pj.getArma().getNombre()
                        + "\", nombreARDU=\"" + pj.getArmadura().getNombre()
                        + "\" where nombre=\"" + pj.getNombre()
                        + "\" and raza=\"" + pj.getRaza() + "\";");
                insertar.executeUpdate();
                con.close();
                inventario = true;
            } catch (SQLException ex) {
                Logger.getLogger(InputOutputBBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (inventario) {
            try {
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
                PreparedStatement borrar1 = con.prepareStatement("delete from inventarioar where nombrepj=\"" + pj.getNombre() + "\" and razapj=\"" + pj.getRaza() + "\";");
                borrar1.executeUpdate();
                PreparedStatement borrar2 = con.prepareStatement("delete from inventarioardu where nombrepj=\"" + pj.getNombre() + "\" and razapj=\"" + pj.getRaza() + "\";");
                borrar2.executeUpdate();
                PreparedStatement borrar3 = con.prepareStatement("delete from inventarioob where nombrepj=\"" + pj.getNombre() + "\" and razapj=\"" + pj.getRaza() + "\";");
                borrar3.executeUpdate();
                for (int i = 0; i < pj.getInventarioObjeto().size(); i++) {
                    PreparedStatement insertar = con.prepareStatement("insert into inventarioob(nombrepj, razapj, objeto) values (?,?,?);");
                    insertar.setString(1, pj.getNombre());
                    insertar.setString(2, pj.getRaza());
                    insertar.setString(3, pj.getInventarioObjeto().get(i).getNombre());
                    insertar.executeUpdate();
                }
                for (int i = 0; i < pj.getInventarioArma().size(); i++) {
                    PreparedStatement insertar = con.prepareStatement("insert into inventarioar(nombrepj, razapj, arma) values (?,?,?);");
                    insertar.setString(1, pj.getNombre());
                    insertar.setString(2, pj.getRaza());
                    insertar.setString(3, pj.getInventarioArma().get(i).getNombre());
                    insertar.executeUpdate();
                }
                for (int i = 0; i < pj.getInventarioArmadura().size(); i++) {
                    PreparedStatement insertar = con.prepareStatement("insert into inventarioardu(nombrepj, razapj, armadura) values (?,?,?);");
                    insertar.setString(1, pj.getNombre());
                    insertar.setString(2, pj.getRaza());
                    insertar.setString(3, pj.getInventarioArmadura().get(i).getNombre());
                    insertar.executeUpdate();
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InputOutputBBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para listar los personajes de la base de datos
     *
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
     *
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
     *
     * @return
     * @throws SQLException
     */
    public Arma obtenerArma(int nivel) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from arma where nivel=" + nivel + ";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            for (int i = 0; i < (Dado.lanza(3) * nivel) - 1; i++) {
                rs.next();
            }
            int tipo = 0;
            switch (rs.getString("atributo")) {
                case "fuerza":
                    tipo = 1;
                    break;
                case "destreza":
                    tipo = 2;
                    break;
                case "intelecto":
                    tipo = 3;
                    break;
            }
            Arma nueva = new Arma(rs.getString("nombre"), tipo, Integer.parseInt(rs.getString("bonificador")), rs.getString("descripcion"));
            con.close();
            return nueva;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Metodo para obtener un objeto de la base de datos
     *
     * @param nivel
     * @return
     * @throws SQLException
     */
    public Objeto obtenerObjeto() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from objeto;");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            for (int i = 0; i < Dado.lanza(12) - 1; i++) {
                rs.next();
            }
            int tipo = 0;
            switch (rs.getString("tipo")) {
                case "curacion":
                    tipo = 1;
                    break;
                case "apoyo":
                    tipo = 2;
                    break;
                case "daño":
                    tipo = 3;
                    break;
            }
            Objeto objeto = new Objeto(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("bonificador"), tipo);
            con.close();
            return objeto;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Metodo para obtener la armadura de la base de datos
     *
     * @param nivel
     * @return
     * @throws SQLException
     */
    public Armadura obtenerArmadura(int nivel) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from armadura where nivel=" + nivel + ";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            for (int i = 0; i < (Dado.lanza(2) * nivel) - 1; i++) {
                rs.next();
            }
            Armadura armadura = new Armadura(rs.getString("nombre"), Integer.parseInt(rs.getString("bonificador")), Integer.parseInt(rs.getString("indice")), rs.getString("descripcion"));
            con.close();
            return armadura;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * metodo obtener la informacion de monstruo de la base de datos
     *
     * @param nivel
     * @return
     * @throws SQLException
     */
    public Monstruo obtenerMonstruo(int nivel) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from monstruo where nivel = " + nivel + ";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            for (int i = 0; i < Dado.lanza(5) - 1; i++) {
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
