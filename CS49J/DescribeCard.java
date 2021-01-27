package edu.sjsu.gutierrez;

/**
 * Card Description Tester
 */

import java.util.Scanner;

public class DescribeCard
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter shorthand card notation:");
        String input = in.nextLine();
        Card card = new Card(input);
        System.out.println(card.getDescription());
        in.close();
    }
}