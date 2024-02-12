package a1_Basics;

import java.util.Locale;

public class E1_3_WorkingWithStrings {
    public static void main(String[] args) {
        String word = " Hello World!";

        System.out.println(word.length());
        System.out.println(word.toUpperCase());
        System.out.println(word.toLowerCase());
        System.out.println(word.replace("World", "Codersbay"));
        System.out.println(word.trim());

        for (int i = 1; i <= 15; i++) {
            System.out.println(word);
        }
    }
}

//Create a variable of type String with “ Hello World! ” as its content (contains leading and trailing spaces).
//Print the String and its length to the console.
//Print the String with some variations:
//all letters in uppercase
//all letters in lowercase
//replace “World” with “Codersbay”
//without the leading spaces
//Repeat the printed String 15 times seperated with linebreaks (don't copy the code 15 times 😉)
