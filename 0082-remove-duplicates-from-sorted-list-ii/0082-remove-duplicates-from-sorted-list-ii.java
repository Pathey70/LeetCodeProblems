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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode prev=new ListNode(-101);
        prev.next=head;
        ListNode node1=head;
        ListNode prevCp=prev;
        while(node1!=null&&node1.next!=null)
        {
            ListNode node2=node1.next;
            while(node2!=null&&node2.val==node1.val)
                node2=node2.next;
            if(node2!=node1.next)
            {
                //Delete condition
                prev.next=node2;
                node1=node2;
                //prev=node2;
            }else{
                prev=node1;
                node1=node1.next;
            }
        }
        return prevCp.next;
        
    }
}