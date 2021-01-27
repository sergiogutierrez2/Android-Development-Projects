package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 2/21/2020
 * The class is used to draw a Traffic light.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Declare the variables of the coordinates.
 */
public class TrafficLight
{
    private int x, y;

    /**
     * Constructor takes the x and y coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public TrafficLight(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * draws the traffic light and fills the circles with a different color accordingly.
     * @param g2 the g2 parameter
     */
    public void draw(Graphics2D g2)
    {
        Rectangle box1 = new Rectangle(x, y, 20, 60);
        g2.setColor(Color.BLACK);
        g2.draw(box1);
        g2.setColor(Color.RED);

        Ellipse2D.Double redCircle = new Ellipse2D.Double(x, y, 20, 20);
        g2.fill(redCircle);
        g2.setColor(Color.YELLOW);

        Ellipse2D.Double yellowCircle = new Ellipse2D.Double(x, y+20, 20, 20);
        g2.fill(yellowCircle);
        g2.setColor(Color.GREEN);

        Ellipse2D.Double greenCircle = new Ellipse2D.Double(x, y+40, 20, 20);
        g2.fill(greenCircle);

        g2.setColor(Color.BLACK);
    }
}