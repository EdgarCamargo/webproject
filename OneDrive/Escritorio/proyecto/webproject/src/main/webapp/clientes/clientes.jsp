<%-- 
    Document   : clientes
    Created on : 19/04/2024, 08:40:24 PM
    Author     : EDGAR
--%>

<%@page import="java.util.List"%>
<%@page import="ClasesPrincipales.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes - Lista</title>
    </head>
    <body>       
         <a href="ApplicationController?action=index">Inicio</a>
        <br/>
        <a href="ApplicationController?action=cliente_single">Crear Nuevo Cliente</a>
        <br/>
        <h1>Lista de Clientes</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Dirección</th>
                    <th>ID Tipo de Documento</th>
                    <th>Número de Documento</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
               <% 
                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("clientes");
                for (Cliente cliente : listaClientes) {
                %>
                <tr>
                    <td><%= cliente.getId() %></td>
                    <td><%= cliente.getNombre() %></td>
                    <td><%= cliente.getApellido()%></td>
                    <td><%= cliente.getDireccion() %></td>
                    <td><%= cliente.getIdTipoDocumento() %></td>
                    <td><%= cliente.getNumeroDeDocumento() %></td>
                    <td>
                        <form action="ClienteController" method="get">
                            <input type="hidden" name="idCliente" value="<%= cliente.getId() %>">
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <button onclick="confirmarEliminar(<%= cliente.getId() %>)">Eliminar</button>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
<script>
    function confirmarEliminar(idCliente) {
        if (confirm("¿Estás seguro de que quieres eliminar este cliente?")) {
            fetch('ClienteController?id=' + idCliente, {
                method: 'DELETE'
            })
            .then(response => {
                location.reload();
            })
            .then(data => {
                //alert(data);                   
            })
            .catch(error => {
                alert(error.message);
            });
        }
    }
</script>