import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            maze[currentNode[0]][currentNode[1]] = '+';
            int currentSteps = currentNode[2];

            if (isExit(currentNode[0],currentNode[1], entrance, maze)){
                return currentSteps;
            }

            for (int[] direction : directions) {
                int newX = currentNode[0] + direction[0];
                int newY = currentNode[1] + direction[1];

                if (isValid(newX, newY, maze)) {
                    queue.add(new int[]{newX, newY, currentSteps+1});
                    maze[newX][newY] = '+'; // neccesary, otherwise a lot of elements get put in the queue for no reason
                }
            }
        }

        return -1;
    }

    public boolean isValid(int x, int y, char[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.';
    }
    public boolean isExit(int positionX, int positionY, int[] entrance,char[][] maze) {
        return (positionX == maze.length - 1 || positionX == 0 || positionY == 0 || positionY == maze[0].length - 1) && !(entrance[0] == positionX && entrance[1] == positionY);
    }
}
