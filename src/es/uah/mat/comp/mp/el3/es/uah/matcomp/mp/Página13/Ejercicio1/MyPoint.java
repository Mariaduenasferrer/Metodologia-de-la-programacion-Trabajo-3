package es.uah.mat.comp.mp.el3.es.uah.matcomp.mp.Página13.Ejercicio1;

public class MyPoint {
    private int x= 0;
    private int y= 0;

    public MyPoint(){
        this.x= 0;
        this.y= 0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+ this.getX() + ", " + this.getY() + ")";
    }

    public double distance(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
    }

    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    public double distance (){
        return distance(0, 0);
    }



}
