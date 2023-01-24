class Solution {
    public long maximumSumScore(int[] nums) {
        long total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        long ans=Long.MIN_VALUE;
        long current=0;
        for(int i=0;i<nums.length;i++){
            current+=nums[i];
            ans=Math.max(ans,Math.max(total-current+nums[i],current));
        }
        return ans;
    }
}