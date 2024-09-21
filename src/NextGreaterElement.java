import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }

        for (int i = nums2.length - 1;i >= 0; i--) {

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }

            if (hashMap.getOrDefault(nums2[i], -1) != -1) {
                nums1[hashMap.get(nums2[i])] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums2[i]);
        }

        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        System.out.println(Arrays.toString(nge.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}))); // [4,1,2], nums2 = [1,3,4,2]
    }
}
