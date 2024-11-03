class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums)
            pq.add(num);
        for(int i=0;i<k;i++)
        {
            int elem=pq.poll();
            ans+=elem;
            pq.add((int)Math.ceil(elem/3.0));
        }
        return ans;
    }
}