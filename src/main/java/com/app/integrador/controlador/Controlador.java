/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.app.integrador.controlador;

import com.app.integrador.modelo.Carrito;
import com.app.integrador.modelo.Medicina;
import com.app.integrador.modelo.MedicinaDAO;
import com.app.integrador.modelo.Registro;
import com.app.integrador.modelo.RegistroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@MultipartConfig
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int ide2;
    int ide1;
    int ide;
    Registro em = new Registro();
    RegistroDAO edao = new RegistroDAO();
    MedicinaDAO pdao = new MedicinaDAO();
    Medicina p = new Medicina();
    List<Medicina> productos = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int idp;
    Carrito car;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        productos = pdao.listar();
        String men = request.getParameter("men");
        String accion = request.getParameter("accion");

        if (men.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (men.equals("inicio")) {
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }
        if (men.equals("medi")) {

            switch (accion) {
                case "Listar":

                    List lista1 = pdao.listar();
                    request.setAttribute("productos", lista1);

                    break;
                case "Agregar":

                    String nombres = request.getParameter("txtnombre");
                    int Precio = Integer.parseInt(request.getParameter("txtprecio"));
                    String descripcion = request.getParameter("txtdescrip");
                    Part part = request.getPart("txtfoto");
                    InputStream foto = part.getInputStream();
                    p.setNombres(nombres);
                    p.setFoto(foto);
                    p.setPrecio(Precio);
                    p.setDescripcion(descripcion);
                    pdao.agregar(p);

                    request.getRequestDispatcher("Controlador?men=medi&accion=Listar").forward(request, response);

                    break;

                case "Editar":
                    ide1 = Integer.parseInt(request.getParameter("id"));
                    Medicina ei = pdao.listarID1(ide1);
                    request.setAttribute("producto", ei);
                    request.getRequestDispatcher("Controlador?men=medi&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":

                    String nombres1 = request.getParameter("txtnombre");
                    part = request.getPart("txtfoto");
                    InputStream foto1 = part.getInputStream();
                    int Precio1 = Integer.parseInt(request.getParameter("txtprecio"));
                    String descripcion1 = request.getParameter("txtdescrip");
                    p.setNombres(nombres1);
                    p.setFoto(foto1);
                    p.setPrecio(Precio1);
                    p.setDescripcion(descripcion1);
                    p.setId(ide1);

                    pdao.actualizar(p);
                    request.getRequestDispatcher("Controlador?men=medi&accion=Listar").forward(request, response);
                    break;

                case "Delete":

                    ide1 = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(ide1);
                    request.getRequestDispatcher("Controlador?men=medi&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("Medicamentos.jsp").forward(request, response);
        }
        
        
        
        
        
        
        
        //-----------------------------registros--------------------------------------//

            if (men.equals("registro")) {

                switch (accion) {
                    case "Listar":
                        List lista = edao.listar();
                        request.setAttribute("registros", lista);
                        break;
                    case "Agregar":
                        String usuario = request.getParameter("txtuser");
                        String nombre = request.getParameter("txtnom");
                        String apellido = request.getParameter("txtape");
                        String contraseña = request.getParameter("txtcontra");
                        String email = request.getParameter("txtema");
                        String rol = request.getParameter("opcion");
                        em.setUser(usuario);
                        em.setNombre(nombre);
                        em.setApe(apellido);
                        em.setContra(contraseña);
                        em.setEmail(email);
                        em.setRol(rol);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?men=registro&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        Registro e = edao.listarID(ide);
                        request.setAttribute("registro", e);
                        request.getRequestDispatcher("Controlador?men=registro&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String usuario1 = request.getParameter("txtuser");
                        String nombre1 = request.getParameter("txtnom");
                        String apellido1 = request.getParameter("txtape");
                        String contraseña1 = request.getParameter("txtcontra");
                        String email1 = request.getParameter("txtema");
                        String rol1 = request.getParameter("opcion");
                        em.setUser(usuario1);
                        em.setNombre(nombre1);
                        em.setApe(apellido1);
                        em.setContra(contraseña1);
                        em.setEmail(email1);
                        em.setRol(rol1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?men=registro&accion=Listar").forward(request, response);
                        break;

                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?men=registro&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }

                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
        }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
