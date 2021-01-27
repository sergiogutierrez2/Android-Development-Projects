package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 2/21/2020
 * This class represents a bug moving along a horizontal line.
 * The bug moves either to the right or left. Initially, the
 * bug moves to the right, but it can turn to change its direction.
 * In each move, its position changes by one unit in the current direction.
 */

public class Bug
{
    private int position;
    private boolean goingRight;

    public Bug(int initialPosition)
    {
        position = initialPosition;
        goingRight = true;
    }

    public void turn()
    {
        goingRight = !goingRight;
    }

    public void move()
    {
        if(goingRight)
        {
            position++;
        } else
        {
            position--;
        }
    }

    public int getPosition()
    {
        return position;
    }

    public static void main(String[] args) {
        Bug bugsy = new Bug(10);
        bugsy.move(); // Now the position is 11
        bugsy.turn();
        bugsy.move(); // Now the position is 10
        System.out.println("Expected = 10, Actual = " + bugsy.getPosition());
        bugsy.move();
        System.out.println("Expected = 9, Actual = " + bugsy.getPosition());
        bugsy.move();
        System.out.println("Expected = 8, Actual = " + bugsy.getPosition());
        bugsy.turn();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        System.out.println("Expected = 11, Actual = " + bugsy.getPosition());
        bugsy.turn();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        System.out.println("Expected = 7, Actual = " + bugsy.getPosition());
    }

}
