/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.integrador.modelo;

import com.app.integrador.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author bobby
 */
public class CompraDao extends Conexion {
    Connection con;
    Conexion cn= new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
 public int GenerarCompra(Compra compra){
     int idcompra;
     String sql="insert into compra(idCliente,idpago,fecha,monto,estado)values(?,?,?,?,?)";
     try {
         con=cn.Conexion();
         ps=con.prepareStatement(sql);
         ps.setInt(1,compra.getCliente().getId());
         ps.setInt(2,compra.getIdpago());
         ps.setString(3,compra.getFecha());
         ps.setDouble(4, compra.getMonto());
         ps.setString(5,compra.getEstado());
         r=ps.executeUpdate();
         
         sql="Select @@IDENTITY AS idcompra";
         rs=ps.executeQuery(sql);
         rs.next();
         idcompra=rs.getInt("idcompra");
         rs.close();
         
         for (Carrito detalle : compra.getDetallecompras()){
             sql="insert into detalle_compra(idProducto,idcompra,cantidad,preciocompra)values(?,?,?,?)";
         ps=con.prepareStatement(sql);
         ps.setInt(1,detalle.getIdProducto());
         ps.setInt(2,idcompra);
         ps.setInt(3,detalle.getCantidad());
         ps.setDouble(4, detalle.getPreciocompra());
         r=ps.executeUpdate();
         }
         
     } catch (Exception e){
         
     }
 
    return r;
}
}
