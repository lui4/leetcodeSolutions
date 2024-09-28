import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cost = 0;

        for (int stick: sticks) {
            heap.add(stick);
        }

        while (heap.size() > 1) {
            int firstMinStick = heap.remove();
            int secondMindStick = heap.remove();
            cost += firstMinStick + secondMindStick;
            heap.add(firstMinStick + secondMindStick);
        }
        return cost;
    }
}
