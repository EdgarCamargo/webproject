/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class MediosDePago {
    
    private String tipo;             // Tipo de medio de pago (ej. "Tarjeta de crédito o dèbito", "Efectivo", "Transferencia")
    private String numeroTarjeta;    // Número de tarjeta (solo si aplica)
    private String valorTotalCompra; // Valor Total de la compra
    private String titular;          // Titular del medio de pago (nombre del titular de la tarjeta)

    public MediosDePago(String tipo, String numeroTarjeta, String valorTotalCompra, String titular) {
        this.tipo = tipo;
        this.numeroTarjeta = numeroTarjeta;
        this.valorTotalCompra = valorTotalCompra;
        this.titular = titular;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getValorTotalCompra() {
        return valorTotalCompra;
    }

    public String getTitular() {
        return titular;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setValorTotalCompra(String valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    
    
}
