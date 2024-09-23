public class ClosestBinarySearchTreeValue {
    int result;
    public int closestValue(TreeNode root, double target) {
        result = Integer.MAX_VALUE;
        findClosestValue(root, target);
        return result;
    }

    public void updateResult(double target, int rootValue) {
        if (Math.abs(result-target) == Math.abs(rootValue - target)) {
            if (rootValue < result) {
                result = rootValue;
            }
            return;
        }

        if (Math.abs(result-target) > Math.abs(rootValue - target)) {
            result = rootValue;
        }
    }
    public void findClosestValue(TreeNode root, double target) {
        if (root == null) {return;}

        updateResult(target, root.val);

        if (root.val >= target) {
            if (root.right != null) {
                updateResult(target, root.right.val);
            }

            findClosestValue(root.left, target);
        } else {
            if (root.left != null) {
                updateResult(target, root.left.val);
            }
            findClosestValue(root.right, target);
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.right = node3;
        node2.left = node1;

        ClosestBinarySearchTreeValue cb = new ClosestBinarySearchTreeValue();
        System.out.println(cb.closestValue(node2, 0.14));
    }
}
