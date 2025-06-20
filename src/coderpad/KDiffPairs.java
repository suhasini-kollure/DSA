package coderpad;

import java.util.HashMap;
import java.util.Map;

/*(LeetCode 532):
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is a pair of integers (i, j) where:
i and j are different indices
|nums[i] - nums[j]| == k. Which is the same as: nums[j] == nums[i] + k  OR  nums[i] == nums[j] + k
So, to avoid checking every pair (which would be O(n²)), we use a HashMap to:
Count occurrences of each number (map.put(num, frequency)).
Then for each unique key in the map: Check if there exists another number that is key + k — that will form a valid pair.

Each pair is counted only once (no duplicates)

Time Complexity: O(n) where n is the number of elements in nums
Space Complexity: O(n) for the hashmap*/

public class KDiffPairs {
    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;  // Absolute difference can't be negative

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Step 1: Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check conditions for k
        for (int key : map.keySet()) {
            if (k == 0) {
                // Count elements that appear more than once
                if (map.get(key) >= 2) {
                    count++;
                }
            } else {
                // For k > 0, check if key + k exists
                if (map.containsKey(key + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2)); // Output: 2
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1)); // Output: 4
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0)); // Output: 1
    }
}
