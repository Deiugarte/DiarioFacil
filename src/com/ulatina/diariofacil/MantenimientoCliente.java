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
 * @author Andres
 */
public class MantenimientoCliente {
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void agregarUsuarios(Usuario u){
        this.usuarios.add(u);
    }
    
    public  MantenimientoCliente(){}
    //inicio del mantenimiento
    public void mantenimientoInicio(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite 1 Buscar el cliente");
        System.out.println("Digite 2 para salir");
        
        try {
             switch (scan.nextInt()) {
                case 1:
                    buscarCliente();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    mantenimientoInicio();
                    break;
            }
             
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");   
            mantenimientoInicio();
        }
    }
    //modifica al cliente o lo elimina
    public void modificarCliente(Usuario u) {
       Scanner scan = new Scanner(System.in);
       
        System.out.println("1-Cambiar Nombre");
        System.out.println("2-Cambiar Cedula");
        System.out.println("3-Cambiar Direccion");
        System.out.println("4-Cambiar Telefono");
        System.out.println("5-Cambiar Email");
        System.out.println("6-eliminar el usuario");
        
       int opcion =scan.nextInt();
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
                    eliminarCliente(u);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    mantenimientoInicio();
                    break;
            }
             
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");   
            mantenimientoInicio();
        }  
        
        System.out.println(" Nombre: " + u.getNombre()
                                 + " Direccion: " + u.getDireccion()
                                 + " Telefono: " + u.getTelefono()
                                 + " Email: " + u.getEmail()); 
        mantenimientoInicio();
        
    }
    //elimina al cliente
   public void eliminarCliente(Usuario u) {
       usuarios.remove(u);
       System.out.println("Este Usuario ha sido borrado");
   }
   //busca al cliente
   public void buscarCliente(){
    
       for (Usuario u: usuarios){
           System.out.println(
                 " Nombre: " + u.getNombre()
                + " Cedula: " + u.getCedula() 
                + " Direccion: " + u.getDireccion()
                + " Telefono: "+ u.getTelefono()  
                + " Email: " + u.getEmail());
       }
       
       Usuario usuarioSelect = seleccionarCliente();
       //agarra el usuario y si no es nulo abre el metodo modificarCliente
       if (usuarioSelect != null){
           modificarCliente(usuarioSelect);
       }
   }
   
   //selecciona al cliente y lo muestra
   public Usuario seleccionarCliente(){
       Scanner scan = new Scanner(System.in);
       
        System.out.println("Digite la cedula del cliente");    
        String cedula = scan.nextLine();
        
        
       for(Usuario u: usuarios){
           if (u.getCedula().equals(cedula)){
               System.out.println(" Nombre: " + u.getNombre()
                                 + " Direccion: " + u.getDireccion()
                                 + " Telefono: " + u.getTelefono()
                                 + " Email: " + u.getEmail());   
           } else {
               System.out.println("cedula no encontrada o no existente!");
               seleccionarCliente();
           }
           return u;
       }
       return null;
   }
   
}