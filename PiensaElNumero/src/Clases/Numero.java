/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marina
 */
public class Numero {

    private String numero;
    private int bien;
    private int regular;
    private ArrayList digitos = new ArrayList();
    private ArrayList probados = new ArrayList();

    public Numero() {

        digitos.add("1");
        digitos.add("2");
        digitos.add("3");
        digitos.add("4");
        digitos.add("5");
        digitos.add("6");
        digitos.add("7");
        digitos.add("8");
        digitos.add("9");
        digitos.add("0");
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getBien() {
        return bien;
    }

    public void setBien(int bien) {
        this.bien = bien;
    }

    public int getRegular() {
        return regular;
    }

    public void setRegular(int regular) {
        this.regular = regular;
    }

    public ArrayList getDigitos() {
        return digitos;
    }

    public void setDigitos(ArrayList digitos) {
        this.digitos = digitos;
    }

    public ArrayList getProbados() {
        return probados;
    }

    public void setProbados(ArrayList probados) {
        this.probados = probados;
    }

//Suma 1 al numero que se le pasa
    public String elegirNum() {

        List<String> valores = new ArrayList();
        valores.clear();;
        valores.add((String) digitos.get(0));
        valores.add((String) digitos.get(1));
        valores.add((String) digitos.get(2));
        valores.add((String) digitos.get(3));

        probados(valores);

        String valor = "";
        for (int i = 0;
                i < valores.size();
                i++) {
            valor = valor + valores.get(i);
        }
        return valor;

    }

    public void eliminarDigitos(String valor) {
        List<String> valores = new ArrayList<String>(Arrays.asList(valor.split("")));
        for (int i = 0; i < valores.size(); i++) {

            digitos.remove(valores.get(i));
        }
    }

    public void probados(List<String> valores) {

        for (int i = 0; i < valores.size() - 1; i++) {
            if (!probados.contains(digitos.get(i))) {
                probados.add(digitos.get(i));
            }
        }
        for (int i = 0; i < digitos.size(); i++) {
            if (!probados.contains(digitos.get(i))) {
                probados.add(digitos.get(i));
                valores.remove(valores.get(3));
                valores.add((String) digitos.get(i));

                break;
            }
        }

    }
}
