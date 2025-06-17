package coderpad;

import java.util.*;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";  // If numerator is 0, result is 0 no matter what

        StringBuilder result = new StringBuilder();

        // Step 1: Handle negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Step 2: Work with absolute values to avoid complications with negatives
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Step 3: Integer part
        result.append(num / den);  // Append integer division result
        num %= den;                // Get remainder

        // If no fractional part
        if (num == 0) return result.toString();

        // Step 4: Decimal part
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();  // Stores seen remainders and their positions

        while (num != 0) {
            if (map.containsKey(num)) {
                // Repeating remainder found
                int index = map.get(num);            // Get where repetition started
                result.insert(index, "(");           // Insert opening parenthesis
                result.append(")");                  // Append closing parenthesis
                break;
            }

            map.put(num, result.length());  // Remember current remainder and its index
            num *= 10;                      // Prepare next digit in decimal
            result.append(num / den);       // Append next digit
            num %= den;                     // Update remainder
        }

        return result.toString();  // Final decimal string
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2, 5));    // 0.4
        System.out.println(fractionToDecimal(1, 2));    // 0.5
        System.out.println(fractionToDecimal(1, 3));    // 0.(3)
        System.out.println(fractionToDecimal(12, 5));   // 2.4
        System.out.println(fractionToDecimal(11, 20));  // 0.55
        System.out.println(fractionToDecimal(5, 3));    // 1.(6)
    }
}