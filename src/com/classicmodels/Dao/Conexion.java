/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classicmodels.Dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Humberto Hdz
 */
public class Conexion {
    Connection con = null;
    
    public Connection getConection(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String server = "jdbc:mysql://Localhost:3306/classicmodels";
            String userName = "root";
            String password = "";
            
            con = (Connection)DriverManager.getConnection(server,userName, password);
           
        } catch (ClassNotFoundException e){
            System.out.println("Error drive"+ e.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la conexion" + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return con;
    }
}
