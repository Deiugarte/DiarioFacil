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

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto(int id, String nombre, String descripcion, double precio) {
        
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        
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

}
