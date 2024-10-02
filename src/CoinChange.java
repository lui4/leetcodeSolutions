import java.util.HashMap;

public class CoinChange {
    HashMap<Integer, Integer> memory = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        return dp(coins, amount);
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
