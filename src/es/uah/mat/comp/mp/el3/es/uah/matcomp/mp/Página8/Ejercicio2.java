package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página8;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 2:
 * Usa comandos desde la línea de comandos para:
 * - "init": crear un fichero con un alumno por defecto.
 * - "show": leer y mostrar ese alumno desde el fichero.
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Ejercicio2 <operacion> <fichero>");
            return;
        }

        String operacion = args[0];
        String rutaArchivo = args[1];
        Gson gson = new Gson();

        if ("init".equalsIgnoreCase(operacion)) {
            Alumno alumno = new Alumno("Juan Pérez", 20, "Informática", 7.5, true);
            try (FileWriter writer = new FileWriter(rutaArchivo)) {
                gson.toJson(alumno, writer);
                System.out.println("Fichero creado con valores por defecto.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("show".equalsIgnoreCase(operacion)) {
            try (FileReader reader = new FileReader(rutaArchivo)) {
                Alumno alumno = gson.fromJson(reader, Alumno.class);
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Carrera: " + alumno.getCarrera());
                System.out.println("Nota media: " + alumno.getNotaMedia());
                System.out.println("¿Está matriculado?: " + (alumno.isMatriculado() ? "Sí" : "No"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Operación no reconocida.");
        }
    }

    // Clase Alumno reutilizada y mejorada
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


