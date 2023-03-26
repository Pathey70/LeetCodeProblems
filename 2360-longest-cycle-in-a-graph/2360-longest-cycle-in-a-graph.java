class Solution {
    int cLen=-1;
    boolean cycleSeen[];
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean[] visited=new boolean[n];
        cycleSeen=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                HashMap<Integer,Integer> hm=new HashMap<>();
                //System.out.println(i);
                dfs(i,edges,hm,visited,0);
            }
        }
        return cLen;
    }
    public void dfs(int i,int[] edges,HashMap<Integer,Integer> hm,boolean visited[],int len){
        if(i==-1||cycleSeen[i])
            return;
        if(hm.containsKey(i))
        {
            cLen=Math.max(cLen,len-hm.get(i));
            for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
                int key=entry.getKey();
                cycleSeen[key]=true;
            }
            return;
        }
        hm.put(i,len);
        visited[i]=true;
        dfs(edges[i],edges,hm,visited,len+1);
    }
}