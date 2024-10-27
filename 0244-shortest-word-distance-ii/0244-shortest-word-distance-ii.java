class WordDistance {

    HashMap<String,List<Integer>> hm;
    public WordDistance(String[] wordsDict) {
        hm=new HashMap<>();
        for(int i=0;i<wordsDict.length;i++)
        {
            if(!hm.containsKey(wordsDict[i]))
            {
                hm.put(wordsDict[i],new ArrayList<Integer>());
            }
            hm.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> li1=hm.get(word1);
        List<Integer> li2=hm.get(word2);
        int i=0;int j=0;
        int min=Integer.MAX_VALUE;
        while(i<li1.size()&&j<li2.size())
        {
            int diff=li1.get(i)-li2.get(j);
            if(diff>0)
            {
                j++;
            }else{
                i++;
            }
            min=Math.min(min,Math.abs(diff));
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */