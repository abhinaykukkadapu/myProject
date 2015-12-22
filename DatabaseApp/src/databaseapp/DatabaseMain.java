/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;

import java.util.List;

/**
 *
 * @author abhinaykukkadapu
 */
public class DatabaseMain {
    public static void main(String[] args) {
        try {
            
            DbHelper helper = new DbHelper();
            
            // add employee flow
            Employee emp = new Employee();
            emp.setEmpId(12345);
            emp.setEmpName("Abhinay");
            emp.setEmpSalary(2231234);
            helper.addEmploy(emp);
            
            // retrieve employee-- the one added above
            Employee emp1 = helper.getEmployById(emp.getEmpId());
            System.out.println(emp1);
            
            // deleting the added employee
            helper.deleteEmploy(emp.getEmpId());
            
            
            // retreive the existing employees in datablse
            List<Employee> employList = helper.getALlEmploys();
            for(Employee e: employList){
                System.out.println(e);
            }
            
            // delete the employee which is not there
            helper.deleteEmploy(123456);
            
            // this will not execute as exception is thrown in the previous line
            helper.getALlEmploys();
            
        } catch (EmployNotFoundException ex) {
            //Logger.getLogger(DatabaseApp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

    }
}
