import java.util.*;

public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < i; j++) {

                long distanceSquared = (long)(bombs[i][0]-bombs[j][0])*(bombs[i][0]-bombs[j][0]) + (long) (bombs[i][1]-bombs[j][1])*(bombs[i][1]-bombs[j][1]);

                if ((long)(bombs[i][2])*(bombs[i][2]) >= distanceSquared) {
                    graph.computeIfAbsent(i, val -> new ArrayList<>());
                    graph.get(i).add(j);
                }

                if ((long)(bombs[j][2])*(bombs[j][2]) >= distanceSquared) {
                    graph.computeIfAbsent(j, val -> new ArrayList<>());
                    graph.get(j).add(i);
                }

            }

        }

        int result = 0;

        for (int i = 0; i < bombs.length; i++) {
            result = Math.max(dfs(i, graph, new int[bombs.length]), result);
        }
        return result;
    }

    public int dfs(int startNode, HashMap<Integer, List<Integer>> graph, int[] seenNodes) {
        seenNodes[startNode] = 1;
        if (graph.get(startNode) == null){
            return 1;
        }

        int ans = 1;

        for (int neighbor: graph.get(startNode)) {
            if (seenNodes[neighbor] == 0){
                seenNodes[neighbor] = 1;
                ans += dfs(neighbor, graph, seenNodes);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DetonateTheMaximumBombs db = new DetonateTheMaximumBombs();
        System.out.println(db.maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
    }
}
