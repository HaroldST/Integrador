/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.integrador.modelo;


public class Cliente {
   private int id;
   private String nombre;
    private String ape;
    private int tef;
    private int email;
    private String nu;
    private String contra;

public Cliente (){
    
}

    public Cliente(int id, String nombre, String ape, int tef, int email, String nu, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.ape = ape;
        this.tef = tef;
        this.email = email;
        this.nu = nu;
        this.contra = contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public int getTef() {
        return tef;
    }

    public void setTef(int tef) {
        this.tef = tef;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    

}

