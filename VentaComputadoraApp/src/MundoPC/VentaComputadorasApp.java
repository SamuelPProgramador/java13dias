package MundoPC;

import MundoPC.Servicio.Orden;
import MundoPC.modelo.Computadora;
import MundoPC.modelo.Monitor;
import MundoPC.modelo.Raton;
import MundoPC.modelo.Teclado;

public class VentaComputadorasApp {
    public static void main(String[] args) {

    Raton ratonLenovo = new Raton("UBS","lenovo");
    //System.out.print(ratonLenovo);

    Teclado tecladoLenovo = new Teclado("USB", "Lenovo");
   // System.out.print(tecladoLenovo);

    Monitor monitoLenovo = new Monitor("lenovo", 25);
   // System.out.print(monitoLenovo);

    //Creamos un objeto tipo computadora
        Computadora computadoraLenovo = new Computadora("Computadora Lenovo", monitoLenovo, tecladoLenovo, ratonLenovo);
       // System.out.print(computadoraLenovo);

        Teclado teclado1 = new Teclado("USB", "DELL");
        Monitor monitor1 = new Monitor("Dell", 27);
        Raton raton1 = new Raton("USB", "DELL");
        Computadora computadora1 = new Computadora("Computadora Dell", monitor1, teclado1, raton1);

        Teclado teclado2 = new Teclado("USB", "IMAC");
        Monitor monitor2 = new Monitor("IMAC", 45 );
        Raton raton2 = new Raton("Tipo C","IMAC" );
        Computadora computadora2 = new Computadora("Computadora Mac", monitor2, teclado2, raton2);



        //Creamos una orden
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.mostrarOrden();

        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadora1);
        orden2.mostrarOrden();

        Orden orden3 = new Orden();
        orden3.agregarComputadora(computadora1);
        orden3.agregarComputadora(computadora2);
        orden3.agregarComputadora(computadora2);
        orden3.agregarComputadora(computadoraLenovo);
        orden3.mostrarOrden();
    }
}