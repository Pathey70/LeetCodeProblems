class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int timeTaken[][]=new int[n+1][2];
        List<List<Integer>> graph=new ArrayList<List<Integer>>();
        for(int i=0;i<=n;i++)
        {
            timeTaken[i][0]=Integer.MAX_VALUE;
            timeTaken[i][1]=Integer.MAX_VALUE;
            List<Integer> li=new ArrayList<Integer>();
            graph.add(li);
        }        
        for(int i=0;i<edges.length;i++)
        {
            int s=edges[i][0];
            int d=edges[i][1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>(new Comparator<List<Integer>>(){
            public int compare(List<Integer> l1,List<Integer> l2)
            {
                return Integer.compare(l1.get(0),l2.get(0));
            }
        });
        List<Integer> start=new ArrayList<>();
        start.add(0);
        start.add(1);
        pq.add(start);
        while(timeTaken[n][1]==Integer.MAX_VALUE&&!pq.isEmpty())
        {
            List<Integer> li=pq.poll();
            int node=li.get(1);
            int currentTime=li.get(0);
            //System.out.println(li);
            if(currentTime<timeTaken[node][0])
            {
                timeTaken[node][1]=timeTaken[node][0];
                timeTaken[node][0]=currentTime;
            } else if(currentTime<timeTaken[node][1]&&currentTime!=timeTaken[node][0])
            {
                timeTaken[node][1]=currentTime;
            }
            else{
                continue;
            }
            List<Integer> l1=graph.get(node);
            int goTime=giveGoTime(change,currentTime);
            for(Integer i:l1)
            {
                List<Integer> temp=new ArrayList<>();
                temp.add(goTime+time);
                temp.add(i);
                pq.add(temp);
                //System.out.println(time);
            }   
        }
        return timeTaken[n][1];
    }
    /*public void dfs(int node,List<List<Integer>> graph,int n,int time,int change,int currentTime,int timeTaken[][])
    {
        if(currentTime<timeTaken[node][0])
        {
            timeTaken[node][1]=timeTaken[node][0];
            timeTaken[node][0]=currentTime;
        }else if(currentTime<timeTaken[node][1]&&currentTime!=timeTaken[node][0])
        {
            timeTaken[node][1]=currentTime;
        }
        else{
            //Not first or second best time so not useful to explore or do cycle.
            return;
        }
        //System.out.println(node+"  "+currentTime);
        List<Integer> li=graph.get(node);
        int goTime=giveGoTime(change,currentTime);
        for(Integer i:li)
        {
            dfs(i,graph,n,time,change,goTime+time,timeTaken);
        }
    }*/
    public int giveGoTime(int change,int currentTime)
    {
        int d=currentTime/change;
        if(d%2==0)
            return currentTime;
        else 
            return change*(d+1);
    }
}