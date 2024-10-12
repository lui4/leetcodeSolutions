import java.util.ArrayList;
import java.util.Arrays;

public class BestTimeToBuyAndSellStocksWithTransactionFee {
    int fee;
    int[] prices;
    int[][] memo;
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        this.memo = new int[prices.length][2];

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(this.memo[i], -1);
        }

        return dp(0, 0);

    }

    public int dp(int currentDay, int holding) {
        if(currentDay == prices.length) return 0;

        if(memo[currentDay][holding] != -1) return memo[currentDay][holding];

        int ans = dp(currentDay+1, holding);
        if(holding == 1){
            ans = Math.max(ans, prices[currentDay] - fee + dp(currentDay+1, 0));
        }else {
            ans = Math.max(ans, -prices[currentDay] + dp(currentDay+1, 1));
        }

        memo[currentDay][holding] = ans;

        return ans;
    }
}
