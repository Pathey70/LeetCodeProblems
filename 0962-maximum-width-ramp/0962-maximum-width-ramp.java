class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int minIdx=arr[0][1];
        int ans=0;
        for(int i=1;i<n;i++)
        {
            ans=Math.max(ans,arr[i][1]-minIdx);
            minIdx=Math.min(arr[i][1],minIdx);
        }
        return ans;
    }
}