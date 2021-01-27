package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 3/2/2020
 * This program prints a Fibonacci number according to the user's input.
 */

import java.util.Scanner;

public class Fibonacci {

    public int fibNumber(int n)
    {
        int fold1 = 1;
        int fold2 = 1;
        int fnew = 0;

        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return fold1;
        }

        if (n == 2)
        {
            return fold2;
        }

        while(n > 2)
        {
            fnew = fold1+fold2;
            fold1 = fold2;
            fold2 = fnew;
            n--;
        }

        return fnew;
    }
    public static void main(String[] args)
    {
        Fibonacci number = new Fibonacci();
        int n;
        System.out.println("Please Enter an Integer:");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        System.out.println("Fibonacci number " + n + " is: " + number.fibNumber(n) + ".");
        input.close();
    }
}