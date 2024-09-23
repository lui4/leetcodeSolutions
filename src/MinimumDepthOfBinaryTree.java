class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return 1;
        }

        int rightMinDepth = minDepth(root.right);
        int leftMinDepth = minDepth(root.left);

        if (rightMinDepth == 0){
            return leftMinDepth + 1;
        } else if(leftMinDepth == 0) {
            return rightMinDepth + 1;
        } else {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        }
    }
}
