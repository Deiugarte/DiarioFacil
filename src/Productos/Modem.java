/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import com.ulatina.diariofacil.IDescuento;
import com.ulatina.diariofacil.Producto;

/**
 *
 * @author Andres
 */

public class Modem  extends Producto implements IDescuento {
    public Modem ( String nombre, String descripcion, double precio,  int inventario){
        super( nombre, descripcion, precio, inventario);
    }
    @Override
    public double getDescuento() {
        return 0.05;
    }
}
