import java.util.*;

public class WordLadder {
    class Pair{
        String x;
        int y;
        public Pair(String x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> seen = new HashSet<>();
        HashMap<String, List<String>> graph = new HashMap<>();

        for (String word: wordList) {
            for (int i = 0; i < beginWord.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1);

                graph.computeIfAbsent(newWord, val -> new ArrayList<>());
                graph.get(newWord).add(word);
            }

        }

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(beginWord, 1));
        seen.add(beginWord);

        while (!queue.isEmpty()) {
            Pair currentElement = queue.poll();

            for (int i = 0; i < beginWord.length(); i++) {
                String genericWord = currentElement.x.substring(0, i) + '*' + currentElement.x.substring(i+1);

                for (String intermediateWord: graph.getOrDefault(genericWord, new ArrayList<>())) {
                    if (intermediateWord.equals(endWord)) {
                        return currentElement.y + 1;
                    }
                    if (!seen.contains(intermediateWord)){
                        queue.add(new Pair(intermediateWord, currentElement.y + 1));
                        seen.add(intermediateWord);
                    }
                }
            }
        }
        return 0;
    }
}

// Mit der Konstruktion erhalten wir alle Wörter die sich um einen Charakter von dem vorherigen Wort unterscheiden
