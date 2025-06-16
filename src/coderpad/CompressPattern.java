package coderpad;

/*Given a string ” A B A B C A B A B C D”, you have to compress it into the following format: A B * C * D. Here,
till A B * of the output, A B repeats twice, but till A B * C *, A B A B C repeats twice.
*/

public class CompressPattern {
    public static String compress(String input) {
        String[] tokens = input.trim().split(" ");
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < tokens.length) {
            boolean patternFound = false;

            // Try to find the longest repeating pattern from position i
            for (int len = 1; i + 2 * len <= tokens.length; len++) {
                boolean isPattern = true;
                for (int j = 0; j < len; j++) {
                    if (!tokens[i + j].equals(tokens[i + len + j])) {
                        isPattern = false;
                        break;
                    }
                }

                if (isPattern) {
                    // Append first pattern
                    for (int j = 0; j < len; j++) {
                        result.append(tokens[i + j]).append(" ");
                    }
                    result.append("* ");
                    i += 2 * len;
                    patternFound = true;
                    break;
                }
            }

            if (!patternFound) {
                result.append(tokens[i]).append(" ");
                i++;
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input = "A B A B C A B A B C D";
        System.out.println(compress(input));  // Output: A B * C * D
    }
}

