import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfComponentsInUndirectedGraph {
    boolean[] seen;
    public int countComponents(int n, int[][] edges) {
        seen = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                answer++;
                dfs(i, graph);
            }
        }
        return answer;
    }
    
    public void dfs(int source, Map<Integer, List<Integer>> graph){
        seen[source] = true;
        if (graph.get(source) == null) {
            return;
        }
        for (int i = 0; i < graph.get(source).size(); i++) {
            int currentNode = graph.get(source).get(i);
            if(!seen[currentNode]) {
                dfs(currentNode, graph);
            }
        }
    }
    
}
