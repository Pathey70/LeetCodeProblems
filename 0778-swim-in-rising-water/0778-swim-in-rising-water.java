class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=Integer.MAX_VALUE;
        
        dfs(grid,0,0,0,n,dp);
        return dp[n-1][n-1];
    }
    public void dfs(int grid[][],int x,int y,int maxPathCost,int n,int dp[][]){
        if(x<0||y<0||x==n||y==n||maxPathCost>=dp[x][y])
            return;
        dp[x][y]=Math.max(grid[x][y],maxPathCost);
        maxPathCost=dp[x][y];
        dfs(grid,x,y+1,maxPathCost,n,dp);
        dfs(grid,x,y-1,maxPathCost,n,dp);
        dfs(grid,x+1,y,maxPathCost,n,dp);
        dfs(grid,x-1,y,maxPathCost,n,dp);
       
    }
}