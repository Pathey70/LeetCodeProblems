
class Solution {
    HashMap<String,Integer> hm=new HashMap<String,Integer>();
    HashMap<String,Integer> hm1=new HashMap<String,Integer>();
    HashMap<String,Integer> hm2=new HashMap<String,Integer>();
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
        /*boolean end=false;
        for(int i=0;i<wordList.size();i++)
        {
            int d=calculateDistance(wordList.get(i),endWord);
            if(d==0)
            {
                end=true;
                hm.put(wordList.get(i),Integer.MAX_VALUE);
                hm1.put(wordList.get(i),d);
                hm2.put(wordList.get(i),Integer.MAX_VALUE);
            }
            else
            {
                //List<Integer> li=new ArrayList<Integer>();
                //li.add(d);
                //li.add(Integer.MAX_VALUE)
                hm.put(wordList.get(i),Integer.MAX_VALUE);
                hm1.put(wordList.get(i),d);
                hm2.put(wordList.get(i),Integer.MAX_VALUE);
            }
        }
        hm.put(beginWord,Integer.MAX_VALUE);
        hm1.put(beginWord,calculateDistance(beginWord,endWord));
        hm2.put(beginWord,Integer.MAX_VALUE);
        if(end)
        {
            int ans=findMinPath(beginWord,endWord,wordList,0);
            if(ans==Integer.MAX_VALUE)
            {
                return 0;
            }
            else{
                return ans;
            }
        }
        else
        {
            return 0;
        }*/
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
                    int[] next={i,node[1]+1};
                    queue.add(next);
                }
            }
        }
        return 0;
    }
    /*public int findMinPath(String beginWord,String endWord,List<String> wordList,int level)
    {
        if(beginWord.equals(endWord))
        {
            return level;
        }
        int min=Integer.MAX_VALUE;
        int d=hm1.get(beginWord);
        for(int i=0;i<wordList.size();i++)
        {
            String word=wordList.get(i);
            if(calculateDistance(word,beginWord)==1)
            {
                
                    if(hm.get(word)>level)
                    {
                        if(hm2.get(word)==Integer.MAX_VALUE&&hm.get(word)!=Integer.MAX_VALUE)
                        {
                            
                        }
                        else
                        {
                                hm.put(word,level+1);
                                int t1=findMinPath(word,endWord,wordList,level+1);
                                hm2.put(word,t1);
                                if(t1<min)
                                {
                                    min=t1;
                                }
                            
                        
                        }
                    }
                
            }
        }
        return min;
        
    }*/
}