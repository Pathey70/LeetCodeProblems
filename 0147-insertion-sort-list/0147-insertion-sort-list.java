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
    public ListNode insertionSortList(ListNode head) {
        ListNode node=new ListNode(Integer.MIN_VALUE);
        node.next=head;
        ListNode start=head.next;
        ListNode startPrev=head;
        while(start!=null)
        {
            int val=start.val;
            ListNode node1=node;
            ListNode node2=node1.next;
            ListNode next=start.next;
            while(val>node2.val)
            {
                node1=node1.next;
                node2=node2.next;
            }
            if(node2!=start)
            {
                startPrev.next=next;
                node1.next=start;
                start.next=node2;
            }
            else{
                startPrev=start;
            }
            start=next;
        }
        return node.next;
    }
}