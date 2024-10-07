import java.util.Arrays;
import java.util.Stack;

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }

        Stack<String> sentence1S = new Stack();
        Stack<String> sentence2S = new Stack<>();

        int index = 0;
        StringBuilder currWord1 = new StringBuilder();
        StringBuilder currWord2 = new StringBuilder();
        while(index < sentence1.length()) {
            if (sentence1.charAt(index) == ' ') {
                sentence1S.push(currWord1.toString());
                currWord1.setLength(0);
            }
            currWord1.append(sentence1.charAt(index));
            index++;


        }

        while(index < sentence2.length()) {
            if (sentence2.charAt(index) == ' ') {
                sentence2S.push(currWord2.toString());
                currWord2.setLength(0);
            }
            currWord2.append(sentence2.charAt(index));
            index++;
        }

        boolean isStack1Larger = sentence1S.size() > sentence2S.size();
        boolean poppedPrev = false;
        int poppedElements = 0;
        while (!sentence1S.isEmpty() || !sentence2S.isEmpty()) {
            if(sentence1S.peek().equals(sentence2S.peek())) {
                sentence1S.pop();
                sentence2S.pop();
                poppedPrev = false;
            } else {
                if(isStack1Larger) {
                    if(sentence1S.isEmpty() || (poppedPrev && poppedElements != 0)) return false;
                    sentence1S.pop();
                    poppedPrev = true;
                    poppedElements++;
                } else {
                    if(sentence2S.isEmpty() || (poppedPrev && poppedElements != 0)) return false;
                    sentence2S.pop();
                    poppedPrev = true;
                    poppedElements++;
                }
            }

        }

        return true;

    }
}
