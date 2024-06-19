
package com.app.integrador.controlador;

import com.app.integrador.modelo.Carrito;
import com.app.integrador.modelo.Cliente;
import com.app.integrador.modelo.Compra;
import com.app.integrador.modelo.CompraDao;
import com.app.integrador.modelo.Medicina;
import com.app.integrador.modelo.MedicinaDAO;
import com.app.integrador.modelo.Pago;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class ControladorU extends HttpServlet {

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
            throws ServletException, IOException {
        productos = pdao.listar();
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Comprar":
                totalPagar = 0.0;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarID(idp);
                item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombres(p.getNombres());
                car.setDescripcion(p.getDescripcion());
                car.setPreciocompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad * p.getPrecio());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarID(idp);
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idp == listaCarrito.get(i).getIdProducto()) {
                            pos = i;
                        }
                    }

                    if (idp == listaCarrito.get(pos).getIdProducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subtotal = listaCarrito.get(pos).getPreciocompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);

                    } else {
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombres(p.getNombres());
                        car.setDescripcion(p.getDescripcion());
                        car.setPreciocompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad * p.getPrecio());
                        listaCarrito.add(car);
                    }
                } else {
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getId());
                    car.setNombres(p.getNombres());
                    car.setDescripcion(p.getDescripcion());
                    car.setPreciocompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubtotal(cantidad * p.getPrecio());
                    listaCarrito.add(car);
                }

                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("ControladorU?accion=default").forward(request, response);
                break;
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idproducto) {
                        listaCarrito.remove(i);
                    }

                    request.getRequestDispatcher("ControladorU?accion=Carrito").forward(request, response);
                }
                break;
            case "GenerarCompra":
                Cliente cliente = new Cliente();
                CompraDao dao = new CompraDao();
                cliente.setId(1);
                Compra compra = new Compra(cliente, 1, Fecha.FechaBD(), totalPagar, "Cancelado", listaCarrito);
                int res = dao.GenerarCompra(compra);
                if (res != 0 && totalPagar > 0) {
                    request.getRequestDispatcher("vistac.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("vistae.jsp").forward(request, response);

                }
                break;
            case "ActualizarCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idpro) {
                        listaCarrito.get(i).setCantidad(cant);
                        double st = listaCarrito.get(i).getPreciocompra() * cant;
                        listaCarrito.get(i).setSubtotal(st);
                    }
                }

                break;
            case "Carrito":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            default:

        }

        request.setAttribute("productos", productos);
        request.getRequestDispatcher("stock.jsp").forward(request, response);

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
