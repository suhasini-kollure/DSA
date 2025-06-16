package coderpad;

import java.lang.annotation.Target;

/*Find the minimum subarray whose sum is at least the given target.
eg: Sub array: 1, 2, 5, 6, 11, 2 Target: 12 Answer: 11, 2
or
Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.
*/

public class MinSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);  //gives the number of elements between i and j (inclusive).
                    break;
                }
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 11, 2};
        int target = 12;
        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum length of subarray with sum ≥ " + target + " is: " + result);
    }
}

