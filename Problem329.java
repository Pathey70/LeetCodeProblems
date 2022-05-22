public class Problem329 {
    public int longestIncreasingPath(int[][] matrix) {
        
        
        
        
        int dp[][]=new int[matrix.length][matrix[0].length];
        int startx=0;
        int starty=0;
        int max1=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                
                dp[i][j]=1;
            }
            
        }
        int max=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                
                dp[i][j]=findLongestPath(matrix,i,j,dp);
                max=Math.max(dp[i][j],max);
            }
            
        }
        //System.out.println(startx+" "+starty);
        
    
        return max;
        
    }
    public int findLongestPath(int[][] matrix,int startx,int starty,int[][] dp)
    {
        int a1=1,a2=1,a3=1,a4=1;
        //System.out.println(startx+" "+starty);
        if(startx-1>=0&&matrix[startx][starty]>matrix[startx-1][starty])
        {
            if(dp[startx-1][starty]==1)
                a1=1+findLongestPath(matrix,startx-1,starty,dp);   
            else
                a1=1+dp[startx-1][starty];
        }
        if(startx+1<matrix.length&&matrix[startx][starty]>matrix[startx+1][starty])
        {
            if(dp[startx+1][starty]==1)
                a2=1+findLongestPath(matrix,startx+1,starty,dp);  
            else
                a2=1+dp[startx+1][starty];
        }
        if(starty-1>=0&&matrix[startx][starty]>matrix[startx][starty-1])
        {
            if(dp[startx][starty-1]==1)
                a3=1+findLongestPath(matrix,startx,starty-1,dp);     
            else
                a3=1+dp[startx][starty-1];
        }
        if(starty+1<matrix[0].length&&matrix[startx][starty]>matrix[startx][starty+1])
        {
            if(dp[startx][starty+1]==1)
                a4=1+findLongestPath(matrix,startx,starty+1,dp);
            else
                a4=1+dp[startx][starty+1];
            
        }
        return Math.max(Math.max(a1,a2),Math.max(a3,a4));
        //return dp[startx][starty];
        
    }
    
}