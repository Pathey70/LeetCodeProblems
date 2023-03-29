class Solution {
    int ans=0;
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        }
        Arrays.sort(satisfaction);
        return rec(satisfaction,0,1,dp);
        
    }
    public int rec(int[] satisfaction,int i,int o,int dp[][]){
        if(i==satisfaction.length)
            return 0;
        if(dp[i][o]>=0)
            return dp[i][o];
        dp[i][o]=Math.max(o*satisfaction[i]+rec(satisfaction,i+1,o+1,dp),rec(satisfaction,i+1,o,dp));
        //System.out.println(dp[i][o]+" "+i+" "+o);
        return dp[i][o];
    }
}