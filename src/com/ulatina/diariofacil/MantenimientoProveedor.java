/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class MantenimientoProveedor {

//    public void mantenimientoProveedor(List<Proveedor> proveedores) {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print("OPCIONES DE PROVEEDORES" + "\n"
//                + "1. Agregar Proveedor" + "\n"
//                + "2. Editar Proveedor" + "\n"
//                + "3. Eliminar Proveedor" + "\n"
//                + "5. Ver Proveedores" + "\n");
//
//        int opcion = scan.nextInt();
//        switch (opcion) {
//            case 1:
//                agregarProveedor(proveedores);
//                break;
//            case 2:
//                editarProveedor(proveedores);
//                break;
//            case 3:
//                eliminarProveedor(proveedores);
//                break;
//            case 5:
//                verProveedores(proveedores);
//                break;
//
//        }
//
//    }
//
//    public void verProveedores(List<Proveedor> proveedores) {
//        System.out.println("===LISTA DE PROVEEDORES===" + "\n");
//        for (Proveedor a : proveedores) {
//            System.out.print(a.toString());
//        }
//        mantenimientoProveedor(proveedores);
//    }
//
//    public void agregarProveedor(List<Proveedor> proveedores) {
//        Scanner leer = new Scanner(System.in);
//        System.out.println("¿Cual es el nombre de la empresa: ");
//        String empresa = leer.nextLine();
//        System.out.println("¿Cual es el nombre del representante: ");
//        String representante = leer.nextLine();
//        System.out.println("Cual es el correo");
//        String correo = leer.nextLine();
//        System.out.println("Cual es el telefono: ");
//        int telefono = leer.nextInt();
//
//        System.out.println(empresa + " es un nuevo proveedor de DiarioFacil!" + "\n");
//        proveedores.add(new Proveedor(empresa, representante, correo, telefono));
//        mantenimientoProveedor(proveedores);
//    }
//
//    public void editarProveedor(List<Proveedor> proveedores) {
//        Scanner scan = new Scanner(System.in);
//        int i = 0;
//        System.out.print("===EDITAR PROVEEDOR===" + "\n"
//                + "¿Cuál proveedor quieres editar?" + "\n");
//        for (Proveedor a : proveedores) {
//            i++;
//            System.out.print(i + ". " + a.toString());
//        }
//        System.out.println("Digita el indice del proveedor deseado: " + "\n");
//        int proveedor = scan.nextInt();
//        System.out.println("¿Qué quieres editar de " + proveedores.get(proveedor - 1).getNombre() + "? " + "\n"
//                + "1. Nombre de empresa" + "\n"
//                + "2. Nombre de representante" + "\n"
//                + "3. Correo de la empresa" + "\n"
//                + "4. Teléfono de la empresa" + "\n"
//                + "Digite una opcion: " + "\n");
//        int opcion = scan.nextInt();
//        Scanner leer = new Scanner(System.in);
//        switch (opcion) {
//
//            case 1:
//                System.out.println("¿Cuál sería el nuevo nombre?");
//                String nuevoNombre = leer.nextLine();
//                System.out.println("El nombre de " + proveedores.get(proveedor - 1).getNombre()
//                        + " ha sido cambiado a " + nuevoNombre);
//                proveedores.get(proveedor - 1).setNombre(nuevoNombre);
//                break;
//            case 2:
//                System.out.println("¿Cuál sería el nuevo representante?");
//                String nuevoRepresentante = leer.nextLine();
//                System.out.println("El representante de " + proveedores.get(proveedor - 1).getNombre()
//                        + " ha sido actualizado a " + nuevoRepresentante);
//                proveedores.get(proveedor - 1).setPersonaEncargada(nuevoRepresentante);
//                break;
//            case 3:
//                System.out.println("¿Cuál sería el nuevo correo?");
//                String correo = leer.nextLine();
//                System.out.println("El correo de " + proveedores.get(proveedor - 1).getNombre()
//                        + " ha sido actualizado a " + correo);
//                proveedores.get(proveedor - 1).setEmail(correo);
//                break;
//
//        }
//        mantenimientoProveedor(proveedores);
//    }
//
//    public void eliminarProveedor(List<Proveedor> proveedores) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("===ELIMINAR PROVEEDOR===");
//        int i = 0;
//        for (Proveedor a : proveedores) {
//            i++;
//            System.out.println(i + ". " + a.toString());
//        }
//        System.out.println("¿Cuál Proveedor desea eliminar? " + "\n"
//                + "Digite el indice del deseado: ");
//        int opcion = scan.nextInt();
//        System.out.println(proveedores.get(opcion - 1).getNombre() + "Ha sido eiminado exitosamente!");
//        proveedores.remove(opcion - 1);
//    }
}
