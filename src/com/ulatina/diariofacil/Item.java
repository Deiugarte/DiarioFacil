/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

/**
 *
 * @author Diego
 */
public class Item {

    private int numero;
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public Item(int numero, Producto producto, int cantidad) {
        this.numero = numero;
        this.producto = producto;
        this.cantidad = cantidad;
        //updateSubtotal();
    }

    public int getNumero() {
        return numero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        updateSubtotal();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        updateSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void updateSubtotal() {
        subtotal = producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "producto: " + producto.getNombre() + " cantidad : " + cantidad + " subtotal :" + producto.getPrecio() * cantidad;
    }

    
}
