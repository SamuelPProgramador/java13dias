package Servicio;

import Dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("*** Listado Pelicula ***");
        peliculas.forEach(System.out::println);

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Pelicula Agregada correctamente...." + pelicula);

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresar el indice de la pelicual encotrada
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1)
            System.out.println("Pelicula no encontrada: " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);
    }

    public static void main(String[] args) {
        //creamos objeto pelicula
        var pelicula1 = new Pelicula("Batman", "Waner bro");
        var pelicula2 = new Pelicula("Super man", "Waner bro");

        //creamos el servicio
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        //Agregamos  las pelicula a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        //listamos la pelicula
        servicioPeliculas.listarPeliculas();

        servicioPeliculas.buscarPelicula( new Pelicula("Karateki", "yo no se"));
        servicioPeliculas.buscarPelicula(pelicula2);
    }
}
