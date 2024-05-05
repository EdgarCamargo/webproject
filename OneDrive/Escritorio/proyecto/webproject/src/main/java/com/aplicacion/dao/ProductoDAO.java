/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.dao;

import ClasesPrincipales.ConnectionManager;
import ClasesPrincipales.Producto;
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
public class ProductoDAO {
    private final Connection connection;
    
    public ProductoDAO() {
        connection = ConnectionManager.estableceConecxion();
    }
    
    // Método para insertar un cliente
    public void insertarProducto(Producto producto) { 
        String query = "INSERT INTO proveedor (Codigo, Nombre, Descripción, Precio, StockInventario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getDescripción());
            preparedStatement.setString(4, producto.getPrecio());
            preparedStatement.setInt(5, producto.getStockInventario());            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Método para listar todos los Productos
    public List<Producto> listarProducto() {
        List<Producto> listaProductos = new ArrayList<Producto>();
        String query = "SELECT * FROM producto";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getInt("Id"));
                producto.setCodigo(resultSet.getString("Codigo"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setDescripción(resultSet.getString("Descripción"));
                producto.setPrecio(resultSet.getString("Precio"));
                producto.setStockInventario(resultSet.getInt("StockInventario"));
                
                //agregar proveedor a lista de proveedores
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    //Método para obtener un producto por el id
    public Producto obtenerUnProducto(Integer idProducto) {
        Producto producto = new Producto();
        String query = "SELECT * FROM producto where Id = " + idProducto;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                producto.setId(resultSet.getInt("id"));
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripción(resultSet.getString("descripción"));
                producto.setPrecio(resultSet.getString("precio"));
                producto.setStockInventario(resultSet.getInt("stockinventario"));
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }
    
    // Método para actualizar un producto
    public boolean actualizarProducto(Producto producto) {
        String query = "UPDATE producto SET "
                + "Codigo = ?, "
                + "Nombre = ?, "
                + "Descripción = ?, "
                + "Precio = ?, "
                + "StockInventario = ? "
                + "WHERE Id = ?";
        
        try (Connection connection = ConnectionManager.estableceConecxion();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getDescripción());
            preparedStatement.setString(4, producto.getPrecio());
            preparedStatement.setInt(5, 2); //NIT            
            preparedStatement.setInt(6, producto.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para eliminar un producto por su ID
    public boolean eliminarProducto(int idProducto) {
        String query = "DELETE FROM producto WHERE id = ?";
        try (Connection connection = ConnectionManager.estableceConecxion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idProducto);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }   
}