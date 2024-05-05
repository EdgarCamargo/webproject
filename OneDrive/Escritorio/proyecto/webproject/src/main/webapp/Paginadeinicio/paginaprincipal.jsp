<%-- 
    Document   : paginaprincipal
    Created on : 22/04/2024, 08:25:31 PM
    Author     : EDGAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Facturación FBS</title>
    <link href="../css/styles.css" rel="stylesheet" type="text/css"/>
    <script src="js/login.js"></script>
 </head>
<body>
    <header>
        <h1>SISTEMA DE FACTURACIÓN FBS</h1>
    </header>
    <main>
        <div>
            <h2>Bienvenidos al Sistema FBS</h2>
            <img src="${pageContext.request.contextPath}/Imagenes/Logo.jpg" height="150" />
        </div>
        <br />
        <div class="tablaloguin">
            <table>
                <tr>
                    <td>
                        usuario
                    </td>
                    <td><input type="text" id="input_usuario"></td>
                </tr>
                <tr>
                    <td>contraseña</td>
                    <td><input type="password" id="input_password"></td>
                </tr>
                <tr></tr>
                <tr>
                    <td colspan="2">
                        <button class="favorite styled" type="button" onclick="iniciarsesion()">iniciar sesión</button>
                        <button class="favorite styled" type="button" onclick="cancelar()">cancelar</button>
                    </td>
                </tr>
            </table>
        </div>
    </main>
    <footer>
        <p>&copy; Sistema de Facturación FBS 2024</p>
    </footer>
</body>
</html>