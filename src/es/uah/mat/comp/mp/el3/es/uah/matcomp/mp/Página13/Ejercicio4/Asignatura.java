package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio4;

import java.util.List;

public class Asignatura {
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
