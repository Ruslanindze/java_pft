package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 15.10.2021
 * version 1.0
 */

public class PointTests {
    private static final double DELTA = 0.0001;

    @Test
    public void testDistanceA() {
        Point firstPoint = new Point(-3.5, 2.5);
        Point secondPoint = new Point(12, -15);

        Assert.assertEquals(Point.distance(firstPoint, secondPoint), 23.3773, DELTA);
    }

    @Test
    public void testDistanceB() {
        Point firstPoint = new Point(7.2, -5.6);
        Point secondPoint = new Point(-4.8, 8.4);

        Assert.assertEquals(Point.distance(firstPoint, secondPoint), 18.439, DELTA);
    }
}
