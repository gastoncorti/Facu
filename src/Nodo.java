package Estructuras;

public class Nodo {

    private Nodo izq, der;
    private int altura;
    private int elem;

    public Nodo(int elem) {
        this.elem = elem;
    }

    public Nodo(int elem, int alt) {
        this.elem = elem;
        this.altura = alt;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

}
