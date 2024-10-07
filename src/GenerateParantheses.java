import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> answer = new ArrayList<>();

        StringBuilder current = new StringBuilder();
        current.append("(");

        backtrack(1, n, current, answer);

        return answer;
    }

    public void backtrack(int currentlyOpenedBrackets, int n, StringBuilder current, List<String> answer) {
        if (current.length() == n * 2) {
            answer.add(current.toString());
            return;
        }

        if (currentlyOpenedBrackets < n) {
            current.append("(");

            backtrack(currentlyOpenedBrackets + 1, n, current, answer);

            current.deleteCharAt(current.length() - 1);
        }

        if (current.length() < currentlyOpenedBrackets*2) {
            current.append(")");

            backtrack(currentlyOpenedBrackets, n, current, answer);

            current.deleteCharAt(current.length() - 1);
        }

    }
}
