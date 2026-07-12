package org.example.modelo;

public class Personal {
    private String nombre;
    private String curp;
    public Personal(String nombre, String curp) {
        this.nombre = nombre;
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return " , nombre = "+nombre+", curp = "+curp;
    }
}
/// Alumno 1. id_alumno = 0, nombre = osvaldo, curp = dasdasdas, grado = 2, promedio = 67