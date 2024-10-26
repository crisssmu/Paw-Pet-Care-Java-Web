package entities;


import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Crism
 */
public class Customer {
    private Long idCustomer;
    private Long document;
    private String name;
    private String lastName;
    private String gender;
    private Long cellPhone;
    private String email;
    private String address;
    private List<Pet> pet;

    public Customer() {
    }

    public Customer(Long idCustomer, Long document, String name, String lastName, String gender, Long cellPhone, String email, String address) {
        this.idCustomer = idCustomer;
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.cellPhone = cellPhone;
        this.email = email;
        this.address = address;
       
    }

    public Customer(Long document, String name, String lastName, String gender, Long cellPhone, String email, String address) {
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.cellPhone = cellPhone;
        this.email = email;
        this.address = address;
       
    }
  

    /**
     * @return the idCustomer
     */
    public Long getIdCustomer() {
        return idCustomer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the cellPhone
     */
    public Long getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellPhone the cellPhone to set
     */
    public void setCellPhone(Long cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * @return the document
     */
    public Long getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(Long document) {
        this.document = document;
    }
    
}
