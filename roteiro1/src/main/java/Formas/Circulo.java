package Formas;

public class Circulo implements Formas{
    double raio;
    public  Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * (this.raio * this.raio);
    }
}
