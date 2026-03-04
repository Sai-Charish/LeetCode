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
    int ind = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode helper(int [] preorder,int [] inorder , int low,int high){
        if(low > high) return null;

        TreeNode root = new TreeNode(preorder[ind]);
        int mid = search(inorder,preorder[ind]);
        ind+=1;
        TreeNode left = helper(preorder,inorder,low,mid-1);
        TreeNode right = helper(preorder,inorder,mid+1,high);

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
