import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length;i++) {
            int query = queries[i];
            int left = 0;
            int right = nums.length - 1;
            boolean foundElem = false;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == query) {
                    answer[i] = mid + 1;
                    foundElem = true;
                    break;
                }

                if (nums[mid] > query) {
                    right = mid - 1;
                } else {
                    left = mid +1;
                }
            }
            if (!foundElem) {
                answer[i] = left;
            }


        }
        return answer;
    }
}
