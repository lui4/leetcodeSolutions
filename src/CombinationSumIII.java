import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();

        backtrack(answer, 1,new ArrayList<>(), 0, n, k);

        return answer;
    }

    public void backtrack(List<List<Integer>> answer, int startingIndex,List<Integer> currentElements, int currentSum, int n, int k) {
        if (currentSum == n && currentElements.size() == k) {
            answer.add(new ArrayList<>(currentElements));
            return;
        }

        for (int i = startingIndex; i < 10; i++) {
            if (currentElements.size() + 1 <= k && currentSum + i <= n) {
                currentElements.add(i);
                currentSum += i;

                backtrack(answer, i + 1, currentElements, currentSum, n, k);

                currentSum -= i;
                currentElements.remove(currentElements.size() - 1);

            }
        }
    }
}
