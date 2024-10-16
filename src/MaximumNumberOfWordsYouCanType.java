import java.util.Arrays;

public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        int[] defects = new int[26];

        for (int i = 0; i < brokenLetters.length(); i++) {
            defects[brokenLetters.charAt(i) % 32 - 1] = 1;
        }

        String[] words = text.split(" ");

        int rightWords = 0;
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if(defects[words[i].charAt(j) % 32 -1] == 1){
                    flag = true;
                    break;
                }
            }
            if(!flag) rightWords++;
            flag = false;
        }

        return rightWords;
    }
}
