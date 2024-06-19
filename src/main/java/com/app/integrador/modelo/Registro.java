package com.app.integrador.modelo;




public class Registro {
    int id;
    String user;
    String nombre;
    String ape;
    String Contra;
    String email;
    String rol;
    
    public Registro(){
        
    }
    
    public Registro(int id, String user, String nombre, String ape,String Contra,String email,String rol){
        this.id = id;
        this.user = user;
        this.nombre= nombre;
        this.ape = ape;
        this.Contra= Contra;
        this.email= email;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}


