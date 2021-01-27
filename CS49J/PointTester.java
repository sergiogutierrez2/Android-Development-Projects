package edu.sjsu.gutierrez;

import java.awt.*;
/*
 * Sergio Gutierrez
 * CS49J
 * 2/11/2020
 * This program prints the distance between two points
 */

public class PointTester
{
    public static void main (String[] args)
    {
        Point p1 = new Point (3, 4);
        Point p2 = new Point (-3,-4);

        System.out.println("The distance between point 1 and point 2 is: " + p1.distance(p2));
        System.out.println("Expected result is: " + "10.0");
    }
}
