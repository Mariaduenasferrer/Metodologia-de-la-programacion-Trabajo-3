package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersonJson {

    private static final Gson gson = new Gson();

    /** Guarda un Person en JSON */
    public static void savePerson(Person p, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(p, w);
        }
    }

    /** Carga un Person desde JSON */
    public static Person loadPerson(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            return gson.fromJson(r, Person.class);
        }
    }

    /** Guarda una lista de Person en JSON */
    public static void savePersonList(List<Person> list, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            gson.toJson(list, w);
        }
    }

    /** Carga una lista de Person desde JSON */
    public static List<Person> loadPersonList(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
            return gson.fromJson(r, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Una persona
            Person p1 = new Person("Ana López", "Calle Mayor, 10");
            String file1 = "person.json";
            savePerson(p1, file1);
            System.out.println("Person guardado en " + file1);

            Person loadedP1 = loadPerson(file1);
            System.out.println("Person cargado: " + loadedP1);

            // Varias personas
            List<Person> people = new ArrayList<>();
            people.add(p1);
            people.add(new Person("Luis García", "Plaza Nueva, 5"));

            String fileList = "persons.json";
            savePersonList(people, fileList);
            System.out.println("Lista de Person guardada en " + fileList);

            List<Person> loadedPeople = loadPersonList(fileList);
            System.out.println("Lista cargada:");
            for (Person p : loadedPeople) {
                System.out.printf("  %s → dirección: %s%n", p.getName(), p.getAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}