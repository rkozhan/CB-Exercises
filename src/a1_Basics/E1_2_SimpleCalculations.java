package a1_Basics;

public class E1_2_SimpleCalculations {
    public static void main(String[] args) {

        int a = 138, b = 235;

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        double quotient = (double) a / b;

        System.out.printf("Variables a: %d, b: %d,\nsum: %d, difference: %d, product: %d, quotient: %.2f",
                 a, b , sum, difference, product, quotient);
    }
}

//Declare two numeric variables with arbitary values. Calculate their sum, difference, product and quotient
// and print the calculation with the result on the console with System.out.println/System.out.printf.
// Perform all calculations with whole numbers and fractional numbers.
//Bonus: Try to limit the decimal places of your calculations with the fractional numbers.