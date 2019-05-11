/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Intentos {

    private int regular;
    private int coinciden;
    private NumeroAleatorio numAleatorio;

    public Intentos() {
    }

    public int getRegular() {
        return regular;
    }

    public void setRegular(int regular) {
        this.regular = regular;
    }

    public int getCoinciden() {
        return coinciden;
    }

    public void setCoinciden(int coinciden) {
        this.coinciden = coinciden;
    }

    public NumeroAleatorio getNumAleatorio() {
        return numAleatorio;
    }

    public void setNumAleatorio(NumeroAleatorio numAleatorio) {
        this.numAleatorio = numAleatorio;
    }

    public void Adivinar(NumeroAleatorio aleatorio) {
        listaDigitos(aleatorio);
        do {

            Scanner reader = new Scanner(System.in);

            System.out.println("Ingrese cantidad de coincidencias");
            coinciden = reader.nextInt();
            if (Integer.toString(coinciden).length() > 4 || Integer.toString(coinciden).length() < 0) {
                System.out.println("Incorrecto");
            }

            System.out.println("Ingrese cantidad de regulares");
            regular = reader.nextInt();
            if (Integer.toString(regular).length() > 4 || Integer.toString(regular).length() < 0) {
                System.out.println("Incorrecto");
            }

            if (coinciden == 4) {
                System.out.println("GANE!! El numero es " + aleatorio.getNumAleatorio());
            }
            if (regular >= 2) {

                for (int i = 0; i < 4; i++) {
                    aleatorio.getRegulares().add(Character.getNumericValue(aleatorio.getNumAleatorio().charAt(i)));

                }
                listaDigitos(aleatorio);
                if (coinciden >= 2) {
                    for (int i = 0; i < 4; i++) {
                        aleatorio.getDigitosList().add(Character.getNumericValue(aleatorio.getNumAleatorio().charAt(i)));

                    }
                    listaDigitos(aleatorio);
                }
            } else {
                listaDigitos(aleatorio);
            }
        } while (coinciden != 4);
    }

    private void listaDigitos(NumeroAleatorio n) {
        if (!n.getDigitosList().isEmpty() && n.getDigitosList().size() > 9) {
            n.elegirNum(n.getDigitosList());
        }
        if (!n.getRegulares().isEmpty() && n.getDigitosList().isEmpty()) {
            n.elegirNum(n.getRegulares());
        } else {
            n.elegirNum(n.getDigitos());
        }
    }
}


/*else {
 if (coinciden + regular==4) {

 for (int i = 0; i < 4; i++) {
 if (aleatorio.getDigitosList().contains(Character.getNumericValue(aleatorio.getNumAleatorio().charAt(i)))) {
 continue;
 } else {
 aleatorio.getDigitosList().add(Character.getNumericValue(aleatorio.getNumAleatorio().charAt(i)));
 }
 }
 }
 */            

            //}
