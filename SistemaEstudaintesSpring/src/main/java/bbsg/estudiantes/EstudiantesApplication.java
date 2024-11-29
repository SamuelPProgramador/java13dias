package bbsg.estudiantes;

import bbsg.estudiantes.modelo.Estudiante;
import bbsg.estudiantes.servicio.EstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication  implements CommandLineRunner {
	@Autowired
	private EstudianteServicio estudianteServicio;

	private static  final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String ln = System.lineSeparator();


	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");

		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion Finalizada...");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(ln + "Ejecutando metodo run de spring" + ln);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir = ejecutarOperacion(consola);
			logger.info("");
		}//fin del while
	}

	private boolean ejecutarOperacion(Scanner consola) {
		var opc = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opc){
			case 1->{// listar estudiante
				logger.info(ln + "Litado de estudiante: "+ ln);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiante();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + ln)));
			}// case 1

			case 2 ->{ //buscar por id
				logger.info("Introducir id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Estudiante encontrado" + estudiante +  ln);
				}
				else {
					logger.info("Estudiante no encontrado con " + idEstudiante);
				}

			} //Fin case 2

			case 3 ->{//Agregar estudiante
				logger.info("Agregar Estudiante: " + ln);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//crear el objeto estudiante sin el ID
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante guardado " + estudiante + ln);
			}// fin caso 3

			case 4->{// modificar
				logger.info("Modificar Estudiante..." + ln);
				logger.info("Id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//buscamos al estudiante a buscar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado..");
				}else {
					logger.info("Estudiante NO encontado con el id " + idEstudiante + ln);
				}
			}// fin caso 4

			case 5 ->{//eliminar estudiante
				logger.info("Eliminar estudiante " + ln);
				logger.info("Id del estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos  id a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiantes eliminado correctamente..");

				}else{
					logger.info("Id Estudiante no registrado" + idEstudiante);
				}

			}// fin caso 5

			case 6 ->{//salir
				logger.info("hasta pronto... "+ ln + ln);
				salir = true;
			}// fin caso 6

			default ->{
				logger.info("Valor erroneo...");
			}
		}// fin swich
	return salir;
    }

	private void mostrarMenu() {
		logger.info(ln);
		logger.info("""
				*** Sistema Estudiantes ***
				1. Listar Estudiante 
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. salir
				Elige una opcion: """);
	}
}
