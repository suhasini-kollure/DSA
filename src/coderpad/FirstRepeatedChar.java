package coderpad;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {
    public static Character firstRepeatedChar(String str) {
        Set<Character> seen = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (seen.contains(ch)) {
                return ch;
            }
            seen.add(ch);
        }
        return null;
    }

    public static void main(String[] args) {
        String input = "geeksforgeeks";
        System.out.println(firstRepeatedChar(input));
    }
}
