class Solution {
    long ans = 0; int s;
    
    private int dfs(int i, int prev, List<List<Integer>> graph) {
        int people = 1;
        for (int x: graph.get(i)) {
            if (x == prev) continue;
            people += dfs(x, i, graph);
        }
        if (i != 0) ans += (people + s - 1) / s;
        return people;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList(); s = seats;
        for (int i = 0; i < roads.length + 1; i++) graph.add(new ArrayList());
        for (int[] r: roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        dfs(0, 0, graph);
        return ans;
    }
}
   /* public long minimumFuelCost(int[][] roads, int seats) {
        int n=roads.length+1;
        int graph[][]=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                graph[i][j]=-1;
            }
        }
        for(int i=0;i<n-1;i++){
            int x1=roads[i][0];
            int x2=roads[i][1];
             for(int j=0;j<3;j++){
                if(graph[x1][j]==-1){
                    graph[x1][j]=x2;
                    break;
                }
            }
            for(int j=0;j<3;j++){
                if(graph[x2][j]==-1){
                    graph[x2][j]=x1;
                    break;
                }
            }
        }
        long ans[]=dfsPostOrder(0,graph,seats,-1);
        //System.out.println(ans[1]);
        return ans[2]-ans[1];
    }
    public long[] dfsPostOrder(int index,int[][] graph,int seats,int p){
        long ans[]=new long[3];
        int adj[]=graph[index];
        for(int i=0;i<3;i++){
            if(adj[i]!=-1&&adj[i]!=p){
                long t1[]=dfsPostOrder(adj[i],graph,seats,index);
                for(int j=0;j<3;j++){
                    ans[j]+=t1[j];
                }
            }
        }
        ans[0]++;
        ans[1]=(long)Math.ceil((1.0*ans[0])/seats);
        ans[2]+=ans[1];
        return ans;
    }
}*/
