package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página8;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {
        String rutaArchivo = "alumno.json"; // Ruta del fichero JSON

        if (!validarExistenciaArchivo(rutaArchivo)) return;

        // Llama al método que utiliza Gson para leer el archivo JSON y deserializarlo
        Alumno alumno = leerAlumnoDesdeArchivo(rutaArchivo);

        // Si se ha leído correctamente, muestra los datos
        if (alumno != null) {
            mostrarAlumno(alumno);
        } else {
            System.out.println("Hubo un problema al leer los datos del archivo.");
        }
    }
    // Valida si el archivo existe antes de continuar.

    public static boolean validarExistenciaArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo especificado no existe: " + rutaArchivo);
            return false;
        }
        return true;
    }
    //Método para leer los datos de un Alumno desde un archivo JSON usando Gson./

    public static Alumno leerAlumnoDesdeArchivo(String rutaArchivo) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, Alumno.class);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.err.println("Error en la sintaxis del JSON: " + e.getMessage());
        }
        return null;
    }

    // Método para mostrar los datos de un Alumno.

    public static void mostrarAlumno(Alumno alumno) {
        System.out.println(alumno); // Usará el método toString
    }

    // Clase Alumno mejorada con Getter, Setter y toString().

    public static class Alumno {
        private String nombre;
        private int edad;
        private String carrera;
        private double notaMedia;
        private boolean matriculado;

        // Constructor vacío necesario para deserialización con Gson
        public Alumno() {}

        // Constructor para inicializar valores
        public Alumno(String nombre, int edad, String carrera, double notaMedia, boolean matriculado) {
            this.nombre = nombre;
            this.edad = edad;
            this.carrera = carrera;
            this.notaMedia = notaMedia;
            this.matriculado = matriculado;
        }

        // Getters y Setters para todos los atributos
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        public double getNotaMedia() {
            return notaMedia;
        }

        public void setNotaMedia(double notaMedia) {
            this.notaMedia = notaMedia;
        }

        public boolean isMatriculado() {
            return matriculado;
        }

        public void setMatriculado(boolean matriculado) {
            this.matriculado = matriculado;
        }

        @Override
        public String toString() {
            return "Alumno{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", carrera='" + carrera + '\'' +
                    ", notaMedia=" + notaMedia +
                    ", matriculado=" + (matriculado ? "Sí" : "No") +
                    '}';
        }
    }
}




