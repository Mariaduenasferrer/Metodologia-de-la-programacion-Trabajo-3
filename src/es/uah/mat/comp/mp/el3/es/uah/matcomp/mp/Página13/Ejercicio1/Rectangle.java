package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

public class Rectangle {
    private float length;
    private float width;


    public Rectangle() {
        length = 1.0f;
        width = 1.0f;
    }

    public Rectangle(float l, float w) {
        length = l;
        width = w;
    }

    public float getLength() {

        return length;
    }

    public void setLength(float newLength) {

        length = newLength;
    }

    public float getWidth() {

        return width;
    }

    public void setWidth(float newWidth) {

        width = newWidth;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);

    }

    public String toString() {
        return "Rectangle[length=" + this.getLength() + ", width=" + this.getWidth() + "]";
    }
}