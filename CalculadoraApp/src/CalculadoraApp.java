import java.awt.*;
import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {
            System.out.println("*** Aplicacion Calcualdora ***");
            mostrarMenu();
            try {
                var opc = Integer.parseInt((consola.nextLine()));
                if (opc >= 1 && opc <= 4) {
                    ejecutarOperacion(opc, consola);

                } else if (opc == 5) {
                    System.out.println("Hasta pronto...");
                    break;
                } else {
                    System.out.print("Valor Erroneo");
                }
            } catch (Exception e){
                System.out.println("Ocurrio un error" + e.getMessage());
            }

        }// fin del while

    }
    private static void mostrarMenu(){
        //Haciendo el menu
        System.out.print(""" 
                    Menu
                    1. Suma
                    2. Recta
                    3. Multiplicacion
                    4. Division
                    5. Salir
                    """);
        System.out.print("Elige tu opcion: ");
    }
    private  static void ejecutarOperacion(int opc, Scanner consola){
        System.out.print("Escribe el operando1: ");
        var operando1 = Integer.parseInt(consola.nextLine());
        System.out.print("Escribe el operenado2: ");
        var operando2 = Integer.parseInt(consola.nextLine());
        int resultado;

        switch (opc) {
            case 1:
                resultado = operando1 + operando2;
                System.out.println("La suma es " + resultado);
                break;

            case 2:
                resultado = operando1 - operando2;
                System.out.println("La resta es: " + resultado);
                break;

            case 3:
                resultado = operando1 * operando2;
                System.out.println("La multplicacion es: " + resultado);
                break;

            case 4:
                resultado = operando1 / operando2;
                System.out.println("La division es: " + resultado);
                break;

            default:
                System.out.println("Numero Erroneo" + opc);
        }

    }
}