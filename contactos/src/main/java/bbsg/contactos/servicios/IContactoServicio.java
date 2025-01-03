package bbsg.contactos.servicios;

import bbsg.contactos.modelo.Contacto;

import java.util.List;

public interface IContactoServicio {
    public List<Contacto> listarContacto();

    public Contacto buscarContactoPorID(Integer idContacto);

    public void guardarContacto(Contacto contacto);

    public void eliminarContacto(Contacto contacto);

}
