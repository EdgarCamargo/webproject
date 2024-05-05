<%-- 
    Document   : proveedor
    Created on : 28/04/2024, 03:46:46 PM
    Author     : EDGAR
--%>

<%@page import="java.util.List"%>
<%@page import="ClasesPrincipales.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores - Lista BIKERSHOP BGA</title>
    </head>
    <body>       
         <a href="ApplicationController?action=index">Inicio</a>
        <br/>
        <a href="ApplicationController?action=proveedor_single">Crear Nuevo Proveedor</a>
        <br/>
        <h1>Lista de Proveedor</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Número de Documento</th>
                    <th>ID Tipo de Documento</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Proveedor> listaDeProveedores = (List<Proveedor>) request.getAttribute("listaproveedores");
                for (Proveedor proveedor : listaDeProveedores) {
                %>
                <tr>
                    <td><%= proveedor.getId() %></td>
                    <td><%= proveedor.getNombre() %></td>
                    <td><%= proveedor.getDireccion() %></td>
                    <td><%= proveedor.getIdTipoDocumento() %></td>
                    <td><%= proveedor.getNumeroDeDocumento() %></td>
                    <td>
                        <form action="ProveedorController" method="get">
                            <input type="hidden" name="idProveedor" value="<%= proveedor.getId() %>">
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <button onclick="confirmarEliminar(<%= proveedor.getId() %>)">Eliminar</button>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
<script>
    function confirmarEliminar(idProveedor) {
        if (confirm("¿Estás seguro de que quieres eliminar este proveedor?")) {
            fetch('ProveedorteController?id=' + idProveedor, {
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
