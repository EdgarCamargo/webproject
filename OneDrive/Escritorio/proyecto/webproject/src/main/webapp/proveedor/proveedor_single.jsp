<%-- 
    Document   : proveedor_single
    Created on : 28/04/2024, 01:19:25 PM
    Author     : EDGAR
--%>
<%@page import="ClasesPrincipales.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar proveedor </title>
    </head>
    <body>
        <h1>Guardar Proveedor</h1>
        <br/>
        
        <form action="ProveedorController" method="post">
            <% 
            Proveedor proveedor = (Proveedor) request.getAttribute("proveedor");
            %>
            <input type="hidden" name="idProveedor" value="<%= proveedor != null ? proveedor.getId() : "" %>">
            <div>
                <label for="name">Nombre:</label>
                <input type="text" id="name" name="name" value="<%= proveedor != null ? proveedor.getNombre() : "" %>" required/>
            </div>
            <div>
                <label for="edad">Dirección:</label>
                <input type="text" id="direccion" name="direccion" value="<%= proveedor != null ? proveedor.getDireccion(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" value="<%= proveedor != null ? proveedor.getTelefono(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Documento:</label>
                <input type="text" id="documento" name="documento" value="<%= proveedor != null ? proveedor.getNumeroDeDocumento(): "" %>" required/>
            </div>
            <button type="submit">Guardar</button>
            <button type="button">Cancelar</button> <!<!-- agregar función para regresar a la lista -->
        </form> 
    </body>
</html>

