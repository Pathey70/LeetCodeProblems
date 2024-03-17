class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[start]==target)
                return start;
            if(nums[end]==target)
                return end;
            if(nums[mid]==target)
            {
                return mid;
            }
            boolean left=false;
            if(nums[mid]<nums[start])
            {
                if(target>nums[start]||target<nums[mid])
                    left=true;
            }
            else
            {
                if(target<nums[mid]&&target>nums[start])
                    left=true;
            }
            if(!left)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        
        return -1;
    }
}