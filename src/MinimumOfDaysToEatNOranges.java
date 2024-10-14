import java.util.HashMap;

public class MinimumOfDaysToEatNOranges {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int minDays(int n) {
        return dp(n);
    }

    public int dp(int n){
        if(n<=1) return 0;

        if(memo.getOrDefault(n, -1) != -1) return memo.get(n);

        int ans = 1 + Math.min(n % 2 + dp(n - (n/2 + n%2)), n%3 + dp(n - (2*(n/3) + n%3)));

        memo.put(n, ans);

        return ans;
    }
}
