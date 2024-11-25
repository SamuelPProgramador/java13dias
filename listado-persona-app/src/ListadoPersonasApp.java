import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        //Hare la lista fuera del ciclo
        List<Persona> personas = new ArrayList<>();

        //Hacemos el menu
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);

            } catch (Exception e ){
                System.out.print("Error" + e.getMessage());
            }

            System.out.println("");
        }

    }


    private static void mostrarMenu() {
        //opciones
        System.out.print("""
                **** Menu ****
                1). Agregar
                2). listar
                3). Salir
                """);
        System.out.print("Propociona una opcion: ");
    }
    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opc = Integer.parseInt(consola.nextLine());
        var salir = false;

        //revisamos la opcion
        switch (opc){
            case 1 ->{
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el Telefono");
                var telefono = consola.nextLine();
                System.out.print("Proporciona el Email: ");
                var email = consola.nextLine();

                // crear Objecto Persona
                var persona = new Persona(nombre, telefono, email);
                personas.add(persona);
                System.out.print("La lista tiene " + personas.size() + " Elemento");

            }// fin caso 1
            case 2 ->{
                System.out.print("Listado de Persona: ");
                //Mejora usando lambda y metodos de referencia
               // personas.forEach((persona) -> System.out.print(persona));
                personas.forEach(System.out::println);
            } // fin caso 2

            case 3 ->{
                System.out.print("Hasta la proxima....");
                salir = true;
            }// fin caso 3

            default -> System.out.print("Valor erroneo... " + opc);
        }//Fin Swich
    return  salir;

    }

}
