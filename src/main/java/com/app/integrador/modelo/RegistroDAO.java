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
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int r;

    public Registro validar(String user, String pass) {
        Registro em = new Registro();
        String sql = "SELECT * FROM registro WHERE usuario=?";
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
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, ps, rs);
        }
        return em;
    }

    public List<Registro> listar() {
        String sql = "SELECT * FROM registro";
        List<Registro> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Registro em = new Registro();
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
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, ps, rs);
        }
        return lista;
    }

    public int agregar(Registro em) {
        String sql = "INSERT INTO registro (id_registro, usuario, nombre, apellido, contraseña, email, rol) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getId());
            ps.setString(2, em.getUser());
            ps.setString(3, em.getNombre());
            ps.setString(4, em.getApe());

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passEncriptada = encoder.encode(em.getContra());
            ps.setString(5, passEncriptada);

            ps.setString(6, em.getEmail());
            ps.setString(7, em.getRol());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, ps, null);
        }
        return r;
    }

    public Registro listarID(int id) {
        Registro emp = new Registro();
        String sql = "SELECT * FROM registro WHERE id_registro = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setId(rs.getInt("id_registro"));
                emp.setUser(rs.getString("usuario"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApe(rs.getString("apellido"));
                emp.setEmail(rs.getString("email"));
                emp.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, ps, rs);
        }
        return emp;
    }

    public int actualizar(Registro em) {
        String sql = "UPDATE registro SET usuario = ?, nombre = ?, apellido = ?, contraseña = ?, email = ?, rol = ? WHERE id_registro = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getUser());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApe());

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passEncriptada = encoder.encode(em.getContra());
            ps.setString(4, passEncriptada);

            ps.setString(5, em.getEmail());
            ps.setString(6, em.getRol());
            ps.setInt(7, em.getId());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, ps, null);
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM registro WHERE id_registro = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, ps, null);
        }
    }

    private void cerrarRecursos(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}