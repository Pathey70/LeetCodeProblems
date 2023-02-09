class Solution {
    public int numWays(int steps, int arrLen) {
        long dp[][]=new long[steps+1][steps+1];
        for(int i=0;i<steps+1;i++){
            for(int j=0;j<steps+1;j++){
                dp[i][j]=-1;
            }
        }
        return (int)dfs(0,steps,arrLen,dp);
    }
    public long dfs(int i,int steps,int arrLen,long[][] dp){
        
        if(steps==0){
            if(i==0)
                return 1;
            else
                return 0;
        }
        if(i>=arrLen||i<0)
            return 0;
        if(dp[steps][i]!=-1)
            return dp[steps][i];
        else{
            int mod=1000000007;
            long one=0;
            dp[steps][i]=(dfs(i-1,steps-1,arrLen,dp)+dfs(i+1,steps-1,arrLen,dp)+dfs(i,steps-1,arrLen,dp))%mod;
            return dp[steps][i];
        }
        
    }
}