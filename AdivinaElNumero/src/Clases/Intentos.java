/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Intentos {

    private int regular;
    private int bien;
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
        return bien;
    }

    public void setCoinciden(int bien) {
        this.bien = bien;
    }

    public NumeroAleatorio getNumAleatorio() {
        return numAleatorio;
    }

    public void setNumAleatorio(NumeroAleatorio numAleatorio) {
        this.numAleatorio = numAleatorio;
    }

    public int teclado() {
        int numero;

        do {
            System.out.println("Ingrese un numero de 4 dígitos");
            Scanner reader = new Scanner(System.in);
            numero = reader.nextInt();
            if (Integer.toString(numero).length() > 4 || Integer.toString(numero).length() < 4) {
                System.out.println("Incorrecto");

            }
        } while (Integer.toString(numero).length() > 4 || Integer.toString(numero).length() < 4);
        return numero;

    }

    public void Adivinar(NumeroAleatorio aleato) {
        int numero = teclado();
        bien = 0;
        regular = 0;
        String num = Integer.toString(numero);
        String aleatorio = aleato.getNumAleatorio();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == aleatorio.charAt(i)) {
                bien++;
            }

        }
        System.out.println("Coincidencias: " + bien);
        if (bien == 4) {
            System.out.println("feliidades!! Ganaste");
        } else {
            for (int i = 0; i < aleatorio.length(); i++) {
                if (num.charAt(i) != aleatorio.charAt(i) && num.indexOf(aleatorio.charAt(i)) > -1) {

                    regular++;
                }

            }
            System.out.println("Regulares: " + regular);
            Adivinar(aleato);
        }

    }

}
