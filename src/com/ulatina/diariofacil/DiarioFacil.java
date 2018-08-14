/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    /**
     * Muestra el menu principal
     */
    public void inicio() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenido al sistema. Digite una opcion para continuar.");
        System.out.println("1 - Login");
        System.out.println("2 - Olvide mi contraseña");
        System.out.println("3 - Registrarse");
        System.out.println("4 - Salir");

        try {
            switch (scan.nextInt()) {
                case 1:
                    login();
                    break;
                case 2:
                    olvideContra();
                    break;
                case 3:
                    registro();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    inicio();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            inicio();
        }
    }
    
    /**
     * Muestra el menu del usuario
     */
    public void menuUsuario() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite una opcion para continuar.");
        System.out.println("1 - Ver promociones");
        System.out.println("2 - Ver combos");
        System.out.println("3 - Comprar");
        System.out.println("4 - Ultima compra");
        System.out.println("5 - Salir");

        try {
            switch (scan.nextInt()) {
                case 1:
                    obtenerPromociones();
                    break;
                case 2:
                    verCombos();
                    break;
                case 3:
                    registro();
                    break;
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    menuUsuario();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            menuUsuario();
        }
    }

        /**
     * Muestra el menu del usuario
     */
    public void menuAdmin() {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Bienvenido al sistema. Digite una opcion para continuar.");
//        System.out.println("1 - Promociones");
//        System.out.println("2 - Comprar");
//        System.out.println("3 - Ultima compra");
//        System.out.println("4 - Salir");
//
//        try {
//            switch (scan.nextInt()) {
//                case 1:
//                    obtenerPromociones();
//                    break;
//                case 2:
//                    olvideContra();
//                    break;
//                case 3:
//                    registro();
//                    break;
//                case 4:
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Opcion no valida");
//                    menuUsuario();
//                    break;
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("El valor deber ser numerico.");
//            menuUsuario();
//        }
    }
    /**
     * Le pide al usuario su cedula y contraseña si ambas son validas abre el
     * "Landing Page"
     */
    public void login() {
        Scanner scan = new Scanner(System.in);
        String cedula;
        String pass;

        System.out.println("Ingrese su cedula y contraseña o \"salir\" para regresar al menu principal");
        System.out.print("Cedula: ");
        cedula = scan.nextLine();

        if (salir(cedula)) {
            inicio();
            return;
        }

        System.out.print("Contraseña: ");
        pass = scan.nextLine();

        while (!verificarCredenciales(cedula, pass)) {
            if (salir(pass)) {
                inicio();
                return;
            } else {
                System.out.println("Contraseña o usuario invalido");
            }
            System.out.print("Contraseña: ");
            pass = scan.nextLine();
        }
        if (esAdmin(cedula)) menuAdmin();
        else menuUsuario();
        //TODO Ir al "Landing Page" correspondiente si es cliente regular, frequente o admin
    }
    
    /**
     * Muestra las Promociones basado en la lista de productos 
     */
    public void obtenerPromociones() {
        System.out.println("---------------Promociones---------------");
        productos.forEach(producto -> {
            if (producto instanceof IDescuento) {
                System.out.println(producto);
            }
        });
        System.out.println("-------------------------------------");
        menuUsuario();
    }

    /**
     * Muestra el proceso para establecer una nueva contraseña
     */
    public void olvideContra() {
        Scanner scan = new Scanner(System.in);
        Usuario user = null;
        String cedula;
        String direccion;
        String password;
        String password2;

        while (true) {
            System.out.println("Digite su numero de cedula o \"salir\" para regresar al menu principal.");
            System.out.print("Cedula: ");
            cedula = scan.nextLine();
            if (salir(cedula)) {
                inicio();
                return;
            }

            for (Usuario u : usuarios) {
                if (u.getCedula().equals(cedula)) {
                    user = u;
                    break;
                }
            }

            if (user != null) {
                break;
            } else {
                System.out.println("No existe un usuario con esa cedula");
            }
        }

        System.out.println("Escriba la direccion registrada en su cuenta.");
        System.out.print("Direccion: ");
        direccion = scan.nextLine();

        //TODO Email?
        while (!direccion.toLowerCase().equals(user.getDireccion().toLowerCase())) {
            if (salir(direccion)) {
                inicio();
                return;
            }
            System.out.println("Las direcciones no son iguales.");
            System.out.print("Direccion: ");
            direccion = scan.nextLine();
        }

        System.out.println("Ingrese su nueva contraseña.");
        System.out.print("Contraseña: ");
        password = scan.nextLine();

        System.out.print("Repetir: ");
        password2 = scan.nextLine();

        while (true) {
            if (password.equals(password2)) {
                if (password.toLowerCase().equals("salir")) {
                    System.out.println("Eso seria una mala idea, selecione otra contraseña.");
                } else {
                    break;
                }
            } else {
                System.out.println("Las contraseñas no son iguales.");
            }

            System.out.print("Contraseña: ");
            password = scan.nextLine();

            System.out.print("Repetir: ");
            password2 = scan.nextLine();
        }

        user.setPassword(password);
        System.out.println("Contraseña actualizada regresando al menu principal.");
        inicio();
    }

    /**
     * Muestra el proceso para registrar un nuevo usuario. Si todos los pasos se
     * completan exitosamente agrega el nuevo usuario a la lista de usuarios
     */
    public void registro() {
        Scanner scan = new Scanner(System.in);
        String nombre;
        String cedula;
        String direccion;
        String telefono;
        String email;
        String password;
        String password2;

        System.out.println("Ingrese su nombre o \"salir\" para regresar al menu principal.");
        System.out.print("Nombre: ");
        nombre = scan.nextLine();
        if (salir(nombre)) {
            inicio();
            return;
        }

        System.out.print("Cedula: ");
        cedula = scan.nextLine();

        System.out.print("Direccion: ");
        direccion = scan.nextLine();

        System.out.print("Telefono: ");
        telefono = scan.nextLine();

        System.out.print("Email: ");
        email = scan.nextLine();

        System.out.print("Contraseña: ");
        password = scan.nextLine();

        System.out.print("Repetir: ");
        password2 = scan.nextLine();

        while (true) {
            if (password.equals(password2)) {
                if (password.toLowerCase().equals("salir")) {
                    System.out.println("Eso seria una mala idea, selecione otra contraseña.");
                } else {
                    break;
                }
            } else {
                System.out.println("Las contraseñas no son iguales.");
            }

            System.out.print("Contraseña: ");
            password = scan.nextLine();

            System.out.print("Repetir: ");
            password2 = scan.nextLine();
        }

        usuarios.add(new Usuario(nombre, cedula, direccion, telefono, email, password));
        System.out.println("Registro completado, regresando al menu principal.");
        inicio();
    }

    /**
     * Busca el usuario con la cedula especificada en el paramentro y compara su
     * contraseña con la especificada en el parametro
     *
     * @param cedula La cedula del usuario que se desea ingresar al sistema
     * @param password La contraseña que ingreso el usuario
     * @return true si la contraseña es correcta, false si la contraseña es
     * incorrecta.
     */
    private boolean verificarCredenciales(String cedula, String password) {
        for (Usuario u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                return u.getPassword().equals(password);
            }
        }
        return false;
    }

    private boolean esAdmin(String cedula) {
        for (Persona u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                return u instanceof Administrador;
            }
        }
        return false;
    }
    /**
     * Revisa si el parametro es igual a "salir" antes de comprarlo lo convierte
     * a minusculas.
     *
     * @param string El string a comparar
     * @return true si son iguales, de lo contario false
     */
    private boolean salir(String string) {
        return string.toLowerCase().equals("salir");
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
    
    public void addProducto(Producto p){
        productos.add(p);
    }
    
    public void addCombo(Combo c) {
        combos.add(c);
    }
    
    public void verCombos(){
        System.out.println("---------------Combos---------------");
        combos.forEach(combo -> {
            System.out.println(combo);
        });
        menuUsuario();
        System.out.println("-------------------------------------");
    }
}
