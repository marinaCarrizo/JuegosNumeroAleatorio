/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piensaelnumero;

import Clases.Intentos2;
import Clases.Numero;

/**
 *
 * @author Marina
 */
public class PiensaElNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Piensa un numero de 4 digitos");
        Numero numero = new Numero();
        numero.setNumero(1234);
        
      
        Intentos2 i = new Intentos2();
        i.Adivinar(numero);

    
    }
    
}
