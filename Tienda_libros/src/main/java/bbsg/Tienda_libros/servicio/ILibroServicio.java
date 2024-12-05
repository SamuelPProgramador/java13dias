package bbsg.Tienda_libros.servicio;

import bbsg.Tienda_libros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILibroServicio  {
    public List<Libro> listar_libros();
    public Libro buscarLibroPorId(Integer idLibro);
    public void guardarLibro(Libro libro);
    public void eliminarLibro(Libro libro);


}
