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
    HashMap<Integer,Integer> hm;
    int pend;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);
        pend=postorder.length-1;
        return buildTree(inorder,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int inorder[],int postorder[],int start,int end)
    {
        if(start>end)
            return null;
        TreeNode root=new TreeNode(postorder[pend]);
        int index=hm.get(postorder[pend]);
        //System.out.println(start+" "+end+" "+index);
        pend--;
        root.right=buildTree(inorder,postorder,index+1,end);
        root.left=buildTree(inorder,postorder,start,index-1);
        
        return root;
            
    }
}