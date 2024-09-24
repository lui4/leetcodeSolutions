import java.util.Arrays;

public class MaxAreaOfIsland {
    int[][] directions;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                answer = Math.max(dfs(i, j, grid), answer);
            }
        }

        return answer;
    }
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    public int dfs(int sourceX, int sourceY, int[][] grid) {
        if(grid[sourceX][sourceY] == 0) {
            return 0;
        }

        grid[sourceX][sourceY] = 0;

        int areaOfIsland = 0;
        int newX;
        int newY;
        for (int[] direction : directions) {
            newX = sourceX + direction[0];
            newY = sourceY + direction[1];
            if (!isValidCoordinate(newX, newY) || grid[newX][newY] == 0) {
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
