package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDao {

    public boolean inscribirProfesor(Profesor profesor) {
        boolean inscrito = false;
        String sql = "INSERT INTO MAESTRO (id_maest, nombre, curp, puesto, sueldo) VALUES (?,?,?,?,?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, profesor.getId_prof());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getCurp());
            stm.setString(4, profesor.getPuesto());
            stm.setDouble(5, profesor.getSueldo());

            int registrosAfectados = stm.executeUpdate();
            if (registrosAfectados > 0) {
                inscrito = true;
                System.out.println("Profesor registrado correctamente.");
            }
        } catch (SQLException err) {
            System.out.println("Error al inscribir profesor: " + err.getMessage());
        }
        return inscrito;
    }

    public ArrayList<Profesor> extraerProfesor() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM MAESTRO";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Profesor prof = new Profesor();
                prof.setId_prof(rs.getInt("id_maest"));
                prof.setNombre(rs.getString("nombre"));
                prof.setCurp(rs.getString("curp"));
                prof.setPuesto(rs.getString("puesto"));
                prof.setSueldo(rs.getDouble("sueldo"));
                profesores.add(prof);
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer profesores: " + err.getMessage());
        }
        return profesores;
    }

    public boolean actualizar(Profesor profesor) {
        boolean actualizado = false;
        String sql = "UPDATE MAESTRO SET nombre = ?, curp = ?, puesto = ?, sueldo = ? WHERE id_maest = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setString(1, profesor.getNombre());
            stm.setString(2, profesor.getCurp());
            stm.setString(3, profesor.getPuesto());
            stm.setDouble(4, profesor.getSueldo());
            stm.setInt(5, profesor.getId_prof());

            int registrosAfectados = stm.executeUpdate();
            if (registrosAfectados > 0) {
                actualizado = true;
                System.out.println("Profesor actualizado correctamente.");
            } else {
                System.out.println("ID de profesor no encontrado.");
            }
        } catch (SQLException err) {
            System.out.println("Error al actualizar profesor: " + err.getMessage());
        }
        return actualizado;
    }

    public boolean eliminarProfesor(int idProf) {
        boolean eliminado = false;
        String sql = "DELETE FROM MAESTRO WHERE id_maest = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, idProf);
            int registrosAfectados = stm.executeUpdate();
            if (registrosAfectados > 0) {
                eliminado = true;
                System.out.println("Profesor dado de baja correctamente.");
            } else {
                System.out.println("No se encontró ningún profesor con ese ID.");
            }
        } catch (SQLException err) {
            System.out.println("Error al eliminar profesor: " + err.getMessage());
        }
        return eliminado;
    }
}