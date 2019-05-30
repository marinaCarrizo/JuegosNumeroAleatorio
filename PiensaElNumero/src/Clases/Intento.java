/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Intento {

    private ArrayList digitosList = new ArrayList();
    ;
    private ArrayList probados = new ArrayList();
    private ArrayList digitosListProbados = new ArrayList();
    private Map<String, Integer> coleccion = new LinkedHashMap<String, Integer>();

    public Intento() {
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
            Teclado();
        }
        return ingreso;
    }

    public void Adivinar(Numero valor) {
        
        if (digitosListProbados.size() == 23) {
            System.out.println("Ya no tengo mas opciones para combinar, me estas mintiendo!");
        }  else {
            System.out.println("Es: " + valor.getNumero() + " ?");
            System.out.println("Ingrese cantidad de numeros que estan bien");
            valor.setBien(Teclado());

            System.out.println("Ingrese cantidad de regulares");
            valor.setRegular(Teclado());

            if (valor.getBien() == 4) {
                System.out.println("GANE!! El numero es " + valor.getNumero());
            } else {
                if ((valor.getBien() + valor.getRegular()) == 4) {

                    
                    digitosListProbados.add(valor.getNumero());
                   

                    String num = valor.getNumero();
                    digitosList.clear();
                    agregarDigitosList(num);
                    valor.setNumero(Reordenar(digitosList));
                    Adivinar(valor);

                } else {
                    if (valor.getBien() + valor.getRegular() == 0) {
                       
                        valor.eliminarDigitos(valor.getNumero());
                        valor.setNumero(valor.elegirNum());
                        Adivinar(valor);
                    } else {
                        if (digitosList.isEmpty()) {
                            coleccion.put(valor.getNumero(), (valor.getRegular() + valor.getBien())); // guardo (numero, suma de bien y regular)

                            if (valor.getProbados().size()!=10) {
                                valor.setNumero(valor.elegirNum());
                                Adivinar(valor);
                            } else {
                                Aciertos(coleccion);
                                valor.setNumero(Reordenar(digitosList));
                                Adivinar(valor);

                            }
                        } else {
                            valor.setNumero(Reordenar(digitosList));
                            Adivinar(valor);
                        }

                    }
                }
            }

        }

    }

    public String Reordenar(ArrayList diigitosList) {
        ArrayList digitosListAux = new ArrayList();
        if (digitosList.size() > 4) {

            digitosListAux.add(digitosList.get(digitosList.size() - 1));
            digitosListAux.add(digitosList.get(digitosList.size() - 2));
            digitosListAux.add(digitosList.get(digitosList.size() - 3));

            for (int i = 0; i < digitosList.size(); i++) {

                if ((!probados.contains(digitosList.get(i)) && (!digitosListAux.contains(digitosList.get(i))))) {
                    probados.add(digitosList.get(i));
                    digitosListAux.add(digitosList.get(i));
                    break;
                }
            }

        } else {
            digitosListAux = diigitosList;
        }
        Collections.shuffle(digitosListAux);

        String valornum = "";
        for (int i = 0; i < digitosListAux.size(); i++) {
            valornum = valornum + digitosListAux.get(i);
        }
        while (digitosListProbados.contains(valornum)) {
            Collections.shuffle(digitosListAux);
            valornum = "";
            for (int i = 0; i < digitosListAux.size(); i++) {
                valornum = valornum + digitosListAux.get(i);
            }
        }
        return valornum;
    }

    public void agregarDigitosList(String numero) {

        for (int i = 0; i < numero.length(); i++) {
            if (!digitosList.contains(numero.charAt(i))) {
                digitosList.add(numero.charAt(i));
            }

        }
    }

    public void Aciertos(Map coleccion) {
        ArrayList candidatos = new ArrayList();
        int numero = 0;
        Iterator it = coleccion.keySet().iterator();
        Iterator it1 = coleccion.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            int valor = (int) coleccion.get(key); //valor va a ser un numero entre 0 y 3
            if (valor >= numero) {
                numero = valor;

            }

        }
        while (it1.hasNext()) {                     // comparo cada suma con el valor obtenido arriba
            String key = (String) it1.next();      //obtengo sólo los candidatos con mayor cantidad de bien y regulares
            int valor = (int) coleccion.get(key);
            if (valor == numero) {
                candidatos.add(key);
            }

        }
        for (Object candidato : candidatos) {
            String value = candidato.toString();
            agregarDigitosList(value);
        }

    }

}
