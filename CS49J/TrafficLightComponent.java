package edu.sjsu.gutierrez;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class TrafficLightComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        TrafficLight signal = new TrafficLight(10, 20);
        signal.draw(g2);
    }
}
