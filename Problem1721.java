
 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class Problem1721 {


    public ListNode swapNodes(ListNode head, int k) {
        ListNode head1=head;
        for(int i=0;i<k-1;i++)
        {
            head=head.next;
        }
        ListNode swap1=head;
        ListNode swap2=head1;
        while(head.next!=null)
        {
            head=head.next;
            swap2=swap2.next;
        }
        int t1=swap1.val;
        swap1.val=swap2.val;
        swap2.val=t1;
        return head1;
    }
}