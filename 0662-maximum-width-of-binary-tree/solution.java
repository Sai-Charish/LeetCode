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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> que = new LinkedList<>();

        int max = 0;
        
        que.add(new Pair(root,1L));

        while(!que.isEmpty()){
            int size = que.size();
            long start = que.peek().ind;
            long end = start;
            for(int i=0;i<size;i+=1){
                Pair temp = que.poll();
                TreeNode node = temp.node;
                long ind = temp.ind;

                if(node.left != null){
                    que.add(new Pair(node.left,ind*2));
                }

                if(node.right != null){
                    que.add(new Pair(node.right,(ind*2)+1));
                }

                end = Math.max(end,ind);
            }

            int diff =(int) (end - start + 1);

            max = Math.max(max , diff);

        }

        return max;
    }
}

class Pair {
    TreeNode node;
    long ind;

    public Pair(TreeNode node,long ind){
        this.node = node;
        this.ind = ind;
    }
}
