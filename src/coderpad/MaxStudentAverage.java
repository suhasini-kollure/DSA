package coderpad;

import java.util.*;

/*Given an array in which there are arrays that are of length two,
the first index of that array has the student name and the second index has the marks scored.
Find the maximum average scored by any student.
The array can have multiple subjects of marks for a particular student.
or
given 2D String array, that contains(StudentName, Grades). There can be one or more grades per student.
Return the maximum AverageGrade amongst all students.
*/

public class MaxStudentAverage {

    public static double getMaxAverage(String[][] scores) {

        HashMap<String, List<Integer>> studentScores = new HashMap<>();

        for (String[] entry : scores) {
            String name = entry[0];
            int score = Integer.parseInt(entry[1]);

            studentScores.computeIfAbsent(name, k -> new ArrayList<>()).add(score);
        }

        double maxAverage = 0.0;
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> marks = entry.getValue();

            double sum = 0.0;
            for (int mark : marks) {
                sum += mark;
            }

            double avg = sum / marks.size();
            maxAverage = Math.max(maxAverage, avg);
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        String[][] scores = {
                {"Alice", "80"},
                {"Bob", "90"},
                {"Alice", "100"},
                {"Bob", "70"},
                {"Charlie", "60"}
        };
        double maxAverage = getMaxAverage(scores);
        System.out.println(maxAverage);
    }
}
