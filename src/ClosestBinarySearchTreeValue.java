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

}
