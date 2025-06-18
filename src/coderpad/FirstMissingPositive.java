package coderpad;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index (nums[i] == i + 1)
        for (int i = 0; i < n; i++) {
            // While current number is in range and not already placed correctly
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Find first index where value is not i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;   //Because arrays are 0-indexed, but the positive integers start from 1.
            }
        }

        // If all values from 1 to n are present, answer is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
       int[] nums = {3, 4, -1, 1};
       int[] nums1 = {1,2,0};
       int[] nums2 = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositive(nums2));

    }
}
