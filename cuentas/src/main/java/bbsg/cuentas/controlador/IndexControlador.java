package bbsg.cuentas.controlador;

import bbsg.cuentas.modelo.Cuenta;
import bbsg.cuentas.servicio.CuentaServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexControlador {

    @Autowired
    CuentaServicio cuentaServicio;
    private List<Cuenta> cuentas;
    private Cuenta cuentaSelecionada;

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    public CuentaServicio getCuentaServicio() {
        return cuentaServicio;
    }

    public void setCuentaServicio(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public Cuenta getCuentaSelecionada() {
        return cuentaSelecionada;
    }

    @Override
    public String toString() {
        return "IndexControlador{" +
                "cuentaServicio=" + cuentaServicio +
                ", cuentas=" + cuentas +
                ", cuentaSelecionada=" + cuentaSelecionada +
                '}';
    }

    public void setCuentaSelecionada(Cuenta cuentaSelecionada) {
        this.cuentaSelecionada = cuentaSelecionada;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos() {
        this.cuentas = cuentaServicio.listarCuenta();
        cuentas.forEach((cuenta) -> logger.info(cuenta.toString()));
    }

    public void agregarCuenta(){
        logger.info("Se creo la cuenta");
        this.cuentaSelecionada = new Cuenta();

    }
    public void guardarCuenta(){
        logger.info("Cuenta a guardar: " + this.cuentaSelecionada);
        //Agregar
        if(this.cuentaSelecionada.getIdCuenta() == null){
            this.cuentaServicio.guardarCuenta(this.cuentaSelecionada);
            this.cuentas.add(this.cuentaSelecionada);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta Agregada",
                            "La cuenta se agregó correctamente."));

//            FacesContext.getCurrentInstance().addMessage(null,
//                                                    new FacesMessage("Cuenta Agregada"));
        }

        else { //modificar (update)
            this.cuentaServicio.guardarCuenta(cuentaSelecionada);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cuenta Actualizada..."));

        }
        //ocultamos la ventana
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");
        //Actualizamos la pagina
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes",
                                                        "forma-cuentas:cuentas-tabla");
    }
}
