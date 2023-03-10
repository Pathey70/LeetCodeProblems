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

    List<Integer> li=new ArrayList<>();
    
    public Solution(ListNode head) {
        while(head!=null){
            li.add(head.val);
            head=head.next;
        }
    }
    
    public int getRandom() {
        int min=0;
        int max=li.size()-1;
        return li.get((int)Math.floor(Math.random() *(max - min + 1) + min));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */