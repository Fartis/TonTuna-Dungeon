/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
    
    private static Connection con ;
    
    public ControladorBBDD(){
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tontuna", "root","");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } 
    }
    
    public void accederBBDD(){
        
    }
    
}
