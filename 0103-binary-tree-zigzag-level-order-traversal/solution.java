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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        boolean lr = false;

        if(root == null){
            return res;
        }  

        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> cur = new ArrayList<>();
            for(int i=0;i<size;i+=1){
                TreeNode temp = que.poll();
                cur.add(temp.val);
                if(temp.right != null){
                    que.add(temp.right);
                }
                if(temp.left != null){
                    que.add(temp.left);
                }
            }
            if(!lr){
                Collections.reverse(cur);
            }
            res.add(cur);
            lr = !lr;
        }

        return res;
    }
}
