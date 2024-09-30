import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(0);

        backtrack(answer, graph, curr);

        return answer;
    }

    public void backtrack(List<List<Integer>> answer, int[][] graph, List<Integer> currentPath) {
        int currentNode = currentPath.get(currentPath.size() - 1);
        if (currentNode == graph.length - 1) {
            answer.add(currentPath);
            return;
        }

        for (int i = 0; i < graph[currentNode].length; i++) {
            currentPath.add(graph[currentNode][i]);
            backtrack(answer, graph, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }

}
