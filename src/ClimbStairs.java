import java.awt.desktop.PreferencesEvent;
import java.util.HashMap;

public class ClimbStairs {
    HashMap<Integer, Integer> memory = new HashMap<>();
    public int climbStairs(int n) {
        return dp(n);
    }

    public int dp(int stair) {
        if (stair == 1) {
            return 1;
        }
        if (stair == 2) {
            return 2;
        }

        if (memory.getOrDefault(stair, null) != null) {
            return memory.get(stair);
        }

        memory.put(stair, dp(stair - 1) + dp(stair - 2));
        return memory.get(stair);
    }
}
