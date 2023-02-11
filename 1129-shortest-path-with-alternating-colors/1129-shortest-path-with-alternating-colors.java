class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer,HashSet<Integer>> redGraph=new HashMap<>();
        HashMap<Integer,HashSet<Integer>> blueGraph=new HashMap<>();
        for(int i=0;i<redEdges.length;i++){
            int s=redEdges[i][0];
            int d=redEdges[i][1];
            HashSet<Integer> hs=redGraph.getOrDefault(s,new HashSet<Integer>());
            hs.add(d);
            redGraph.put(s,hs);
        }
        for(int i=0;i<blueEdges.length;i++){
            int s=blueEdges[i][0];
            int d=blueEdges[i][1];
            HashSet<Integer> hs=blueGraph.getOrDefault(s,new HashSet<Integer>());
            hs.add(d);
            blueGraph.put(s,hs);
        }
        int ans[]=new int[n];
        for(int i=1;i<n;i++){
            ans[i]=-1;
        }
        Queue<List<Integer>> queue=new LinkedList<>();
        boolean red[]=new boolean[n];
        boolean blue[]=new boolean[n];
        for(Integer i:redGraph.getOrDefault(0,new HashSet<Integer>())){
            queue.add(convert(i,1,0));
        }
        for(Integer i:blueGraph.getOrDefault(0,new HashSet<Integer>())){
             queue.add(convert(i,1,1));
        }
        while(!queue.isEmpty()){
            List<Integer> node=queue.poll();
            int src=node.get(0);
            int steps=node.get(1);
            int color=node.get(2);
            if(ans[src]==-1||ans[src]>steps)
            {
                ans[src]=steps;
            }
            if(color==1)
            {   
                blue[src]=true;
                for(Integer i:redGraph.getOrDefault(src,new HashSet<Integer>())){
                    if(!red[i]){
                        queue.add(convert(i,steps+1,0)); 
                    }
                }
            }
            else
            {
                red[src]=true;
                for(Integer i:blueGraph.getOrDefault(src,new HashSet<Integer>())){
                    if(!blue[i]){
                        queue.add(convert(i,steps+1,1)); 
                    }
                }
            }
            
        }
        return ans;
    }
    public List<Integer> convert(int a,int b,int c){
        List<Integer> li=new ArrayList<>();
        li.add(a);
        li.add(b);
        li.add(c);
        return li;
    }
}