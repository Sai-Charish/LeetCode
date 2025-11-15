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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode res = new TreeNode(val);
        if(root == null) return res;
        
        TreeNode temp = root;
        while(true){
            if(temp.val <= val){
                if(temp.right == null){
                    temp.right = res;
                    break;
                }
                else{
                    temp = temp.right;
                }
            }
            else{
                if(temp.left == null){
                    temp.left = res;
                    break;
                }
                else{
                    temp = temp.left;
                }
            }
        }
        return root;
    }
}
