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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans=new ArrayList<Integer>();
        PriorityQueue<ArrayList<Integer>> pq=new PriorityQueue<>(new ListComparator());
        int i=0;
        while(head!=null){
            ans.add(0);
            while(!pq.isEmpty()&&pq.peek().get(0)<head.val){
                List<Integer> li=pq.poll();
                ans.set(li.get(1),head.val);
            }
            ArrayList<Integer> li=new ArrayList<>();
            li.add(head.val);
            li.add(i);
            pq.add(li);
            i++;
            head=head.next;
        }
        int ret[]=new int[ans.size()];
        for(int j=0;j<ans.size();j++){
            ret[j]=ans.get(j);
        }
        return ret;
    }
}
class ListComparator implements Comparator<List<Integer>>{
    public int compare(List<Integer> l1,List<Integer> l2){
        return Integer.compare(l1.get(0),l2.get(0));
    }
}