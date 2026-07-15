package org.example.modelo;

public abstract class PersonaUT {
    private String nombre;
    private String curp;

    public PersonaUT(String nombre, String curp) {
        this.nombre = nombre;
        this.curp = curp;
    }

    // Método abstracto: no lleva llaves {}, sólo define la estructura obligatoria
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
        // Llama dinámicamente a mostrarTipoPersona() gracias al polimorfismo
        return " Tipo: " + mostrarTipoPersona() + ", nombre = " + nombre + ", curp = " + curp;
    }
}