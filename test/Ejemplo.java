
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        List<String> strings = new ArrayList<>();
        strings.add("Prueba 1");
        strings.add("Prueba 2");
        strings.add("Prueba 3");

        System.out.println("Selecione una opcion:");

        //Imprimir todas las opciones
        for (int i = 0; i < strings.size(); i++) {
            System.out.println((i + 1) + " - " + strings.get(i));
        }

        //Esperar que el usuario selecione una opcion valida
        int opcion;
        while (true) {
            try {
                opcion = scan.nextInt();
                //Revisar si el numero es valido (Que corresponde a un valor de la lista)
                if (opcion <= strings.size() && opcion >= 1) {
                    //Salir del loop cuando el usuario seleciona una opcion valida
                    break;
                } else {
                    System.out.println("Selecione una opcion valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor deber ser numerico.");
                //Cuando Scanner tira un excepcion el valor no se usa entonces hay que pasarlo
                scan.next();
            }
        }

        //Finalmente imprimir la opcion que seleciono el usuario
        System.out.println("La opcion selecionada es: " + opcion);
    }

}
