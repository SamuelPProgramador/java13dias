package bbsg.cuentas.servicio;

import bbsg.cuentas.modelo.Cuenta;

import java.util.List;

public interface ICuentaServicio {
    public List<Cuenta> listarCuenta();
    public Cuenta buscarCuentaPorId(Integer idCuenta);
    public void guardarCuenta(Cuenta cuenta);
    public void eliminarCuenta(Cuenta cuenta);


}
