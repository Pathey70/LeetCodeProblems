class Solution {
    public long countPairs(int n, int[][] edges) {
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            rank[i]=1;
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            union(edges[i][0],edges[i][1],parent,rank);
        }
        List<Integer> componentSizes=new ArrayList<>();
        long sum=n;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                componentSizes.add(rank[i]);
            }
        }
        long ans=0;
        for(int i=0;i<componentSizes.size();i++){
            ans+=(sum-componentSizes.get(i))*(componentSizes.get(i));
        }
        return ans/2;
    }
    public int findParent(int x1,int parent[]){
        if(parent[x1]==x1){
            return x1;
        }
        parent[x1]=findParent(parent[x1],parent);
        return parent[x1];
    }
    public void union(int x1,int x2,int parent[],int rank[]){
        int p1=findParent(x1,parent);
        int p2=findParent(x2,parent);
        if(p1!=p2){
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
}