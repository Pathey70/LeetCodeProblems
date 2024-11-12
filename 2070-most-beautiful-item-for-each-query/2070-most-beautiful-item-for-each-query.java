class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b)->a[0]-b[0]);
        int n=items.length;
        int dp[]=new int[n];
        dp[0]=items[0][1];
        for(int i=1;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],items[i][1]);
        }
        int m=queries.length;
        int ans[]=new int[m];
        for(int i=0;i<m;i++)
        {
            int low=0;
            int high=n-1;
            int idx=-1;
            while(low<=high)
            {
                int mid=(high+low)/2;
                if(items[mid][0]<=queries[i])
                {
                    idx=mid;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            if(idx!=-1)
                ans[i]=dp[idx];
        }
        return ans;
    }
}