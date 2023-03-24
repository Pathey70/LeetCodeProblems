class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean visited[]=new boolean[n];
        List<List<Integer>> to=new ArrayList<List<Integer>>();
        List<List<Integer>> from=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            List<Integer> l1=new ArrayList<>();
            List<Integer> l2=new ArrayList<>();
            to.add(l1);
            from.add(l2);
        }
        for(int i=0;i<connections.length;i++){
            int destination=connections[i][0];
            int source=connections[i][1];
            to.get(source).add(destination);
            from.get(destination).add(source);
        }
       // System.out.println(to+" "+from);
        Queue<Integer> queue=new LinkedList<>();
        int ans=0;
        int visitedCount=0;
        queue.add(0);
        while(visitedCount<n&&!queue.isEmpty()){
            int city=queue.poll();
            List<Integer> l1=to.get(city);
            List<Integer> l2=from.get(city);
            visited[city]=true;
            visitedCount++;
            for(Integer i:l1){
                if(!visited[i])
                {
                    queue.add(i);
                }
            }
            for(Integer i:l2){
                if(!visited[i]){
                    queue.add(i);
                    ans++;
                }
            }
        }
        return ans;
    }
}