/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int max(int a, int b) {
    return a > b ? a : b;
}

int maxDepth(struct TreeNode* root, int* diameter) {
    if (root == NULL)
        return 0;
    
    int left_depth = maxDepth(root->left, diameter);
    int right_depth = maxDepth(root->right, diameter);
    
    // Update diameter if needed
    *diameter = max(*diameter, left_depth + right_depth);
    
    // Return the depth of the current node
    return 1 + max(left_depth, right_depth);
}

int diameterOfBinaryTree(struct TreeNode* root) {
    if (root == NULL)
        return 0;
    
    int diameter = 0; // Initialize diameter
    
    maxDepth(root, &diameter);
    
    return diameter;
}
