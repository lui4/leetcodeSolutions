import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1],a[1]));

        int index = 0;
        int answer = 0;
        while (index < boxTypes.length && truckSize > 0) {
            int amountOfBoxesToLoad = Math.min(boxTypes[index][0], truckSize);
            answer += amountOfBoxesToLoad*boxTypes[index][1];
            truckSize -= amountOfBoxesToLoad;
            index++;
        }

        return answer;
    }
}
