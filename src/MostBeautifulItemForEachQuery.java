import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemForEachQuery {
    //2070
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(n -> n[0]));

        int maxBeauty = 0;
        for (int i = 0; i < items.length; i++) {
            maxBeauty = Math.max(items[i][1], maxBeauty);
            items[i][1] = maxBeauty;
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = items.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if(items[mid][0] <= queries[i]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            answer[i] = right == -1 ? 0 : items[right][1];
        }
        return answer;
    }
}
