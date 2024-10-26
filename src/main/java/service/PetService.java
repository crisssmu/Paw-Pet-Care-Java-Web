/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

import entities.Pet;
import persistence.PetRepository;

/**
 *
 * @author Crism
 */
public class PetService {
    PetRepository pr = new PetRepository();
    
    public void registerPet(Pet pet){
        pr.registerPet(pet);
    }
    
    public List<Pet> getAllPet(){
        return pr.getAllPets();
    }
    
    public boolean deletePet(Long document){
        return pr.deletePet(document);
    }
    
    public Pet searchPetByOnwer_name(String name, Long idOwner){
        return pr.searchPetByOwner_Name(idOwner, name);
    }
    
    public Pet searchPetByDocument(Long document){
        return pr.searchPetByDocument(document);
    }

}
