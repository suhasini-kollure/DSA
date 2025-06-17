package coderpad;

import java.util.*;

public class IntervalOrdering {

    public static List<int[]> orderIntervals(List<int[]> intervals) {

        HashMap<Integer, int[]> startPoint = new HashMap<>();
        HashSet<Integer> endPoints = new HashSet<>();

        // Step 1: Fill maps
        for (int[] interval : intervals) {
            startPoint.put(interval[0], interval);
            endPoints.add(interval[1]);
        }
        // Step 2: Find the start point (which is not in endPoints)

        int start = -1;
        for (int[] interval : intervals) {
            if (!endPoints.contains(interval[0])) {
                start = interval[0];
                break;
            }
        }

        // Step 3: Reconstruct the chain
        List<int[]> result = new ArrayList<>();
        while (startPoint.containsKey(start)) {
            int[] interval = startPoint.get(start);
            result.add(interval);
            start = interval[1];
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> intervals = Arrays.asList(
                new int[]{5, 7}, new int[]{15, 29},
                new int[]{7, 9}, new int[]{1, 5},
                new int[]{12, 15}, new int[]{29, 34},
                new int[]{9, 12}
        );

        List<int[]> ordered = orderIntervals(intervals);
        for (int[] interval : ordered) {
            System.out.print("(" + interval[0] + "," + interval[1] + ") ");
        }
    }
}