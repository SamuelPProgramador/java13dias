package MundoPC.modelo;

public class Monitor {
    private final  int idMonitores;
    private String marca;
    private double tamanio;
    private static int contadorMonitores;

    private Monitor(){
    idMonitores = ++contadorMonitores;
    }//Fin de la clase monitor
    public Monitor(String marca, double tamanio){
        this();
        this.marca = marca;
        this.tamanio = tamanio;

    }

    @Override
    public String toString() {
        return "\nMonitor{" +
                "idMonitores=" + idMonitores +
                ", marca='" + marca + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}
