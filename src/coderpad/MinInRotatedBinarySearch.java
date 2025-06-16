package coderpad;

//Find the minimum element in a sorted and rotated array

public class MinInRotatedBinarySearch {

    static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while (low < high) {
            if (arr[low] < arr[high]) {
                return arr[low];
            }

            int mid = (low + high) / 2;

//          Mid element is greater than the last element.That means the minimum is to the right of mid.
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}
