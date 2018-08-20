
import Productos.Computadora;
import Productos.Modem;
import Productos.router;
import com.ulatina.diariofacil.Combo;
import com.ulatina.diariofacil.menuCombo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres
 */
public class testerCombo {
    public static void main(String[] args) {
        
        menuCombo menu = new menuCombo("inicio");
        menu.inicio();
        
        Combo cb = new Combo(0);
        Combo cb2 = new Combo(0);
        Combo cb3 = new Combo(0);
        
        Computadora com1 = new Computadora( "HP", "Laptop portatil", 1000,10);
        router rout1 = new router ( "Sony", "router de largo alcance", 200,10);
        Modem mo1 = new Modem ( "Dell", "Modem para oficina", 200,10);
       
            double precioCombo1 = com1.getPrecio() + rout1.getPrecio();
            double precioCombo2 = com1.getPrecio() + rout1.getPrecio() + mo1.getPrecio();
            double precioCombo3 = rout1.getPrecio() + mo1.getPrecio();
            
            
        
        cb.agregarProductos(com1);
        cb.agregarProductos(rout1);
        cb2.agregarProductos(com1);
        cb2.agregarProductos(rout1);
        cb2.agregarProductos(mo1);
        cb3.agregarProductos(rout1);
        cb3.agregarProductos(mo1);
        
        cb.imprimirProductos();
        System.out.println("Precio del combo 1: " + precioCombo1);
        cb2.imprimirProductos();
        System.out.println("Precio del combo 2: " + precioCombo2);
        cb3.imprimirProductos();
        System.out.println("Precio del combo 3: " + precioCombo3);
        
        menu.escogerCombo();
        
        
    }
    //falta los descuentos
}
