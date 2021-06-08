package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Grupo2
 */
public class Conexion {

    private static String url = "jdbc:mysql://localhost/vacunar";
    private static String usuario = "root";
    private static String password = "";
    private static Connection connection;

    private Conexion() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
    }

    private Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        Class.forName("org.mariadb.jdbc.Driver");
    }

    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, password);
        }
        return connection;
    }

}
