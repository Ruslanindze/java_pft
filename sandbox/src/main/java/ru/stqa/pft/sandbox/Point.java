package ru.stqa.pft.sandbox;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        double answer = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return answer;
    }

    public static void main(String[] args) {
        Point firstPoint = new Point(0.5, 2);
        Point secondPoint = new Point(2.5, 0.5);

        System.out.println("Distance: " + Point.distance(firstPoint, secondPoint));
    }
}