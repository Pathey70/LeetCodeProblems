class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int x1=matrix[i][j];
                if(x1==1&&j>0)
                {
                    dp[i][j]=dp[i][j-1]+x1;
                }else{
                    dp[i][j]=x1;
                }
                int minW=dp[i][j];
                
                for(int k=i;k>=0;k--)
                {
                    minW=Math.min(minW,dp[k][j]);
                    if(minW>=(i-k+1))
                    {
                        ans++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return ans;
    }
}