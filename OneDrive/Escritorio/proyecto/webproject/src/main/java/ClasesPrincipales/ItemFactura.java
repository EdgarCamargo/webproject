/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class ItemFactura {
    
    private String nombre;          // Nombre del producto o servicio
    private double precioUnitario;  // Precio unitario del producto o servicio
    private int cantidad;           // Cantidad de unidades compradas

    // Constructor
    public ItemFactura(String nombre, double precioUnitario, int cantidad) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    // Métodos para obtener y establecer los atributos (opcional, dependiendo de las necesidades)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para calcular el precio total del ítem
    public double getPrecioTotal() {
        return this.precioUnitario * this.cantidad;
    }

    // Otros métodos según sea necesario
}
    

