class Solution {
    public boolean canSortArray(int[] nums) {
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]>nums[i])
                {
                    if(calculateBits(nums[j])!=calculateBits(nums[i]))
                        return false;
                }
            }
        }
        return true;
    }
    
    public int calculateBits(int n)
    {
        int count=0;
        while(n!=0)
        {
            count+=n%2;
            n/=2;
        }
        return count;
    }
}