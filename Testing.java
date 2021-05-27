/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;

/**
 *
 * @author TPC
 */
public class Testing {
    public static void main(String args[]) throws SQLException
    {
    User u =new User("teste", "teste","teste", "teste");
    u.ajout();
    System.out.println(u.authentifier());
    
    
    }
}
