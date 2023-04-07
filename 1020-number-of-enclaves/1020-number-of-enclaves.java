class Solution {
    int ans=0;
    int count=0;
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    if(dfs(grid,i,j,visited,m,n)){
                        ans+=count;
                        
                        //System.out.println(i+" "+j);
                    }
                    visited[i][j]=true;
                    count=0;
                }
               
            }
        }
        return ans;
    }
    public boolean dfs(int grid[][],int i,int j,boolean visited[][],int m,int n){
        if(i<0||j<0||i==m||j==n)
            return false;
        if(grid[i][j]==0||visited[i][j])
            return true;
        visited[i][j]=true;
        count++;
        boolean a1=dfs(grid,i+1,j,visited,m,n);
        boolean a2=dfs(grid,i-1,j,visited,m,n);
        boolean a3=dfs(grid,i,j+1,visited,m,n);
        boolean a4=dfs(grid,i,j-1,visited,m,n);
        return a1&&a2&&a3&&a4;
    }
}