class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n];
        long total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
            if(i>=2*k){
                ans[i-k]=(int)   (total/(2*k+1));
                total-=nums[i-2*k];
            }
            if(i<k||i>n-k-1)
                ans[i]=-1;
        }
        return ans;
    }
}