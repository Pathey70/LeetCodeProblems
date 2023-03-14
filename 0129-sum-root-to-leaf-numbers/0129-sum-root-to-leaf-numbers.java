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
    public int ans=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        sum(root,0);
        return ans;
    }
    public void sum(TreeNode root,int val)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
             ans+=(val*10+root.val);
        else
        {
            //System.out.println(val+root.val);
            //depth++;
            sum(root.left,val*10+root.val);
            sum(root.right,val*10+root.val);
        }
    }
}