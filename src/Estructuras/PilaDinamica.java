/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Gaston
 */
public class PilaDinamica {

    private Nodo tope;

    public PilaDinamica() {
    }

    public PilaDinamica(int elem) {
        tope = new Nodo(elem);
    }

    public boolean apilar(int elem) {
        boolean seApilo = true;
        if (!esVacia()) {
            /*Nodo nuevo = new Nodo(elem);
            nuevo.setEnlace(tope);
            tope = nuevo;*/
            tope = new Nodo(elem, tope);
        } else {
            tope.setElem(elem);
        }

        return seApilo;
    }

    public boolean desapilar() {
        boolean seDesapilo = false;
        if (!esVacia()) {
            seDesapilo = true;
            tope.setEnlace(tope.getEnlace());
        }
        return seDesapilo;
    }

    public int getTope() {
        return tope.getElem();
    }

    public boolean esVacia() {
        return (tope == null);
    }

    public void vaciar() {
        tope = null;
    }

    /*public PilaDinamica clonar() {
                               PilaDinamica clon = new PilaDinamica();
                              
                               return new PilaDinamica();
                }*/
    @Override
    public String toString() {
        Nodo actual = tope;
        String cadena = "Pila: ";
        while (actual.getEnlace() != null) {
            cadena = cadena + actual.getElem();
            actual = actual.getEnlace();
        }
        return cadena;
    }
}
