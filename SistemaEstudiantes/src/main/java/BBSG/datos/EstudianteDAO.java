package BBSG.datos;

import BBSG.conexion.Conexion;
import BBSG.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static BBSG.conexion.Conexion.getConexion;

//DAO - Data Access Object
public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT *FROM estudiante ORDER BY id_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error... "+ e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e ){
                System.out.println("Has ocurrido un error..." + e.getMessage());
            }
        }
        return estudiantes;
    }

    public Boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT *FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return  true;
            }

        }catch (Exception e){
            System.out.println("has ocurrido un error" + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("ha ocurrido un error"+ e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email)" +
                "VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return  true;

        }catch (Exception e){
            System.out.println("has ocurrido un error.. " + e.getMessage());
        }
        finally {
            try {
                    con.close();
            }catch (Exception e){
                System.out.println("ha ocurrido un error " + e.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre =?, apellido =?, telefono =?, email =? " +  "WHERE id_estudiante = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return  true;
        }catch (Exception e){
            System.out.println("ha ocurrido un error" + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("ha ocurrido un error" + e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return  true;
        }catch (Exception e){
            System.out.println("Has ocurrido un erro"+ e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Has surgido un error " + e.getMessage());
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        var estudianteDAO = new EstudianteDAO();

        //Eliminar Estudiante(2)
        var estudianteEliminar = new Estudiante(2);
        var eliminado = estudianteDAO.eliminarEstudiante(estudianteEliminar);
        if(eliminado){
            System.out.println("Estudiante eliminado con exito..." + estudianteEliminar);
        }
        else{
            System.out.println("error al eliminar" + estudianteEliminar);
        }


        //modificar
//        var estudianteModificado = new Estudiante(3,"Juan Carlos","Penalo", "9494 -9999- 9900", "jcpenalo@gmail.com");
//        var modidicado = estudianteDAO.modificarEstudiante(estudianteModificado);
//        if(modidicado){
//            System.out.println("Estudiante modificado con exito..." + estudianteModificado);
//        }
//        else {
//            System.out.println("error al modificar el estudiante.. " + estudianteModificado);
//        }



        //agregar estudiante
//        var nuevoEstudiante =
//                new Estudiante("Carlos", "Lara", "555-0000", "Clara@gmail.com");
//        var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
//        if(agregado){
//            System.out.println("Estudiante agregado con exito.." + nuevoEstudiante);
//        }
//        else {
//            System.out.println("No se agrego el estudiante "+ nuevoEstudiante);
//        }


        //Listar los estudiantes
       System.out.println("*** Listado de Estudiantes ***");
        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
       estudiantes.forEach(System.out::println);

        //Buscar por Id
//        var estudiante1 = new Estudiante(3);
//        System.out.println("Estudiante ante de la busqueda" + estudiante1);
//        var encotrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
//
//        if(encotrado){
//            System.out.println("Estudiante Encontrado " + estudiante1);
//        }
//        else {
//            System.out.println("No se ha encontrado estudiante " +
//                    estudiante1.getIdEstudiante());
//        }
    }

}
