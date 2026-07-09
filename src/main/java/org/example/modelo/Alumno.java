package org.example.modelo;

public class Alumno extends Personal {
    private int id_alumno;
    private int grado; // Cambiado de String grupo a int grado
    private double promedio;

    public Alumno(){
        super("", "");
    }
    public Alumno(int id_alumno, String nombre, String curp, int grado, double promedio) {
        super(nombre, curp);
        setId_alumno(id_alumno);
        setGrado(grado);
        setPromedio(promedio);
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        if (id_alumno > 2000000000 && id_alumno < 2140000000) {
            this.id_alumno = id_alumno;
        } else {
            System.out.println("El numero de expediente es invalido");
        }
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        if (grado <= 0) {
            System.out.println("El grado debe ser un numero positivo");
        } else {
            this.grado = grado;
        }
    }

    public double getPromedio() {
        return this.promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) {
            this.promedio = promedio;
        } else {
            System.out.println("El promedio debe ser entre 0 y 10");
        }
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id_alumno=" + getId_alumno() +
                super.toString() +
                ", grado=" + getGrado() +
                ", promedio=" + getPromedio() +
                '}' +
                "------------------------------------------------"
                ;
    }
}