import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindIfPathExistsInGraph {
    boolean[] seen;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // convert edges into hashmap
        seen = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if(hashMap.getOrDefault(x, null) == null) {
                hashMap.put(x, new ArrayList<>());
            }
            if (hashMap.getOrDefault(y, null) == null) {
                hashMap.put(y, new ArrayList<>());
            }
            hashMap.get(x).add(y);
            hashMap.get(y).add(x);
        }
        return dfs(source, destination, hashMap);
    }

    public boolean dfs(int source, int destination, HashMap<Integer, ArrayList<Integer>> hashMap) {
        seen[source] = true;
        if (source == destination) {
            return true;
        }

        ArrayList<Integer> edges = hashMap.getOrDefault(source, null);

        if (edges == null) {return false;}

        boolean result = false;

        for (int i = 0; i < edges.size(); i++) {
            if (seen[edges.get(i)]) {
                continue;
            }
            result = result || dfs(edges.get(i), destination, hashMap);
        }

        return result;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph fp = new FindIfPathExistsInGraph();

        System.out.println(fp.validPath(10, new int[][]{{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}},7,5));
        System.out.println(new ArrayList<>());
    } // {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}}
}
