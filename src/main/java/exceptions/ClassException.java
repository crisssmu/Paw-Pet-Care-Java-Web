/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author Crism
 */
public class ClassException {
    
    public void validateOnlyNumbers(String input) throws NumberException{
        if(!input.matches("\\d+")){
            throw new NumberException("debe contener numeros");
        }
    }
    
    public void validateOnlyString(String input) throws Exception{
        if(!input.matches("[a-zA-Z]+")){
            throw new Exception("debe contener letras");
        }
    }
    
    public void validateOnlyElevenDigits(String input) throws Exception{
        int longi = input.length();
        if(longi != 11){
            throw new Exception("Solo debe tener 11 digitos");
        }
    }
    
    
}
