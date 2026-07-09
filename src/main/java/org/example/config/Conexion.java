//    private static final String url = "jdbc:mysql://localhost:3306/UniversidadUT?useSSL=false&serverTimezone=UTC";
package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/UniversidadUT?useSSL=false&serverTimezone=UTC";
    private static final String  user = "root";
    private static final String  password = "";

    public static Connection conectar(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion realizada correctamente");
        }
        catch (SQLException err){
            System.out.println("Error al conectar la base de datos\n"+err);
            System.out.println("Error al conectar la base de datos\n"+err.getMessage());
        }
        return conexion;
    }
}
