class Solution {
    public int minPatches(int[] nums, int n) {
        int ans=0;
        long sum=1;
        int i=0;
        while(sum<=n){
            if(i<nums.length&&nums[i]<=sum)
            {
                sum+=nums[i];
                i++;
            }
            else{
                sum+=sum;
                ans++;
            }
        }
        return ans;
    }
}