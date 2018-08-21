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
        DiarioFacil d = new DiarioFacil("Test");
        Persona u = new Administrador("Prueba", "0", "En algun lugar", "11223344", "admin@admin.admin", "admin");
        
        //Persona usuario1 = new Usuario("andres","1122","curridabat", "1234","andy@gmail.com","andres");
        //Persona usuario2 = new Usuario("deivid","1123","curridabat", "342","deivid@gmail.com","deivid");
        //Persona usuario3 = new Usuario("andrew","1124","curridabat", "4321","andrew@gmail.com","andrew");
        //Persona usuario4 = new Usuario("diego","1125","curridabat", "432","diego@gmail.com","diego");
        //agregar estos usuarios
        
       //nombre, cedula, direccion, telefono, email, password
       
        Producto p1 = new ProductoGenerico( "nombre", "desc", 100,10);
        Producto p2 = new Computadora( "Dell", "meh", 1000,10);
        
        d.addProducto(p1);
        d.addProducto(p2);
        Combo cb = new Combo(1000);
        Combo cb2 = new Combo(1200);
        Combo cb3 = new Combo(300);
        
        
        
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
        
        
        d.getUsuarios().add(u);
        d.inicio();
        
    }
    
}
