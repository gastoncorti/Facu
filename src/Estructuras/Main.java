/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.Random;

/**
 *
 * @author Gaston
 */
public class Main {
    public static void main(String[] args) {
        ArbolBB a = new ArbolBB();
        Random r = new Random();
        int Low = -50;
        int High = 50;
        int rnd = 0;
        for (int i = 0; i < 10; i++) {
            rnd = r.nextInt(High-Low) + Low;
            a.insertar(rnd);
            System.out.println(rnd);
        }
        ArbolBB b = a.clonar();
        
        System.out.println("LLAMANDO LISTAR A");
        a.listar();
         System.out.println("LLAMANDO LISTAR B");
        b.listar();
        
        System.out.println("\n A "+a.altura());
        System.out.println("\n B "+a.altura());
    }
}
