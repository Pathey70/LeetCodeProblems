class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]==0){
                    if(dfs(grid,i,j,visited,m,n)){
                        ans++;
                        //System.out.println(i+" "+j);
                    }
                    visited[i][j]=true;
                }
               
            }
        }
        return ans;
    }
    public boolean dfs(int grid[][],int i,int j,boolean visited[][],int m,int n){
        if(i<0||j<0||i==m||j==n)
            return false;
        if(grid[i][j]==1||visited[i][j])
            return true;
        visited[i][j]=true;
        boolean a1=dfs(grid,i+1,j,visited,m,n);
        boolean a2=dfs(grid,i-1,j,visited,m,n);
        boolean a3=dfs(grid,i,j+1,visited,m,n);
        boolean a4=dfs(grid,i,j-1,visited,m,n);
        return a1&&a2&&a3&&a4;
    }
}