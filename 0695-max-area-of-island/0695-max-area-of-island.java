class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    ans=Math.max(ans,dfs(i,j,visited,grid,m,n));
                }
            }
        }
        
        return ans;
    }
    public int dfs(int i,int j,boolean[][] visited,int[][] grid,int m,int n){
        if(i<0||j<0||i==m||j==n||visited[i][j]||grid[i][j]==0)
            return 0;
        int count=1;
        visited[i][j]=true;
        count+=(dfs(i+1,j,visited,grid,m,n)+
        dfs(i-1,j,visited,grid,m,n)+
        dfs(i,j+1,visited,grid,m,n)+
        dfs(i,j-1,visited,grid,m,n));
        return count;
    }
}