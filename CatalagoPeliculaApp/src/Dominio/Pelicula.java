package Dominio;

public class Pelicula {
    private String nombre;
    private String autor;

    public Pelicula(){}
    public Pelicula(String nombre, String autor){
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;

        if (!nombre.equals(pelicula.nombre)) return false;
        return autor.equals(pelicula.autor);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + autor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pelicula:\n" +
                "Nombre= '" + nombre + '\'' +
                ",\nAutor= '" + autor + '\''
                 + "\n";
    }

    public static void main(String[] args) {
        Pelicula pelicua1 = new Pelicula("BAtman","Waner Bro");
        Pelicula pelicula2 = new Pelicula("Super Man", "Waner bo");

        System.out.println(pelicua1);
        System.out.println(pelicula2);
    }
}
