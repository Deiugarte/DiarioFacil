/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

/**
 *
 * @author 
 */
public abstract class Producto {

    protected int id;
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected int inventario;

    public Producto(String nombre, String descripcion, double precio, int inventario) {
        
        this.id = getNumeroId() ;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.inventario = inventario;
    }

    public Producto() {
    }

    public Producto(int id) {
        this.id = id;
    }
    
    

    private static int idConsecutivo = 0;
    //consecutivo para el combo
    public static int getNumeroId(){
        idConsecutivo++;
        return idConsecutivo;
    }
    
    public double checkDescuento() {
        if (this instanceof IDescuento) {
//            if (this instanceof Cucaracha) {
//                return ((Cucaracha) this).getDescuento();
//            } else if (this instanceof Diadema) {
//                return ((Diadema) this).getDescuento();
//            } else if (this instanceof Lazo) {
//                //return ((Lazo) this).getDescuento();
//            }
        }
        return 0;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio - (precio * checkDescuento());
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "id : " + id + " | nombre : " + nombre + " | descripcion : " + descripcion + " | precio : " + precio;
    }

    
}
