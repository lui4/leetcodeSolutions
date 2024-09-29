public class FindTheSmallestDivisorGivenATreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000; // max bound given (saves us found from finding the actual max element in nums)

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkCondition(nums, mid, threshold)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean checkCondition(int[] nums, int divisor, int treshold) {
        int sum = 0;
        for (double num: nums) {
            sum += (int) Math.ceil(num / divisor);
        }
        return sum <= treshold;
    }

    public static void main(String[] args) {
        FindTheSmallestDivisorGivenATreshold fs = new FindTheSmallestDivisorGivenATreshold();
        System.out.println(fs.smallestDivisor(new int[]{21212,10101,12121}, 1000000));
    }
}
