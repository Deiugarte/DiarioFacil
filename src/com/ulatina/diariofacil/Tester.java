package com.ulatina.diariofacil;


import Productos.Computadora;
import Productos.Modem;
import Productos.ProductoGenerico;
import Productos.router;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Producto p1 = new ProductoGenerico( "nombre", "desc", 100,10);
        Producto p2 = new Computadora( "Dell", "meh", 1000,10);
        DiarioFacil d = new DiarioFacil("Test");
        d.addProducto(p1);
        d.addProducto(p2);
        Combo cb = new Combo(0);
        Combo cb2 = new Combo(0);
        Combo cb3 = new Combo(0);
        
        
        
        Computadora com1 = new Computadora( "HP", "Laptop portatil", 1000,10);
        router rout1 = new router ( "Sony", "router de largo alcance", 200,10);
        Modem mo1 = new Modem ( "Dell", "Modem para oficina", 200,10);
        
        
        cb.agregarProductos(com1);
        cb.agregarProductos(rout1);
        cb2.agregarProductos(com1);
        cb2.agregarProductos(rout1);
        cb2.agregarProductos(mo1);
        cb3.agregarProductos(rout1);
        cb3.agregarProductos(mo1);
        d.addCombo(cb);
        d.addCombo(cb2);
        d.addCombo(cb3);
        
        
        
        d.inicio();
        
    }
    
}
