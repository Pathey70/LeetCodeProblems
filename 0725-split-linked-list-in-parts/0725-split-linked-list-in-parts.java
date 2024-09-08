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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head==null)
        {
            ListNode[] ans=new ListNode[k];
            return ans;
            //return null;   
        }
        int count=1;
        ListNode temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
            count++;
        }
        int parts=count/k;
        int rparts=(count-k*parts);
        ListNode ans[]=new ListNode[k];
        temp=head;
        for(int i=0;i<rparts;i++)
        {
            ans[i]=temp;
            //System.out.println(ans[i].val);
            for(int j=0;j<parts;j++)
            {
                temp=temp.next;
            }
            ListNode temp2=temp.next;
            temp.next=null;
            temp=temp2;
        }
        for(int i=rparts;i<k;i++)
        {
            ans[i]=temp;
            //System.out.println(ans[i].val);
            for(int j=0;j<parts-1;j++)
            {
                temp=temp.next;
            }
            if(temp!=null)
            {   
                ListNode temp2=temp.next;
                temp.next=null;
                temp=temp2;
            }
        }
        return ans;
    }
}