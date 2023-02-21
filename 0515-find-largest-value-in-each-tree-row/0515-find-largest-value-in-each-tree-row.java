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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        dfs(root,li,0);
        return li;
    }
    public void dfs(TreeNode root,List<Integer> li,int level){
        if(root==null)
            return;
        if(li.size()==level)
            li.add(root.val);
        else
            li.set(level,Math.max(li.get(level),root.val));
        dfs(root.left,li,level+1);
        dfs(root.right,li,level+1);
    }
}