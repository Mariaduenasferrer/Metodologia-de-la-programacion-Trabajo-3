package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CircleJson {

    private static final Gson gson = new Gson();

    /** Guarda una sola instancia de Circle en un fichero JSON */
    public static void saveCircle(Circle c, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(c, writer);
        }
    }

    /** Carga una sola instancia de Circle desde un fichero JSON */
    public static Circle loadCircle(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Circle.class);
        }
    }

    /** Guarda una lista de Circle en un fichero JSON */
    public static void saveCircleList(List<Circle> list, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(list, writer);
        }
    }

    /** Carga una lista de Circle desde un fichero JSON */
    public static List<Circle> loadCircleList(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Circle>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un círculo
            Circle c1 = new Circle(2.5);
            String file1 = "circle.json";
            saveCircle(c1, file1);
            System.out.println("Guardado en " + file1);

            Circle c1Loaded = loadCircle(file1);
            System.out.println("Cargado: " + c1Loaded + ", área=" + c1Loaded.getArea());

            // Varios círculos
            List<Circle> lista = new ArrayList<>();
            lista.add(new Circle(1.0));
            lista.add(new Circle(3.14));
            lista.add(new Circle(5.0));

            String fileList = "circles.json";
            saveCircleList(lista, fileList);
            System.out.println("Lista guardada en " + fileList);

            List<Circle> loadedList = loadCircleList(fileList);
            System.out.println("Lista cargada:");
            for (Circle c : loadedList) {
                System.out.println("  " + c + " → circunferencia=" + c.getCircumference());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}