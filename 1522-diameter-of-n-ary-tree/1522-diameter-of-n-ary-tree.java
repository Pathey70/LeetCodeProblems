/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ans=0;
    public int diameter(Node root) {
        dfs(root);
        return ans;
    }
    public int dfs(Node root)
    {
        if(root==null)
            return 0;
        List<Node> children=root.children;
        int d1=0;
        int d2=0;
        for(Node child:children)
        {
            int cd=dfs(child);
            if(cd>d1)
            {
                d2=d1;
                d1=cd;
            }else if(cd>d2)
            {
                d2=cd;
            }
        }
        ans=Math.max(d1+d2,ans);
       // System.out.println(d1+" "+d2+" "+root.val);
        return d1+1;
    }
}