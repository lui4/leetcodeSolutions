import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.HashMap;
import java.util.HashSet;

public class ImplementTrie {
    class TrieNode{
        TrieNode[] children;
        boolean wordEndsHere;
        public TrieNode(boolean wordEndsHere) {
            this.children = new TrieNode[26];
            this.wordEndsHere = wordEndsHere;
        }

        public void put(char character, boolean wordEndsHere){
            children[character - 'a'] = new TrieNode(wordEndsHere);
        }

        public boolean containsKey(char key) {
            return children[key - 'a'] != null;
        }

        public TrieNode get(char character) {return children[character - 'a'];}

    }
    TrieNode root;

    public ImplementTrie() {
        this.root = new TrieNode(false);
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if(!curr.containsKey(word.charAt(i))) curr.put(word.charAt(i),false);

            curr = curr.get(word.charAt(i));
        }

        curr.wordEndsHere = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if(!curr.containsKey(word.charAt(i))) return false;

            curr = curr.get(word.charAt(i));
        }
        return curr.wordEndsHere;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            if(!curr.containsKey(prefix.charAt(i))) return false;

            curr = curr.get(prefix.charAt(i));
        }
        return true;
    }
}
