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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();

        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode pp = precessor(curr.left,curr);
                if(pp.right != null){
                    pp.right = null;
                    curr = curr.right;
                }
                else{
                    res.add(curr.val);
                    pp.right = curr;
                    curr = curr.left;
                }
            }
        }

        return res;
    }

    public TreeNode precessor(TreeNode root,TreeNode curr){
        while(root.right != null && root.right != curr){
            root = root.right;
        }
        return root;
    }
}
