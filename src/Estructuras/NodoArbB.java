package Estructuras;
public class NodoArbB {
    private int elem;
    private NodoArbB hIzq;
    private NodoArbB hDer;
    
    public NodoArbB(int elem){
        this.elem = elem;
        this.hDer = null;
        this.hIzq = null;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public NodoArbB getIzq() {
        return hIzq;
    }

    public void setIzq(NodoArbB hIzq) {
        this.hIzq = hIzq;
    }

    public NodoArbB getDer() {
        return hDer;
    }

    public void setDer(NodoArbB hDer) {
        this.hDer = hDer;
    }
    
}
