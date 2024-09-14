class Solution {
    public int longestSubarray(int[] nums) {
        int max=nums[0];
        int maxFreq=1;
        int freq=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                freq=1;
                maxFreq=1;
            }
            else if(nums[i]==max)
            {
                if(nums[i]==nums[i-1])
                {
                    freq++;
                    maxFreq=Math.max(maxFreq,freq);
                }
                else{
                    freq=1;
                }
            }
            else{
                freq=0;
            }
        }
        
        return maxFreq;
    }
}