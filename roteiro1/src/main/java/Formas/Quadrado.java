package Formas;

public class Quadrado implements Formas{

    double lado;

    public  Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double area() {
        return this.lado * this.lado;
    }
}
