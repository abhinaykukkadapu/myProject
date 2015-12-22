/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;

/**
 *
 * @author abhinaykukkadapu
 */
public class Employee {
    private int empId;
    private String empName;
    private double empSalary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
    
    @Override
    public String toString(){
        return "EmpID:" + this.empId + "EmpName:" + this.empName + "empSalary:" + this.empSalary; 
    }
}
