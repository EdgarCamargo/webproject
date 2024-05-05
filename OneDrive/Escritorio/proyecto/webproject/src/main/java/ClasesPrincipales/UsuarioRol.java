/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

/**
 *
 * @author EDGAR
 */
public class UsuarioRol {
    
    private int id;             // Identificador único de la relación usuario-rol
    private int contaseña;      // Ingresar contraeña
    private int idUsuario;      // Identificador del usuario
    private int idRol;          // Identificador del rol

        public UsuarioRol(int id, int contaseña, int idUsuario, int idRol) {
            this.id = id;
            this.contaseña = contaseña;
            this.idUsuario = idUsuario;
            this.idRol = idRol;
        }

        public int getId() {
            return id;
        }

        public int getContaseña() {
            return contaseña;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public int getIdRol() {
            return idRol;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setContaseña(int contaseña) {
            this.contaseña = contaseña;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public void setIdRol(int idRol) {
            this.idRol = idRol;
        }
    
        
}