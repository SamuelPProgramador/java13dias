package MundoPC.modelo;

public class Raton extends DipositivoEntrada{
    private  final int idRaton;
    private static int contadorRatones;

    public Raton(String tipo_entrada, String marca){
        super(tipo_entrada, marca);
        idRaton = ++contadorRatones;

    }

    public int getIdRaton() {
        return idRaton;
    }

    public static int getContadorRatones() {
        return contadorRatones;
    }

    public static void setContadorRatones(int contadorRatones) {
        Raton.contadorRatones = contadorRatones;
    }

    @Override
    public String toString() {
        return "Raton{" +
                "idRaton=" + idRaton +
                "} "+ super.toString() ;
    }
}
