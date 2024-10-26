/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import static java.lang.String.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Crism
 */
public class Pet {
    private Long idPet;
    private String name;
    private String dateBirth;
    private String gender;
    private Specie specie;
    private Long idOwner;
    private Long document;

    public Pet(String name, String dateBirth, String gender, Specie specie, Long idOwner, Long document) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.specie = specie;
        this.idOwner = idOwner;
        this.document = document;
    }

    
    public Pet(Long idPet, String name, String dateBirth, String gender, Specie specie, Long owner, Long document) {
        this.idPet = idPet;
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.specie = specie;
        this.idOwner = owner;
        this.document = document;
    }

   
    public Pet() {
    }
    

  public Long generatePetDocument(){
        Random random = new Random();
        int year = LocalDate.now().getYear();
        int randomDigits = 100000 + random.nextInt(900000);
        return Long.valueOf(valueOf(year + "" +randomDigits));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

   

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    /**
     * @return the id
     */
    public Long getIdPet() {
        return idPet;
    }

    /**
     * @param id the id to set
     */
    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

   
    
}
