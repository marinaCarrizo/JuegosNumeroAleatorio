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
    private int coinciden;
    NumeroAleatorio numAleatorio;

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

    public int teclado() {
        int numero;
        do {
            System.out.println("Ingrese un numero de 4 dígitos");
            Scanner reader = new Scanner(System.in);
            numero = reader.nextInt();
            if (Integer.toString(numero).length() > 4) {
                System.out.println("Incorrecto");

            }
        } while (Integer.toString(numero).length() > 4);
        return numero;
    }

    public void coincidencias(int numero, NumeroAleatorio aleato) {
        coinciden = 0;
        String num = Integer.toString(numero);
        String aleatorio = aleato.getNumAleatorio();

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == aleatorio.charAt(i)) {
                coinciden++;
            }

        }
        System.out.println("Coincidencias: " + coinciden);
    }

    public void regulares(int numero, NumeroAleatorio aleato) {

        regular = 0;
        String num = Integer.toString(numero);
        String aleatorio = aleato.getNumAleatorio();

        for (int i = 0; i < aleatorio.length(); i++) {
            if (num.charAt(i) != aleatorio.charAt(i) && num.indexOf(aleatorio.charAt(i)) > -1) {

                regular++;
            }

        }
        System.out.println("Regulares: " + regular);

    }

}
