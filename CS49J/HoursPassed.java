package edu.sjsu.gutierrez;

import java.util.*;
public class HoursPassed
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the first time: ");
        int hourone = in.nextInt();

        System.out.print("Please enter the second time: ");
        int hourtwo = in.nextInt();

        MilitaryTime difference = new MilitaryTime(hourone, hourtwo);
        System.out.println(difference.getDifference());
        in.close();
    }
}