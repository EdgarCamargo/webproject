/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import ClasesPrincipales.Proveedor;
import com.aplicacion.dao.ProveedoresDAO;
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
@WebServlet(name = "ProveedorController", urlPatterns = {"/ProveedorController"})
public class ProveedorController extends HttpServlet {

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
        String name = request.getParameter("name");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String numeroDocumento = request.getParameter("documento");
        
        if(name == null || name.isEmpty()){
            name = "No se envio nada";
            return;
        }
        
        //guardamos en la base de datos
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(request.getParameter("name"));
        proveedor.setDireccion(request.getParameter("direccion"));
        proveedor.setTelefono(request.getParameter("telefono"));
        proveedor.setNumeroDeDocumento(request.getParameter("documento"));        
        proveedor.setIdTipoDocumento(2);
        
        ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
        
        String idProveedor = request.getParameter("idProveedor");
        if (idProveedor != null && !idProveedor.trim().isEmpty()){
            // Actualizar el cliente en la base de datos  
            proveedor.setId(Integer.valueOf(idProveedor));
            boolean isUpdated = proveedoresDAO.actualizarProveedor(proveedor); 
            
            request.removeAttribute("id");
        }
        else {
            // Insertar el proveedor en la base de datos            
            proveedoresDAO.insertarProveedor(proveedor); 
        }                       
        
        CargarListaProveedor(request, response);
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
        String idProveedor = request.getParameter("idProveedor");
        
        if (idProveedor != null){
            CargarUnProveedor (request, response, idProveedor);
        }
        else {
            CargarListaProveedor(request, response);
        }                
    }
    
    private void CargarUnProveedor(HttpServletRequest request, HttpServletResponse response, String idProveedor)
    throws ServletException, IOException {
        ProveedoresDAO ProveedoresDAO = new ProveedoresDAO();
        Proveedor proveedor = ProveedoresDAO.obtenerUnProveedor(Integer.valueOf(idProveedor));
        request.setAttribute("proveedor", proveedor);
        request.getRequestDispatcher("/proveedor/proveedor_single.jsp").forward(request, response);
    }
    
    private void CargarListaProveedor(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
        List<Proveedor> listaProveedoresDao = proveedoresDAO.listarProveedor();
        request.setAttribute("listaproveedores", listaProveedoresDao);
        request.getRequestDispatcher("/proveedor/proveedor.jsp").forward(request, response);
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
        int idProveedor = Integer.parseInt(request.getParameter("id"));
        
        ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
        boolean eliminado = proveedoresDAO.eliminarProveedor(idProveedor);
        
        if (eliminado){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Proveedor eliminado exitosamente");
        }
        else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error al eliminar el proveedor");
        }
        
        CargarListaProveedor(request, response);
    }   
 
  }
