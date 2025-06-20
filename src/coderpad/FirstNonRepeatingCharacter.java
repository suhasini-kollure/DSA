package coderpad;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static String firstNonRepeatingChar(String s) {

        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .map(String::valueOf)
                .orElse("0");
    }

    public static void main(String[] args) {

        String str = "aabccd";
        System.out.println(firstNonRepeatingChar(str));
    }
}