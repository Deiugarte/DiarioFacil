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
public class PersonaJuridica extends Persona {

    private String representante;

    public PersonaJuridica(String nombre, String cedula, String direccion, String telefono, String email, String password, String representante) {
        super(nombre, cedula, direccion, telefono, email, password);
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

}
