import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
    int windowSize;
    int windowSum;
    Queue<Integer> queue;
    public MovingAverageFromDataStream(int size) {
        windowSize = size;
        windowSum = 0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == windowSize) {
            int removedQueueEntry = queue.poll();
            windowSum -= removedQueueEntry;
            queue.offer(val);
            windowSum += val;
        } else {
            queue.offer(val);
            windowSum += val;
        }
        return (double) windowSum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream ma = new MovingAverageFromDataStream(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }
}
