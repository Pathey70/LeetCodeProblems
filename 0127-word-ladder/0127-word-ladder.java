
class Solution {
    public boolean calculateDistance(String s1,String s2)
    {
        int count=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
            if(count>1)
                return false;
        }
        return count==1 ? true : false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
   
        wordList.add(beginWord);
        //wordList.add(endWord);
        int n=wordList.size();
        int end=-1;
        List<List<Integer>> graph=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            List<Integer> li=new ArrayList<>();
            graph.add(li);
        }
        for(int i=0;i<n;i++){
            String s2=wordList.get(i);
            if(s2.equals(endWord))
                end=i;
            for(int j=i+1;j<n;j++){
                String s1=wordList.get(j);
                
                if(calculateDistance(s1,s2)){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        Queue<int[]> queue=new LinkedList<>();
        int start[]={n-1,0};
        queue.add(start);
        boolean visited[]=new boolean[n];
        while(!queue.isEmpty())
        {
            int[] node=queue.poll();
            if(node[0]==end)
                return node[1]+1;
            if(!visited[node[0]]){
                visited[node[0]]=true;
                List<Integer> li=graph.get(node[0]);
                for(Integer i:li){
                    if(!visited[i]){
                        int[] next={i,node[1]+1};
                        queue.add(next);
                    }
                }
            }
        }
        return 0;
    }
   
}