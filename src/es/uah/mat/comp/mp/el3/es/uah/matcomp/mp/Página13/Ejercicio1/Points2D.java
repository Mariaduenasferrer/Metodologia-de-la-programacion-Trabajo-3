package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

public class Points2D {

    // Clase interna Point2D

    // Variables
    private float x;
    private float y;

    // Constructores
    public Points2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Points2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getter
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float[] getXY() {
        return new float[] { x, y };
    }

    // Setter
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    // Procedimiento
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

