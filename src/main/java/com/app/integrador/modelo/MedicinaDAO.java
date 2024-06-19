/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.integrador.modelo;

import com.app.integrador.config.Conexion;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MedicinaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int ra;
public Medicina validar(String user,String pass){
        Medicina p =new Medicina();
       String sql="select * from medi where IDMedic=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1,user);
           ps.setString(2, pass);
           rs=ps.executeQuery();
           while (rs.next()){
               p.setId(rs.getInt("IDMedic"));
               p.setNombres(rs.getString("Nombre"));
               p.setFoto(rs.getBinaryStream("Foto"));
               p.setPrecio(rs.getInt("Precio"));
               p.setDescripcion(rs.getString("descripcion"));
           }
           
           
       }catch(SQLException e){
           
       }
    return p;
    }
    public List listar() {
        List<Medicina> productos = new ArrayList();
        String sql = "select * from medi";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicina p = new Medicina();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setPrecio(rs.getInt(4));
                p.setDescripcion(rs.getString(5));
                productos.add(p);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
       public int agregar(Medicina p){
        String sql="insert into medi(IDMedic,Nombre,Foto,Precio,descripcion)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2,p.getNombres());
            ps.setBinaryStream(3, p.getFoto());
            ps.setInt(4,p.getPrecio());
            ps.setString(5, p.getDescripcion());
            ps.executeUpdate(); 
        } catch (SQLException e) {
        }
        return ra;
    } 

    public Medicina listarID(int id) {
        String sql = "select * from medi where IDMedic=" + id;
        Medicina p = new Medicina();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setPrecio(rs.getInt(4));
                p.setDescripcion(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
public int actualizar(Medicina p){
        String sql="update medi set Nombre=?,Foto=?,Precio=?,descripcion=? where IDMedic=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setBinaryStream(2, p.getFoto());
            ps.setInt(3, p.getPrecio());
            ps.setString(4, p.getDescripcion());
            ps.setInt(5,p.getId());
            ps.executeUpdate(); 
        } catch (SQLException e) {
        }
        return ra;
    }
 
    public void listarImg(int id, HttpServletResponse response) {
    String sql = "select * from medi where IDMedic=?";
    try (
        Connection con = cn.Conexion();
        PreparedStatement ps = con.prepareStatement(sql);
    ) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                try (InputStream inputStream = rs.getBinaryStream("Foto");
                     OutputStream outputStream = response.getOutputStream();
                     BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {

                    byte[] buffer = new byte[8192]; // Buffer de 8KB (ajustable según necesidades)
                    int bytesRead;
                    while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                        bufferedOutputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Manejo básico de la excepción para depuración
    }
}

 public Medicina listarID1(int id) {
        String sql = "select * from medi where IDMedic=" +id;
        Medicina p = new Medicina();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setPrecio(rs.getInt(4));
                p.setDescripcion(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return p;
    }
    
public void delete(int id){
        String sql="delete from medi where IDMedic=" +id;
        
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
   