package org.example.vista;

import org.example.dao.AlumnoDao;
import org.example.dao.ProfesorDao;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDao alumnoDao = new AlumnoDao();
    static ProfesorDao profesorDao = new ProfesorDao();
    static Alumno alumno = new Alumno();

    // ================= FUNCIONES PARA ALUMNOS =================
    public static void inscribirAlumno() throws IOException {
        System.out.println("Escribe un NUMERO DE EXPEDIENTE: ");
        alumno.setId_alumno(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el NOMBRE DEL ALUMNO: ");
        alumno.setNombre(leer.readLine());
        System.out.println("Escribe la CURP DEL ALUMNO:");
        alumno.setCurp(leer.readLine());
        System.out.println("Escribe el GRADO DEL ALUMNO:");
        alumno.setGrado(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el PROMEDIO ACTUAL:");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));
        alumnoDao.inscribirAlumno(alumno);
    }

    public static void mostrarDatosAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDao.extraerAlumno();
        System.out.println("\n========== LISTA DE ALUMNOS ==========");
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }

    public static void actualizarDatosAlumno() throws IOException {
        System.out.println("ACTUALIZAR DATOS DEL ALUMNO");
        System.out.println("1. Escribe el NUMERO DE EXPEDIENTE A ACTUALIZAR: ");
        alumno.setId_alumno(Integer.parseInt(leer.readLine()));
        System.out.println("2. Escribe el NOMBRE NUEVO DEL ALUMNO: ");
        alumno.setNombre(leer.readLine());
        System.out.println("3. Escribe la CURP NUEVA DEL ALUMNO:");
        alumno.setCurp(leer.readLine());
        System.out.println("4. Escribe el GRADO NUEVO DEL ALUMNO:");
        alumno.setGrado(Integer.parseInt(leer.readLine()));
        System.out.println("5. Escribe el PROMEDIO NUEVO:");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDao.actualizar(alumno);
    }

    public static void darBajaAlum() throws IOException {
        System.out.println("Escribe el NUMERO DE EXPEDIENTE del alumno a dar de baja: ");
        int id = Integer.parseInt(leer.readLine());
        alumnoDao.eliminarAlumno(id);
    }
    public static void buscarAlum() throws IOException {
        System.out.println("Escribe el NUMERO DE EXPEDIENTE del alumno a buscar: ");
        int id = Integer.parseInt(leer.readLine());
        Alumno a = alumnoDao.buscarAlumno(id);
        if (a != null) {
            System.out.println("\nAlumno encontrado\n" + a);
        } else {
            System.out.println("No se encontró el alumno.");
        }
    }

    // ================= FUNCIONES PARA PROFESORES =================
    public static void inscribirProfesor() throws IOException {
        Profesor profesor = new Profesor();
        System.out.println("Escribe el NUMERO DE EXPEDIENTE DEL PROFESOR: ");
        profesor.setId_prof(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el NOMBRE DEL PROFESOR: ");
        profesor.setNombre(leer.readLine());
        System.out.println("Escribe la CURP DEL PROFESOR:");
        profesor.setCurp(leer.readLine());
        System.out.println("Escribe el PUESTO:");
        profesor.setPuesto(leer.readLine());
        System.out.println("Escribe el SUELDO:");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDao.inscribirProfesor(profesor);
    }

    public static void mostrarDatosProfesores() {
        ArrayList<Profesor> profesores = profesorDao.extraerProfesor();
        System.out.println("\n========== F       DE PROFESORES ==========");
        for (Profesor p : profesores) {
            System.out.println(p);
        }
    }

    public static void actualizarDatosProfesor() throws IOException {
        Profesor profesor = new Profesor();
        System.out.println("ACTUALIZAR DATOS DEL PROFESOR");
        System.out.println("1. Escribe el ID DEL PROFESOR A MODIFICAR: ");
        profesor.setId_prof(Integer.parseInt(leer.readLine()));
        System.out.println("2. Escribe el NOMBRE NUEVO: ");
        profesor.setNombre(leer.readLine());
        System.out.println("3. Escribe la CURP NUEVA:");
        profesor.setCurp(leer.readLine());
        System.out.println("4. Escribe el PUESTO NUEVO:");
        profesor.setPuesto(leer.readLine());
        System.out.println("5. Escribe el SUELDO NUEVO:");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDao.actualizar(profesor);
    }
    public static void buscarProfesor() throws IOException {
        System.out.println("Escribe el ID del profesor a buscar: ");
        int id = Integer.parseInt(leer.readLine());
        Profesor p = profesorDao.buscarProfesor(id);
        if (p != null) {
            System.out.println("\nProfesor encontrado: \n" + p);
        } else {
            System.out.println("No se encontró al profesor.");
        }
    }

    public static void darBajaProfesor() throws IOException {
        System.out.println("Escribe el ID del profesor a dar de baja: ");
        int id = Integer.parseInt(leer.readLine());
        profesorDao.eliminarProfesor(id);
    }

    // ================= MENÚ =================
    public static void menu() throws IOException {
        int op = 0;
        while (op != 3) {
            System.out.println("\n****** UNIVERSIDAD UTsjr ******");
            System.out.println("1. Funciones para Alumnos");
            System.out.println("2. Funciones para Profesores");
            System.out.println("3. Salir de la aplicación");
            System.out.print("Elige una opción: ");
            op = Integer.parseInt(leer.readLine());

            switch (op) {
                case 1: menuAlumnos(); break;
                case 2: menuProfesores(); break;
                case 3: System.out.println("Fin del programa. phw"); break;
                default: System.out.println("Tienes que escoger un numero del 1 al 3 usuario");
            }
        }
    }

    private static void menuAlumnos() throws IOException {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- FUNCIONES PARA ALUMNOS ---");
            System.out.println("1. Inscribir alumno");
            System.out.println("2. Visualizar alumnos");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Dar de baja alumno");
            System.out.println("5. Buscar a un alumno");
            System.out.println("6. Volver al menú anterior");
            System.out.print("Elige una opción: ");
            op = Integer.parseInt(leer.readLine());

            switch (op) {
                case 1: inscribirAlumno(); break;
                case 2: mostrarDatosAlumnos(); break;
                case 3: actualizarDatosAlumno(); break;
                case 4: darBajaAlum(); break;
                case 5: buscarAlum(); break;
            }
        }
    }

    private static void menuProfesores() throws IOException {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- FUNCIONES PARA PROFESORES ---");
            System.out.println("1. Registrar profesor");
            System.out.println("2. Visualizar profesores");
            System.out.println("3. Actualizar profesor");
            System.out.println("4. Dar de baja profesor");
            System.out.println("5. Buscar a un profesor");
            System.out.println("6. Volver al menú anterior");
            System.out.print("Elige una opción: ");
            op = Integer.parseInt(leer.readLine());

            switch (op) {
                case 1: inscribirProfesor(); break;
                case 2: mostrarDatosProfesores(); break;
                case 3: actualizarDatosProfesor(); break;
                case 4: darBajaProfesor(); break;
                case 5: buscarProfesor(); break;
            }
        }
    }
}