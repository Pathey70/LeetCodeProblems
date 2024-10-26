class Solution {
    int parent[];
    int rank[];
    int min[];
    public int minScore(int n, int[][] roads) {
        parent=new int[n+1];
        rank=new int[n+1];
        min=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
            min[i]=Integer.MAX_VALUE;
        }
        
        for(int i=0;i<roads.length;i++){
            int c1=roads[i][0];
            int c2=roads[i][1];
            int c3=roads[i][2];
            int p=union(c1,c2);
            min[p]=Math.min(min[p],c3);
        }
        int x1=findP(n);
        return min[x1];
        
    }
    public int union(int x1,int x2){
        int t1=findP(x1);
        int t2=findP(x2);
        if(rank[t1]>=rank[t2]){
            parent[t2]=t1;
            rank[t1]+=rank[t2];
            min[t1]=Math.min(min[t1],min[t2]);
            return t1;
        }else{
            parent[t1]=t2;
            rank[t2]+=rank[t1];
            min[t2]=Math.min(min[t1],min[t2]);
            return t2;
        }
    }
    public int findP(int x1){
        if(parent[x1]==x1)
            return x1;
        else
        {
            return findP(parent[x1]);
            
            //return parent[x1];
        }
    }
}