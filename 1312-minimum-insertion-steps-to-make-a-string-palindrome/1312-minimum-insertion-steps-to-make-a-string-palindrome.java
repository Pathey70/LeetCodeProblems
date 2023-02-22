class Solution {
    public int minInsertions(String s) {
        int start=0;
        int end=s.length()-1;
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
                dp[i][j]=Integer.MAX_VALUE;
        }
        return findMin(s,start,end,dp);
    }
    public int findMin(String s,int start,int end,int dp[][]){
        if(start>=end)
            return 0;
        if(dp[start][end]!=Integer.MAX_VALUE)
            return dp[start][end];
        if(s.charAt(start)==s.charAt(end))
            dp[start][end]=findMin(s,start+1,end-1,dp);
        else
            dp[start][end]=1+Math.min(findMin(s,start+1,end,dp),findMin(s,start,end-1,dp));
        return dp[start][end];
    }
}