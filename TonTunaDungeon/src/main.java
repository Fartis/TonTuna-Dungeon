
import Controlador.ControladorBBDD;
import Modelo.Monstruo;
import Modelo.Personaje;
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
    public static void main(String[]args) throws SQLException, ClassNotFoundException{
        ControladorBBDD controladorBBDD = ControladorBBDD.getSingleton();
        Monstruo monstruo =  controladorBBDD.obtenerMonstruo(2);
        System.out.println(monstruo);
        Personaje personaje = controladorBBDD.crearPJBase("Federico","Humano");
        System.out.println(personaje);
        controladorBBDD.guardarInfoPJ(personaje);
    }
}
