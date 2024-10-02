import java.util.HashMap;

public class MinCostClimbingStairs {
    HashMap<Integer, Integer> memory = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return dp(cost.length - 1, cost);
    }

    public int dp(int stair, int[] cost) {
        if (stair == 0) {
            return cost[0];
        }

        if(stair == 1) {
            return Math.min(cost[0], cost[1]);
        }

        if (memory.getOrDefault(stair, null) != null) {
            return memory.get(stair);
        }

        memory.put(stair, Math.min(dp(stair-1, cost) + cost[stair-1], dp(stair - 2, cost) + cost[stair - 2]));
        return memory.get(stair);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mc = new MinCostClimbingStairs();
        System.out.println(mc.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

}
