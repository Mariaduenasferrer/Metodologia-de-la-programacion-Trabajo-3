package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

public class Circle {
    private double radius;


    public Circle() { // 1st (default) constructor
        radius = 1.0;
    }

    public Circle(double r) { // 2nd constructor
        radius = r;
    }

    public double getRadius() {

        return radius;
    }
    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getCircumference() {

        return radius * 2 * Math.PI;
    }
    public String toString() {

        return "Circle[radius=" + this.getRadius() + "]";
    }
}
