/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.dao;

import ClasesPrincipales.Cliente;
import ClasesPrincipales.ConnectionManager;
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
public class ClienteDAO {
    private final Connection connection;
    
    public ClienteDAO() {
        connection = ConnectionManager.estableceConecxion();
    }
    
    // Método para insertar un cliente
    public void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (nombre, apellido, dirección, teléfono, idTipoDeDocumento, numerodeDocumento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setInt(5, cliente.getIdTipoDocumento());
            preparedStatement.setString(6, cliente.getNumeroDeDocumento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Método para listar todos los clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM cliente";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDireccion(resultSet.getString("dirección"));
                cliente.setTelefono(resultSet.getString("teléfono"));
                cliente.setIdTipoDocumento(resultSet.getInt("idTipoDeDocumento"));
                cliente.setNumeroDeDocumento(resultSet.getString("numerodeDocumento"));
                
                //agregar cliente a lista de clientes
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    
    //Método para obtener un cliente por el id
    public Cliente obtenerUnCliente(Integer idCliente) {
        Cliente cliente = new Cliente();
        String query = "SELECT * FROM cliente where Id = " + idCliente;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDireccion(resultSet.getString("dirección"));
                cliente.setTelefono(resultSet.getString("teléfono"));
                cliente.setIdTipoDocumento(resultSet.getInt("idTipoDeDocumento"));
                cliente.setNumeroDeDocumento(resultSet.getString("numerodeDocumento"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    // Método para actualizar un cliente
    public boolean actualizarCliente(Cliente cliente) {
        String query = "UPDATE cliente SET "
                + "nombre = ?, "
                + "apellido = ?, "
                + "dirección = ?, "
                + "teléfono = ?, "
                + "idTipoDeDocumento = ?, "
                + "numeroDeDocumento = ? "
                + "WHERE id = ?";
        
        try (Connection connection = ConnectionManager.estableceConecxion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setInt(5, 1);
            preparedStatement.setString(6, cliente.getNumeroDeDocumento());
            preparedStatement.setInt(7, cliente.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para eliminar un cliente por su ID
    public boolean eliminarCliente(int idCliente) {
        String query = "DELETE FROM cliente WHERE id = ?";
        try (Connection connection = ConnectionManager.estableceConecxion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idCliente);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente obtenerClientePorId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
