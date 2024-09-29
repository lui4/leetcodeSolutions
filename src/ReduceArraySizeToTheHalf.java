import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> occ = new HashMap<>();

        for (int elem: arr) {
            occ.put(elem, occ.getOrDefault(elem, 0) + 1);
        }

        int[] frequencies = new int[occ.values().size()];

        int index = 0;
        for (int frequency: occ.values()) {
            frequencies[index] = frequency;
            index++;
        }

        Arrays.sort(frequencies);
        int ans = 0;
        int removedSlots = 0;

        index = frequencies.length - 1;
        while (index >= 0 && removedSlots < arr.length / 2) {
            removedSlots += frequencies[index];
            ans++;
            index--;
        }
        return ans;
    }
}
