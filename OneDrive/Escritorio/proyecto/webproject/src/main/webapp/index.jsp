<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página De Inicio</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <h1>Sistema De Facturaciòn FBS</h1>
        <a href="ApplicationController?action=clientes">Administrar clientes</a> |
        <a href="ApplicationController?action=proveedores">Administrar proveedores</a> |
        <a href="ApplicationController?action=cuentas">Administrar Produtos de Inventario</a>
        <br/>
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
       
        
        <!--
        <form action="ClienteController" method="post">
            <div>
            <label for="name">Nombre cliente:</label>
            <input type="text" id="name" name="name" />
            </div>
            <div>
            <label for="apellido">Apellido cliente:</label>
            <input type="text" id="apellido" name="apellido" />
            </div>
            <div>
            <label for="edad">Dirección:</label>
            <input type="text" id="direccion" name="direccion" />
            </div>
            <div>
            <label for="edad">Teléfono</label>
            <input type="text" id="telefono" name="telefono" />
            </div>
            <div>
            <label for="edad">Documento</label>
            <input type="text" id="documento" name="documento" />
            </div>
            <button type="submit">click me</button>
        </form> 
        -->
        
        <!--
        <form action="ProveedorController" method="post">
            <div>
            <label for="name">Nombre proveedor:</label>
            <input type="text" id="name" name="name" />
            </div>
            <div>
            <label for="edad">Dirección:</label>
            <input type="text" id="direccion" name="direccion" />
            </div>
            <div>
            <label for="edad">Teléfono</label>
            <input type="text" id="telefono" name="telefono" />
            </div>
            <div>
            <label for="edad">Documento</label>
            <input type="text" id="documento" name="documento" />
            </div>
            <button type="submit">click me</button>
        </form> 
        -->
        
          <!--
        <form action="ProductoController" method="post">
            <div>
            <label for="edad">Codigo:</label>
            <input type="text" id="codigo" name="codigo" />
            </div>
            <div>
            <label for="edad">Nombre:</label>
            <input type="text" id="nombre" name="nombre" />
            </div>
            <div>
            <label for="edad">Descripción:</label>
            <input type="text" id="descripción" name="descrpción" />
            </div>
            <div>
            <label for="edad">Precio</label>
            <input type="text" id="precio" name="precio" />
            </div>
            <div>
            <label for="edad">StockInventario</label>
            <input type="text" id="stockinventario" name="stockinventario" />
            </div>
            <button type="submit">click me</button>
        </form> 
        -->
    </body>
    <footer>
        <p>&copy; Sistema de Facturación FBS 2024</p>
    </footer
</html>
