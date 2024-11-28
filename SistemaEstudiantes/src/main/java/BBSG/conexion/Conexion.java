package BBSG.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public  static Connection getConexion(){
      Connection conexion = null;
      var baseDatos = "estudiantes_db";
      var url = "jdbc:mysql://localhost:3306/" + baseDatos;
      var usuario = "root";
      var password = "";
      //Cargamos la clase del driver de mysql a memoria
      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
      }catch (ClassNotFoundException | SQLException e){
          System.out.println("Ocurrio un error" + e.getMessage());
      }
      return  conexion;

    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion != null){
            System.out.println("Conexion exitosa" + conexion);
        }
        else {
            System.out.println("Error durante la conexion");
        }
    }

}
