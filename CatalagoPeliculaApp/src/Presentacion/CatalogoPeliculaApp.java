package Presentacion;

import Dominio.Pelicula;
import Servicio.IServicioPeliculas;
import Servicio.ServicioPeliculasArchivo;
import Servicio.ServicioPeliculasLista;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class CatalogoPeliculaApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //Agregamos la implementacion el servicio
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
         IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);

            } catch (Exception e ){
                System.out.println("Error ocurrido" + e.getMessage());
            }
        System.out.println();
        }//fin del ciclo while
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas) {
     var opc = Integer.parseInt(consola.nextLine());
     var salir = false;
     switch (opc){
         case 1 ->{
             System.out.print("Introduce el nombre de la pelicula: ");
             var nombrePelicula = consola.nextLine();
             System.out.print("Introduce el autor de la pelicula: ");
             var autorPelicula = consola.nextLine();
             servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula, autorPelicula));
         }//fin caso 1

         case 2 -> servicioPeliculas.listarPeliculas(); //fin caso 2

         case 3 ->{
            System.out.print("Introduce nombre de la pelicula: ");
            var nombreP = consola.nextLine();
            System.out.print("Introduce auotr de la pelicula: ");
            var autorP = consola.nextLine();
           servicioPeliculas.buscarPelicula(new Pelicula(nombreP, autorP ));

         }// fin caso 3
         case 4 ->{
             System.out.print("Hasta pronto...");
             salir = true;
         }
         default ->  System.out.print("Opcion no reconocida...");

     }

        return salir;
    }


    private static void mostrarMenu() {
        System.out.println("""
                *** Menu ***
                1). Agregar pelicula
                2). Listar Pelicula
                3). Buscar Pelicula
                4) Salir
                """);
        System.out.print("Ingresa la opcion: ");
    }
}