import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (Objects.equals(digits, "")) {
            return new ArrayList<>();
        }

        HashMap<Character, char[]> letterMapping = new HashMap<>();

        letterMapping.put('2', new char[]{'a', 'b', 'c'});
        letterMapping.put('3', new char[]{'d', 'e', 'f'});
        letterMapping.put('4', new char[]{'g', 'h', 'i'});
        letterMapping.put('5', new char[]{'j', 'k', 'l'});
        letterMapping.put('6', new char[]{'m', 'n', 'o'});
        letterMapping.put('7', new char[]{'p', 'q', 'r', 's'});
        letterMapping.put('8', new char[]{'t', 'u', 'v'});
        letterMapping.put('9', new char[]{'w', 'x', 'y', 'z'});



        ArrayList<String> answer = new ArrayList<>();

        backtrack(answer, digits, new StringBuilder(), letterMapping);

        return answer;
    }

    public void backtrack(ArrayList<String> answer, String digits, StringBuilder currentString, HashMap<Character, char[]> letterMapping) {
        if (currentString.length() == digits.length()) {
            answer.add(currentString.toString());
            return;
        }

        char currentDigit = digits.charAt(currentString.length());

        for (char nextPossibleChar: letterMapping.get(currentDigit)) {
            currentString.append(nextPossibleChar);
            backtrack(answer, digits, currentString, letterMapping);
            currentString.deleteCharAt(currentString.length() - 1);
        }

    }
}
