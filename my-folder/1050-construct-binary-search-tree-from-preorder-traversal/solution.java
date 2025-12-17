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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE);
    }

    public TreeNode helper(int [] arr , int ub){
        if(i == arr.length || arr[i] > ub){
            return null;
        }

        TreeNode root = new TreeNode(arr[i]);
        i+=1;
        
        TreeNode left = helper(arr,root.val);
        TreeNode right = helper(arr,ub);

        root.left = left;
        root.right = right;

        return root;
    }
}
