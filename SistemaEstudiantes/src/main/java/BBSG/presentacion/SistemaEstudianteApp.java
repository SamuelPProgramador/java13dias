package BBSG.presentacion;

import BBSG.datos.EstudianteDAO;
import BBSG.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudianteApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        var salir = false;

        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try {
                mostrarMenu();;
                salir = ejecutarOperaciones(consola, estudianteDao);
            }catch (Exception e){
                System.out.print("has ocurrido un error.." + e.getMessage());
            }
        System.out.println();
        }// fin del while


    }

    private static boolean ejecutarOperaciones(Scanner consola, EstudianteDAO estudianteDao) {

        var opc = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opc){
            case 1 ->{ // listar estudiante
                System.out.print("Listando estudiantes...");
                var estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            } // fin caso 1

            case 2 ->{//Buscar estudiante
                System.out.print("Proporciana el id del estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estuadiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDao.buscarEstudiantePorId(estuadiante);
                if (encontrado){
                    System.out.print("Estudiantes encontrado..." + estuadiante);
                }else {
                    System.out.print("Estudiante no encontrado..." + estuadiante);
                }

            }// fin caso 2

            case 3 ->{//Agregar estudiante
                System.out.print("Agregar Estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                // crear objecto estudiante sin id
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDao.agregarEstudiante(estudiante);
                if(agregado){
                    System.out.print("Estudiante agregado con exito..." + estudiante);
                }else {
                    System.out.print("no se pudo agregar el estudiante..."  + estudiante);
                }

            }// fin caso 3
            case 4 ->{// modificar estudiante
                System.out.print("Modificar estudiante: ");
                System.out.print("Ingrese ID del estudiante a modificar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                //Crear el objecto del estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDao.modificarEstudiante(estudiante);
                if(modificado){
                    System.out.print("Estudiante modificado con exito..." + modificado);
                }
                else {
                    System.out.print("El estudiante no se pudo modificar.." + estudiante);
                }
            } // fin del caso 4
            case 5->{//eliminar
                System.out.print("Eliminar estudiante: ");
                System.out.print("Ingresa ID estudiante a eliminar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDao.eliminarEstudiante(estudiante);
                if (eliminado){
                    System.out.print("Estudinte eliminado con exito..." + estudiante);
                }else{
                    System.out.print("El estudiante no se puedo eliminar.. "+ estudiante);
                }

            } // fin case 5
            case 6 ->{
                System.out.print("Saliendo...");
                salir = true;
            } // fin caso 6
            default -> System.out.print("Valor erroneo...");
        }

        return salir;
    }

    private static void mostrarMenu() {
        System.out.println("""
                *** Sistemaas de Estudiantes ***
                1. Listar    Estudiante
                2. Buscar    Estudiante
                3. Agregar   Estudiante
                4. Modificar Estudiante
                5. Eliminar  Estudiante
                6. Salir""");

        System.out.print("Agrega una opcion: ");
    }
}