/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhinaykukkadapu
 */
public class DatabaseApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DbHelper helper = new DbHelper();
            Employee emp = new Employee();
             Employee emp1 = new Employee();
            emp.setEmpId(12345);
            emp.setEmpName("Abhinay");
            emp.setEmpSalary(2231234);
            helper.addEmploy(emp);
            helper.deleteEmploy(emp.getEmpId());
            helper.getALlEmploys();
            helper.deleteEmploy(123456);
            helper.getALlEmploys();
            emp1 = helper.getEmployById(emp.getEmpId());
            /*System.out.println("There are " + no_of_rows
            + " record in the table");
            String sort = "Select empID from employee order by empID desc";
            ResultSet rs1 = stmt.executeQuery(sort);
            rs1.next();
            int eid = rs1.getInt("empID");
            eid++;
            
            
            // insert flow
            String sql = "INSERT INTO employee VALUES ("+eid+", 'Karthik', 25982)";
            int executeUpdate = stmt.executeUpdate(sql);
            if(executeUpdate == 1){
            System.out.println("DB Updated");
            
            }
            } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
            }*/
        } catch (EmployNotFoundException ex) {
            //Logger.getLogger(DatabaseApp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception raised");
        }

    }

}
