package org.example.vista;

import org.example.dao.AlumnoDao;
import org.example.modelo.Alumno;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDao alumnoDao = new AlumnoDao();
    static Alumno alumno = new Alumno();

    public static void inscribirAlumno()throws IOException{
        System.out.println("Escribe un NUMERO DE EXPEDIENTE: ");
        alumno.setId_alumno(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el NOMBRE DEL ALUMNO: ");
        alumno.setNombre(leer.readLine());
        System.out.println("Escribe la CURP DEL ALUMNO");
        alumno.setCurp(leer.readLine());
        System.out.println("Escribe el GRADO DEL ALUMNO");
        alumno.setGrado(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el PROMEDIO ACTUAL");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));
        alumnoDao.inscribirAlumno(alumno);
    }
    public static void mostrarDatos(){
        ArrayList<Alumno> alumnos = alumnoDao.extraerAlumno();
        System.out.println("========== LISTA DE ALUMNOS ==========");
        for (Alumno alumno:alumnos ){
            System.out.println(alumno);
        }
    }
    public static void actualizarDatos()throws IOException{
        System.out.println("Escribe un NUMERO DE EXPEDIENTE: ");
        alumno.setId_alumno(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el NOMBRE DEL ALUMNO: ");
        alumno.setNombre(leer.readLine());
        System.out.println("Escribe la CURP DEL ALUMNO");
        alumno.setCurp(leer.readLine());
        System.out.println("Escribe el GRADO DEL ALUMNO");
        alumno.setGrado(Integer.parseInt(leer.readLine()));
        System.out.println("Escribe el PROMEDIO ACTUAL");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));
        alumnoDao.actualizar(alumno);
    }
    public static void darBajaAlum(){}
    public static void buscarAlum(){}

    public static void menu()throws IOException {
        int op_u = 0;
        while (op_u != 6){
            System.out.println("1. Inscribir alumno a la base de datos");
            System.out.println("2. Visualizar datos de los alumno");
            System.out.println("3. Actualizar datos del alumno");
            System.out.println("4. Dar de baja a un alumno");
            System.out.println("5. Buscar alumno");
            System.out.println("6. Salir del programa");
            System.out.println("Elige una opcion usuario");
            op_u = Integer.parseInt(leer.readLine());
            switch(op_u){
                case 1: inscribirAlumno();break;
                case 2: mostrarDatos(
                );break;
                case 3: actualizarDatos();break;
                case 4: darBajaAlum(); break;
                case 5: buscarAlum(); break;
                case 6:
                    System.out.println("Haz salido de la aplicacion");
                    break;
                default:
                    System.out.print("Tienes que escoger una opcion del 1 al 6");
            }
        }
        System.out.println();
    }
}
