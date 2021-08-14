package ru.stqa.pft.sandbox;

public class MyFirstProgramm {

    public static void main(String[] args) {
        hello("Hello Java!");
        hello("Hello User!");
        hello("Hello Rus!");

        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонома " + a + " и " + b + " = " + area(a, b));
    }

    public static void hello(String somebody) {
        System.out.println(somebody);
    }

    public static double area(double l) {
        return l * l;
    }
    // Перегрузка функции по кол-ву параметров
    public static double area(double a, double b) {
        return a * b;
    }
}