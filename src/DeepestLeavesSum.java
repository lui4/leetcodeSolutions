import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            int currentLevelSum = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }
            result = currentLevelSum;
        }
        return result;
    }
}
