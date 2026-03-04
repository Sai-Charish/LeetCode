/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if (root == null) return "#";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("#,");
                continue;
            }

            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    int start = 0;

    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;

        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            // left child
            if (!values[i].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.left);
            }
            i++;

            // right child
            if (!values[i].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.right);
            }
            i++;
        }

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
