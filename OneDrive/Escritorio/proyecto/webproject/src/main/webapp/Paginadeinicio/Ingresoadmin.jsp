<%-- 
    Document   : Ingresoadmin
    Created on : 25/04/2024, 11:35:10 PM
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
        <img src="${pageContext.request.contextPath}/Imagenes/Logo.jpg" height="80" /> 
    </header>
    <main>
        <div>
            <h2>Bienvenido USUARIO ADMIN</h2>
            
             <div class="contenedor">
      
        <img src="${pageContext.request.contextPath}/Imagenes/iconos/clientes.png" height="150" />
        <br>
        <button onclick="alert('¡Botón clickeado!')">Haz clic aquí</button>

        </div>
        <div class="contenedor">
      
       <img src="${pageContext.request.contextPath}/Imagenes/iconos/facturacion.png" height="150" />
        <br>
        <button onclick="alert('¡Botón clickeado!')">Haz clic aquí</button>
    </div>
         </div>
        </div>
        <div class="contenedor">
      
       <img src="${pageContext.request.contextPath}/Imagenes/iconos/inventario.png" height="150" />
        <br>
        <button onclick="alert('¡Botón clickeado!')">Haz clic aquí</button>
    </div>
           
        </div>
         </div>
            
            <img src="${pageContext.request.contextPath}/Imagenes/iconos/logo ventas.png" height="150" />
            
        </div>
      
        </div>
    </main>
    <footer>
        <p>&copy; Sistema de Facturación FBS 2024</p>
    </footer>
</body>
</html>