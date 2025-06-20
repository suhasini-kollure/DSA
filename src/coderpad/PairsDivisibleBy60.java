package coderpad;

/*You are given a list of song durations (in seconds),
and you need to count the number of pairs of songs such that the sum of their durations is divisible by 60.
Input: time = [30, 20, 150, 100, 40]
Output: 3

Explanation:
        (30, 150) → 180 % 60 == 0
        (20, 100) → 120 % 60 == 0
        (20, 40) → 60 % 60 == 0*/


import java.util.*;

public class PairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> remainderMap = new HashMap<>();

        for (int t : time) {
            int rem = t % 60;
            int complement = (60 - rem) % 60;

            // If complement exists, add its frequency to count
            count += remainderMap.getOrDefault(complement, 0);

            // Add current remainder to map
            remainderMap.put(rem, remainderMap.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        PairsDivisibleBy60 obj = new PairsDivisibleBy60();
        int[] time = {30, 20, 150, 100, 40};
        System.out.println("Number of valid pairs: " + obj.numPairsDivisibleBy60(time));  // Output: 3
    }
}

