/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Intentos2 {

    private ArrayList digitosList = new ArrayList();

    private Map<Integer, Integer> coleccion = new LinkedHashMap<Integer, Integer>();

    public Intentos2() {
    }

    public ArrayList getDigitosList() {
        return digitosList;
    }

    public void setDigitosList(ArrayList digitosList) {
        this.digitosList = digitosList;
    }

    public int Teclado() {
        Scanner reader = new Scanner(System.in);

        int ingreso = reader.nextInt();
        while (ingreso > 4 || ingreso < 0) {
            System.out.println("Incorrecto");
            this.Teclado();
        }
        return ingreso;
    }

    public void Adivinar(Numero valor) {
        System.out.println("Es: "+valor.getNumero()+" ?");
        System.out.println("Ingrese cantidad de numeros que estan bien");
        valor.setBien(Teclado());

        System.out.println("Ingrese cantidad de regulares");
        valor.setRegular(Teclado());

        if (valor.getBien() == 4) {
            System.out.println("GANE!! El numero es " + valor.getNumero());
        }
        if ((valor.getBien() + valor.getRegular()) == 4) {

            String num = Integer.toString(valor.getNumero());
            agregarDigitosList(num);
            valor.setNumero(Reordenar(this.digitosList));
            Adivinar(valor);

        } else {

            coleccion.put(valor.getNumero(), (valor.getRegular() + valor.getBien()));
            if (valor.getNumero() % 10 != 0) {
                valor.setNumero(valor.elegirNum(valor.getNumero()));
                Adivinar(valor);
            } else {
                Aciertos(coleccion);
                valor.setNumero(Reordenar(this.digitosList));

            }

        }

    }

    public int Reordenar(ArrayList diigitosList) {
        ArrayList num = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {

            int n = rand.nextInt(digitosList.size());

            if (num.contains(n)) { //verifica si el digito esta repetido
                i--;
            } else {
                num.add(n);
            }
        }
        String valor = num.toString();
        int valornum = Integer.parseInt(valor);
        return valornum;
    }

    public void agregarDigitosList(String numero) {

        for (int i = 0; i < numero.length(); i++) {
            if (digitosList.contains(numero.charAt(i))) {
                i--;
            } else {
                digitosList.add(numero.charAt(i));

            }

        }
    }

    public void Aciertos(Map coleccion) {
        ArrayList candidatos = new ArrayList();
        int numero = 0;
        Iterator it = coleccion.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            int valor = (int) coleccion.get(key);
            if (valor >= numero) {
                numero = valor;

            }

        }
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            int valor = (int) coleccion.get(key);
            if (valor == numero) {
                candidatos.add(key);
            }
            for (int i = 0; i < candidatos.size(); i++) {
                String value = candidatos.get(i).toString();
                agregarDigitosList(value);
            }
        }

    }
    

}
