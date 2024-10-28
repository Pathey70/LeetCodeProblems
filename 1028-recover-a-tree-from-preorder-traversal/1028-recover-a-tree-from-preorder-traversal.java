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
    public TreeNode recoverFromPreorder(String traversal) {
        
        
        return generateTree(traversal,0,traversal.length(),1);
        
    }
    public TreeNode generateTree(String traversal,int start,int end,int d)
    {
        if(start>end)
            return null;
        TreeNode root=new TreeNode(getNumber(traversal,start,end));
        int len=0;
        int ls=-1;
        int rs=-1;
        for(int j=start;j<end;j++)
        {
            if(traversal.charAt(j)=='-')
                len++;
            else
            {
                if(len==d)
                {
                    if(ls<0)
                        ls=j;
                    else if(rs<0)
                    {
                        rs=j;
                        break;
                    }
                }
                len=0;
            }
        }
       // System.out.println(ls+" "+rs);
        if(ls!=-1&&rs!=-1)
        {
            root.left=generateTree(traversal,ls,rs,d+1);
            root.right=generateTree(traversal,rs,end,d+1);
        }
        else if(ls!=-1)
        {
            root.left=generateTree(traversal,ls,end,d+1);
        }
        
        
        return root;
    }
    
    public int getNumber(String s,int idx,int end)
    {
        int i=idx;
        while(i<end&&s.charAt(i)>='0'&&s.charAt(i)<='9')
            i++;
        return Integer.parseInt(s.substring(idx,i));
    }
}