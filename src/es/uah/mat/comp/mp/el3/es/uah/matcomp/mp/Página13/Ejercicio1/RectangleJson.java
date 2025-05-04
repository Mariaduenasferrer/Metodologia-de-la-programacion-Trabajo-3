package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RectangleJson {

    private static final Gson gson = new Gson();

    /** Guarda una sola instancia de Rectangle en un fichero JSON */
    public static void saveRectangle(Rectangle r, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(r, writer);
        }
    }

    /** Carga una sola instancia de Rectangle desde un fichero JSON */
    public static Rectangle loadRectangle(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Rectangle.class);
        }
    }

    /** Guarda una lista de Rectangle en un fichero JSON */
    public static void saveRectangleList(List<Rectangle> list, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(list, writer);
        }
    }

    /** Carga una lista de Rectangle desde un fichero JSON */
    public static List<Rectangle> loadRectangleList(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Rectangle>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un rectángulo
            Rectangle r1 = new Rectangle(4.5f, 2.0f);
            String file1 = "rectangle.json";
            saveRectangle(r1, file1);
            System.out.println("Guardado en " + file1);

            Rectangle r1Loaded = loadRectangle(file1);
            System.out.println("Cargado: " + r1Loaded + ", perímetro=" + r1Loaded.getPerimeter());

            // Varios rectángulos
            List<Rectangle> lista = new ArrayList<>();
            lista.add(new Rectangle(1.0f, 2.0f));
            lista.add(new Rectangle(3.0f, 4.0f));
            lista.add(new Rectangle(5.5f, 6.5f));

            String fileList = "rectangles.json";
            saveRectangleList(lista, fileList);
            System.out.println("Lista guardada en " + fileList);

            List<Rectangle> loadedList = loadRectangleList(fileList);
            System.out.println("Lista cargada:");
            for (Rectangle r : loadedList) {
                System.out.println("  " + r + " → área=" + r.getArea());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
