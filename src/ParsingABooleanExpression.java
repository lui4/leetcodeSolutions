import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        if(expression.equals("f")) return false;
        if(expression.equals("t")) return true;

        boolean ans = false;
        if(expression.charAt(0) == '|') {
            for (String subString: extractSubProblems(expression.substring(2, expression.length()-1))) {
                ans |= parseBoolExpr(subString);
            }
            return ans;
        }

        if(expression.charAt(0) == '&'){
            ans = true;
            for (String subString: extractSubProblems(expression.substring(2, expression.length()-1))) {
                System.out.println(subString);
                ans &= parseBoolExpr(subString);
            }
            return ans;
        }

        if(expression.charAt(0) == '!'){
            ans = !parseBoolExpr(expression.substring(2, expression.length()-1));
            return ans;
        }

        return ans;
    }

    public ArrayList<String> extractSubProblems(String logicalArguments){
        int openBrackets = 0;
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < logicalArguments.length(); i++) {
            if(logicalArguments.charAt(i) == '(') openBrackets++;

            if(logicalArguments.charAt(i) == ',' && openBrackets == 0){
                answer.add(curr.toString());
                curr.setLength(0);
                continue;
            }

            if(logicalArguments.charAt(i) == ')') openBrackets--;

            curr.append(logicalArguments.charAt(i));
        }
        answer.add(curr.toString());

        return answer;
    }
}
