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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        dfs(root,li,0);
        root.val=0;
        dfs2(root,li,0);
        return root;
    }
    public void dfs(TreeNode root,List<Integer> li,int depth)
    {
        if(root==null)
            return;
        if(li.size()==depth)
            li.add(0);
        li.set(depth,li.get(depth)+root.val);
        dfs(root.left,li,depth+1);
        dfs(root.right,li,depth+1);
    }
    public void dfs2(TreeNode root,List<Integer> li,int d)
    {
        if(root==null||d+1==li.size())
            return;
        int total=getTotal(root);
        if(root.left!=null)
            root.left.val=li.get(d+1)-total;
        if(root.right!=null)
            root.right.val=li.get(d+1)-total;
        dfs2(root.left,li,d+1);
        dfs2(root.right,li,d+1);
    }
    public int getTotal(TreeNode node)
    {
        int total=0;
        if(node.left!=null)
            total+=node.left.val;
        if(node.right!=null)
            total+=node.right.val;
        return total;
    }
}