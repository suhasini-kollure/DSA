package coderpad;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Sentinel value to handle edge cases
        int maxLength = 0;

        // Iterate through the characters of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Push the index of the opening bracket
                stack.push(i);
            } else {
                // Pop the previous index (matching '(' or base)
                stack.pop();

                if (stack.isEmpty()) {
                    // If stack is empty, push current index as base for future valid substring
                    stack.push(i);
                } else {
                    // Calculate valid length = current index - index before matching '('
                    int currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }

    // Main method for testing
    public static void main(String[] args) {
        LongestValidParentheses solver = new LongestValidParentheses();

        System.out.println(solver.longestValidParentheses("(()"));      // Output: 2
        System.out.println(solver.longestValidParentheses(")()())"));   // Output: 4
        System.out.println(solver.longestValidParentheses(""));         // Output: 0
        System.out.println(solver.longestValidParentheses("()(()"));    // Output: 2
        System.out.println(solver.longestValidParentheses("()()"));     // Output: 4
    }
}

