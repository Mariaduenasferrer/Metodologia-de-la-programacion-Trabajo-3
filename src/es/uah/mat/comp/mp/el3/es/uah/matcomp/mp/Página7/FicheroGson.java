package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FicheroGson {

    // Método genérico para guardar un objeto en un archivo JSON
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
            System.out.println("Datos guardados en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método genérico para cargar un objeto desde un archivo JSON
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Ana López", 20, "A001");
        Estudiante estudiante2 = new Estudiante("Carlos Pérez", 22, "A002");

        // Crear lista de estudiantes y asignatura
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add(estudiante1);
        listaEstudiantes.add(estudiante2);

        Asignatura asignatura = new Asignatura("Matemáticas", listaEstudiantes);

        // Ruta del archivo JSON
        String rutaArchivo = "asignatura.json";

        // Guardar asignatura en el archivo JSON
        guardarObjetoEnArchivo(rutaArchivo, asignatura);

        // Cargar asignatura desde el archivo JSON
        Asignatura asignaturaCargada = cargarObjetoDesdeArchivo(rutaArchivo, Asignatura.class);
        if (asignaturaCargada != null) {
            System.out.println("Asignatura cargada desde el archivo:");
            System.out.println(asignaturaCargada);
        }
    }

    // Clase Estudiante
    static class Estudiante {
        private String nombre;
        private int edad;
        private String matricula;

        public Estudiante(String nombre, int edad, String matricula) {
            this.nombre = nombre;
            this.edad = edad;
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return "Estudiante{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", matricula='" + matricula + '\'' +
                    '}';
        }
    }

    // Clase Asignatura
    static class Asignatura {
        private String nombre;
        private List<Estudiante> estudiantes;

        public Asignatura(String nombre, List<Estudiante> estudiantes) {
            this.nombre = nombre;
            this.estudiantes = estudiantes;
        }

        @Override
        public String toString() {
            return "Asignatura{" +
                    "nombre='" + nombre + '\'' +
                    ", estudiantes=" + estudiantes +
                    '}';
        }
    }
}

