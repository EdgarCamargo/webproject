<%-- 
    Document   : cliente_single
    Created on : 27/04/2024, 12:27:42 AM
    Author     : EDGAR
--%>

<%@page import="ClasesPrincipales.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar cliente</title>
    </head>
    <body>
        <h1>Guardar Cliente</h1>
        <br/>
        
        <form action="ClienteController" method="post">
            <% 
            Cliente cliente = (Cliente) request.getAttribute("cliente");
            %>
            <input type="hidden" name="idCliente" value="<%= cliente != null ? cliente.getId() : "" %>">
            <div>
                <label for="name">Nombre:</label>
                <input type="text" id="name" name="name" value="<%= cliente != null ? cliente.getNombre() : "" %>" required/>
            </div>
            <div>
                <label for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido" value="<%= cliente != null ? cliente.getApellido(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Dirección:</label>
                <input type="text" id="direccion" name="direccion" value="<%= cliente != null ? cliente.getDireccion(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" value="<%= cliente != null ? cliente.getTelefono(): "" %>" required/>
            </div>
            <div>
                <label for="edad">Documento:</label>
                <input type="text" id="documento" name="documento" value="<%= cliente != null ? cliente.getNumeroDeDocumento(): "" %>" required/>
            </div>
            <button type="submit">Guardar</button>
            <button type="button">Cancelar</button> <!<!-- agregar función para regresar a la lista -->
        </form> 
    </body>
</html>
