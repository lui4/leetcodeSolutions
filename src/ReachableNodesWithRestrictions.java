import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReachableNodesWithRestrictions {
    HashSet<Integer> seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        seen = new HashSet<>();

        for (int i = 0; i < restricted.length; i++) {
            seen.add(restricted[i]);
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            graph.computeIfAbsent(x, val-> new ArrayList<>());
            graph.computeIfAbsent(y, val -> new ArrayList<>());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        return dfs(0, graph);
    }

    public int dfs(int source, HashMap<Integer, List<Integer>> graph) {
        seen.add(source);

        int nodes = 0;

        if (graph.get(source) == null) {
            return 1;
        }

        for (int neighbor: graph.get(source)) {
            if (!seen.contains(neighbor)) {
                nodes += dfs(neighbor, graph);
            }

        }

        return nodes + 1;
    }

    public static void main(String[] args) {
        ReachableNodesWithRestrictions rn = new ReachableNodesWithRestrictions();
    }
}
