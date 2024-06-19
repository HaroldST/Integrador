
package com.app.integrador.modelo;

import com.app.integrador.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class RegistroDAO {
    Conexion cn =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
public Registro validar(String user, String pass) {
    Registro em = new Registro();
    String sql = "select * from registro where usuario=?";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, user);
        rs = ps.executeQuery();
        if (rs.next()) {
            String storedPassword = rs.getString("contraseña"); 
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            boolean matches = encoder.matches(pass, storedPassword);

            if (matches) {    
                em.setId(rs.getInt("id_registro"));
                em.setUser(rs.getString("usuario"));
                em.setNombre(rs.getString("nombre"));
                em.setApe(rs.getString("apellido"));
                em.setContra(storedPassword);
                em.setEmail(rs.getString("email"));
                em.setRol(rs.getString("rol"));
            }
        }
    } catch (SQLException e) {
    }
    return em;
}
    
    public List listar() {
        String sql="select * from registro";
        List<Registro>lista=new ArrayList<>();
        
        try {
            con= cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Registro em=new Registro();
                em.setId(rs.getInt(1));
                em.setUser(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setApe(rs.getString(4));
                em.setContra(rs.getString(5));
                em.setEmail(rs.getString(6));
                em.setRol(rs.getString(7));
                lista.add(em);
            }            
        } catch (SQLException e) {
        }
          return lista;
}
    
    public int agregar(Registro em){
        String sql="insert into registro(id_registro,usuario,nombre,apellido,contraseña,email,rol)values(?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, em.getId());
            ps.setString(2, em.getUser());
            ps.setString(3, em.getNombre());
            ps.setString(4, em.getApe());
            
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passEncriptada = encoder.encode(em.getContra());
            ps.setString(5, passEncriptada);
            
            ps.setString(6, em.getEmail());
            ps.setString(7, em.getRol());
            ps.executeUpdate(); 
        } catch (SQLException e) {
        }
        return r;
    }
    
    public Registro listarID(int id){
        Registro emp=new Registro();
        String sql="select* from registro where id_registro="+id;
        
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setUser(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setApe(rs.getString(4));
               // emp.setContra(rs.getString(5));
                emp.setEmail(rs.getString(6));
                emp.setRol(rs.getString(7));
            }
        } catch (SQLException e) {
        }
        return emp;
    }
    public int actualizar(Registro em){
        String sql="update registro set usuario=?,nombre=?,apellido=?,contraseña=?,email=?,rol=? where id_registro=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getUser());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApe());
            //ps.setString(4, em.getContra());
            
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passEncriptada = encoder.encode(em.getContra());
            ps.setString(4, passEncriptada);
            
            ps.setString(5, em.getEmail());
            ps.setString(6, em.getRol());
            ps.setInt(7,em.getId());
            ps.executeUpdate(); 
        } catch (SQLException e) {
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from registro where id_registro=" +id;
        
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
