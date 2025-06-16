package coderpad;

//Find the minimum element in a sorted and rotated array

public class MinInRotatedLinearSearch {

    public static int findMin(int[] arr) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = Math.min(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}
