package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("Hello Java!");
        hello("Hello User!");
        hello("Hello Rus!");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонома " + r.a + " и " + r.b + " = " + s.area());
    }

    public static void hello(String somebody) {
        System.out.println(somebody);
    }
}