/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.dao;

import ClasesPrincipales.ConnectionManager;
import ClasesPrincipales.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDGAR
 */
public class ProveedoresDAO {
    private final Connection connection;
    
    public ProveedoresDAO() {
        connection = ConnectionManager.estableceConecxion();
    }
    
    // Método para insertar un cliente
    public void insertarProveedor(Proveedor proveedor) { 
        String query = "INSERT INTO proveedor (Nombre, Dirección, Teléfono, NumeroDocumento, IdTipoDocumento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, proveedor.getNombre());
            preparedStatement.setString(2, proveedor.getDireccion());
            preparedStatement.setString(3, proveedor.getTelefono());
            preparedStatement.setString(4, proveedor.getNumeroDeDocumento());
            preparedStatement.setInt(5, proveedor.getIdTipoDocumento());            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Método para listar todos los clientes
    public List<Proveedor> listarProveedor() {
        List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        String query = "SELECT * FROM proveedor";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(resultSet.getInt("Id"));
                proveedor.setNombre(resultSet.getString("Nombre"));
                proveedor.setDireccion(resultSet.getString("Dirección"));
                proveedor.setTelefono(resultSet.getString("Teléfono"));
                proveedor.setNumeroDeDocumento(resultSet.getString("NumeroDocumento"));
                proveedor.setIdTipoDocumento(resultSet.getInt("IdTipoDocumento"));
                
                //agregar proveedor a lista de proveedores
                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProveedores;
    }
    
    //Método para obtener un cliente por el id
    public Proveedor obtenerUnProveedor(Integer idProveedor) {
        Proveedor proveedor = new Proveedor();
        String query = "SELECT * FROM proveedor where Id = " + idProveedor;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                proveedor.setId(resultSet.getInt("id"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setDireccion(resultSet.getString("dirección"));
                proveedor.setTelefono(resultSet.getString("teléfono"));
                proveedor.setNumeroDeDocumento(resultSet.getString("numerodeDocumento"));
                proveedor.setIdTipoDocumento(resultSet.getInt("idTipoDeDocumento"));
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedor;
    }
    
    // Método para actualizar un cliente
    public boolean actualizarProveedor(Proveedor proveedor) {
        String query = "UPDATE proveedor SET "
                + "Nombre = ?, "
                + "Dirección = ?, "
                + "Teléfono = ?, "
                + "NumeroDocumento = ?, "
                + "IdTipoDocumento = ? "
                + "WHERE Id = ?";
        
        try (Connection connection = ConnectionManager.estableceConecxion();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, proveedor.getNombre());
            preparedStatement.setString(2, proveedor.getDireccion());
            preparedStatement.setString(3, proveedor.getTelefono());
            preparedStatement.setString(4, proveedor.getNumeroDeDocumento());
            preparedStatement.setInt(5, 2); //NIT            
            preparedStatement.setInt(6, proveedor.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para eliminar un cliente por su ID
    public boolean eliminarProveedor(int idProveedor) {
        String query = "DELETE FROM cliente WHERE id = ?";
        try (Connection connection = ConnectionManager.estableceConecxion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idProveedor);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }   
}