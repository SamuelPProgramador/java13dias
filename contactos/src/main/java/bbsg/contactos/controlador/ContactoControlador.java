package bbsg.contactos.controlador;

import bbsg.contactos.modelo.Contacto;
import bbsg.contactos.servicios.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    ContactoServicio contactoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Contacto> contactos = contactoServicio.listarContacto();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return "index"; //index.html
    }
    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";
    }
}
