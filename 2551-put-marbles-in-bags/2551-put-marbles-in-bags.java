class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Long> minPQ=new PriorityQueue<>();
        PriorityQueue<Long> maxPQ=new PriorityQueue<>(1,Collections.reverseOrder());
        for(int i=1;i<weights.length;i++){
            long sum=0;
            sum+=weights[i]+weights[i-1];
            minPQ.add(sum);
            maxPQ.add(sum);
        }
        long ans=0;
        int i=0;
        while(i<k-1){
            ans+=(maxPQ.poll()-minPQ.poll());
            i++;
        }
        return ans;
    }
}