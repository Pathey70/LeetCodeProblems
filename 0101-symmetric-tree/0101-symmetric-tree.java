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
    public boolean symmetric(TreeNode left,TreeNode right)
    {
        if(left!=null&&right!=null)
        {
            if(left.val==right.val)
                return (symmetric(left.left,right.right)&&symmetric(left.right,right.left));
            else 
                return false;
        }
        else if(left==null&&right!=null)
        {
            return false;
        }
        else if(right==null&&left!=null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        if(root.left!=null&&root.right!=null)
        {
            return symmetric(root.left,root.right);
        }
        if(root.left==null&&root.right==null)
            return true;
        return false;
    }
}