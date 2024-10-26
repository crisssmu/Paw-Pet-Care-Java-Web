/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package presentation;

import java.io.IOException;
import java.util.List;

import entities.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 *
 * @author Crism
 */
@WebServlet(name = "CustomerControl", urlPatterns = {"/CustomerControl"})
public class CustomerControl extends HttpServlet {
  
    
    CustomerService cs = new CustomerService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("contCustomer");
        if ("action" != null) {
            switch (action) {
                case "mostrar":
                    listCustomer(request, response);
                    break;
                case "search":
                    searchCustomerByDocument(request, response);
            }

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("contCustomer");
        if ("action" != null) {
            switch (action) {
                case "registrar":
                    registerCustomer(request, response);
                    break;
                case "eliminar":
                    deleteCustomer(request, response);
                    break;
            }

        }
    }

    protected void registerCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Long document = Long.parseLong(request.getParameter("document"));
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            Long cellPhone = Long.parseLong(request.getParameter("cellPhone"));
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            // Validar si ya existe el cliente
            if (cs.searchCustomerByDocument(document) != null) {
                request.setAttribute("mensaje", "El documento ya existe");
            } else {
                // Validar datos incompletos
                if (name == null || name.isEmpty() || lastName == null || lastName.isEmpty() || gender == null || gender.isEmpty()) {
                    request.setAttribute("mensaje", "Los datos del cliente están incompletos");
                } else {
                    Customer customer = new Customer(document, name, lastName, gender, cellPhone, email, address);
                    cs.registerCustomer(customer);
                    request.setAttribute("mensaje", "Cliente registrado exitosamente");
                }
            }
            request.getRequestDispatcher("/FormCustomer.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "Error en los datos númericos");
            request.getRequestDispatcher("/FormCustomer.jsp").forward(request, response);
        }

    }

    protected List<Customer> listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Customer> allCustomers = cs.getAllCustomers();
        try {
            
            String lis = " ";
            int cont = 1;
            if (allCustomers == null || cs.getAllCustomers().isEmpty()) {
                request.setAttribute("mensaje", "No hay datos que mostrar");
            } else {
                for (Customer allCustomer : allCustomers) {
                    lis += "[" + cont + "]" + " ID: " + allCustomer.getDocument() + " Nombre: " + allCustomer.getName() + " Apellido: " + allCustomer.getLastName() + " Genero: " + allCustomer.getGender() + " Numero: " + allCustomer.getCellPhone() + " Email: " + allCustomer.getEmail() + " Direccion: " + allCustomer.getAddress() + "<br>";
                    cont++;
                }
                request.setAttribute("mensaje", "Estos son: <br>" + lis);
            }
        } catch (Exception e) {
            request.setAttribute("mensaje", "No hay clientes registrados");
        }

        request.getRequestDispatcher("/ShowCustomer.jsp").forward(request, response);
        return allCustomers;
    }

    protected void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long document = Long.parseLong(request.getParameter("document"));
            Customer cus = cs.searchCustomerByDocument(document);
            boolean success = cs.deleteCustomer(cus);

            // Mensaje para la vista
            if (success) {
                request.setAttribute("mensaje", "Cliente eliminado exitosamente");
            } else {
                request.setAttribute("mensaje", "No se encontró el cliente");
            }

            request.getRequestDispatcher("/DeleteCustomer.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "Debe digitar el documento");
            request.getRequestDispatcher("/DeleteCustomer.jsp").forward(request, response);
        }

    }
    
    
    protected Customer searchCustomerByDocument(HttpServletRequest request, HttpServletResponse responser) throws ServletException, IOException {
        try{
            Long document = Long.parseLong(request.getParameter("document"));
            Customer cus = cs.searchCustomerByDocument(document);
            String lis = " Documento: "+cus.getDocument()+"<br> Nombre: "+cus.getName()+"<br> Apellido: "+cus.getLastName()+"<br> Genero: "+cus.getGender()+"<br> Numero: "+cus.getCellPhone()+"<br> Email: "+cus.getEmail()+"<br> Direccion: "+cus.getAddress();
            
            request.setAttribute("mensaje",  lis);
            request.getRequestDispatcher("/CustomerSearch.jsp").forward(request, responser);
            return cus;
        }catch(NumberFormatException e){
            request.setAttribute("mensaje", "Error en el dato");
            request.getRequestDispatcher("/CustomerSearch.jsp").forward(request, responser);
        } catch(NullPointerException ex){
            request.setAttribute("mensaje", "No existe el cliente");
            request.getRequestDispatcher("/CustomerSearch.jsp").forward(request, responser);
        }
        return null;
    }
}



