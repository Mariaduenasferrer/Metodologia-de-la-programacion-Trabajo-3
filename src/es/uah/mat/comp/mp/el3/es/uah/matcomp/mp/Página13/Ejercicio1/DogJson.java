package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DogJson {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /** Guarda un Dog en JSON */
    public static void saveDog(Dog d, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(d, w);
        }
    }

    /** Carga un Dog desde JSON */
    public static Dog loadDog(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            return gson.fromJson(r, Dog.class);
        }
    }

    /** Guarda una lista de Dog en JSON */
    public static void saveDogList(List<Dog> list, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(list, w);
        }
    }

    /** Carga una lista de Dog desde JSON */
    public static List<Dog> loadDogList(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Dog>>() {}.getType();
            return gson.fromJson(r, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un perro
            Dog buddy = new Dog("Buddy");
            String singleFile = "dog.json";
            saveDog(buddy, singleFile);
            System.out.println("Dog guardado en " + singleFile);

            Dog loadedBuddy = loadDog(singleFile);
            System.out.println("Dog cargado: " + loadedBuddy);
            loadedBuddy.greets();

            // Varios perros
            List<Dog> pack = new ArrayList<>();
            pack.add(buddy);
            pack.add(new Dog("Rex"));

            String listFile = "dogs.json";
            saveDogList(pack, listFile);
            System.out.println("Lista de Dogs guardada en " + listFile);

            List<Dog> loadedPack = loadDogList(listFile);
            System.out.println("Lista cargada:");
            for (Dog d : loadedPack) {
                System.out.printf("  %s saluda: ", d.toString());
                d.greets();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
