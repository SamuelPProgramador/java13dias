package bbsg.tareas.servicio;

import bbsg.tareas.modelo.Tarea;
import bbsg.tareas.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio implements ITareaServicio{
    @Autowired
    public TareaRepositorio tareaRepositorio;
    @Override
    public List<Tarea> listarTarea() {
        return tareaRepositorio.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea) {
       Tarea tarea = tareaRepositorio.findById(idTarea).orElse(null);
       return tarea;

    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepositorio.save(tarea);

    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        tareaRepositorio.delete(tarea);
    }
}
