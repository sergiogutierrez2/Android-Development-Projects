package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 3/2/2020
 * This program prints the first fifty random numbers from 0 to 100.
 */

import java.util.Random;

public class RandomFifty {
    public static void main(String[] args) {
        Random rand = new Random(1000);
        System.out.println("The first 50 random numbers:");

        for (int i = 0; i < 50; i++) {
            System.out.println(1 + rand.nextInt(100));
        }
    }
}