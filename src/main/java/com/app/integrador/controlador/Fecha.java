package com.app.integrador.controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.text.SimpleDateFormat;
import java.util.Date;


public class Fecha {
    
     public static String FechaBD() {
        Date fecha=new Date();
            SimpleDateFormat formatFecha=new SimpleDateFormat("dd/MM/YYYY");
            return formatFecha.format(fecha);
    }
}

