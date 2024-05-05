/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class FacturaDetalle {
    
    private final String nombreProducto;   // Nombre del producto o servicio
    private final int cantidad;            // Cantidad de unidades compradas
    private final double precioUnitario;   // Precio unitario del producto o servicio
    private final double precioTotal;      // Precio total del ítem

    // Constructor
    public FacturaDetalle(String nombreProducto, int cantidad, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = calcularPrecioTotal();
    }
      
    // Métodos para obtener los atributos
    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    // Método para calcular el precio total del ítem
    private double calcularPrecioTotal() {
        return cantidad * precioUnitario;
    }
    
    // Otros métodos según sea necesario
    
}
    

    

