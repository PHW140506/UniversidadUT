package org.example.dao;

import com.sun.source.tree.TryTree;
import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDao {
    public boolean inscribirAlumno(Alumno alumno) {
        boolean inscrito = false;
        // El orden de las columnas en tu SQL es: id_alum, nombre, curp, promedio, grado
        String sql = "INSERT INTO ALUMNOS (id_alum, nombre, curp, promedio, grado) VALUES(?,?,?,?,?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, alumno.getId_alumno());
            stm.setString(2, alumno.getNombre());
            stm.setString(3, alumno.getCurp());
            stm.setDouble(4, alumno.getPromedio());
            stm.setInt(5, alumno.getGrado()); // Ahora envía un int
            System.out.println(stm);
            int filasAfectadas = stm.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Alumno inscrito correctamente en la base de datos.");
                inscrito = true;
            }
        } catch (SQLException err) {
            System.out.println("Error al inscribir: " + err.getMessage());
        }
        return inscrito;
    }
    public ArrayList<Alumno> extraerAlumno(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        String sql = "SELECT * FROM ALUMNOS";
        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){
            ResultSet rs = stm.executeQuery();
            System.out.println(stm);
            System.out.println(rs);
            System.out.println();

            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alum"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setPromedio(rs.getDouble("promedio"));
                alumno.setGrado(rs.getInt("grado"));
                alumnos.add(alumno);

            }
        } catch (SQLException err){

            System.out.println("Error al extraer a los alumnos "+ err.getMessage());

        }
        return  alumnos;
    }
    public boolean actualizar(Alumno alumno) {
        boolean actualizado = false;
        String sql = "UPDATE ALUMNOS SET nombre = ?, curp = ?, promedio = ?, grado = ? WHERE id_alum = ? ";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);) {
            stm.setString(1, alumno.getNombre());
            stm.setString(2, alumno.getCurp());
            stm.setDouble(3, alumno.getPromedio());
            stm.setInt(4, alumno.getGrado());
            stm.setInt(5, alumno.getId_alumno());
            int registrosAfectados = stm.executeUpdate();
            System.out.println(sql);
            if (registrosAfectados > 0) {
                System.out.println("Alumno Actualizado Correctamente");
                actualizado = true;
            } else {
                System.out.println("Tu id de estudiante es erroneo");
            }
        } catch (SQLException err) {
            System.out.println("Error al actualizar Alumno " + err.getMessage());
        }
        return actualizado;
    }
}