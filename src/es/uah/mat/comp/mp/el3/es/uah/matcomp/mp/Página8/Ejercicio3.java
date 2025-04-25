package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página8;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 3:
 * Crea y guarda un conjunto de alumnos con todos los atributos.
 * Luego los carga y muestra por pantalla.
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        String rutaArchivo = "alumnos.json";
        Gson gson = new Gson();

        Alumno[] alumnos = {
                new Alumno("Ana López", 22, "Matemáticas", 9.2, true),
                new Alumno("Carlos Pérez", 24, "Física", 7.8, false),
                new Alumno("María García", 21, "Química", 8.4, true)
        };

        // Guardar los alumnos
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(alumnos, writer);
            System.out.println("Fichero creado con datos iniciales.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer los alumnos y mostrarlos
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Alumno[] alumnosCargados = gson.fromJson(reader, Alumno[].class);
            System.out.println("Datos cargados del fichero:");
            for (Alumno alumno : alumnosCargados) {
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Carrera: " + alumno.getCarrera());
                System.out.println("Nota media: " + alumno.getNotaMedia());
                System.out.println("¿Está matriculado?: " + (alumno.isMatriculado() ? "Sí" : "No"));
                System.out.println("-----------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase Alumno igual a la de los otros ejercicios
    public static class Alumno {
        private String nombre;
        private int edad;
        private String carrera;
        private double notaMedia;
        private boolean matriculado;

        public Alumno() {}

        public Alumno(String nombre, int edad, String carrera, double notaMedia, boolean matriculado) {
            this.nombre = nombre;
            this.edad = edad;
            this.carrera = carrera;
            this.notaMedia = notaMedia;
            this.matriculado = matriculado;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public int getEdad() { return edad; }
        public void setEdad(int edad) { this.edad = edad; }

        public String getCarrera() { return carrera; }
        public void setCarrera(String carrera) { this.carrera = carrera; }

        public double getNotaMedia() { return notaMedia; }
        public void setNotaMedia(double notaMedia) { this.notaMedia = notaMedia; }

        public boolean isMatriculado() { return matriculado; }
        public void setMatriculado(boolean matriculado) { this.matriculado = matriculado; }
    }
}


