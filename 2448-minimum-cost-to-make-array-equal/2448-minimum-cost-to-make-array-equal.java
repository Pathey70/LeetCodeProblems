class Solution {
    public long minCost(int[] nums, int[] cost) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int low=min;
        int high=max;
        long ans=0;
        while(low<high){
            int mid=(low+high)/2;
            long cmid=cost(nums,cost,mid);
            long cmid_plusone=cost(nums,cost,mid+1);
            long cmid_minusone=cost(nums,cost,mid-1);
            //System.out.println(cmid+" "+cmid_minusone+" "+cmid_plusone);
            if(cmid<=cmid_minusone&&cmid<=cmid_plusone){
                ans=cmid;
                break;
            }
            else if(cmid>cmid_plusone){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            ans=Math.min(cmid_minusone,cmid_plusone);
        }
        return ans;
 
    }
    public long cost(int nums[],int cost[],int v){
        long ans=0;
        long one=1;
        for(int i=0;i<nums.length;i++){
            ans+=(Math.abs(nums[i]-v)*(one*cost[i]));
        }
        return ans;
    }
}