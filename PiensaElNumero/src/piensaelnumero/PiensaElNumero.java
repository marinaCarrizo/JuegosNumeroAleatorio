/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piensaelnumero;

import Clases.Intentos;
import Clases.NumeroAleatorio;

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
        NumeroAleatorio aleatorio = new NumeroAleatorio();
        aleatorio.elegirNum();
        System.out.println("Es: "+ aleatorio.getNumAleatorio());
        Intentos i = new Intentos();
        i.Adivinar(aleatorio);

      /*  int numero;
        int x = 1;
        do {
            

            System.out.println("INTENTO: " + x);
            numero = i.teclado();
            i.coincidencias(numero, aleatorio);
            i.regulares(numero, aleatorio);
            x++;

        } while (numero!= Integer.parseInt(aleatorio.getNumAleatorio()));*/
    }
    
}
