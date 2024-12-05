package bbsg.Tienda_libros.repositorio;

import bbsg.Tienda_libros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository <Libro, Integer> {

}
