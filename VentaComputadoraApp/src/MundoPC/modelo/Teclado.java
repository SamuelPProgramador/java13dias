package MundoPC.modelo;

public class Teclado extends  DipositivoEntrada{
    private  final int idTeclado;

    private  static  int contadorTeclado;

    public Teclado(String tipo_entrada, String marca){
        super(tipo_entrada, marca);
        idTeclado = ++contadorTeclado;

    }

    public int getIdTeclado() {
        return idTeclado;
    }

    public static int getContadorTeclado() {
        return contadorTeclado;
    }

    public static void setContadorTeclado(int contadorTeclado) {
        Teclado.contadorTeclado = contadorTeclado;
    }

    @Override
    public String toString() {
        return "\nTeclado{" +
                "idTeclado=" + idTeclado +
                "} " + super.toString();
    }
}
