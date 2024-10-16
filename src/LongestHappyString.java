import java.util.Arrays;

public class LongestHappyString {
    StringBuilder string = new StringBuilder();
    public String longestDiverseString(int a, int b, int c) {
        int[][] array = new int[][]{{a, 97},{b,98},{c,99}};
        recursion(array, (char) 0);

        return string.toString();
    }

    public void recursion(int[][] array, char lastChar){
        Arrays.sort(array, (n1, n2) -> n2[0]-n1[0]);

        if(array[0][0] == 0) return;

        int[] elem = array[0];

        int elementsToRemove = Math.min(elem[0], 2);

        if(lastChar == (char) elem[1]) {
            elem = array[2];

            if(elem[0] == 0) return;

            if(array[0][0] - array[1][0] <= 1) elementsToRemove = 1;
        }

        string.append((char) elem[1]);
        if(elementsToRemove == 2) string.append((char) elem[1]);

        elem[0] -= elementsToRemove;
        lastChar = (char) elem[1];

        recursion(array, lastChar);
    }

}
