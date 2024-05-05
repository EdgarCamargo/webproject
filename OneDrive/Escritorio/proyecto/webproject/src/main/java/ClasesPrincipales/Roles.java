/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class Roles {
    
    private String nombre;           // Nombre del rol
    private String cedula;           // Nùmero de Documento
    private String descripcion;      // Descripción del rol

    public Roles(String nombre, String cedula, String descripcion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
         
}
