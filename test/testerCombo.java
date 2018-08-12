
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
        
        Computadora com1 = new Computadora(1, "HP", "Laptop portatil", 1000);
        router rout1 = new router (1, "Sony", "router de largo alcance", 200);
        Modem mo1 = new Modem (1, "Dell", "Modem para oficina", 200);
        
        cb.agregarProductos(com1);
        cb.agregarProductos(rout1);
        cb2.agregarProductos(com1);
        cb2.agregarProductos(rout1);
        cb2.agregarProductos(mo1);
        cb3.agregarProductos(rout1);
        cb3.agregarProductos(mo1);
        
        cb.imprimirProductos();
        cb2.imprimirProductos();
        cb3.imprimirProductos();
        
        menu.escogerCombo();
        
        
    }
    //falta los descuentos, sacar el precio total bien
}
