class Solution {
    int ans=0;
    public int uniquePathsIII(int[][] grid) {
        int startX=0;
        int startY=0;
        int endX=0;
        int endY=0;
        int t=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                startX=i;
                startY=j;
                t++;
            }
            if(grid[i][j]==2){
                endX=i;
                endY=j;
            }
            if(grid[i][j]==0)
                t++;
            }
        }
        boolean visited[][]=new boolean[m][n];
        dfs(grid,startX,startY,endX,endY,visited,0,m,n,t);
        return ans;
        
    }
    public void dfs(int[][] grid,int x,int y,int endX,int endY,boolean visited[][],int o,int m,int n,int t)
    {
        if(x<0||y<0||x==m||y==n||visited[x][y]||grid[x][y]==-1)
            return;
        if(x==endX&&y==endY&&o==t)
        {
            ans++;
            return;
        }
        visited[x][y]=true;
        dfs(grid,x-1,y,endX,endY,visited,o+1,m,n,t);
        dfs(grid,x+1,y,endX,endY,visited,o+1,m,n,t);
        dfs(grid,x,y-1,endX,endY,visited,o+1,m,n,t);
        dfs(grid,x,y+1,endX,endY,visited,o+1,m,n,t);
        visited[x][y]=false;
        
    }
}