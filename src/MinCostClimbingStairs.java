import java.util.HashMap;

public class MinCostClimbingStairs {
    HashMap<Integer, Integer> memory = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        int bottomOne = 0;
        int upperOne = 0;
        int currentCost = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            currentCost = Math.min(bottomOne + cost[i-2], upperOne + cost[i-1]);
            bottomOne = upperOne;
            upperOne = currentCost;
        }

        return upperOne;
    }


    public static void main(String[] args) {
        MinCostClimbingStairs mc = new MinCostClimbingStairs();
        System.out.println(mc.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

}
