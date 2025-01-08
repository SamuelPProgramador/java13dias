package bbsg.cuentas.repositorio;

import bbsg.cuentas.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer> {

}
