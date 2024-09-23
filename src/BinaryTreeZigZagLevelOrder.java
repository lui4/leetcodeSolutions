import java.util.*;

public class BinaryTreeZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        int queueSize;
        int level = 0;
        TreeNode node;

        while (!queue.isEmpty()) {
            queueSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                if (level % 2 == 0) { // links nach rechts
                    node = queue.pollFirst();
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }

                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    node = queue.pollLast();
                    if(node.right != null) {
                        queue.offerFirst(node.right);
                    }

                    if(node.left != null) {
                        queue.offerFirst(node.left);
                    }

                }

                tempList.add(node.val);
            }
            level++;
            result.add(tempList);
        }

        return result;
    }
}
