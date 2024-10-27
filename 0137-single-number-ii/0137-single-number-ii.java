class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            int bit=0;
            for(int j=0;j<nums.length;j++)
            {
                bit+=((nums[j]&1<<(i))>>i);
                bit%=3;
            }
            ans=(ans|bit<<i);
        }
        
        return ans;
    }
}