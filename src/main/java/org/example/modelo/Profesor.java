package org.example.modelo;

public class Profesor extends Personal {
    private int id_prof;
    private String puesto;
    private double sueldo;

    public Profesor(String nombre, String curp, int id_prof, String puesto, double sueldo) {
        super(nombre, curp);
        setId_prof(id_prof);    
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id_prof=" + id_prof +
                ", puesto='" + puesto + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
