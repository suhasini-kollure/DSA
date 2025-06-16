package coderpad;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {

        // Step 1: Count character frequencies while preserving order
        LinkedHashMap<Character, Long> charCount = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Step 2: Find the first character with count == 1
        for (Map.Entry<Character, Long> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());  // Return the index of the unique character
            }
        }
        return -1; // No unique character
    }

    public static void main(String[] args) {
        String input = "leetcode";
        int index = firstUniqChar(input);
        System.out.println("Index of first unique character: " + index);
    }
}
