import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        int[] seenIndices = new int[arr.length];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        seenIndices[start] = 1;

        while (!queue.isEmpty()) {
            int currentIndice = queue.poll();

            if (arr[currentIndice] == 0) {
                return true;
            }

            if (currentIndice + arr[currentIndice] < arr.length && seenIndices[currentIndice + arr[currentIndice]] == 0) {
                queue.add(currentIndice + arr[currentIndice]);
                seenIndices[currentIndice + arr[currentIndice]] = 1;
            }

            if (currentIndice - arr[currentIndice] >= 0 && seenIndices[currentIndice - arr[currentIndice]] == 0) {
                queue.add(currentIndice - arr[currentIndice]);
                seenIndices[currentIndice - arr[currentIndice]] = 1;
            }

        }
        return false;
    }
}
