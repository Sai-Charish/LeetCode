/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root,k);
    }

    public boolean inorder(TreeNode root, int k){
        if(root == null){
            return false;
        }
        
        boolean left = inorder(root.left,k);

        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);

        boolean right = inorder(root.right,k);

        return left || right;
    }
}
