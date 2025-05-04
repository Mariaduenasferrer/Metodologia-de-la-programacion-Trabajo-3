package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

public class Dog extends Animal2 {
    public Dog(String name) {
        super(name);

    }
    @Override
    public void greets() {
        System.out.println("Woof");

    }

    public void greets(Dog another){
        System.out.println("Wooooof");


    }

}
