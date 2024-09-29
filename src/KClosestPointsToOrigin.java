import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (n1, n2) -> {
                    int n1EuclideanD = (int) (Math.pow(n1[0], 2) + Math.pow(n1[1], 2));
                    int n2EuclideanD = (int) (Math.pow(n2[0], 2) + Math.pow(n2[1], 2));

                    return n1EuclideanD - n2EuclideanD;
                });
        for (int i = 0; i < points.length; i++) {
            heap.add(points[i]);

            if (heap.size() > k){
                heap.remove();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(2^5);
    }
}
