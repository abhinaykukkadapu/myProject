/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author abhinaykukkadapu
 */
public class DbConnection {
    
    private static Connection con=null;
     private DbConnection(){
        
    }
    static{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Employ", "emp",
                    "emp");
        } catch (Exception e) {
            System.out.println("Class not found " + e);
        }
        
    }
    
    public static Connection getConnection(){
        return con;
    }
    
   
}
