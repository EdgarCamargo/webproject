/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EDGAR
 */
public class ConnectionManager {
          
    Connection conectar = null; 
    
    private static final String usuario = "root";
    private static final String contraseña = "edgar34";
    String basededatos = "sistemadefacturación";
    String ip = "localhost";
    String puerto = "3306";
    
    //private static final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + basededatos;
    private static final String cadena = "jdbc:mysql://localhost:3306/sistemadefacturación";
    /**
     *
     * @return
     */
    public static Connection estableceConecxion(){
    
        try  
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(cadena,usuario,contraseña);
            //JOptionPane.showMessageDialog(null,"La conexion se ha realizado con Éxito");
                    
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos, error:" + e.toString());
            return null;
        }
        
        //return conectar;
    }
    
    /*public static Connection estableceConecxion() throws SQLException {
        return DriverManager.getConnection(cadena,usuario,contraseña);
    }*/
}


