/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode head1=head;
        ListNode head2=head;
        while(head1!=null&&head2!=null&&head2.next!=null)
        {
            
            head1=head1.next;
            head2=head2.next.next;
            if(head1==head2)
            {
                ListNode head3=head;
                while(head3!=head1)
                {
                    head3=head3.next;
                    head1=head1.next;
                    
                }
                return head3;
            }
        }
        return null;
    }
}