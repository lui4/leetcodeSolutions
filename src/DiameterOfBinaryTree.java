public class DiameterOfBinaryTree {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        dfs(root);

        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxPathLeft = dfs(node.left);
        int maxPathRight = dfs(node.right);

        result = Math.max(result, maxPathRight + maxPathLeft);
        return Math.max(maxPathLeft, maxPathRight) + 1;

    }
}
