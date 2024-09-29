import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num: nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }
}
