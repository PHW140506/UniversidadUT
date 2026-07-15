package org.example.modelo;

import org.example.interfaces.Ensenador;
import org.example.interfaces.Evaluador;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {
    private int id_prof;
    private String puesto;
    private double sueldo;

    public Profesor() {
        super("", "");
    }

    public Profesor(String nombre, String curp, int id_prof, String puesto, double sueldo) {
        super(nombre, curp);
        setId_prof(id_prof);
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    @Override
    public String mostrarTipoPersona() {
        return "Profesor";
    }

    @Override
    public void ensenar() {
        System.out.println("El profesor " + getNombre() + " está dictando cátedra.");
    }

    @Override
    public void evaluar() {
        System.out.println("El profesor " + getNombre() + " está evaluando los proyectos.");
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        if (id_prof > 0) {
            this.id_prof = id_prof;
        } else {
            System.out.println("El ID del profesor debe ser un número positivo.");
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            System.out.println("El puesto no puede estar vacío.");
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo >= 0) {
            this.sueldo = sueldo;
        } else {
            System.out.println("El sueldo no puede ser negativo.");
        }
    }

    @Override
    public String toString() {
        return "Profesor = id_prof = " + getId_prof() + super.toString() + ", puesto = " + puesto + ", sueldo = " + sueldo;
    }
}