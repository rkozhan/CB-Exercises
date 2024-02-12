package a1_Basics;

import java.util.Calendar;

public class E1_1_TellMeAboutYourself {
    public static void main(String[] args) {

        int age = 35;
        String name = "Roman";
        String gender = "male";

        //String birthday = "28.06.1988";
        Calendar birthday = Calendar.getInstance();
        birthday.set(1988, 5, 28);  //Monate - von 0 bis 11

        double  averageGrade = 1.5;
        boolean isMarried = true;

        System.out.println("Alter: " + age);
        System.out.println("Name: " + name);
        System.out.println("Geschlecht: " + gender);
        //System.out.println(birthday);
        System.out.printf("Geburstag: %tD%n", birthday);
        System.out.println("Durchschnittsnote: " + averageGrade);
        System.out.println("Verheiratet: " + isMarried);
    }
}

//Declare variables to express your age, first name, gender, last name, birthday, average grade
// and whether you are married or not. Think which datatype is well suited for which variable.
//Print all variables to the console with System.out.println
