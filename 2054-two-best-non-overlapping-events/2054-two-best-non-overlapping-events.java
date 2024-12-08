class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n=events.length;
        int dp[]=new int[n];
        dp[n-1]=events[n-1][2];
        for(int i=n-2;i>=0;i--)
        {
            dp[i]=Math.max(dp[i+1],events[i][2]);
        }
        int ans=0;
        for(int i=0;i<events.length;i++)
        {
            int e=events[i][1];
            ans=Math.max(ans,events[i][2]);
            int left=i+1;
            int right=n-1;
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(events[mid][0]>e)
                {
                    ans=Math.max(ans,dp[mid]+events[i][2]);
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return ans;
    }
}