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
    int ind;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ind = inorder.length-1;
        return helper(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode helper(int [] inorder, int [] postorder,int low,int high){
        if(low > high) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[ind]);
        int mid = search(inorder,postorder[ind]);
        ind-=1;
        
        TreeNode right = helper(inorder,postorder,mid+1,high);
        TreeNode left = helper(inorder,postorder,low,mid-1);

        root.left = left;
        root.right = right;
        return root;
    }

    public int search(int [] inorder,int x){
        for(int i=0;i<inorder.length;i+=1){
            if(inorder[i] == x){
                return i;
            }
        }
        return -1;
    }
}
