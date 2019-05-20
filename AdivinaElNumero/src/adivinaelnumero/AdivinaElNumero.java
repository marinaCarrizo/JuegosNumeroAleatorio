/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinaelnumero;

import Clases.Intentos;
import Clases.NumeroAleatorio;

/**
 *
 * @author Marina
 */
public class AdivinaElNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Hola Pensaré en un numero de 4 dígitos distintos y debes adivinarlo");
        NumeroAleatorio aleatorio = new NumeroAleatorio();
        aleatorio.elegirNum();
       // System.out.println(aleatorio.getNumAleatorio());

        Intentos i = new Intentos();

        i.Adivinar(aleatorio);

    }

}
