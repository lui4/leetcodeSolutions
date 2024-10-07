import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        // AB CD

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(1));

        for (int i = 1; i < s.length(); i++) {
            char prev = stack.peek();
            char currChar = s.charAt(i);

            if(currChar == 'B' && stack.peek() == 'A') {
                stack.pop();
                continue;
            }

            if(currChar == 'D' && stack.peek() == 'C') {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }
        return stack.size();
    }
}
