/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import persistence.Customer;
import service.CustomerService;

/**
 *
 * @author Crism
 */
public class CustomerControl extends HttpServlet {

    CustomerService cs = new CustomerService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cual = request.getParameter("contCustomer");

        if (cual.equals("registrar")) {
            Long document = Long.parseLong(request.getParameter("document"));
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String gener = request.getParameter("gener");
            Long number = Long.parseLong(request.getParameter("number"));
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            if (cs.searchCustomer(document) != null) {
                request.setAttribute("mensaje", "El documento existe");
            } else {
                Customer customer = new Customer(document, name, lastName, gener, number, email, address);
                cs.registerCustomer(customer);
                request.setAttribute("mensaje", "Cliente registrado existosamente");
            }

            request.getRequestDispatcher("/FormCustomer.jsp").forward(request, response);
        } else if (cual.equals("mostrar")) {
            List<Customer> allCustomers = cs.getAllCustomers();
            String lis = " ";
            int cont=1;
            for (Customer allCustomer : allCustomers) {
                lis += "["+cont+"]" +" ID: " + allCustomer.getDocument() + " Nombre: " + allCustomer.getName() + " Apellido: " +allCustomer.getLastName()+ " Genero: " + allCustomer.getGener() +" Numero: "+ allCustomer.getNumber() + " Email: " + allCustomer.getEmail() + " Direccion: " + allCustomer.getAddres() + "<br>";
                cont++;
            }

            request.setAttribute("mensaje", "Estos son: <br>" + lis);
            request.getRequestDispatcher("/ShowCustomer.jsp").forward(request, response);
        } else if (cual.equals("eliminar")) {
            Long document = Long.parseLong(request.getParameter("document"));

            boolean success;
            success = cs.deleteCustomer(document);

            // Mensaje para la vista
            if (success) {
                request.setAttribute("mensaje", "Cliente eliminado exitosamente");
            } else {
                request.setAttribute("mensaje", "No se encontró el cliente");
            }
            cs.deleteCustomer(document);
            request.setAttribute("mensaje", "Cliente eliminado exitosamente");
            request.getRequestDispatcher("/DeleteCustomer.jsp").forward(request, response);
        } 

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
