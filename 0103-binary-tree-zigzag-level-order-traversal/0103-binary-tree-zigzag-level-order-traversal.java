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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> levels=new LinkedList<>();
        queue.add(root);
        levels.add(0);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            int level=levels.poll();
            if(node==null)
                continue;
            if(ans.size()>level){
                ans.get(level).add(node.val);
            }
            else{
                List<Integer> li=new ArrayList<Integer>();
                li.add(node.val);
                ans.add(li);
            }
            queue.add(node.left);
            queue.add(node.right);
            levels.add(level+1);
            levels.add(level+1);
        }
        for(int i=1;i<ans.size();i+=2){
            List<Integer> li=ans.get(i);
            Collections.reverse(li);
        }
            
        return ans;
    }
}