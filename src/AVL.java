package Estructuras;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    private Nodo raiz;

    public AVL() {
        this.raiz = null;
    }

    public boolean insertar(int nuevo) {
        boolean esCorrecto;
        if (raiz != null) {
            esCorrecto = insertarAux(raiz, null, nuevo);
        } else {
            raiz = new Nodo(nuevo, 0);
            esCorrecto = true;
        }
        return esCorrecto;
    }

    //BALANCE = altHijoIZQ - alturaHijoDER
    private boolean insertarAux(Nodo raizActual, Nodo padre, int nuevo) {
        boolean esCorrecto = false;
        if (raizActual != null) {
            if (raizActual.getElem() > nuevo) {
                if (raizActual.getIzq() != null) {
                    esCorrecto = insertarAux(raizActual.getIzq(), raizActual, nuevo);
                } else {
                    raizActual.setIzq(new Nodo(nuevo));
                    esCorrecto = true;
                }
            } else if (raizActual.getElem() < nuevo) {
                if (raizActual.getDer() != null) {
                    esCorrecto = insertarAux(raizActual.getDer(), raizActual, nuevo);
                } else {
                    raizActual.setDer(new Nodo(nuevo));
                    esCorrecto = true;
                }
            }
            balancear(raizActual, padre);
        }
        return esCorrecto;
    }

    public boolean eliminar(int elem) {
        boolean seElimino = false;
        if (raiz != null) {
            seElimino = eliminarAux(raiz, null, elem);
        }
        return seElimino;
    }

    private boolean eliminarAux(Nodo raizActual, Nodo padre, int elem) {
        boolean seElimino = false;
        if (raizActual != null) {
            if (raizActual.getElem() != elem) {
                if (raizActual.getElem() > elem) { //por izq
                    seElimino = eliminarAux(raizActual.getIzq(), raizActual, elem);
                } else {// por der
                    seElimino = eliminarAux(raizActual.getDer(), raizActual, elem);
                }
            } else { //encontre el elemento a eliminar
                switch (casoEliminacion(raizActual)) {
                    case 1:
                        Nodo sustituto = new Nodo(buscarSustituto(raizActual));
                        sustituto.setIzq(raizActual.getIzq());
                        sustituto.setDer(raizActual.getDer());
                        if (eliminar(sustituto.getElem())) {
                            if (padre == null) { // quiere borrar raiz
                                raiz = sustituto;
                            } else {
                                if (padre.getElem() > elem) {
                                    padre.setIzq(sustituto);
                                } else {
                                    padre.setDer(sustituto);
                                }
                            }
                        }
                        break;
                    case 2:
                        if (padre.getElem() > elem) {
                            padre.setIzq(raizActual.getIzq());
                        } else {
                            padre.setDer(raizActual.getIzq());
                        }
                        break;
                    case 3:
                        //tiene hder
                        if (padre.getElem() > elem) {
                            padre.setIzq(raizActual.getDer());
                        } else {
                            padre.setIzq(raizActual.getDer());
                        }
                        break;
                    case 4:
                        if (padre.getElem() > elem) {
                            padre.setIzq(null);
                        } else {
                            padre.setDer(null);
                        }
                        break;
                }
                seElimino = true;
            }
        }

        return seElimino;
    }

    private int casoEliminacion(Nodo nodoEliminar) {
        int caso = -1;
        if (nodoEliminar != null) {
            if (nodoEliminar.getIzq() != null) {
                if (nodoEliminar.getDer() != null) {
                    caso = 1;
                } else {
                    caso = 2;
                }
            } else {
                if (nodoEliminar.getDer() != null) {
                    caso = 3;
                } else {
                    caso = 4;
                }
            }
        }
        return caso;
    }

    private int buscarSustituto(Nodo nodoEliminar) {
        int sustituto = nodoEliminar.getDer().getElem();
        Nodo nodoAux = nodoEliminar.getDer();
        while (nodoAux.getIzq() != null) {
            sustituto = nodoAux.getIzq().getElem();
            nodoAux = nodoAux.getIzq();
        }
        return sustituto;
    }

    public int padre(int elem) {
        int padre = 0;

        if (raiz != null) {
            if (raiz.getElem() != elem) {
                Nodo nodo = getPadre(raiz, elem);
                padre = (nodo != null) ? nodo.getElem() : 0;
            } else {
                padre = raiz.getElem();
            }
        }
        return padre;
    }

    private Nodo getPadre(Nodo raizActual, int elem) {
        Nodo padre = null;
        if (raizActual != null) {
            if (raizActual.getElem() > elem) {//busco por izq
                if (raizActual.getIzq().getElem() != elem) {
                    padre = getPadre(raizActual.getIzq(), elem);
                } else {
                    padre = raizActual;
                }
            } else { //busco por derecha
                if (raizActual.getDer().getElem() != elem) {
                    padre = getPadre(raizActual.getDer(), elem);
                } else {
                    padre = raizActual;
                }
            }
        }
        return padre;
    }

    public boolean pertenece(int elem) {
        return perteneceAux(elem, raiz);
    }

    public boolean perteneceAux(int elem, Nodo raizActual) {
        boolean pertenece = false;
        if (raizActual != null) {
            if (raizActual.getElem() != elem) {
                if (raizActual.getElem() > elem) {
                    pertenece = perteneceAux(elem, raizActual.getIzq());
                } else {
                    pertenece = perteneceAux(elem, raizActual.getDer());
                }
            } else {
                pertenece = true;
            }
        }
        return pertenece;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    private int altura(Nodo raizActual) {
        int alt = 0;
        if (raizActual != null) {
            alt = alturaAux(raizActual);
        }
        return alt;
    }

    public int alturaArbol() {
        return alturaAux(raiz);
    }

    private int alturaAux(Nodo raizActual) {
        int altD = 0, altI = 0, alt;
        if (raizActual != null) {
            if (raizActual.getIzq() != null) {
                altI = 1 + alturaAux(raizActual.getIzq());
            }
            if (raizActual.getDer() != null) {
                altD = 1 + alturaAux(raizActual.getDer());
            }
            alt = (altI >= altD) ? altI : altD;
        } else {
            alt = 0;
        }
        return alt;
    }

    public int nivel(int elem) {
        return 0;
    }

    public void vaciar() {
        raiz = null;
    }

    public ArbolBB clonar() {
        ArbolBB clon = new ArbolBB();
        clonarAux(raiz, clon);
        return clon;
    }

    private void clonarAux(Nodo raizActual, ArbolBB clon) {
        if (raizActual != null) {
            clon.insertar(raizActual.getElem());
            if (raizActual.getIzq() != null) {
                clonarAux(raizActual.getIzq(), clon);
            }
            if (raizActual.getDer() != null) {
                clonarAux(raizActual.getDer(), clon);
            }
        }
    }

    public void listar() {
        if (raiz != null) {
            listarAux(raiz);
        } else {
            System.out.println("Sin Elem");
        }
    }

    private void listarAux(Nodo nActual) {
        if (nActual != null) {
            listarAux(nActual.getIzq());
            System.out.print(nActual.getElem() + ",");
            listarAux(nActual.getDer());
        }
    }

    public void listarAltura() {
        if (raiz != null) {
            listarAlturaAux(raiz);
            System.out.print("\n");
        } else {
            System.out.println("Sin Elem");
        }
    }

    private void listarAlturaAux(Nodo nActual) {
        if (nActual != null) {
            listarAlturaAux(nActual.getIzq());
            System.out.print(nActual.getElem() + ",Alt: " + nActual.getAltura() + "\n");
            listarAlturaAux(nActual.getDer());
        }
    }

    public void listarNivel() {
        if (raiz != null) {
            listarNivelAux(raiz);
        } else {
            System.out.println("Sin Elem");
        }
    }

    private void listarNivelAux(Nodo raizActual) {
        Queue cola = new LinkedList();
        cola.add(raizActual);
        while (!cola.isEmpty()) {
            Nodo nodoAux = (Nodo) cola.poll();
            System.out.print(nodoAux.getElem());
            
            if (nodoAux.getIzq() != null) {
                cola.add(nodoAux.getIzq());
            }
            if (nodoAux.getDer() != null) {
                cola.add(nodoAux.getDer());
            }
        }
    }

    private void balancear(Nodo raizActual, Nodo padre) {

    }

    private int balance(Nodo raizActual) {
        int res;
        if (raizActual.getIzq() != null) {
            if (raizActual.getDer() != null) {
                res = raizActual.getIzq().getAltura() - raizActual.getIzq().getAltura();
            } else {
                res = raizActual.getIzq().getAltura() + 1;
            }
        } else {
            if (raizActual.getDer() != null) {
                res = -1 - raizActual.getDer().getAltura();
            } else {
                res = 0;
            }
        }
        return res;
    }
}
