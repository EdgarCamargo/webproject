/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.dao;

import ClasesPrincipales.UsuarioRol;
import ClasesPrincipales.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRolDAO {
    private final Connection connection;
    
    public UsuarioRolDAO() {
        connection = ConnectionManager.estableceConecxion();
    }
    
    public void insertarUsuarioRol(UsuarioRol usuarioRol) {
        String query = "INSERT INTO usuario_rol (idUsuario, idRol, contaseña) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioRol.getIdUsuario());
            preparedStatement.setInt(2, usuarioRol.getIdRol());
            preparedStatement.setInt(3, usuarioRol.getContaseña());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Aquí podrías agregar más métodos según las operaciones que necesites realizar
    // para la relación usuario-rol, como obtener todos los roles de un usuario, 
    // obtener todos los usuarios de un rol, eliminar una relación usuario-rol, etc.
}