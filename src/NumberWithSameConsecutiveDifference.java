import java.util.ArrayList;

public class NumberWithSameConsecutiveDifference {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> answer = new ArrayList<>();

        backtrack(n, k, answer, new StringBuilder());

        int[] ans = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }

    public void backtrack(int n, int k, ArrayList<Integer> answer, StringBuilder currentInteger) {
        if (currentInteger.length() == n) {
            answer.add(Integer.valueOf(currentInteger.toString()));
            return;
        }

        int startingIndex = currentInteger.isEmpty() ? 1 : 0;

        for (int i = startingIndex; i < 10; i++) {
            if(currentInteger.isEmpty() || Math.abs(Integer.parseInt(currentInteger.substring(currentInteger.length() - 1)) - i) == k) {
                currentInteger.append(i);

                backtrack(n, k, answer, currentInteger);

                currentInteger.deleteCharAt(currentInteger.length() - 1);
            }
        }
    }
}
