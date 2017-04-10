/*
public class BinarySearchTree {
      …
      
      public boolean remove(int value) {
            if (root == null)
                  return false;
            else {
                  if (root.getValue() == value) {
                        BSTNode auxRoot = new BSTNode(0);
                        auxRoot.setLeftChild(root);
                        boolean result = root.remove(value, auxRoot);
                        root = auxRoot.getLeft();
                        return result;
                  } else {
                        return root.remove(value, null);
                  }
            }
      }
}
public class BSTNode {
      …

      public boolean remove(int value, BSTNode parent) {
            if (value < this.value) {
                  if (left != null)
                        return left.remove(value, this);
                  else
                        return false;
            } else if (value > this.value) {
                  if (right != null)
                        return right.remove(value, this);
                  else
                        return false;
            } else {
                  if (left != null && right != null) {
                        this.value = right.minValue();
                        right.remove(this.value, this);
                  } else if (parent.left == this) {
                        parent.left = (left != null) ? left : right;
                  } else if (parent.right == this) {
                        parent.right = (left != null) ? left : right;
                  }
                  return true;
            }
      }
 
      public int minValue() {
            if (left == null)
                  return value;
            else
                  return left.minValue();
      }
}
*/

package Estructuras;

import java.util.LinkedList;
import java.util.Queue;

public class ABB {

    private NodoArbB raiz;

    public ABB() {
        this.raiz = null;
    }

    public boolean insertar(int nuevo) {
        boolean esCorrecto;
        if (raiz != null) {
            esCorrecto = insertarAux(raiz, nuevo);
        } else {
            raiz = new NodoArbB(nuevo);
            esCorrecto = true;
        }
        return esCorrecto;
    }

    private boolean insertarAux(NodoArbB raizActual, int nuevo) {
        boolean esCorrecto = false;
        if (raizActual != null) {
            if (raizActual.getElem() > nuevo) {
                if (raizActual.getIzq() != null) {
                    esCorrecto = insertarAux(raizActual.getIzq(), nuevo);
                } else {
                    raizActual.setIzq(new NodoArbB(nuevo));
                    esCorrecto = true;
                }
            } else if (raizActual.getElem() < nuevo) {
                if (raizActual.getDer() != null) {
                    esCorrecto = insertarAux(raizActual.getDer(), nuevo);
                } else {
                    raizActual.setDer(new NodoArbB(nuevo));
                    esCorrecto = true;
                }
            }
        }
        return esCorrecto;
    }

    public boolean eliminar(int elem) {
        NodoArbB padre = getPadre(raiz, elem);
        boolean seElimino = false;
        if (padre.getIzq() != null) {
            if (padre.getIzq().getElem() == elem) {
                seElimino = eliminarAux(padre.getIzq(), padre, 'i');
            } else {
                seElimino = eliminarAux(padre.getDer(), padre, 'd');
            }
        }
        return seElimino;
    }

    private boolean eliminarAux(NodoArbB nodoEliminar, NodoArbB padre, char h) {
        boolean seElimino = false;
        if (nodoEliminar.getIzq() != null) {
            if (nodoEliminar.getDer() != null) {
                //Buscar sutituto
                seElimino = true;
            } else {
                padre.setIzq(nodoEliminar.getIzq());
                seElimino = true;
            }
        } else {
            if (nodoEliminar.getDer() != null) {
                padre.setDer(nodoEliminar.getDer());
            } else {
                if(h == 'i') {
                    padre.setIzq(null);
                } else {
                    padre.setDer(null);
                }
            }
        }

        return true;
    }

    public int padre(int elem) {
        int padre = 0;
        NodoArbB nodo;
        if (raiz != null) {
            nodo = getPadre(raiz, elem);
            padre = (nodo != null) ? nodo.getElem() : 0;
        }
        return padre;
    }

    private NodoArbB getPadre(NodoArbB raizActual, int elem) {
        NodoArbB padre = null;
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

    public boolean perteneceAux(int elem, NodoArbB raizActual) {
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

    public int altura() {
        return alturaAux(raiz);
    }

    private int alturaAux(NodoArbB raizActual) {
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

    private void clonarAux(NodoArbB raizActual, ArbolBB clon) {
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

    private void listarAux(NodoArbB nActual) {
        if (nActual != null) {
            listarAux(nActual.getIzq());
            System.out.print(nActual.getElem() + ",");
            listarAux(nActual.getDer());
        }
    }

    public void listarNivel() {
        if (raiz != null) {
            listarNivelAux(raiz);
        } else {
            System.out.println("Sin Elem");
        }
    }

    private void listarNivelAux(NodoArbB raizActual) {
        Queue cola = new LinkedList();
        cola.add(raizActual);
        while (!cola.isEmpty()) {
            NodoArbB nodoAux = (NodoArbB) cola.poll();
            System.out.print(nodoAux.getElem());
            if (nodoAux.getIzq() != null) {
                cola.add(nodoAux.getIzq());
            }
            if (nodoAux.getDer() != null) {
                cola.add(nodoAux.getDer());
            }
        }
    }

    public String listarRangp() {
        return "";
    }

    public int minimo() {
        return 0;
    }

    public int maximo() {
        return 0;
    }
}
