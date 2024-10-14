import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        long score = 0;
        while (k-- > 0){
            int elem = pq.poll();
            score += elem;
            pq.offer((elem+2)/3);
        }

        return score;
    }
}
