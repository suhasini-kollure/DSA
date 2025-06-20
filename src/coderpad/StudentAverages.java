package coderpad;

//Find the average 5 subjects of each student
public class StudentAverages {
    public static void main(String[] args) {
        String[] students = {"Alice", "Bob"};
        int[][] scores = {
                {90, 85, 78, 92, 88},  // Alice's scores
                {76, 81, 70, 89, 84}   // Bob's scores
        };

        for (int i = 0; i < students.length; i++) {
            int total = 0;
            for (int j = 0; j < scores[i].length; j++) {
                total += scores[i][j];
            }
            double average = total / 5.0;
            System.out.println(students[i] + "'s average: " + average);
        }
    }
}

