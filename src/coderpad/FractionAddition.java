package coderpad;

/*
1. Given two fractions which are represented as an array of two elements (numerator and denominator),
the task to find the reduced fraction which is the sum of two fractions.
or
a/b + c/d = simple form

To express a/b + c/d in its simplest form, you need to find a common denominator and then add the numerators.
The simplest form is (ad + bc) / bd.

The key idea:
The GCD of two numbers a and b is the same as the GCD of b and a % b.
We repeat this until b becomes 0, and at that point, a is the GCD.
*/

public class FractionAddition {

    // Function to compute GCD (Greatest Common Divisor)
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Function to add fractions and simplify
    public static String addFractions(int a, int b, int c, int d) {
        int numerator = a * d + c * b;
        int denominator = b * d;

        int gcd = gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        int c = 3, d = 4;

        System.out.println("Result: " + addFractions(a, b, c, d));

    }
}
