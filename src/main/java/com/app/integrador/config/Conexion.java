/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.integrador.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Harol
 */
public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/";
    String bd="wfarma";
    String user="root"; 
    String pass="";
    
    
    public Conexion() {
    }
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url+bd,user,pass);
            System.out.println("Se conectó a la BD "+bd);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se conectó a la BD "+bd+' '+ e.getMessage());
        }
        return con;
    }
    
    public static void main(String[] args) {
        Conexion conex = new Conexion();
        conex.Conexion();
    }

   }
