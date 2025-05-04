package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Points2DJson {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /** Guarda un Points2D en JSON */
    public static void savePoint(Points2D p, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(p, w);
        }
    }

    /** Carga un Points2D desde JSON */
    public static Points2D loadPoint(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            return gson.fromJson(r, Points2D.class);
        }
    }

    /** Guarda una lista de Points2D en JSON */
    public static void savePointList(List<Points2D> list, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(list, w);
        }
    }

    /** Carga una lista de Points2D desde JSON */
    public static List<Points2D> loadPointList(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Points2D>>() {}.getType();
            return gson.fromJson(r, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un punto
            Points2D p1 = new Points2D(2.5f, 7.5f);
            String file1 = "point2d.json";
            savePoint(p1, file1);
            System.out.println("Points2D guardado en " + file1);

            Points2D loadedP1 = loadPoint(file1);
            System.out.println("Points2D cargado: " + loadedP1);

            // Varios puntos
            List<Points2D> points = new ArrayList<>();
            points.add(p1);
            points.add(new Points2D(0.0f, 0.0f));
            points.add(new Points2D(-3.2f, 4.8f));

            String fileList = "points2d.json";
            savePointList(points, fileList);
            System.out.println("Lista de Points2D guardada en " + fileList);

            List<Points2D> loadedPoints = loadPointList(fileList);
            System.out.println("Lista cargada:");
            for (Points2D p : loadedPoints) {
                System.out.printf("  %s%n", p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
