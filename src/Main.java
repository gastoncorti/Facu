/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author se21336
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> l;
        Grafo g = new Grafo();
        
        g.insertarVertice(4);
        g.insertarVertice(3);
        g.insertarVertice(2);
        g.insertarVertice(1);
        
        g.insertarArco(1, 2);
        g.insertarArco(1, 3);
        g.insertarArco(1, 4);
        g.insertarArco(2, 3);
        
        l = g.profundidad();
        
        for(int temp : l) {
            System.out.println(temp);
        }
        
        System.out.println(g.existeCamino(1,2));
    }
}
