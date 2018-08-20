/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class Combo extends Producto {
    
    private int consecutivo;
    private double precio;
    private List<Producto> lstProductos = new ArrayList<Producto>();
    private double TotalDescuento;
    
    // daba error si ponia 0 
    private static int numeroCombo = -3;
    //consecutivo para el combo
    public static int getNumeroCombo(){
        numeroCombo = numeroCombo + 1;
        return numeroCombo;
    }
    
    public Combo(){
        super();
    }
    public Combo(double precio) {
        this.precio = precio;
        this.consecutivo = getNumeroCombo();
    }
    public int getConsecutivo() {
        return consecutivo;
    }
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }
    public double getTotal() {
        return precio;
    }
    public void setTotal(double precio) {
        this.precio = precio;
    }
    public List<Producto> getLstProductos() {
        return lstProductos;
    }
    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }
    public void agregarProductos(Producto p){
        this.lstProductos.add(p);
    }
    
    public void imprimirProductos(){
        System.out.println("Combo: " + getNumeroCombo());
        for(Producto p: lstProductos){
            System.out.println(" ID: " + p.getid() 
                    + " Nombre: " + p.getNombre() 
                    + " Descripcion: " + p.getDescripcion()); //" Precio: " + p.getPrecio() 
                    
        }
        //System.out.println("Precio del Combo: " + sacarPrecioCombo());
    }
    public double sacarPrecioCombo(){
        double subtotal = 0;
        for(Producto p: lstProductos){
           //arreglar el precio del subtotal y poner el descuento al total
            subtotal = p.getPrecio();
            TotalDescuento = subtotal + TotalDescuento;
            
        }
        return subtotal;
        
    }

    @Override
    public String toString() {
        System.out.println("Combo: " + this.consecutivo);
        lstProductos.forEach(producto -> {
            System.out.println(" ID: " + producto.getid()
                    + " Nombre: " + producto.getNombre() 
                    + " Descripcion: " + producto.getDescripcion()); //" Precio: " + p.getPrecio() 
        });
        System.out.println("Precio del Combo: " + sacarPrecioCombo());
        return "";
    }
    
    
}
