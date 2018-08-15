
import Productos.Computadora;
import Productos.Modem;
import Productos.router;
import com.ulatina.diariofacil.DiarioFacil;
import com.ulatina.diariofacil.Orden;
import com.ulatina.diariofacil.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego
 */
public class TesterOrden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiarioFacil d = new DiarioFacil("Prueba");

        Computadora com1 = new Computadora("HP", "Laptop portatil", 1000, 10);
        router rout1 = new router("Sony", "router de largo alcance", 200, 10);
        Modem mo1 = new Modem("Dell", "Modem para oficina", 200, 10);

        Usuario u = new Usuario("Diego", "123", "Por ahi", "222333", "abc@123", "hola");
        d.getUsuarios().add(u);
        d.addOrden(u);
        d.getOrdenes().get(0).addItem(mo1, 1);
        
        d.addOrden(u);
        d.getOrdenes().get(1).addItem(rout1, 3);
        d.getOrdenes().get(1).addItem(com1, 10);
        
        d.listarOrdenes("123");
        d.imprimirOrden(1);
        d.imprimirOrden(0);
        d.imprimirOrden(1);
    }

}
