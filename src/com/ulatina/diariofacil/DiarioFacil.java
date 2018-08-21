/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;


import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Iterator;
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
    private List<Persona> usuarios = new ArrayList<>();
    private List<Combo> combos = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();
    private Persona usuarioActual;

    private int consPro;
    private int consOrd;

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
        System.out.println("3 - Historial ordenes");
        System.out.println("4 - Comprar");
        System.out.println("5 - Ultima compra");
        System.out.println("6 - Salir");

        try {
            switch (scan.nextInt()) {
                case 1:
                    obtenerPromociones();
                    break;
                case 2:
                    menuCombo();
                    break;
                case 3:
                    listarOrdenes(usuarioActual.getCedula());
                    menuUsuario();
                    break;
                case 4:
                    comprar();
                    break;
                case 5:
                    verUltimaCompra();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    if (esAdmin(usuarioActual.getCedula())) {
                        menuAdmin();
                    } else {
                        menuUsuario();
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            if (esAdmin(usuarioActual.getCedula())) {
                menuAdmin();
            } else {
                menuUsuario();
            }
        }
    }

    public void menuAdmin() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite una opcion para continuar.");
        System.out.println("1 - Ver promociones");
        System.out.println("2 - Ver combos");
        System.out.println("3 - Historial ordenes");
        System.out.println("4 - Comprar");
        System.out.println("5 - Ultima compra");
        System.out.println("6 - Mantenimiento clientes");
        System.out.println("7 - Mantenimiento productos");
        System.out.println("8 - Salir");

        try {
            switch (scan.nextInt()) {
                case 1:
                    obtenerPromociones();
                    break;
                case 2:
                    verCombos();
                    break;
                case 3:
                    listarOrdenes(usuarioActual.getCedula());
                    menuAdmin();
                    break;
                case 4:
                    comprar();
                    break;
                case 5:
                    verUltimaCompra();
                    break;
                case 6:
                     mantenimientoInicio(usuarios);
                    //new MantenimientoCliente().mantenimientoInicio(usuarios);
                    menuAdmin();
                    break;
                case 7:
                    MantenimientoCliente.mantenimientoProducto(productos);
                    menuAdmin();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    if (esAdmin(usuarioActual.getCedula())) {
                        menuAdmin();
                    } else {
                        menuUsuario();
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            menuAdmin();
        }
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
        this.usuarioActual = getUsuarioActual(cedula);
        if (esAdmin(cedula)) {
            menuAdmin();
        } else {
            menuUsuario();
        }
    }

    /**
     * Muestra las Promociones basado en la lista de productos
     */
    public void obtenerPromociones() {
        List<Orden> ordenesUsuario = new ArrayList<>();

        for (Orden o : ordenes) {
            if (o.getUsuario().getCedula().equals(usuarioActual.getCedula())) {
                ordenesUsuario.add(o);
            }
        }

        if (ordenesUsuario.size() > 5) {
            System.out.println("---------------Promociones---------------");
            productos.forEach(producto -> {
                if (producto instanceof IDescuento) {
                    System.out.println(producto);
                }
            });
            System.out.println("-------------------------------------");
        } else {
            System.out.println("Las promociones son solo para clientes frecuentes");
        }

        if (esAdmin(usuarioActual.getCedula())) {
            menuAdmin();
        } else {
            menuUsuario();
        }
    }

    /**
     * Muestra el proceso para establecer una nueva contraseña
     */
    public void olvideContra() {
        Scanner scan = new Scanner(System.in);
        Persona user = null;
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

            for (Persona u : usuarios) {
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
        for (Persona u : usuarios) {
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

    private void comprar() {
        Scanner scan = new Scanner(System.in);
        String producto;
        List<Item> items = new ArrayList<>();
        while (true) {
            System.out.println("Digite el id de producto que desea comprar, salir para cancelar la orden o comprar para generar la compra");
            verProductos();
            producto = scan.nextLine();
            try {
                if (salir(producto)) {
                    salirCarrito(items);

                } else if (producto.equals("comprar")) {
                    comprarCarrito(items);

                } else if (!existeProducto(parseInt(producto))) {
                    System.out.println("Producto no valido");
                } else {
                    agregarProducto(producto, items);

                }
            } catch (NumberFormatException e) {
                System.out.println("Debe de seleccionar alguna de las opciones anteriores");
            }

        }
    }

    private void agregarProducto(String producto, List<Item> items) throws NumberFormatException {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        for (Producto a : productos) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("Cuantos productos desea:");
        int cantidad = parseInt(scan.nextLine());
        Producto p = obtenerProductoPorId(parseInt(producto));
        if (cantidad <= p.getInventario()) {
            p.setInventario(p.getInventario() - cantidad);
            actualizarInventario(p);
            Item item = new Item(cantidad, p, cantidad);
            items.add(item);
            System.out.println("Producto agregado: ");
            System.out.println(item + "\n\n");
        } else {
            System.out.println("Lo sentimos actualmente nuestro inventario del producto es de " + p.getInventario());
        }
    }

    private void comprarCarrito(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("Debe de añadir productos");
        } else {
            System.out.println("Se genera la compra");
            generarOrden(items);
        }
    }

    private void salirCarrito(List<Item> items) {
        Scanner scan = new Scanner(System.in);
        if (!items.isEmpty()) {
            System.out.println("Tiene articulos en su carrito, desea salir? escriba salir para cancelar la comprar");
            if (salir(scan.nextLine())) {
                retornarInventario(items);
                if (esAdmin(usuarioActual.getCedula())) {
                    menuAdmin();
                } else {
                    menuUsuario();
                }
            }
        } else {
            if (esAdmin(usuarioActual.getCedula())) {
                menuAdmin();
            } else {
                menuUsuario();
            }
        }
    }

    private void retornarInventario(List<Item> items) {
        items.forEach(item -> {
            Producto p = item.getProducto();
            p.setInventario(p.getInventario() + item.getCantidad());
            actualizarInventario(p);
        });
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

    public List<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Persona> usuarios) {
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

    public void addProducto(Producto p) {
        productos.add(p);
    }

    public void addCombo(Combo c) {
        combos.add(c);
    }
    //este verCombos no se sabe su procedencia 
    public void verCombos() {
        System.out.println("---------------Combos---------------");
        combos.forEach(combo -> {
            System.out.println(combo);
        });
        if (esAdmin(usuarioActual.getCedula())) {
            menuAdmin();
        } else {
            menuUsuario();
        }
        System.out.println("-------------------------------------");
    }
    //menu del combo donde se puede ver y escoger todos los combos que hay
    public void menuCombo(){
        Scanner scan = new Scanner(System.in);
        combos.forEach(combo -> {
            System.out.println(combo);
        });
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("Escoja un combo de las 3 opciones");
        System.out.println("Digite 4 para salir");
        
        try {
            switch (scan.nextInt()){
                case 1:
                    System.out.println("Escogio el combo 1");
                    menuUsuario();
                    break;
                case 2:
                    System.out.println("Escogio el combo 2");
                    menuUsuario();
                    break;
                case 3:
                    System.out.println("Escogio el combo 3'");
                    menuUsuario();
                    break;
                case 4:
                    menuUsuario();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    menuCombo();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            menuCombo();
        }
    }


    public void verProductos() {
        productos.forEach(producto -> {
            System.out.println(producto);
        });
    }

    private boolean existeProducto(int codigo) {
        for (Producto producto : productos) {
            if (producto.getid() == codigo) {
                return true;
            }
        }
        return false;
    }

    private Producto obtenerProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getid() == id) {
                return producto;
            }
        }
        return null;
    }

    private void actualizarInventario(Producto p) {
        productos.remove(p);
        productos.add(p);
    }

    private Persona getUsuarioActual(String cedula) {
        for (Persona usuario : usuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    private void actualizarUsuario(Usuario u) {
        usuarios.remove(u);
        usuarios.add(u);
    }

    private void generarOrden(List<Item> items) {
        Orden orden = new Orden(ordenes.size(), this.usuarioActual);
        items.forEach(item -> {
            orden.addItem(item.getProducto(), item.getCantidad());
        });
        ordenes.add(orden);
        System.out.println(orden);
        System.out.println("Gracias por su compra");
        ((Usuario) this.usuarioActual).setUltimaOrden(orden.getId());
        actualizarUsuario((Usuario) this.usuarioActual);
        if (esAdmin(usuarioActual.getCedula())) {
            menuAdmin();
        } else {
            menuUsuario();
        }
    }

    private void verUltimaCompra() {
        int ordenId = ((Usuario) this.usuarioActual).getUltimaOrden();
        for (Orden orden : ordenes) {
            if (orden.getId() == ordenId) {
                System.out.println(orden);
            }
        }
        if (esAdmin(usuarioActual.getCedula())) {
            menuAdmin();
        } else {
            menuUsuario();
        }
    }

    private int nextConsPro() {
        return consPro++;
    }

    private int nextConsOrd() {
        return consOrd++;
    }

    public void addOrden(Usuario u) {
        ordenes.add(new Orden(nextConsOrd(), u));
    }
    
    //mant cliente
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
                    menuAdmin();
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

    public void listarOrdenes(String cedula) {
        List<Orden> ordenesUsuario = new ArrayList<>();

        for (Orden o : ordenes) {
            if (o.getUsuario().getCedula().equals(cedula)) {
                ordenesUsuario.add(o);
            }
        }

        System.out.println("Ordenes del usuario:");
        for (Orden o : ordenesUsuario) {
            System.out.println("ID: " + o.getId() + " Fecha: " + formatFecha(o.getFecha()) + " Total: " + o.getTotal());
        }
    }

    public void imprimirOrden(int i) {
        for (Orden o : ordenes) {
            if (o.getId() == i) {
                System.out.println(o.toString());
                break;
            }
        }
    }

    private String formatFecha(Calendar fecha) {
        return fecha.get(Calendar.DAY_OF_MONTH) + "/"
                + fecha.get(Calendar.MONTH) + "/"
                + fecha.get(Calendar.YEAR);
    }
}
