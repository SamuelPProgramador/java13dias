package MundoPC.Servicio;

import MundoPC.modelo.Computadora;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final  int idOrden;
    private final List<Computadora> computadoras;
    private static int contadorOrdenes;

    public Orden(){
        computadoras = new ArrayList<>();
        this.idOrden = ++contadorOrdenes;

    }
    public void agregarComputadora(Computadora computadora){
        computadoras.add(computadora);
    }
    public void mostrarOrden(){
        System.out.println("*** Mostrando lista de Computadora ***");
        System.out.println("Numero de orden #" + idOrden);
        System.out.println("Total de Computadora: "+ computadoras.size());
        computadoras.forEach(System.out::println);
    }
}
