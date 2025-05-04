package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyPointJson {

    private static final Gson gson = new Gson();

    /** Guarda un MyPoint en JSON */
    public static void savePoint(MyPoint p, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(p, w);
        }
    }

    /** Carga un MyPoint desde JSON */
    public static MyPoint loadPoint(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            return gson.fromJson(r, MyPoint.class);
        }
    }

    /** Guarda una lista de MyPoint en JSON */
    public static void savePointList(List<MyPoint> list, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(list, w);
        }
    }

    /** Carga una lista de MyPoint desde JSON */
    public static List<MyPoint> loadPointList(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<MyPoint>>() {}.getType();
            return gson.fromJson(r, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un punto
            MyPoint p1 = new MyPoint(3, 4);
            String file1 = "point.json";
            savePoint(p1, file1);
            System.out.println("MyPoint guardado en " + file1);

            MyPoint loadedP1 = loadPoint(file1);
            System.out.println("MyPoint cargado: " + loadedP1 + " → distancia al origen=" + loadedP1.distance());

            // Varios puntos
            List<MyPoint> points = new ArrayList<>();
            points.add(p1);
            points.add(new MyPoint(10, 20));
            points.add(new MyPoint(-5, 7));

            String fileList = "points.json";
            savePointList(points, fileList);
            System.out.println("Lista de MyPoint guardada en " + fileList);

            List<MyPoint> loadedPoints = loadPointList(fileList);
            System.out.println("Lista cargada:");
            for (MyPoint p : loadedPoints) {
                System.out.printf("  %s → distancia a (5,5)=%.2f%n",
                        p, p.distance(5, 5));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
