class Solution {
    public int shortestDistance(int[][] grid) {
       
        int n=grid.length;
        int m=grid[0].length;
        long dp[][]=new long[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int temp[][]=new int[n][m];
                    for(int k=0;k<n;k++)
                    {
                        for(int l=0;l<m;l++)
                        {
                            temp[k][l]=10000;
                        }
                    }
                    Queue<int[]> queue=new LinkedList<>();
                    int start[]={i,j,0};
                    queue.add(start);
                    int state1[]={i-1,j,1};
                    int state2[]={i,j-1,1};
                    int state3[]={i+1,j,1};
                    int state4[]={i,j+1,1};
                    queue.add(state1);
                    queue.add(state2);
                    queue.add(state3);
                    queue.add(state4);
                    while(!queue.isEmpty())
                    {
                        int state[]=queue.poll();
                        int x=state[0];
                        int y=state[1];
                        int steps=state[2];
                        //System.out.println(x+" "+y+" "+steps);
                        if(x<0||y<0||x==n||y==m||grid[x][y]>0||temp[x][y]<=steps){
                            continue;
                        }
                        //System.out.println("Here");
                        temp[x][y]=steps;
                        int state11[]={x-1,y,steps+1};
                        int state22[]={x,y-1,steps+1};
                        int state33[]={x+1,y,steps+1};
                        int state44[]={x,y+1,steps+1};
                        queue.add(state11);
                        queue.add(state22);
                        queue.add(state33);
                        queue.add(state44);
                    }
                    for(int k=0;k<n;k++)
                    {
                        for(int l=0;l<m;l++)
                        {
                            //System.out.println(temp[k][l]);
                            dp[k][l]+=temp[k][l];
                        }
                    }
                }
            }
        }
        long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //System.out.print(dp[i][j]+" ");
                min=Math.min(dp[i][j],min);
            }
            //System.out.println();
        }
        if(min>=10000)
            return -1;
        return (int)min;
    }
}