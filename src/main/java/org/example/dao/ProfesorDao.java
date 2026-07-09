package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProfesorDao {

    public boolean inscribirProfesor(Profesor profesor) {
        boolean inscrito = false;

        String sql = "INSERT INTO maestro VALUES (?,?,?,?,?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);) {

            stm.setInt(1, profesor.getId_prof());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getCurp());
            stm.setString(4, profesor.getPuesto());
            stm.setDouble(5, profesor.getSueldo());

            int registrosAfectados = stm.executeUpdate();

            if (registrosAfectados > 0) {
                inscrito = true;
                System.out.println("Registro realizado Correctamente");
            }

        } catch (SQLException err) {
            System.out.println("Error " + err.getMessage());
        }

        return inscrito;
    }


}