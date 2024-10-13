import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> flightMap = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            flightMap.computeIfAbsent(flights[i][0],val -> new ArrayList<>());

            flightMap.get(flights[i][0]).add(new int[]{flights[i][2], flights[i][1]}); // price, dest
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2[0]));
        // { distance, node, nodesUsed}
        int[] distances = new int[n];

        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[src] = 0;

        heap.add(new int[]{0, src, 0});

        while(!heap.isEmpty()) {
            int[] elem = heap.poll();
            int node = elem[1];
            int distance = elem[0];
            int steps = elem[2];

            if(steps> distances[node] || steps > k+1) continue;

            if(node == dst) return distance;
            distances[node] = steps;

            for (int[] neighbor: flightMap.getOrDefault(node, new ArrayList<>())) {
                heap.add(new int[]{distance + neighbor[0], neighbor[1], steps+1});
            }
        }

        return -1;
    }
}
