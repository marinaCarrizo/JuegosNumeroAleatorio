/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Marina
 */
public class NumeroAleatorio {

    private String numAleatorio;
    private final ArrayList digitos = new ArrayList(10);
    private ArrayList digitosList = new ArrayList();
    private ArrayList regulares = new ArrayList();
    int numero;

    public NumeroAleatorio() {
        for (int i = 0; i < 10; i++) {
            numero = (int) (Math.random() * 10);

            if (digitos.contains(numero)) {
                i--;
            } else {
                digitos.add(numero);
            }
        }
    }

    public String getNumAleatorio() {
        return numAleatorio;
    }

    public void setNumAleatorio(String numAleatorio) {
        this.numAleatorio = numAleatorio;
    }

    public ArrayList getDigitos() {
        return digitos;
    }

    public ArrayList getDigitosList() {
        return digitosList;
    }

    public void setDigitosList(ArrayList digitosList) {
        this.digitosList = digitosList;

    }

    public ArrayList getRegulares() {
        return regulares;
    }

    public void setRegulares(ArrayList regulares) {
        this.regulares = regulares;
    }

//Metodo que forma un numero aleatorio de 4 dígitos utilizando el array digitos
    public String elegirNum(ArrayList l) {

        ArrayList num = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {

            int n = rand.nextInt(l.size());

            if (n == 0 && i == 0) { // si el primer numero es 0, se descarta
                i--;
            } else {
                if (num.contains(n)) { //verifica si el digito esta repetido
                    i--;
                } else {
                    num.add(n);
                }
            }

        }

        String n = "";
        for (Object x : num) {
            n += x.toString();
            this.numAleatorio = n;
        }
        System.out.println("Es: " + numAleatorio + " ?");
        return numAleatorio;
    }

}
