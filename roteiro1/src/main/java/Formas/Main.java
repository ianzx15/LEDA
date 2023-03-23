package Formas;

public class Main {

    public static void main(String[] args) {
        Formas circulo = new Circulo(10);
        Formas quadrado = new Quadrado(10);
        Formas retangulo = new Retangulo(10,2);
        Formas triangulo = new Triangulo(10,2);


        System.out.println("Círculo: " + circulo.area());
        System.out.println("Quadrado: " + quadrado.area());
        System.out.println("Retângulo: " + retangulo.area());
        System.out.println("Triângulo: " + triangulo.area());


    }

}
