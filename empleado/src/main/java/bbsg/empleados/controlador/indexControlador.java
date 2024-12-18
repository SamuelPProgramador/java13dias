package bbsg.empleado.controlador;

import bbsg.empleado.servicio.EmpleadoServicio;
import bbsg.empleado.modelo.Empleado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class indexControlador {
    private static final Logger logger = LoggerFactory.getLogger(indexControlador.class);

    @Autowired
    EmpleadoServicio empleadoServicio;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> empleados = empleadoServicio.listarEmpleado();
        empleados.forEach((empelado)-> logger.info(empelado.toString()));
        //Compartimos el modelo de vista
        modelo.put("empleados", empleados);
        return "index";

    }
}
