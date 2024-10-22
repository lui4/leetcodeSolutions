import java.util.ArrayList;
import java.util.HashSet;

public class MaxUniqueSplit {
    public int maxUniqueSplit(String s) {
        return backtracking(new HashSet<>(), 0, s);
    }

    public int backtracking(HashSet<String> seen, int start, String s) {
        if(start == s.length()) {
            return 0;
        }
        int maxCount = 0;
        for (int i = start+1; i <= s.length(); ++i) {
            if(seen.contains(s.substring(start, i))) continue;
            seen.add(s.substring(start, i));
            maxCount = Math.max(maxCount, 1+backtracking(seen, i, s));
            seen.remove(s.substring(start, i));
        }
        return maxCount;
    }

}
