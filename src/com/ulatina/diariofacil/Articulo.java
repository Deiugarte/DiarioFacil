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
public class Articulo {
    
    private int stock;
    private int stockMin;
    private String categoria;

    public Articulo(int stock, int stockMin, String categoria) {
        this.stock = stock;
        this.stockMin = stockMin;
        this.categoria = categoria;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
