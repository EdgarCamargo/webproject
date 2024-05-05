<%-- 
    Document   : producto
    Created on : 3/05/2024, 10:24:07 PM
    Author     : EDGAR
--%>

<%@page import="java.util.List"%>
<%@page import="ClasesPrincipales.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos - Lista BIKERSHOP BGA</title>
    </head>
    <body>       
         <a href="ApplicationController?action=index">Inicio</a>
        <br/>
        <a href="ApplicationController?action=producto_single">Crear Nuevo Producto</a>
        <br/>
        <h1>Lista de Productos</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>>Precio</th>
                    <th>>StockInventario</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Producto> listaDeProductos = (List<Producto>) request.getAttribute("listadeproductos");
                for (Producto producto : listaDeProductos) {
                %>
                <tr>
                    <td><%= producto.getId() %></td>
                    <td><%= producto.getCodigo() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getDescripción() %></td>
                    <td><%= producto.getPrecio() %></td>
                    <td><%= producto.getStockInventario() %></td>
                    <td>
                        <form action="ProductoController" method="get">
                            <input type="hidden" name="idProducto" value="<%= producto.getId() %>">
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <button onclick="confirmarEliminar(<%= producto.getId() %>)">Eliminar</button>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
<script>
    function confirmarEliminar(idProducto) {
        if (confirm("¿Estás seguro de que quieres eliminar este proveedor?")) {
            fetch('ProveedorteController?id=' + idProducto, {
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
