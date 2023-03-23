package Formas;

public class Retangulo implements Formas{
    double altura;
    double base;

    public  Retangulo(double altura, double base){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }
}
