class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            // Case 1 & 2: one or zero child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: two children
            TreeNode pred = leftGreatest(root.left);
            root.val = pred.val;
            root.left = deleteNode(root.left, pred.val);
        }

        return root;
    }

    public TreeNode leftGreatest(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}

