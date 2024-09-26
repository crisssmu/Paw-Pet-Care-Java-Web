/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import dataAccess.DataBase; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Crism
 */
public class CustomerRepository {
    private static final String url = "jdbc:postgresql://localhost:5432/pawpetcare";
    private static final String usuario = "postgres";
    private static final String password = "2911";
    
    private static DataBase database = new DataBase();
    private static DataBase db = new DataBase();
    private static Connection conn = db.connection();
    
    public void registerCustomer(Customer customer) {
        Connection conn = db.connection();
        if (conn != null) {
            try {
                String query = "INSERT INTO customer(document, name, lastname, gener, number, email, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setLong(1, customer.getDocument());
                stmt.setString(2, customer.getName());
                stmt.setString(3, customer.getLastName());
                stmt.setString(4, customer.getGener());
                stmt.setLong(5, customer.getNumber());
                stmt.setString(6, customer.getEmail());
                stmt.setString(7, customer.getAddres());
                stmt.executeUpdate();
                stmt.close();
                conn.close();
                //JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
            } catch (SQLException e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al registrar el cliente");
            }
        }
    }
    
    public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    try (Connection conn = database.connection()) {
        String query = "SELECT document, name, lastName, gener, number, email, address FROM customer";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Customer customer = new Customer(
                rs.getLong("document"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("gener"),
                rs.getLong("number"),
                rs.getString("email"),
                rs.getString("address")
            );
            customers.add(customer);
        }
        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return customers;
}
    public Customer searchCustomerById(Long document){
        try(Connection conn = database.connection()){
            String query = "SELECT * FROM Customer WHERE document = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, document);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String gener = rs.getString("gener");
                Long number = rs.getLong("number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Customer customer = new Customer(document, name, lastName, gener, number, email, address);
                return customer;
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateCustomer(Customer customer) {
            try(Connection conn = database.connection()){
                String query = "UPDATE customers SET name = ?, lastName = ?, gener = ?, number = ?, email = ?, address = ?, document = ? WHERE document = ?";
                
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setLong(7, customer.getDocument());
                ResultSet rs = ps.executeQuery();
                
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getLastName());
                ps.setString(3, customer.getGener());
                ps.setLong(4, customer.getNumber());
                ps.setString(5, customer.getEmail());
                ps.setString(6, customer.getAddres());
                ps.setLong(7, customer.getDocument());
                ps.executeUpdate();
                ps.close();
                conn.close();
                //JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente");
            }catch(Exception e){
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al actualizar el cliente");
            }

    }
    
    public boolean deleteCustomer(Long document) {
        
            try(Connection conn = database.connection()){
                String query = "DELETE FROM customer WHERE document = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setLong(1, document);
                ps.executeUpdate();
                ps.close();
                conn.close();
                return true;
            }catch(Exception e){
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al Eliminar el cliente");
            }
        return false;
    }

}
