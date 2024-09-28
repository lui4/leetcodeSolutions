import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int arraySum = 0;

        for (int pile: piles) {
            arraySum += pile;
            heap.add(pile);
        }

        for (int i = 0; i < k; i++) {
            int currentMax = heap.remove();
            arraySum -= currentMax / 2;
            heap.add(currentMax - (currentMax / 2));
        }

        return arraySum;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal rs = new RemoveStonesToMinimizeTheTotal();
        System.out.println(rs.minStoneSum(new int[]{10000}, 10000));
    }
}
