/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isUnivalTree(struct TreeNode* root) {
  
    struct TreeNode *temp = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    temp = root;
    if (root == NULL)
        return true;

    int check = temp->val;
    
    if(root->left != NULL && root->left->val != check)
        return false;
    if(root->right != NULL && root->right ->val != check)
        return false;
       
    return isUnivalTree(temp->left) && isUnivalTree(temp->right);
    
}
