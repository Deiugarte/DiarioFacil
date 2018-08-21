/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import Productos.ProductoGenerico;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class MantenimientoCliente {

//    private List<Persona> usuarios = new ArrayList<>();
//
//    public List<Persona> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Persona> usuarios) {
//        this.usuarios = usuarios;
//    }
//
//    public void agregarUsuarios(Usuario u) {
//        this.usuarios.add(u);
//    }
    public MantenimientoCliente() {
    }

    //inicio del mantenimiento
    public void mantenimientoInicio(List<Persona> usuarios) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite 1 Buscar el cliente");
        System.out.println("Digite 2 para salir");

        try {
            switch (scan.nextInt()) {
                case 1:
                    buscarCliente(usuarios);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    mantenimientoInicio(usuarios);
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            mantenimientoInicio(usuarios);
        }
    }

    //modifica al cliente o lo elimina
    public void modificarCliente(List<Persona> usuarios, Persona u) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1-Cambiar Nombre");
        System.out.println("2-Cambiar Cedula");
        System.out.println("3-Cambiar Direccion");
        System.out.println("4-Cambiar Telefono");
        System.out.println("5-Cambiar Email");
        System.out.println("6-eliminar el usuario");

        int opcion = scan.nextInt();
        scan.nextLine();
        try {
            switch (opcion) {
                case 1:
                    u.setNombre(scan.nextLine());
                    break;
                case 2:
                    u.setCedula(scan.nextLine());
                    break;
                case 3:
                    u.setDireccion(scan.nextLine());
                    break;
                case 4:
                    u.setTelefono(scan.nextLine());
                    break;
                case 5:
                    u.setEmail(scan.nextLine());
                    break;
                case 6:
                    eliminarCliente(usuarios, u);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    mantenimientoInicio(usuarios);
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            mantenimientoInicio(usuarios);
        }

        System.out.println(" Nombre: " + u.getNombre()
                + " Direccion: " + u.getDireccion()
                + " Telefono: " + u.getTelefono()
                + " Email: " + u.getEmail());
        mantenimientoInicio(usuarios);

    }

    //elimina al cliente
    public void eliminarCliente(List<Persona> usuarios, Persona u) {
        usuarios.remove(u);
        System.out.println("Este Usuario ha sido borrado");
    }
    //busca al cliente

    public void buscarCliente(List<Persona> usuarios) {

        for (Persona u : usuarios) {
            System.out.println(
                    " Nombre: " + u.getNombre()
                    + " Cedula: " + u.getCedula()
                    + " Direccion: " + u.getDireccion()
                    + " Telefono: " + u.getTelefono()
                    + " Email: " + u.getEmail());
        }

        Persona usuarioSelect = seleccionarCliente(usuarios);
        //agarra el usuario y si no es nulo abre el metodo modificarCliente
        if (usuarioSelect != null) {
            modificarCliente(usuarios, usuarioSelect);
        }
    }

    //selecciona al cliente y lo muestra
    public Persona seleccionarCliente(List<Persona> usuarios) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite la cedula del cliente");
        String cedula = scan.nextLine();

        for (Persona u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                System.out.println(" Nombre: " + u.getNombre()
                        + " Direccion: " + u.getDireccion()
                        + " Telefono: " + u.getTelefono()
                        + " Email: " + u.getEmail());
            } else {
                System.out.println("cedula no encontrada o no existente!");
                seleccionarCliente(usuarios);
            }
            return u;
        }
        return null;
    }

    public static void mantenimientoProducto(List<Producto> productos) {
        Scanner scan = new Scanner(System.in);
        Producto p;
        System.out.print("OPCIONES DE PRODUCTOS" + "\n"
                + "1. Agregar Producto" + "\n"
                + "2. Modificar Prodcuto" + "\n"
                + "3. Eliminar Producto" + "\n"
                + "4. Ver Productos" + "\n");

        try {
            switch (scan.nextInt()) {

                case 1:
                    agregarProducto(productos);
                    break;
                case 2:
                    p = selectProductos(productos);
                    if (p != null) {
                        modificarProducto(productos, p);
                    }
                    break;
                case 3:
                    p = selectProductos(productos);
                    if (p != null) {
                        eliminarProducto(productos, p);
                    }
                    break;
                case 4:
                    verProductos(productos);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    mantenimientoProducto(productos);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            mantenimientoProducto(productos);
        }

    }

    public static void verProductos(List<Producto> productos) {
        System.out.println("===LISTA DE PRODUCTOS===" + "\n");
        for (Producto a : productos) {
            System.out.println(a.toString() + "\n");
        }
        mantenimientoProducto(productos);
    }

    public static Producto selectProductos(List<Producto> productos) {
        Scanner scan = new Scanner(System.in);

        System.out.println("===LISTA DE PRODUCTOS===" + "\n");

        for (int i = 0; i < productos.size(); i++) {
            System.out.println(i + " - " + productos.get(i).getNombre());
        }

        System.out.print("Selecione un producto: ");
        int prod;
        try {
            prod = scan.nextInt();
            if (prod >= 0 && prod <= productos.size()) {
                return productos.get(prod);
            } else {
                System.out.println("Opcion no valida");
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor no valido");
        }
        return null;
    }

    private static void agregarProducto(List<Producto> productos) {
        Scanner scan = new Scanner(System.in);
        String nombre;
        int precio;
        String descripcion;
        int stock;

        System.out.println("Nombre del producto que deseas agregar");
        nombre = scan.nextLine();
        System.out.println("Precio del producto que desea agregar");
        precio = scan.nextInt();
        System.out.println("Descripcion del producto que desea agregar");
        descripcion = scan.next();
        System.out.println("Stock del producto que desea agregar");
        stock = scan.nextInt();

        productos.add(new ProductoGenerico(nombre, descripcion, precio, stock));

        System.out.println("Producto creado");
    }

    private static void modificarProducto(List<Producto> productos, Producto p) {
        Scanner scan = new Scanner(System.in);

        String nombre;
        int precio;
        String descripcion;

        System.out.println("1 - Modificar de nombre producto");
        nombre = scan.nextLine();
        System.out.println("2 - Modificar de precio producto");
        precio = scan.nextInt();
        System.out.println("3 - Modificar de descripcion producto");
        descripcion = scan.next();

        int opcion = scan.nextInt();
        scan.nextLine();
        try {
            switch (opcion) {
                case 1:
                    p.setNombre(scan.nextLine());
                    break;
                case 2:
                    p.setPrecio(scan.nextInt());
                    break;
                case 3:
                    p.setDescripcion(scan.next());
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            mantenimientoProducto(productos);
        }
        System.out.println(" Nombre " + p.getNombre()
                + " Precio" + p.getPrecio()
                + "Descripción" + p.getDescripcion());

        mantenimientoProducto(productos);

    }

    private static void eliminarProducto(List<Producto> productos, Producto p) {
        Scanner scan = new Scanner(System.in);
        String nombre;
        int precio;
        String descripcion;
        System.out.println("Nombre del producto que deseas eliminar");
        nombre = scan.nextLine();
        productos.remove(p);
        System.out.println("Este producto ha sido borrado");
    }

}
