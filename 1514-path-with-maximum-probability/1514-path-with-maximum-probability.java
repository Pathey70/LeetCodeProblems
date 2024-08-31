class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<List<Double>> pq=new PriorityQueue<>((a,b)->Double.compare(b.get(0),a.get(0)));
        List<HashMap<Integer,Double>> graph=new ArrayList<>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            HashMap<Integer,Double> hm=new HashMap<>();
            graph.add(hm);
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int s=edges[i][0];
            int d=edges[i][1];
            double w=succProb[i];
            graph.get(s).put(d,w);
            graph.get(d).put(s,w);
        }
        List<Double> start=new ArrayList<>();
        start.add(1.0);
        start.add((double)start_node);
        pq.add(start);
        while(!pq.isEmpty())
        {
            List<Double> node=pq.poll();
            double w=node.get(0);
            double s1=node.get(1);
            int s=(int )s1;
            visited[s]=true;

            if(s==end_node)
                return w;
            HashMap<Integer,Double> edge=graph.get(s);
            for(Map.Entry<Integer,Double> entry:edge.entrySet())
            {
                if(!visited[entry.getKey()])
                {
                    List<Double> newNode=new ArrayList<>();
                    newNode.add(w*entry.getValue());
                    newNode.add((double)entry.getKey());
                    
                    pq.add(newNode);
                }
            }
        }
        return 0.0; 
    }
}