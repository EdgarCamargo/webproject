<%-- 
    Document   : producto_single
    Created on : 3/05/2024, 10:24:31 PM
    Author     : EDGAR
--%>

<%@page import="ClasesPrincipales.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar producto </title>
    </head>
    <body>
        <h1>Guardar Producto</h1>
        <br/>
        
        <form action="ProductoController" method="post">
            <% 
            Producto producto = (Producto) request.getAttribute("producto");
            %>
            <input type="hidden" name="idProducto" value="<%= producto != null ? producto.getId() : "" %>">
            <div>
                <label for="edad">Codigo:</label>
                <input type="text" id="codigo" name="codigo" value="<%= producto != null ? producto.getNombre() : "" %>" required/>
            </div>
            <div>
                <label for="edad">Nombre:</label>
                <input type="text" id="nombre" name="nombre" value="<%= producto != null ? producto.getCodigo(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Descripción:</label>
                <input type="text" id="descripción" name="descripcion" value="<%= producto != null ? producto.getDescripción(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Precio:</label>
                <input type="text" id="precio" name="precio" value="<%= producto != null ? producto.getPrecio(): "" %>" required/>
            </div>
            </div>
            <label for="edad">StockInventario:</label>
                <input type="text" id="stockinventario" name="stockinventario" value="<%= producto != null ? producto.getStockInventario(): "" %>" required/>
            <div>
        
            <button type="submit">Guardar</button>
            <button type="button">Cancelar</button> <!<!-- agregar función para regresar a la lista -->
        </form> 
    </body>
</html>

