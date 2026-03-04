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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] d = new int[1];
        dia(root,d);
        return d[0];
    }

    public int dia(TreeNode root,int [] maxi){
        if(root == null) return 0;

        int left = dia(root.left,maxi);
        int right = dia(root.right,maxi);

        maxi[0] = Math.max(left+right,maxi[0]);

        return 1+ Math.max(left,right);
    }
}
