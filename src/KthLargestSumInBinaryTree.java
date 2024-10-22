import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> bfs = new LinkedList<>();
        PriorityQueue<Long> answer = new PriorityQueue<>();

        bfs.add(root);

        while (!bfs.isEmpty()) {
            int qLength = bfs.size();
            long lvlSum = 0;

            for (int i = 0; i < qLength; i++) {
                TreeNode elem = bfs.poll();
                lvlSum += elem.val;
                if(elem.left != null) bfs.add(elem.left);
                if(elem.right != null) bfs.add(elem.right);
            }
            answer.add(lvlSum);
            if(answer.size() > k) answer.poll();
        }

        return answer.size() >= k ? answer.peek() : -1;
    }
}
