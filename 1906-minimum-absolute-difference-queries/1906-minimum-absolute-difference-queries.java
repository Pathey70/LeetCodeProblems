class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n=nums.length;
        int freq[][]=new int[n+1][101];
        for(int i=0;i<n;i++){
            int x1=nums[i];
            for(int j=1;j<101;j++){
                freq[i+1][j]=freq[i][j];
                if(j==x1)
                    freq[i+1][j]++;
            }
        }
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int low=queries[i][0];
            int high=queries[i][1];
            ans[i]=findMinDiff(freq[low],freq[high+1]);
        }
        return ans;
    }
    public int findMinDiff(int left[],int right[]){
        int ans=Integer.MAX_VALUE;
        int prevIndex=-1;
        for(int i=0;i<left.length;i++){
            int diff=right[i]-left[i];
            if(diff>0){
                if(prevIndex!=-1){
                    ans=Math.min(ans,i-prevIndex);
                }
                prevIndex=i;
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}