import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.HashMap;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            max = Math.max(max, nums[i]);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (max <= mid && checkCondition(nums, mid, k, 0) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public int checkCondition(int[] nums, int mid, int k, int startingIndex) {
        if (startingIndex >= nums.length) {
            return 0;
        }

        int currentSubArraySum = 0;
        int index = startingIndex;

        while (index < nums.length && currentSubArraySum + nums[index] <= mid) {
            currentSubArraySum += nums[index];
            index++;
        }

        int amountOfSubArrays = checkCondition(nums, mid, k, index);

        return amountOfSubArrays + 1;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum ss = new SplitArrayLargestSum();
        System.out.println(ss.splitArray(new int[]{}, 2));
    }
}
