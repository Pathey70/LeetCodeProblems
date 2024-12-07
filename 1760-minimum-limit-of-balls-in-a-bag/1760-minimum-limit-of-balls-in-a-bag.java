class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1;
        int high=1;
        for(int num:nums)
            high=Math.max(high,num);
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(checkPossible(nums,maxOperations,mid))
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    public boolean checkPossible(int nums[],int maxOperations,int target)
    {
        for(int num:nums)
        {
            maxOperations-=((int)Math.ceil((num*1.0)/target)-1);
            if(maxOperations<0)
                return false;
        }
        return true;
    }
}