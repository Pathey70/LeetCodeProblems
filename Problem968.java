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
/*
    Integer variable used to keep track of 3 states 
    -1 indicates node is not in coverage currently (So camera must be placed on ancestor of the node)
    0 indicates node is in camera coverage (But camera is not at node)
    1 indicates camera is at node
    
    The idea is we don't need to place the camera in the leaf nodes. For all the non leaf nodes we have following 3 cases
    1) if any of children returns -1 (Not in camera coverage ) then we have to place camera at that node and we can increment the count of cameras and return 1
    2) if both of children return 0 (Indicates node is currently not in coverage) but camera can be placed on ancestor to keep the node under coverage hence return -1
    3) if any of children returns 1 means no need of camera at this node and we can return 0
*/
class Solution {
    int count=0;
    public int minCameraCover(TreeNode root) {
        int a1=traverse(root);
        if(a1==-1)
            count++;
        return count;
    }
    public int traverse(TreeNode root)
    {
        if(root.left==null&&root.right==null)
        {
            return -1;
        }
        int left=0;
        int right=0;
        if(root.left!=null)
        {
            left=traverse(root.left);
        }
        if(root.right!=null)
        {
            right=traverse(root.right);
        }
        if(left==0&&right==0)
        {
           return -1; //Case 2
        }
        else if(left==-1||right==-1)
        {
            count++;  //Case 1
            return 1;
        }
        else
        {
            return 0; //Case 3
        }
        
    }
}