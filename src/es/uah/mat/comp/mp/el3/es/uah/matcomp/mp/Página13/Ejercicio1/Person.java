package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

public class Person {

    // Variables
    private String name;
    private String address;

    // Constructores
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setter
    public void setAddress(String address) {
        this.address = address;
    }

    // Procedimiento
    @Override
    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }
}
