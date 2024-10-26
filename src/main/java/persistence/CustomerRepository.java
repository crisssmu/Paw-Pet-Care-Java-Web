/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataAccess.DataBase;
import entities.Customer;
import entities.Pet;
import entities.Specie;
import java.time.LocalDate;
import java.util.Date;

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
    private String query;
    private PreparedStatement ps;

    public void registerCustomer(Customer customer) {
        if (conn != null) {
            try {
                query = "INSERT INTO customers(document, name, lastname, gender, cellphone, email, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(query);
                ps.setLong(1, customer.getDocument());
                ps.setString(2, customer.getName());
                ps.setString(3, customer.getLastName());
                ps.setString(4, customer.getGender());
                ps.setLong(5, customer.getCellPhone());
                ps.setString(6, customer.getEmail());
                ps.setString(7, customer.getAddress());

                ps.executeUpdate();
                ps.close();
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
            query = "SELECT idCustomer, document, name, lastName, gender, cellPhone, email, address FROM customers";
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer(
                        rs.getLong("idCustomer"),
                        rs.getLong("document"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("gender"),
                        rs.getLong("cellPhone"),
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

    public Customer searchCustomerByDocument(Long document) {
        try (Connection conn = database.connection()) {
            query = "SELECT * FROM Customers WHERE document = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, document);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Long idCustomer = rs.getLong("idCustomer");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                Long cellPhone = rs.getLong("cellPhone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                
                return new Customer(idCustomer,document, name, lastName, gender, cellPhone, email, address);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        try (Connection conn = database.connection()) {
            query = "UPDATE customers SET name = ?, lastName = ?, gender = ?, cellPhone = ?, email = ?, address = ?, document = ? WHERE idCustomer = ?";

            ps = conn.prepareStatement(query);

            ps.setLong(8, customer.getIdCustomer());

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getGender());
            ps.setLong(4, customer.getCellPhone());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getAddress());
            ps.setLong(7, customer.getDocument());
            ps.executeUpdate();
            ps.close();
            conn.close();
            //JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error al actualizar el cliente");
        }

    }

    public boolean deleteCustomer(Customer customer) {

        try (Connection conn = database.connection()) {
            query = "DELETE FROM customers WHERE idCustomer = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, customer.getIdCustomer());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error al Eliminar el cliente");
        }
        return false;
    }

    public void loadPets(Customer customer) {
        try (Connection conn = database.connection()) {
            //join con pet con el id del customer 
            query = "SELECT * FROM pets WHERE idOwner = ?";
            List<Pet> pets = new ArrayList<>();
            ps = conn.prepareStatement(query);
            ps.setLong(1, customer.getIdCustomer());
            ResultSet rs = ps.executeQuery();
            Pet pet = null;
            //recorrer rs crear pet y guardar en una lista
            while (rs.next()) {
                Long idPet = rs.getLong("id");
                String name = rs.getString("name");
                String String = rs.getString("dateBirth");
                String gender = rs.getString("gender");
                Specie specie = Specie.valueOf(rs.getString("specie"));
                Long document = rs.getLong("document");
                Long idOwner = rs.getLong(Long.toString(customer.getIdCustomer()));
                new Pet(idPet, name, String, gender, specie, idOwner, document);

            }
            pets.add(pet);
            customer.setPet(pets);
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
