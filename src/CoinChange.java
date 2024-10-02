import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    HashMap<Integer, Integer> memory = new HashMap<>();
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int dp(int[] coins, int amount) {
        if (memory.getOrDefault(amount, null) != null) return memory.get(amount);

        int answer = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (coin > amount) {
                continue;
            }

            if(coin == amount){
                return 1;
            }

            int recursiveResult = dp(coins, amount - coin);

            if (recursiveResult == -1) {
                continue;
            }

            answer = Math.min(recursiveResult + 1, answer);
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

        memory.put(amount, answer);
        return answer;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        System.out.println(cc.coinChange(new int[]{186,419,83,408}, 6249));
    }
}
