import java.util.Arrays;

public class MaxAreaOfIsland {
    boolean[][] seen;
    int[][] directions;
    public int maxAreaOfIsland(int[][] grid) {
        directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        seen = new boolean[grid.length][grid[0].length];

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                answer = Math.max(dfs(i, j, grid), answer);
            }
        }

        return answer;
    }
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < seen.length && y >= 0 && y < seen[0].length;
    }
    public int dfs(int sourceX, int sourceY, int[][] grid) {
        if(grid[sourceX][sourceY] == 0 || seen[sourceX][sourceY]) {
            return 0;
        }

        seen[sourceX][sourceY] = true;

        int areaOfIsland = 0;
        int newX;
        int newY;
        for (int[] direction : directions) {
            newX = sourceX + direction[0];
            newY = sourceY + direction[1];
            if (!isValidCoordinate(newX, newY) || seen[newX][newY]) {
                continue;
            }
            areaOfIsland += dfs(newX, newY, grid);
        }
        return areaOfIsland + 1;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland ar = new MaxAreaOfIsland();
        System.out.println(ar.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}
