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
    int smallest;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        smallest=Integer.MAX_VALUE;
        dfs(root,p);
        return succs;
    }
    public void dfs(TreeNode root,TreeNode p)
    {
        if(root==null)
            return;
        if(root!=p)
        {
            if(root.val>p.val&&root.val<smallest)
            {
                smallest=root.val;
                succs=root;
            }
        }
        dfs(root.left,p);
        dfs(root.right,p);
    }
}