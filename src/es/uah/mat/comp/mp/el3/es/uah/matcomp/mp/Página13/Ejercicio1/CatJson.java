package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CatJson {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /** Guarda un Cat en JSON */
    public static void saveCat(Cat c, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(c, w);
        }
    }

    /** Carga un Cat desde JSON */
    public static Cat loadCat(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            return gson.fromJson(r, Cat.class);
        }
    }

    /** Guarda una lista de Cat en JSON */
    public static void saveCatList(List<Cat> list, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(list, w);
        }
    }

    /** Carga una lista de Cat desde JSON */
    public static List<Cat> loadCatList(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Cat>>() {}.getType();
            return gson.fromJson(r, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un gato
            Cat kitty = new Cat("Whiskers");
            String singleFile = "cat.json";
            saveCat(kitty, singleFile);
            System.out.println("Cat guardado en " + singleFile);

            Cat loadedKitty = loadCat(singleFile);
            System.out.println("Cat cargado: " + loadedKitty);
            loadedKitty.greets();

            // Varios gatos
            List<Cat> clowder = new ArrayList<>();
            clowder.add(kitty);
            clowder.add(new Cat("Felix"));

            String listFile = "cats.json";
            saveCatList(clowder, listFile);
            System.out.println("Lista de Cats guardada en " + listFile);

            List<Cat> loadedClowder = loadCatList(listFile);
            System.out.println("Lista cargada:");
            for (Cat c : loadedClowder) {
                System.out.printf("  %s saluda: ", c);
                c.greets();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}