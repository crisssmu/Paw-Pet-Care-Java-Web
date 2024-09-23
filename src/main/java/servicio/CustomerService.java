/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.List;
import persistencia.Customer;
import persistencia.CustomerRepository;

/**
 *
 * @author Crism
 */
public class CustomerService {
    CustomerRepository cr = new CustomerRepository();
    public void registerCustomer(Customer customer){
        if(customer != null && customer.getName() != null){
            cr.registerCustomer(customer);
        } else {
            throw new IllegalArgumentException("Customer data is invalid");
        }   
    }
    
    public List<Customer> getAllCustomers(){
        return cr.getAllCustomers();
    }
    
    public void updateCustomer(Customer customer){
        if(customer != null && customer.getName() != null){
            cr.updateCustomer(customer);
        } else {
            throw new IllegalArgumentException("Customer data is invalid");
        }  
    }
    
  
}
