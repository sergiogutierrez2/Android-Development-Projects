package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 2/29/2020
 * MilitaryTime gives the difference between two hours in Military time.
 */

public class MilitaryTime
{
    int subtractedTime;
    public MilitaryTime (int hourone, int hourtwo)
    {
        subtractedTime = convertToMinutes(hourtwo)-convertToMinutes(hourone);
        if (subtractedTime < 0)
        {
            subtractedTime = subtractedTime + (60*24);
        }
    }
    private int convertToMinutes(int hour)
    {
        return (hour/100)*60 + (hour%100);
    }

    public String getDifference()
    {
        int hours = subtractedTime / 60;
        int minutes = subtractedTime %60;
        return hours + " hours " + minutes + " minutes";
    }
}
