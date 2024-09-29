import java.util.Arrays;

public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1;
        int right = 0;

        for (int sweatness: sweetness) {
            right += sweatness;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkConditions(sweetness, k + 1 ,mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public boolean checkConditions(int[] sweetness, int people, int minSweetness) {
        int currentPeopleWithChocolate = 0;
        int currentSum = 0;

        for (int sweetnes: sweetness) {
            currentSum += sweetnes;

            if (currentSum >= minSweetness) {
                currentPeopleWithChocolate += 1;
                currentSum = 0;
            }
        }

        return currentPeopleWithChocolate >= people;
    }
}
