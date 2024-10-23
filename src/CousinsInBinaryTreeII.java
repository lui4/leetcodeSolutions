import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTreeII {
    class Item{
        TreeNode parent;
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int previousLevelSum = root.val;

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < qSize; i++) {
                TreeNode curr = queue.poll();

                curr.val = previousLevelSum - curr.val;

                int siblingSum = (curr.right == null ? 0 : curr.right.val) + (curr.left == null ? 0 : curr.left.val);

                if(curr.right != null) {
                    currentLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    queue.offer(curr.right);
                }

                if(curr.left != null) {
                    currentLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    queue.offer(curr.left);
                }

            }
            previousLevelSum = currentLevelSum;
        }
        return root;
    }
}
