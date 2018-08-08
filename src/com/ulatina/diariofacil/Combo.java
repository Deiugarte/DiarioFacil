/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.List;

/**
 *
 * @author Diego
 */
public class Combo extends Producto {
    
    private List<Producto> productos;

    public Combo(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public boolean add(Producto e) {
        return productos.add(e);
    }
    
}
