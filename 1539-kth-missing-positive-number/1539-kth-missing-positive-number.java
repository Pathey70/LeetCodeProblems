class Solution {
    public int findKthPositive(int[] nums, int k) {
        int ans=-1;
        int low=0;
        int high=nums.length-1;
        if(nums[high]-nums.length<k){
            return k+nums.length;
        }
        if(nums[low]>k)
            return k;
        k-=(nums[low]-1);
        while(low<high-1){
            int mid=low+(high-low)/2;
            if(nums[mid]-nums[low]-(mid-low)<k){
                k-=nums[mid]-nums[low]-(mid-low);
                low=mid;
            }
            else{
                high=mid;
            }
        }
        return k+nums[low];
    }
}