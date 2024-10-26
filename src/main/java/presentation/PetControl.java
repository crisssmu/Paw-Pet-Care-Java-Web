/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package presentation;

import com.google.gson.Gson;
import entities.Customer;
import java.io.IOException;
import java.util.List;

import entities.Pet;
import entities.Specie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import service.CustomerService;
import service.PetService;

import jakarta.servlet.RequestDispatcher;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Crism
 */
@WebServlet(name = "PetControl", urlPatterns = {"/PetControl"})
public class PetControl extends HttpServlet {

    PetService ps = new PetService();
    Pet pet = new Pet();
    CustomerService cs = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("contCustomer");
        if ("action" != null) {
            switch (action) {
                case "mostrar":
                    listPets(request, response);
                    break;
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("contPet");
        if ("action" != null) {
            switch (action) {
                case "registrar":
                    registerPet(request, response);
                    break;
            }

        }
    }

    protected void registerPet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String dateBirth = request.getParameter("dateBirth");
            String gender = request.getParameter("gender");
            Specie specie = Specie.valueOf(request.getParameter("specie"));
            Long documentOwner = Long.parseLong(request.getParameter("idOwner"));
            Long document = pet.generatePetDocument();

           Customer owner = cs.searchCustomerByDocument(documentOwner);
           Long idOwner = owner.getIdCustomer();

            if (ps.searchPetByOnwer_name(name, idOwner) != null) {
                request.setAttribute("mensaje", "Ya existe la mascota");
            } else if (cs.searchCustomerByDocument(idOwner) == null) {
                request.setAttribute("mensaje", "No existe el cliente");
            } else {
                Pet pet = new Pet(name, dateBirth, gender, specie, idOwner, document);
                ps.registerPet(pet);
                cs.loadPets(owner);
                request.setAttribute("mensaje", "Mascota registrada exitosamente");
            }
            

            request.getRequestDispatcher("/FormPet.jsp").forward(request, response);
        } 
         catch (NullPointerException ex) {
            request.setAttribute("mensaje", "Cliente no registrado");
            request.getRequestDispatcher("/FormPet.jsp").forward(request, response);
        }
        
    }

    protected List<Pet> listPets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> allPet = ps.getAllPet();
        String list = " ";
        int cont = 1;
        if (allPet == null || ps.getAllPet().isEmpty()) {
            request.setAttribute("mensaje", "No hay mascotas registradas");
        } else {
            for (Pet pet : allPet) {
                list += "[" + cont + "]" + "Nombre: " + pet.getName() + " Fecha Nacimiento: " + pet.getDateBirth() + " Genero: " + pet.getGender() + " Raza: " + pet.getSpecie() + " Propietario: " + pet.getIdOwner() + " Documento: " + pet.getDocument() + "<br>";
                cont++;
            }
            request.setAttribute("mensaje", "Estos son: <br>" + list);
        }

        request.getRequestDispatcher("/showPet.jsp").forward(request, response);
        return allPet;

    }
}
