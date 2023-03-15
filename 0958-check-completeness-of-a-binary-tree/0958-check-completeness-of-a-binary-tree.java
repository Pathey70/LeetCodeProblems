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
    int heightFinal=0;
    boolean leaf=false;
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        boolean stoppage=false;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(stoppage){
                if(node.left!=null||node.right!=null)
                    return false;
            }
            else{
                if(node.left!=null)
                    queue.add(node.left);
                else 
                    stoppage=true;
                
                if(node.right!=null)
                {
                    if(stoppage)
                        return false;
                    queue.add(node.right);
                }
                else{
                    stoppage=true;
                }
            }
        }
        return true;
    }
    
}