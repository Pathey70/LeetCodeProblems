/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return checkPath(head,root);
    }
    
    public boolean checkPath(ListNode head,TreeNode node)
    {
        if(dfs(head,node))
            return true;
        if(node==null)
            return false;
        return checkPath(head,node.left)||checkPath(head,node.right);
    }
    
    public boolean dfs(ListNode node,TreeNode node1)
    {
        if(node==null)
            return true;
        if(node1==null)
            return false;
        if(node.val==node1.val)
            return dfs(node.next,node1.left)||dfs(node.next,node1.right);
        else
            return false;
    }
}