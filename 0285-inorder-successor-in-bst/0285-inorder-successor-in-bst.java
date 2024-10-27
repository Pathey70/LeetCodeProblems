/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode succs;
    boolean found;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        found=false;
        inOrder(root,p);
        return succs;
    }
    public void inOrder(TreeNode root,TreeNode p)
    {
        if(root==null)
            return;
        inOrder(root.left,p);
        if(found)
        {
            succs=root;
            found=false;
        }
        if(root==p)
        {
            found=true;
        }
        inOrder(root.right,p);
    }
    
    
    
    
}