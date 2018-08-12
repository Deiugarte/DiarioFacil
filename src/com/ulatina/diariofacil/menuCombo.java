/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.InputMismatchException;
import java.util.Scanner;



/**
 *
 * @author Andres
 */
public class menuCombo {
    private String nombre;
    
    public menuCombo(String nombre){
        this.nombre = nombre;
    }
    
    public void inicio(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite 1 para entrar a la zona de combo");
        System.out.println("Digite 2 para salir");
        
        try {
             switch (scan.nextInt()) {
                case 1:
                    //aqui aparecen los combos
                    break;
                case 2:
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
    public void escogerCombo(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("Escoja un combo de las 3 opciones");
        System.out.println("Digite 4 para salir");
        
        try {
            switch (scan.nextInt()){
                case 1:
                    System.out.println("Escogio el combo 1");
                    break;
                case 2:
                    System.out.println("Escogio el combo 2");
                    break;
                case 3:
                    System.out.println("Escogio el combo 3");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    escogerCombo();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor deber ser numerico.");
            escogerCombo();
        }
    }
}
