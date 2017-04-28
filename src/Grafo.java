package Estructuras;

import java.util.LinkedList;

public class Grafo {

    private NodoVert inicio;

    public Grafo() {
        this.inicio = null;
    }

    public boolean insertarVertice(int elem) {
        boolean seInserto = false;
        NodoVert aux = ubicarVertice(elem);
        if (aux == null) {
            this.inicio = new NodoVert(elem, this.inicio);
            seInserto = true;
        }
        return seInserto;
    }

    private NodoVert ubicarVertice(int buscado) {
        NodoVert aux = inicio;
        while (aux != null && aux.getElem() != buscado) {
            aux = aux.getSigVertice();
        }
        return aux;
    }

    public boolean insertarArco(int origen, int destino) {
        boolean seInserto = false;
        NodoVert o = ubicarVertice(origen);
        if (o != null) {
            NodoVert d = ubicarVertice(destino);
            if (d != null) {
                NodoAdy aux = o.getPrimerAdy();
                if (aux != null) {
                    while (aux.getSigAdyacente() != null) {
                        aux = aux.getSigAdyacente();
                    }
                    aux.setSigAdyacente(new NodoAdy(d, null));
                } else {
                    o.setPrimerAdy(new NodoAdy(d, null));
                }
                seInserto = true;
            }
        }

        return seInserto;
    }

    public LinkedList profundidad() {
        //Lista visitados = new Lista();
        LinkedList<Integer> visitados = new LinkedList<>();
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (!visitados.contains(aux.getElem())) {
                profundidadDesde(aux, visitados);
            }
            aux = aux.getSigVertice();
        }

        return visitados;
    }

    private void profundidadDesde(NodoVert nodov, LinkedList visitados) {
        if (nodov != null) {
            visitados.add(nodov.getElem());
            NodoAdy ady = nodov.getPrimerAdy();
            while (ady != null) {
                if (!visitados.contains(ady.getVertice().getElem())) {
                    profundidadDesde(ady.getVertice(), visitados);
                }
                ady = ady.getSigAdyacente();
            }
        }
    }
    
    public boolean existeCamino(int origen, int destino) {
        boolean existe = false;
        
        NodoVert o = ubicarVertice(origen);
        NodoVert d = ubicarVertice(destino);
        
        if(o != null && d != null) {
            LinkedList<Integer> visitados = new LinkedList<>();
            existe = existeCaminoAux(o, destino, visitados);
        }
        
        return existe;
    }

    private boolean existeCaminoAux(NodoVert origen, int destino, LinkedList<Integer> visitados) {
        boolean existe = false;
        if(origen != null) {
            if(origen.getElem() == destino) {
                existe = true;
            } else {
                visitados.add(origen.getElem());
                NodoAdy ady = origen.getPrimerAdy();
                while(!existe && ady != null) {
                    if(!visitados.contains(ady.getVertice().getElem())) {
                        existe = existeCaminoAux(ady.getVertice(), destino, visitados);
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        /*if(origen != null) {
            if(origen.getElem()!= destino) {
                visitados.add(origen.getElem());
                NodoAdy ady = origen.getPrimerAdy();
                while(!existe && ady != null) {
                    if(visitados.contains(ady.getVertice().getElem())) {
                        existe = existeCaminoAux(ady.getVertice(), destino, visitados);
                    }
                    ady = ady.getSigAdyacente();
                }
            } else {
                existe = true;
            }
        }*/
        return existe;
    }
}
