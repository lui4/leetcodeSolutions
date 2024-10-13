import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.Arrays;

public class UniquePathsII {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            Arrays.fill(obstacleGrid[i], -1);
        }

        return dp(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid);
    }

    public int dp(int row, int col, int[][] obstacleGrid) {
        if(row + col == 0) return 1;

        if(memo[row][col] != -1) return memo[row][col];

        int ans = 0;
        if(row > 0 && obstacleGrid[row-1][col] == 0){
            ans += dp(row-1, col, obstacleGrid);
        }

        if(col > 0 && obstacleGrid[row][col-1] == 0) {
            ans += dp(row, col-1, obstacleGrid);
        }


        memo[row][col] = ans;
        return ans;
    }
}
