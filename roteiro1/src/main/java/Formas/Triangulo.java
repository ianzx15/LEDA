package Formas;

public class Triangulo implements  Formas{

    double base;
    double altura;

    public  Triangulo(double altura, double base){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return (this.altura * this.base ) / 2;
    }
}
