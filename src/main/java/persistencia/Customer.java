/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author Crism
 */
public class Customer {
    private Long document;
    private String name;
    private String lastName;
    private String gener;
    private Long number;
    private String email;
    private String addres;

    public Customer() {
    }

    public Customer(Long document, String name, String lastName, String gener, Long number, String email, String addres) {
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.gener = gener;
        this.number = number;
        this.email = email;
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Customer{" + "document=" + document + ", name=" + name + ", lastName=" + lastName + ", gener=" + gener + ", number=" + number + ", email=" + email + ", addres=" + addres + '}';
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
     * @return the gener
     */
    public String getGener() {
        return gener;
    }

    /**
     * @param gener the gener to set
     */
    public void setGener(String gener) {
        this.gener = gener;
    }

    /**
     * @return the number
     */
    public Long getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Long number) {
        this.number = number;
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
     * @return the addres
     */
    public String getAddres() {
        return addres;
    }

    /**
     * @param addres the addres to set
     */
    public void setAddres(String addres) {
        this.addres = addres;
    }
    
}
