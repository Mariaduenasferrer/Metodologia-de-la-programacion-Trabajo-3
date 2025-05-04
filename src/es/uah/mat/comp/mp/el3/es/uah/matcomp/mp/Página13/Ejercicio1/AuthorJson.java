package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AuthorJson {

    private static final Gson gson = new Gson();

    /** Guarda un Author en JSON */
    public static void saveAuthor(Author a, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(a, writer);
        }
    }

    /** Carga un Author desde JSON */
    public static Author loadAuthor(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Author.class);
        }
    }

    /** Guarda una lista de Author en JSON */
    public static void saveAuthorList(List<Author> list, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(list, writer);
        }
    }

    /** Carga una lista de Author desde JSON */
    public static List<Author> loadAuthorList(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Author>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    public static void main(String[] args) {
        try {
            // Un autor
            Author a1 = new Author("George Orwell", "orwell@example.com");
            String file1 = "author.json";
            saveAuthor(a1, file1);
            System.out.println("Author guardado en " + file1);

            Author a1Loaded = loadAuthor(file1);
            System.out.println("Author cargado: " + a1Loaded);

            // Varios autores
            List<Author> authors = new ArrayList<>();
            authors.add(a1);
            authors.add(new Author("Aldous Huxley", "huxley@example.com"));

            String fileList = "authors.json";
            saveAuthorList(authors, fileList);
            System.out.println("Lista de authors guardada en " + fileList);

            List<Author> loadedAuthors = loadAuthorList(fileList);
            System.out.println("Lista cargada:");
            for (Author a : loadedAuthors) {
                System.out.printf("  %s → email: %s%n", a.getName(), a.getEmail());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
