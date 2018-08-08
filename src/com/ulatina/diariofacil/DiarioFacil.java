/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author blaken
 */
public class DiarioFacil {

    private String nombre;
    private List<Producto> productos = new ArrayList<>();
    private List<Orden> ordenes = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Combo> combos = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();

    public DiarioFacil(String nombre) {
        this.nombre = nombre;
    }

    public void inicio() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenido al sistema. Digite una opcion para continuar.");
        System.out.println("1 - Login");
        System.out.println("2 - Olvide mi contraseña");
        System.out.println("3 - Registrarse");
        System.out.println("4 - Salir");

        switch (scan.nextInt()) {
            case 1:
                login();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
                inicio();
                break;
        }

    }

    public void login() {
        Scanner scan = new Scanner(System.in);
        String cedula;
        String pass;

        System.out.println("Ingrese su cedula y contraseña o \"salir\" para regresar al menu principal");
        System.out.print("Cedula: ");
        cedula = scan.nextLine();

        if (cedula.equals("salir") || cedula.equals("Salir") || cedula.equals("SALIR")) {
            inicio();
        }

        System.out.print("Contraseña: ");
        pass = scan.nextLine();

        while (!verificarCredenciales(cedula, pass)) {
            if (pass.equals("salir") || pass.equals("Salir") || pass.equals("SALIR")) {
                inicio();
            } else {
                System.out.println("Contraseña o usuario invalido");
            }
            pass = scan.nextLine();
        }
        //TODO Go to "Landing Page"
    }

    private boolean verificarCredenciales(String cedula, String password) {
        for (Usuario u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                return u.getPassword().equals(password);
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

}
