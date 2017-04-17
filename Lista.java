package Estructuras;

public class Lista {

    private NodoLista cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(int elem, int pos) {
        boolean seInserto = false;
        if (pos >= 1 || pos <= this.longitud() + 1) {
            if (pos != 1) {
                NodoLista aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    i++;
                    aux = aux.getEnlace();
                }
                aux.setEnlace(new NodoLista(elem, aux.getEnlace()));
                seInserto = true;
            } else {
                cabecera = new NodoLista(elem, this.cabecera);
                seInserto = true;
            }
        }

        return seInserto;
    }

    public boolean eliminar(int pos) {
        boolean seElimino = false;
        if (pos >= 1 || pos <= this.longitud()) {
            if (pos != 1) {
                NodoLista aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    i++;
                    aux = aux.getEnlace();
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                seElimino = true;
            } else {
                cabecera = cabecera.getEnlace();
                seElimino = true;
            }   
        }
        return seElimino;
    }

    public int recuperar(int pos) {
        int elem = 0;
        if (!esVacia()) {
            if (pos < 1 || pos > this.longitud()) {
                if (pos != 1) {
                    NodoLista aux = cabecera;
                    int i = 1;
                    while (i < pos - 1) {
                        if (aux.getElem() != elem) {
                            aux = aux.getEnlace();
                        } else {
                            elem = aux.getElem();
                        }
                    }
                } else {
                    elem = cabecera.getElem();
                }
            }
        }
        return elem;
    }

    public int localizar(int elem) {
        int pos = -1;
        return pos;
    }

    public void vaciar() {
        cabecera = null;
    }

    public boolean esVacia() {
        return cabecera == null;
    }

    public Lista clonar() {
        Lista clon = new Lista();
        
        return clon;
    }

    public int longitud() {
        NodoLista aux = cabecera;
        int longitud = 0;

        if (!esVacia()) {
            longitud++;
            while (aux.getEnlace() != null) {
                longitud++;
                aux = aux.getEnlace();
            }
        }

        return longitud;
    }

    @Override
    public String toString() {
        String cad = "";
        if(!esVacia()) {
            NodoLista aux = cabecera;
            for (int i = 1; i <= this.longitud(); i++) {
                cad = cad + aux.getElem() + ",";
                aux = aux.getEnlace();
            }
        } else {
            cad = "Vacia!";
        }
        
        return cad;
    }
}
