package Servicio;

import Dominio.Pelicula;

import java.awt.*;
import java.io.*;

public class ServicioPeliculasArchivo implements  IServicioPeliculas{
    private  final String NOMBRE_ARCHIVO = "Peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
                if(archivo.exists()){
                    System.out.println("El archivo ya existe...");
                }
                else {
                    var salida = new PrintWriter(new FileWriter(archivo));
                    salida.close();
                    System.out.println("El archivo creado con exito...");
                }
        }catch (Exception e){
            System.out.println("ha Ocurrido un error: "+ e.getMessage());
        }
    }
    @Override
    public void listarPeliculas() {
        //volvermos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("*** Listado de Pelicula ***");
            //Abrimo el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //leemos linea a linea
            String linea;
            linea = entrada.readLine();
            //leemos toda las liena
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //ante de cerrar el ciclo volvemos a leer la otra linea
                linea = entrada.readLine();
            }
            //cerramos el archivo
            entrada.close();
        } catch (Exception e){
            System.out.println("has ocurrido un error " + e.getMessage());
        }

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Revisamos si exite el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego el Archivo" + pelicula);
        } catch (Exception e){
            System.out.println("has ocurrido un error: "+ e.getMessage());
        }

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new  File(NOMBRE_ARCHIVO);

        try {
            //Abrimos el archivo para buscar linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = "";
            var indice = 1;
            var encotrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null){
                //bucamos la pelicula
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encotrada = true;
                    break;
                }
                //leemos la siguinte linea ante de la interacion
                lineaTexto = entrada.readLine();
                indice++;
            }//fin del while
            //imprimimos los resultado de la busqueda encontrada
            if(encotrada){
                System.out.println("Pelicula encontada" + lineaTexto + "encotrada -- linea" + indice);
            }else {
                System.out.println("No se encontro la pelicula" + pelicula.getNombre());
            }
            entrada.close();
        } catch (Exception e){
            System.out.println("ha ocurrio un error" + e.getMessage());
        }

    }
}
