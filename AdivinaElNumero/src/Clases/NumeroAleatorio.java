/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marina
 */
public class NumeroAleatorio {

    private String numAleatorio;
    private final int digitos[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public NumeroAleatorio() {

    }

    public String getNumAleatorio() {
        return numAleatorio;
    }

    public void setNumAleatorio(String numAleatorio) {
        this.numAleatorio = numAleatorio;
    }

    public int[] getDigitos() {
        return digitos;
    }
//Metodo que forma un numero aleatorio de 4 dígitos utilizando el array digitos
    public String elegirNum() {

        ArrayList num = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {

            int numero = rand.nextInt(digitos.length);

            if (numero == 0 && i == 0) { // si el primer numero es 0, se descarta
                i--;
            } else {
                if (num.contains(numero)) { //verifica si el digito esta repetido
                    i--;
                } else {
                    num.add(numero);
                }
            }

        }
        String numero = "";
        for (Object n : num) {
            numero+= n.toString();
            this.numAleatorio=numero;
        }

        return numAleatorio;

    }
}
