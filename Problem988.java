
 
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class Problem988 {
    String ans;
    public String smallestFromLeaf(TreeNode root) {
        
        dfs(root,new StringBuilder());
        return ans;
  
    }
    public void dfs(TreeNode node,StringBuilder sb)
    {
        if(node==null)
            return;
        
        char c=(char ) (node.val+97);
        sb.append(c);
        if(node.left==null&&node.right==null)
        {
           
            sb.reverse();
            if(ans==null||sb.toString().compareTo(ans)<0)
                ans=sb.toString();
            
            return;
        }
        dfs(node.left,new StringBuilder(sb));
        dfs(node.right,new StringBuilder(sb));
            
    }
}