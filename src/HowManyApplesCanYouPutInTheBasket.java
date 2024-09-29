import java.util.ArrayList;
import java.util.Arrays;

public class HowManyApplesCanYouPutInTheBasket {
    public int maxNumberOfApples(int[] weight) {
        int[] weights = new int[1001];

        for (int i = 0; i < weight.length; i++) {
            weights[weight[i]] += 1;
        }

        int basketSum = 0;
        int apples = 0;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < weights[i]; j++) {
                if (basketSum + i <= 5000) {
                    basketSum += i;
                    apples++;
                }
            }
        }
        return apples;
    }
}
