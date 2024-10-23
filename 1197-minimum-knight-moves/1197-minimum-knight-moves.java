class Solution {
    public int minKnightMoves(int x, int y) {
        HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
        Queue<int[]> queue=new LinkedList<>();
        int start[]={0,0,0};
        queue.add(start);
        int moves[]={-1,1};
        int moves1[]={-2,2};
        while(!queue.isEmpty())
        {
            int elem[]=queue.poll();
            int x1=elem[0];
            int y1=elem[1];
            if(x1==x&&y1==y)
                return elem[2];
            if(!hm.containsKey(x1))
                hm.put(x1,new HashSet<>());
            else if(hm.get(x1).contains(y1))
                continue;
            hm.get(x1).add(y1);
            for(int i=0;i<moves.length;i++)
            {
                for(int j=0;j<moves.length;j++)
                {
                    int x2=x1+moves[i];
                    int y2=y1+moves1[j];
                    int x3=x1+moves1[i];
                    int y3=y1+moves[j];
                    int next1[]={x2,y2,elem[2]+1};
                    int next2[]={x3,y3,elem[2]+1};
                    queue.add(next1);
                    queue.add(next2);
                }
            }
        }
        
        return -1;
    }
}