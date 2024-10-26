/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

import entities.Customer;
import persistence.CustomerRepository;

/**
 *
 * @author Crism
 */
public class CustomerService {
    CustomerRepository cr = new CustomerRepository();

    public void registerCustomer(Customer customer) {
        cr.registerCustomer(customer);
    }
    public List<Customer> getAllCustomers(){
        return cr.getAllCustomers();
    }
    public boolean deleteCustomer(Customer customer){
        return cr.deleteCustomer(customer);
    }
    public void updateCustomer(Customer customer){
        cr.updateCustomer(customer);
    }
    public Customer searchCustomerByDocument(Long document){
        return cr.searchCustomerByDocument(document);
    }
    
    public void loadPets(Customer customer){
        cr.loadPets(customer);
    }
    
  
}
