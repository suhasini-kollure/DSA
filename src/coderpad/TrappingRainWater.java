package coderpad;

/*Trapping rain water problem.
or
Given an array height[] where each element represents the height of a bar (or building),
imagine it forms a histogram. After raining, water is trapped between the bars.
Your task is to calculate how much water can be trapped.*/

public class TrappingRainWater {
    public static int trap(int[] height) {

        /* 1.Approach :
                      | Operation         | Complexity |
                      |Time Complexity**  | O(n)       |
                      |Space Complexity** | O(n)       |*/

//        int n = height.length;
//        if (n == 0) return 0;
//
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//
//        // Fill leftMax array
//        leftMax[0] = height[0];
//        for (int i = 1; i < n; i++) {
//            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
//        }
//
//        // Fill rightMax array
//        rightMax[n - 1] = height[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
//        }
//
//        // Calculate total water trapped
//        int trappedWater = 0;
//        for (int i = 0; i < n; i++) {
//            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//
//        return trappedWater;

        /* 2.Approach :
        Time Complexity: O(n)
        Space Complexity: O(1) — constant space (no extra arrays used)*/

        if (height == null || height.length < 3) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int snow = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    snow += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    snow += rightMax - height[right];
                }
                right--;
            }
        }

        return snow;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total trapped water: " + trap(height));  // Output: 6
    }
}

