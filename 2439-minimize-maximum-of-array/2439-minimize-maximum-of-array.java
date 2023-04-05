class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max=nums[0];
        double leftSum=nums[0];
        for(int i=1;i<nums.length;i++){
            leftSum+=nums[i];
            max=Math.max(max,(int)Math.ceil(leftSum/(i+1)));
        }
        return max;
    }
}