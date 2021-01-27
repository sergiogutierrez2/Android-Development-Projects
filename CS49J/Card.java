package edu.sjsu.gutierrez;

/*
 * Sergio Gutierrez
 * CS49J
 * 2/29/2020
 * Card class takes card notation string and returns a description of the card.
 */

public class Card
{
    private String description;

    public Card (String desc)
    {
        this.description = desc;
    }

    public String getDescription()
    {
        String unknown = "uknown";

        String number = description.substring (0, 1);
        String type = description.substring(1, 2);

        if (number.equalsIgnoreCase("A"))
            number = "Ace of";
        else if (number.equals("2"))
            number = "Two of";
        else if (number.equals("3"))
            number = "Three of";
        else if (number.equals("4"))
            number = "Four of";
        else if (number.equals("5"))
            number = "Five of";
        else if (number.equals("6"))
            number = "Six of";
        else if (number.equals("7"))
            number = "Seven of";
        else if (number.equals("8"))
            number = "Eight of";
        else if (number.equals("9"))
            number = "Nine of";
        else if (number.equals("1"))
        {
            if (description.equalsIgnoreCase("10S"))
                return "Ten of Spades";
            else if (description.equalsIgnoreCase("10H"))
                return "Ten of Hearts";
            else if (description.equalsIgnoreCase("10D"))
                return "Ten of Diamonds";
            else if (description.equalsIgnoreCase("10C"))
                return "Ten of Clubs";
            else
            { return unknown;}
        }
        else if (number.equalsIgnoreCase("J"))
            number = "Jack of";
        else if (number.equalsIgnoreCase("Q"))
            number = "Queen of";
        else if (number.equalsIgnoreCase("K"))
            number = "King of";
        else
        {return unknown;}

        if (type.equalsIgnoreCase("S"))
            type = "Spades";
        else if (type.equalsIgnoreCase("H"))
            type = "Hearts";
        else if (type.equalsIgnoreCase("D"))
            type = "Diamonds";
        else if (type.equalsIgnoreCase("C"))
            type = "Clubs";
        else
        { return unknown;}

        return number + " " + type;
    }
}