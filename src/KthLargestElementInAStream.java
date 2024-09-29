import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num: nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.remove();
            }
        }
    }

    public int add(int val) {
        heap.add(val);

        if (heap.size() > k) {
            heap.remove();
        }

        return heap.peek();
    }
}
