class Solution {
    public int missingElement(int[] nums, int k) {
        int ans=-1;
        int low=0;
        int high=nums.length-1;
        if(nums[high]-nums[low]-high<k){
            return k+nums[low]+high;
        }
        while(low<high-1){
            int mid=low+(high-low)/2;
            if(nums[mid]-nums[low]-(mid-low)<k){
                k-=nums[mid]-nums[low]-(mid-low);
                low=mid;
            }
            else{
                high=mid;
            }
            //System.out.println(low+" "+high+" "+mid+" "+k);
        }
        return k+nums[low];
    }
}