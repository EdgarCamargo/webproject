/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import ClasesPrincipales.Producto;
import com.aplicacion.dao.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EDGAR
 */

    @WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processPOSTRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //obtiene los valores del formulario
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String descripción = request.getParameter("descripción");
        String precio = request.getParameter("precio");
        String stockinventario = request.getParameter("stockinventario");
        
        if(codigo == null || codigo.isEmpty()){
            codigo = "No se envio nada";
            return;
        }
        
        //guardamos en la base de datos
        Producto producto = new Producto();
        producto.setCodigo(request.getParameter("codigo"));
        producto.setNombre(request.getParameter("nombre"));
        producto.setDescripción(request.getParameter("descripción"));
        producto.setPrecio(request.getParameter("precio"));
        producto.setStockInventario(1);
        
        ProductoDAO productoDAO = new ProductoDAO();
        
        String idProducto = request.getParameter("idProducto");
        if (idProducto != null && !idProducto.trim().isEmpty()){
            // Actualizar el Producto en la base de datos  
            producto.setId(Integer.valueOf(idProducto));
            boolean isUpdated = productoDAO.actualizarProducto(producto); 
            
            request.removeAttribute("id");
        }
        else {
            // Insertar el proveedor en la base de datos            
            productoDAO.insertarProducto(producto); 
        }                       
        
        CargarListaProducto(request, response);
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
        processGETRequest(request, response);
    }
    
    protected void processGETRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        String idProducto = request.getParameter("idProducto");
        
        if (idProducto != null){
            CargarUnProducto (request, response, idProducto);
        }
        else {
            CargarListaProducto(request, response);
        }                
    }
    
    private void CargarUnProducto(HttpServletRequest request, HttpServletResponse response, String idProducto)
    throws ServletException, IOException {
        ProductoDAO ProductoDAO = new ProductoDAO();
        Producto producto = ProductoDAO.obtenerUnProducto(Integer.valueOf(idProducto));
        request.setAttribute("producto", producto);
        request.getRequestDispatcher("/productos/producto_single.jsp").forward(request, response);
    }
    
    private void CargarListaProducto(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> listaProductoDao = productoDAO.listarProducto();
        request.setAttribute("listaproducto", listaProductoDao);
        request.getRequestDispatcher("/productos/producto.jsp").forward(request, response);
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
        processPOSTRequest(request, response);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del cliente a eliminar desde la solicitud
        int idProducto = Integer.parseInt(request.getParameter("id"));
        
        ProductoDAO productoDAO = new ProductoDAO();
        boolean eliminado = productoDAO.eliminarProducto(idProducto);
        
        if (eliminado){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Producto eliminado exitosamente");
        }
        else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error al eliminar el producto");
        }
        
        CargarListaProducto(request, response);
    }   
 
  }
