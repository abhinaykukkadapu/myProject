/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhinaykukkadapu
 */
public class DbHelper {

    public List<Employee> getALlEmploys() {

        List<Employee> employList = new ArrayList<Employee>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();

            // retrieval flow
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            int empId;
            String empName;
            double empSalary;
            while (rs.next()) {
                empId = rs.getInt("empID");
                empName = rs.getString("empName");
                empSalary = rs.getDouble("empSalary");
               // System.out.println("empid :" + empId + "empname :" + empName + "empSalary :" + empSalary);
                Employee emp = new Employee();
                emp.setEmpId(empId);
                emp.setEmpName(empName);
                emp.setEmpSalary(empSalary);
                employList.add(emp);
            }
        } catch (Exception ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employList;
    }

    public Employee getEmployById(int empl) throws EmployNotFoundException {
        Employee emp = null;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();

            // retrieval flow
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee where empID =" + empl);
            int empId;
            String empName;
            double empSalary;
            if (rs.next()) {
                empId = rs.getInt("empID");
                empName = rs.getString("empName");
                empSalary = rs.getDouble("empSalary");
                //System.out.println("empid :" + empId + "empname :" + empName + "empSalary :" + empSalary);
                emp = new Employee();
                emp.setEmpId(empId);
                emp.setEmpName(empName);
                emp.setEmpSalary(empSalary);

            } else {
                throw new EmployNotFoundException("Employee not Found");
            }
        } catch (EmployNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }

    public int addEmploy(Employee emp) {

        int result = 0;
        int betterResult =0;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            int empId = emp.getEmpId();

            String empName = emp.getEmpName();
            double empSalary = emp.getEmpSalary();
            // retrieval flow
            String sql = "Insert into Employee values (" + empId + "," + "'" + empName + "'" + "," + empSalary + ")";
            result = stmt.executeUpdate(sql);
            
            // prepared statement way of doing.
            
           /* String betterSql = "Insert into Employee values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(betterSql);
            ps.setInt(1, empId);
            ps.setString(2, empName);
            ps.setDouble(3, empSalary);
            betterResult = ps.executeUpdate();*/

        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deleteEmploy(int empId) throws EmployNotFoundException{

        int result = 0;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            // retrieval flow
            String sql = "delete from Employee where empID = " + empId;
            result = stmt.executeUpdate(sql);
          if(result ==0){
              throw new EmployNotFoundException("Employee not Found");
          }

        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmployNotFoundException e){
            throw e;
        }
        return result;
    }
}
