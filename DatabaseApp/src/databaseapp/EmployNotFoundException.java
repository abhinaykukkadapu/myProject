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
public class EmployNotFoundException extends Exception{

    EmployNotFoundException(String message) {
        super(message);
    }
    
    EmployNotFoundException(){
        super();
    }
    
}
