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
import entities.Pet;
import entities.Specie;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Crism
 */
public class PetRepository {

    private static final String url = "jdbc:postgresql://localhost:5432/pawpetcare";
    private static final String usuario = "postgres";
    private static final String password = "2911";

    private static DataBase database = new DataBase();
    private static DataBase db = new DataBase();
    private static Connection conn = db.connection();

    public void registerPet(Pet pet) {
        Connection conn = db.connection();
        if (conn != null) {
            String query = "INSERT INTO pets(name, dateBirth, gender, specie, owner, document) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt;
            try {
                
                stmt = conn.prepareStatement(query);
                stmt.setString(1, pet.getName());
                stmt.setDate(2, Date.valueOf(pet.getDateBirth()));
                stmt.setString(3, pet.getGender());
                stmt.setString(4, String.valueOf(pet.getSpecie()));
                stmt.setLong(5, pet.getIdOwner());
                stmt.setLong(6, pet.generatePetDocument());
                
                stmt.executeUpdate();
                stmt.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        try(Connection conn = database.connection()) {
            String query = "SELECT name, dateBirth, gender, specie, idOwner, document FROM pets";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Pet pet = new Pet(
                        rs.getLong("idPet"),
                        rs.getString("name"),
                        rs.getString("dateBirth"),
                        rs.getString("gender"),
                        Specie.valueOf(rs.getString("specie")),
                        rs.getLong("idOwner"),
                        rs.getLong("document")
                );

                pets.add(pet);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }

    
    
     public Pet searchPetByDocument(Long document) {
        try (Connection conn = database.connection()) {
            String query = "SELECT * FROM Pets WHERE document = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, document);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Long idPet = rs.getLong("idPet");
                String name = rs.getString("name");
                String dateBirth = rs.getString("dateBirth");
                String gender = rs.getString("gender");
                Specie specie = Specie.valueOf(rs.getString("specie"));
                Long owner = rs.getLong("owner");
                
                Pet pet = new Pet(idPet, name, dateBirth, gender, specie, owner,document);
                return pet;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
     public Pet searchPetByOwner_Name(Long idOwner, String name) {
        try (Connection conn = database.connection()) {
            String query = "SELECT * FROM Pets p LEFT JOIN Customer c ON p.idOwner = c.idCustomer WHERE p.idOwner = ? AND p.name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, idOwner);
            stmt.setString(2, name);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Long idPet = rs.getLong("idPet");
                String dateBirth = rs.getString("dateBirth");
                String gender = rs.getString("gender");
                Specie specie = Specie.valueOf(rs.getString("specie"));
                idOwner = rs.getLong("idOwner");
                Long document = rs.getLong("document");
                Pet pet = new Pet(idPet,name, dateBirth, gender, specie, idOwner, document);
                return pet;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean deletePet(Long idPet) {
        try (Connection conn = database.connection()) {
            String query = "DELETE FROM Pets WHERE idPet = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, idPet);
            ps.executeUpdate();
 
            ps.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    

}
