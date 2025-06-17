package coderpad;

/*Given a string ” A B A B C A B A B C D”, you have to compress it into the following format: A B * C * D. Here,
till A B * of the output, A B repeats twice, but till A B * C *, A B A B C repeats twice.
*/

import java.util.StringJoiner;

public class CompressPattern {
    private static void compress(String[] a, int from, int to, StringJoiner out) {
        if (from >= to) return;
        int len = to - from;

        for (int L = len / 2; L > 0; L--) {
            boolean match = true;
            for (int i = 0; i < L; i++) {
                if (!a[from + i].equals(a[from + L + i])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                compress(a, from, from + L, out);
                out.add("*");
                compress(a, from + 2 * L, to, out);
                return;
            }
        }
        out.add(a[from]);
        compress(a, from + 1, to, out);
    }

    public static void main(String[] args) {
        String input = "A B A B C A B A B C D";
        String[] tokens = input.split("\\s+");
        StringJoiner out = new StringJoiner(" ");
        compress(tokens, 0, tokens.length, out);
        System.out.println(out);  // prints: A B * C * D
    }
}