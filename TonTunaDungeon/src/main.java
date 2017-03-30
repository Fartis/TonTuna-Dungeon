
import Controlador.ControladorBBDD;
import Modelo.Monstruo;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel David Villalba Escamilla.
 */
public class main {
    public static void main(String[]args) throws SQLException{
        System.out.println("hola");
        ControladorBBDD controladorBBDD = new ControladorBBDD();
        System.out.println("hola");
        Monstruo monstruo =  controladorBBDD.obtenerMonstruo(2);
        System.out.println(monstruo);
    }
}
