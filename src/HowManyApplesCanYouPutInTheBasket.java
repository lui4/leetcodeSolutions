import java.util.ArrayList;
import java.util.Arrays;

public class HowManyApplesCanYouPutInTheBasket {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int basketSum = 0;

        int index = 0;
        while (index < weight.length && basketSum < 5000) {
            if (basketSum + weight[index] <= 5000) {
                basketSum += weight[index];
            } else {
                break;
            }
            index++;
        }

        return index;
    }
}
