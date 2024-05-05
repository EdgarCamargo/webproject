<%-- 
    Document   : mediosdepagoweb
    Created on : 23/04/2024, 12:01:34 AM
    Author     : EDGAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <form action="procesarPago.jsp" method="POST">
         <div id="paypal-button-container"></div>
    </form>
    <script>
  paypal.Buttons({
    createOrder: function(data, actions) {
      // Aquí puedes definir el monto y la moneda del pago
      return actions.order.create({
        purchase_units: [{
          amount: {
            value: '10.00' // Puedes cambiar este valor según tu caso
          }
        }]
      });
    },
    onApprove: function(data, actions) {
      // Aquí se ejecuta cuando el pago es aprobado
      return actions.order.capture().then(function(details) {
        // Aquí puedes hacer algo con los detalles del pago, como guardarlos en la base de datos
        // o mostrar un mensaje de confirmación al usuario
        console.log(details);
        // En este ejemplo, simplemente redireccionamos a una página de confirmación
        window.location.href = 'pagoExitoso.jsp';
      });
    }
  }).render('#paypal-button-container');
</script>
    </head>
    <body>
        
        <h1>Medios De Pago</h1>
        
    </body>
</html>
