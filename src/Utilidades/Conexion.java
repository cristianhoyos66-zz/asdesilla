package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta clase permite realizar la conexión con la base de datos, 
 * y de esta forma realizar las diferentes operaciones de guardado, modificación, consulta y listado
 * @author Cristian A. Hoyos Jaramillo
 * @author Daniela Estrada Monsalve
 * @author Yeisson A. Ochoa Villa
 */
public class Conexion {

    public Conexion() {
    }

    public static Connection getConexionMysql() {

        Connection conectar = null;

        try {

            String url = "jdbc:mysql://localhost/asdesilla_db";
            String usuario = "root";
            String contraseña = "";
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url, usuario, contraseña);


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            return conectar;
        }

    }

    public static void main(String[] args) {
    }
}
