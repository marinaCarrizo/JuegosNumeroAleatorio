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

        NumeroAleatorio aleatorio = new NumeroAleatorio();
        aleatorio.elegirNum();
        System.out.println(aleatorio.getNumAleatorio());

        int numero;
        int x = 1;
        do {
            Intentos i = new Intentos();

            System.out.println("INTENTO: " + x);
            numero = i.teclado();
            i.coincidencias(numero, aleatorio);
            i.regulares(numero, aleatorio);
            x++;

        } while (numero!= Integer.parseInt(aleatorio.getNumAleatorio()));
        System.out.println("Correcto. JUEGO TERMINADO");
    }

}
