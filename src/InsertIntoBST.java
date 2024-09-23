public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        insertNode(root, val);
        return root;
    }

    public void insertNode(TreeNode root, int val) {
        if (root == null) {return;}

        if (root.val >= val) {
            TreeNode left = root.left;

            if (left == null) {
                root.left = new TreeNode(val);
            } else {
                insertNode(root.left, val);
            }
        } else { // go right
            TreeNode right = root.right;

            if (right == null) {
                root.right = new TreeNode(val);
            } else {
                insertNode(root.right, val);
            }
        }

    }
}
