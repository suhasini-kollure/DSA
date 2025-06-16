package coderpad;

/*There are some students, sitting in a circle. Each student is assigned a roll no (1 to n).
There is a teacher who was given an initial roll no and he has to remove the student with initial roll no.
and then has to remove the student who was at that position starting from the removed student.
Your function should return the last student left. Example: 2, 3, 1, 4, 5 start with 3, remove 3,
then remove 5, then remove 1 (follow circle), then remove 4. Ans – 2.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastStudent {

    public static int findLastStudent(List<Integer> students, int startRollNo) {

        int index = students.indexOf(startRollNo);

        while (students.size() > 1) {
            // Remove current student
            students.remove(index);

            // If we reach end, go to start (circular)
            if (index == students.size()) {
                index = 0;
            }
        }
        return students.get(0);
    }

    public static void main(String[] args) {
        List<Integer> students = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 5));
        int start = 3;
        int lastStudent = findLastStudent(students, start);
        System.out.println("Last student left: " + lastStudent); // Output: 2
    }
}
