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
        
        /*a.insertar(5);
        for (int i = 0; i < 10; i++) {
            rnd = r.nextInt(High-Low) + Low;
            a.insertar(rnd);
            System.out.println(rnd);
        }
        //ArbolBB b = a.clonar();
        */
        a.insertar(10);
        a.insertar(-2);
        a.insertar(11);
        a.insertar(12);
        a.insertar(-3);
        a.insertar(2);
        a.insertar(1);
        a.insertar(4);
        
        a.listar();
        
        a.eliminar(12);
        System.out.println("");
        a.listar();
    }
}
