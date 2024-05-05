/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author EDGAR
 */
public class Factura {
    
    private int numeroFactura;
    private Date fecha;
    private ArrayList<ItemFactura> items;

    public Factura(int numeroFactura, Date fecha) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        //this.items = new ArrayList<>();
    }

    public Factura(int numeroFactura, Date fecha, ArrayList<ItemFactura> items) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.items = items;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<ItemFactura> getItems() {
        return items;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setItems(ArrayList<ItemFactura> items) {
        this.items = items;
    }
    
    
}
