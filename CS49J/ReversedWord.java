package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 3/2/2020
 * This program prints a word in reverse.
 */
import java.util.Scanner;

public class ReversedWord
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word to print in reverse: ");
        String word = in.nextLine();

        char[] reversed = word.toCharArray();
        for (int i = word.length() - 1; i >= 0; i--)
        {
            System.out.print(reversed[i]);
        }
        in.close();
    }
}
