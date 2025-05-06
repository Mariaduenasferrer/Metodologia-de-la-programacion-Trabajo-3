package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio4;

public class Estudiante {
    private String nombre;
    private int edad;
    private double notamedia;

    public Estudiante(String nombre, int edad, double notamedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notamedia = notamedia;
    }
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
    public double getNotamedia() {
        return notamedia;
    }
    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", notamedia='" + notamedia + '\'' +
                '}';
    }
}
