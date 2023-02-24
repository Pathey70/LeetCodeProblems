class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> even=new PriorityQueue<>(Collections.reverseOrder());
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int t=nums[i];
            if(t%2!=0)
                t*=2;
            min=Math.min(t,min);
            even.add(t);
        }
        //System.out.println(even);
        int ans=even.peek()-min;
        while(true){
            int element=even.poll();
            ans=Math.min(ans,element-min);
            if(element%2==0){
                min=Math.min(min,element/2);
                
                even.add(element/2);
            }
            else{
                
                break;
            }
        }
        return ans;
    }
}