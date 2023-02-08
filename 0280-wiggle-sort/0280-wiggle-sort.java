class Solution {
    public void wiggleSort(int[] nums) {
        int i=1;
        while(i<nums.length){
            if((i%2!=0&&nums[i]<nums[i-1])||(i%2==0&&nums[i]>nums[i-1])){
                int t=nums[i];
                nums[i]=nums[i-1];
                nums[i-1]=t;
            }
            i++;
        }
        
    }
}