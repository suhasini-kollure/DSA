package coderpad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*This method should return an integer array with two elements that correctly identifies the location of the longest
uniform substring within the input string. The first element of the array should be the starting index of the longest
substring and the second element should be the length.
for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).*/

public class LongestUniformSubstring {
    private static final Map<String, int[]> testCases = new HashMap<>();

    /**
     * This method returns an array of two integers:
     * [starting index, length] of the longest uniform substring.
     */
    static int[] longestUniformSubstring(String input) {
        if (input == null || input.length() == 0) {
       return new int []{-1, 0};
     }

     int longestStart = -1;
     int longestLength = 0;

     int currentStart = 0;
     int currentLength = 1;

     for (int i = 1; i < input.length(); i++) {
       if (input.charAt(i) == input.charAt(i-1)) {
         currentLength++;
       } else {
         if (currentLength > longestLength) {
           longestStart = currentStart;
           longestLength = currentLength;
         }
         currentStart = i;
         currentLength = 1;
       }
     }

     if (currentLength > longestLength) {
         longestStart = currentStart;
         longestLength = currentLength;
     }

        return new int[]{longestStart, longestLength};
    }

    public static void main(String[] args) {
        // Core test cases
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        // Additional test cases
        testCases.put("abcde", new int[]{0, 1});             // All unique
        testCases.put("aaaaaa", new int[]{0, 6});            // All same character
        testCases.put("aabbaaa", new int[]{4, 3});           // Uniform at end
        testCases.put("aaabbaacc", new int[]{0, 3});         // Uniform at start
        testCases.put("aabbbccccddeee", new int[]{5, 4});    // Middle longest

        boolean pass = true;
        for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
            int[] result = longestUniformSubstring(testCase.getKey());
            if (!Arrays.equals(result, testCase.getValue())) {
                pass = false;
                System.out.println("Test failed for input: \"" + testCase.getKey() + "\"");
                System.out.println("Expected: " + Arrays.toString(testCase.getValue()));
                System.out.println("Got     : " + Arrays.toString(result));
            }
        }

        if (pass) {
            System.out.println("All tests pass!");
        } else {
            System.out.println("At least one test failed.");
        }
    }
}
