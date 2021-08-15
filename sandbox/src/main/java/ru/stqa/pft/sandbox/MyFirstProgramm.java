package ru.stqa.pft.sandbox;

public class MyFirstProgramm {

    public static void main(String[] args) {
        hello("Hello Java!");
        hello("Hello User!");
        hello("Hello Rus!");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонома " + r.a + " и " + r.b + " = " + area(r));
    }

    public static void hello(String somebody) {
        System.out.println(somebody);
    }

    public static double area(Square s) {
        return s.l * s.l;
    }

    // Перегрузка функции по кол-ву параметров
    public static double area(Rectangle r) {
        return r.a * r.b;
    }
}