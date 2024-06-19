/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.app.integrador.controlador;

import com.app.integrador.modelo.Medicina;
import com.app.integrador.modelo.MedicinaDAO;
import com.app.integrador.modelo.Registro;
import com.app.integrador.modelo.RegistroDAO;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ControladorM extends HttpServlet {

   int ide;
    Registro em = new Registro();
    RegistroDAO edao = new RegistroDAO();
    MedicinaDAO pdao = new MedicinaDAO();
    Medicina p = new Medicina();
    List<Medicina> productos = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int idp;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
     
           productos = pdao.listar();
        String accion = request.getParameter("accion"); 
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("medis", lista);
                    request.getRequestDispatcher("Medicamentos.jsp").forward(request, response);
                    break;
                case "Agregar":

                    String nombres = request.getParameter("txtnombre");
                    int Precio = request.getIntHeader("txtprecio");
                    String descripcion = request.getParameter("txtdescrip");
                    InputStream foto = request.getInputStream();
                    p.setNombres(nombres);
                    p.setFoto(foto);
                    p.setPrecio(Precio);
                    p.setDescripcion(descripcion);
                    pdao.agregar(p);
                    request.getRequestDispatcher("ControladorM?accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Medicina e = pdao.listarID(ide);
                    request.setAttribute("medi", e);
                    request.getRequestDispatcher("ControladorM?accion=Listar").forward(request, response);
                    break;

                case "Actualizar":

                    String nombres1 = request.getParameter("txtnombre");
                    int Precio1 = request.getIntHeader("txtprecio");
                    String descripcion1 = request.getParameter("txtdescrip");
                    p.setNombres(nombres1);
                    p.setPrecio(Precio1);
                    p.setDescripcion(descripcion1);
                    p.setId(ide);

                    pdao.actualizar(p);
                    request.getRequestDispatcher("ControladorM?accion=Listar").forward(request, response);
                    break;

                case "Delete":
                    int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getId()== idproducto) {
                        productos.remove(i);
                    }

                    request.getRequestDispatcher("ControladorM?accion=Listar").forward(request, response);
                }
                break;
                default:
                    throw new AssertionError();
            }
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("Medicamentos.jsp").forward(request, response);
        }
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
