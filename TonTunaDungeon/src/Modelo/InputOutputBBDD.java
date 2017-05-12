/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Inventario.Arma;
import Modelo.Inventario.Armadura;
import Modelo.Inventario.Objeto;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

//    public Personaje cargarPartida(int indice){
//        Personaje personaje = new Personaje();
//        try {
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
//        } catch (SQLException ex) {
//            Logger.getLogger(InputOutputBBDD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return personaje;
//    }
    public ArrayList obtenerInfoPartida() {
        ArrayList<String[]> lista = new ArrayList();
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select nombre, raza, nivel, fcreacion from pjcreado;");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                String[] info = new String[4];
                info[0] = rs.getString("nombre");
                info[1] = rs.getString("raza");
                info[2] = Integer.toString(Integer.parseInt(rs.getString("nivel") + 1));
                info[3] = rs.getString("fcreacion");
                lista.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputOutputBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
      
    public void borrarPartida(String[] info) {
        try {
            Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://"+variableIP+"/tontunadungeon", "root", "");
            PreparedStatement borrado1 = con1.prepareStatement("delete from inventarioOB where nombrePJ=\""+info[0]+"\" and razaPJ=\""+info[1]+"\";");
            borrado1.executeUpdate();
            con1.close();
            Connection con2 = (Connection) DriverManager.getConnection("jdbc:mysql://"+variableIP+"/tontunadungeon", "root", "");
            PreparedStatement borrado2 = con2.prepareStatement("delete from pjcreado where nombre=\""+info[0]+"\" and raza=\""+info[1]+"\";");
            borrado2.executeUpdate();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String[] cargarPartida(int indice) {
        String[] info = new String[10];
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from pjcreado;");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            for (int i = 0; i < indice; i++) {
                rs.next();
            }
            info[0] = rs.getString("nombre");
            info[1] = rs.getString("raza");
            info[2] = rs.getString("fuerza");
            info[3] = rs.getString("constitucion");
            info[4] = rs.getString("destreza");
            info[5] = rs.getString("intelecto");
            info[7] = rs.getString("nivel");
            info[8] = rs.getString("nombreAR");
            info[9] = rs.getString("nombreARDU");
            con.close();

            Connection con2 = (Connection) DriverManager.getConnection("jdbc:mysql://" + variableIP + "/tontunadungeon", "root", "");
            PreparedStatement consulta2 = con2.prepareStatement("select * from personaje where raza=\"" + info[1] + "\";");
            ResultSet rs2 = consulta2.executeQuery();
            rs2.next();
            info[6] = rs2.getString("descripcion");
            con2.close();
        } catch (SQLException ex) {
            Logger.getLogger(InputOutputBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
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
            for (int i = 0; i < (Dado.lanza(3)) - 1; i++) {
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

    public Arma obtenerArma(String nombre) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from arma where nombre=\"" + nombre + "\";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
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
     * @return
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
                case "dano":
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

    public ArrayList<Objeto> obtenerObjeto(String nombre, String raza) {
        ArrayList<Objeto> inventario = new ArrayList<Objeto>();
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from inventarioOB where nombrePJ=\"" + nombre + "\" and razaPJ=\"" + raza + "\";");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                try {
                    PreparedStatement consulta2 = con.prepareStatement("select * from objeto where nombre=\""+rs.getString("objeto")+"\";");
                    ResultSet rs2 = consulta2.executeQuery();
                    while (rs2.next()) {
                        int tipo = 0;
                        switch (rs2.getString("tipo")) {
                            case "curacion":
                                tipo = 1;
                                break;
                            case "apoyo":
                                tipo = 2;
                                break;
                            case "dano":
                                tipo = 3;
                                break;
                        }
                        Objeto objeto = new Objeto(rs2.getString("nombre"), rs2.getString("descripcion"), rs2.getInt("bonificador"), tipo);
                        inventario.add(objeto);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            con.close();
        } catch (SQLException e) {

            System.out.println(e);
        }
        return inventario;
    }

    /**
     * Metodo para obtener la armadura de la base de datos por nivel
     *
     * @param nivel
     * @return
     */
    public Armadura obtenerArmadura(int nivel) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from armadura where nivel=" + nivel + ";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            for (int i = 0; i < (Dado.lanza(2)) - 1; i++) {
                rs.next();
            }
            Armadura armadura = new Armadura(rs.getString("nombre"), Integer.parseInt(rs.getString("bonificador")), rs.getString("descripcion"));
            con.close();
            return armadura;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Metodo para obtener la armadura de la base de datos por nombre
     *
     * @param nombre
     * @return
     */
    public Armadura obtenerArmadura(String nombre) {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontunadungeon", "root", "");
            PreparedStatement consulta = con.prepareStatement("select * from armadura where nombre=\"" + nombre + "\";");
            ResultSet rs = consulta.executeQuery();
            rs.next();
            Armadura armadura = new Armadura(rs.getString("nombre"), Integer.parseInt(rs.getString("bonificador")), rs.getString("descripcion"));
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
            Armadura armadura = obtenerArmadura(nivel);
            Arma arma = obtenerArma(nivel);
            Monstruo monstruo = new Monstruo(fuerza, destreza, constitucion, intelecto, nombre, descripcion, armadura, arma);
            con.close();
            return monstruo;
        } catch (SQLException e) {
            return null;
        }
    }

}
