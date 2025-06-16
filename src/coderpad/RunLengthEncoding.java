package coderpad;

//given a string “aaabbbbbccccdaa”, then we to print “a3b5c4d1a2”.

public class RunLengthEncoding {
    public static void doEncoding(String str) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char currentChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                sb.append(currentChar).append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        System.out.println(sb.append(currentChar).append(count));

    }

    public static void main(String[] args) {

        String str = "aaabbbbbccccdaa";
        doEncoding(str);
    }
}
