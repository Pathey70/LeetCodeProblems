class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dp[i][j]=0;
                    Queue<List<Integer>> queue=new LinkedList<>();
                    queue.add(convert(i,j));
                    while(!queue.isEmpty()){
                        List<Integer> state=queue.poll();
                        List<List<Integer>> nextStates=expand(state,dp,n);
                        for(List<Integer> nextState:nextStates){
                            queue.add(nextState);
                        }
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }
        if(ans==0||ans==Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    public List<Integer> convert(int i,int j){
        List<Integer> li=new ArrayList<>();
        li.add(i);
        li.add(j);
        return li;
    }
    public List<List<Integer>> expand(List<Integer> state,int dp[][],int n){
        int x1=state.get(0);
        int y1=state.get(1);
        List<List<Integer>> nextStates=new ArrayList<>();
        if(x1+1<n&&dp[x1+1][y1]>dp[x1][y1]+1){
            dp[x1+1][y1]=1+dp[x1][y1];
            nextStates.add(convert(x1+1,y1));
        }
        if(x1-1>=0&&dp[x1-1][y1]>dp[x1][y1]+1){
            dp[x1-1][y1]=1+dp[x1][y1];
            nextStates.add(convert(x1-1,y1));
        }
        if(y1+1<n&&dp[x1][y1+1]>dp[x1][y1]+1){
            dp[x1][y1+1]=1+dp[x1][y1];
            nextStates.add(convert(x1,y1+1));
        }
        if(y1-1>=0&&dp[x1][y1-1]>dp[x1][y1]+1){
            dp[x1][y1-1]=1+dp[x1][y1];
            nextStates.add(convert(x1,y1-1));
        }
        return nextStates;
    }
}