package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 18.08.2021
 * version 1.0
 */

public class SquareTests {

    @Test
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);
    }
}