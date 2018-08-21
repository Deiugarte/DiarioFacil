/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {

    List<Producto> listProductos = new ArrayList<>();
    private String nombreEmpresa;
    private String personaEncargada;
    private String correo;
    private int telefono;

    public Proveedor() {
    }

    public Proveedor(String nombreEmpresa, String personaEncargada, String correo, int telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.personaEncargada = personaEncargada;
        this.correo = correo;
        this.telefono = telefono;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPersonaEncargada() {
        return personaEncargada;
    }

    public void setPersonaEncargada(String personaEncargada) {
        this.personaEncargada = personaEncargada;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "["+nombreEmpresa +"] "+ " Persona encargada: " + personaEncargada + " Correo electrónico: " + correo + " Tel: (506)" + telefono + "\n";
    }
}
