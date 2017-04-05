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
public class Nodo {

    private int elem;
    private Nodo enlace;
    private int altura;

    public Nodo(int ele) {
        elem = ele;
        enlace = null;
        altura = -1;
    }

    public Nodo(int ele, Nodo enla) {
        elem = ele;
        enlace = enla;
    }

    public int getElem() {
        return elem;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setElem(int e) {
        elem = e;
    }

    public void setEnlace(Nodo e) {
        enlace = e;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public void setAltura(int alt) {
        altura = alt;
    } 
}
