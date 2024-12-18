package bbsg.empleado.servicio;

import bbsg.empleado.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List <Empleado> listarEmpleado();
    public Empleado buscarEmpleadoPorId(Integer idEmpleado );

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
