/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import ClasesPrincipales.Cliente;
import com.aplicacion.dao.ClienteDAO;
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
@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

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
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String numeroDocumento = request.getParameter("documento");
        
        if(name == null || name.isEmpty()){
            name = "No se envio nada";
            return;
        }
        
        //guardamos en la base de datos
        Cliente cliente;
        cliente = new Cliente();
        cliente.setNombre(request.getParameter("name"));
        cliente.setApellido(request.getParameter("apellido"));
        cliente.setDireccion(request.getParameter("direccion"));
        cliente.setTelefono(request.getParameter("telefono"));        
        cliente.setIdTipoDocumento(1);
        cliente.setNumeroDeDocumento(request.getParameter("documento"));

        //instanciamos la clase ClientDAO
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //obtenemos el parámetro idCliente
        String idCliente = request.getParameter("idCliente");
        
        if (idCliente != null && !idCliente.trim().isEmpty()){
            // Actualizar el cliente en la base de datos  
            cliente.setId(Integer.valueOf(idCliente));
            boolean isUpdated = clienteDAO.actualizarCliente(cliente); 
            
            request.removeAttribute("idCliente");
            //request.getParameterMap().remove("idCliente");
        }
        else {
            // Insertar el cliente en la base de datos            
            clienteDAO.insertarCliente(cliente); 
        }
        
        CargarListaClientes(request, response);
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
        String idCliente = request.getParameter("idCliente");
        
        if (idCliente != null){
            CargarUnCliente(request, response, idCliente);
        }
        else {
            CargarListaClientes(request, response);
        }                
    }
    
    private void CargarUnCliente(HttpServletRequest request, HttpServletResponse response, String idCliente)
    throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.obtenerUnCliente(Integer.valueOf(idCliente));
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/clientes/cliente_single.jsp").forward(request, response);
    }
    
    private void CargarListaClientes(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listarClientes();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("/clientes/clientes.jsp").forward(request, response);
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
        int idCliente = Integer.parseInt(request.getParameter("id"));
        
        ClienteDAO clienteDAO = new ClienteDAO();
        boolean eliminado = clienteDAO.eliminarCliente(idCliente);
        
        if (eliminado){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Cliente eliminado exitosamente");
        }
        else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error al eliminar el cliente");
        }
        
        CargarListaClientes(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}
