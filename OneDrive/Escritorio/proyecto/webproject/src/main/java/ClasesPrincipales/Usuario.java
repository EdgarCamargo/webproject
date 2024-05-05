/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class Usuario {
    
 private int id;                        // Identificador único del usuario
    private String username;            // Nombre de usuario
    private String password;            // Contraseña (se recomienda almacenarla de forma segura, como hash)
    private String nombreCompleto;      // Nombre completo del usuario
    private String correoElectronico;   // Correo electrónico del usuario
    private boolean activo;             // Estado activo/inactivo del usuario

    public Usuario(int id, String username, String password, String nombreCompleto, String correoElectronico) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
}