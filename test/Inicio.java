
import Productos.Computadora;
import Productos.Modem;
import Productos.router;
import com.ulatina.diariofacil.Administrador;
import com.ulatina.diariofacil.DiarioFacil;
import com.ulatina.diariofacil.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andres
 */
public class Inicio {

    public static void main(String[] args) {
        DiarioFacil d = new DiarioFacil("Test");

        Persona u = new Administrador("Prueba", "0", "En algun lugar", "11223344", "admin@admin.admin", "admin");

        Computadora com1 = new Computadora("HP", "Laptop portatil", 1000, 10);
        router rout1 = new router("Sony", "router de largo alcance", 200, 10);
        Modem mo1 = new Modem("Dell", "Modem para oficina", 200, 10);

        d.addProducto(com1);
        d.addProducto(rout1);
        d.addProducto(mo1);
        
        d.getUsuarios().add(u);
        d.inicio();
    }
}
