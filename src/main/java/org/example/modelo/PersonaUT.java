package org.example.modelo;

public abstract class PersonaUT {
    private String nombre;
    private String curp;

    public PersonaUT(String nombre, String curp) {
        this.nombre = nombre;
        this.curp = curp;
    }

    public abstract String mostrarTipoPersona();

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

        return " Tipo: " + mostrarTipoPersona() + ", nombre = " + nombre + ", curp = " + curp;
    }
}