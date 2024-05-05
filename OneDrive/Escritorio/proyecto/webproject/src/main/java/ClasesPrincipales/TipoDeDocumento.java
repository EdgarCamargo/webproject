/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class TipoDeDocumento {
    
    private String nombre;             // Nombre del Usuario
    private String apellido;           // Apillido del Usuario
    private String tipodocumento;      // Tipo de documento
    private String numerodedocumento;   // Nùmero de Documento

    public TipoDeDocumento(String nombre, String apellido, String tipodocumento, String numerodedocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodocumento = tipodocumento;
        this.numerodedocumento = numerodedocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public String getNumerodedocumento() {
        return numerodedocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public void setNumerodedocumento(String numerodedocumento) {
        this.numerodedocumento = numerodedocumento;
    }
            
       
}
