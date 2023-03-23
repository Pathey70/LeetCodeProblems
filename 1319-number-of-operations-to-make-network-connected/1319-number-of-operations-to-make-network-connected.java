class Solution {
    int parent[];
    int rank[];
    int spare=0;
    public int makeConnected(int n, int[][] connections) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<connections.length;i++){
            unionByRank(connections[i][0],connections[i][1]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)
                count++;
        }
        return spare>=count-1? count-1 : -1;
    }
    public void unionByRank(int x1,int x2){
        int p1=findParent(x1);
        int p2=findParent(x2);
        if(p1==p2)
            spare++;
        else{
            if(rank[p1]>=rank[p2]){
                parent[p2]=p1;
                rank[p1]+=rank[p2];
            }
            else{
            parent[p1]=p2;
            rank[p2]+=rank[p1];
            }
        }
    }
    public int findParent(int x){
        if(x==parent[x])
            return x;
        else
        {
            parent[x]=findParent(parent[x]);
            return parent[x];
        }
    }
}