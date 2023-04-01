class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        HashMap<String,String> parent=new HashMap<>();
        HashMap<String,Integer> rank=new HashMap<>();
        for(List<String> pair:similarPairs){
            String s1=pair.get(0);
            String s2=pair.get(1);
            if(!parent.containsKey(s1)){
                parent.put(s1,s1);
                rank.put(s1,1);
            }
            if(!parent.containsKey(s2)){
                parent.put(s2,s2);
                rank.put(s2,1);
            }
            union(s1,s2,parent,rank);
        }
        if(sentence1.length!=sentence2.length)
            return false;
        for(int i=0;i<sentence1.length;i++){
            String s1=sentence1[i];
            String s2=sentence2[i];
            if(!findParent(s1,parent).equals(findParent(s2,parent))){
                return false;
            }
        }
        return true;
    }
    public void union(String s1,String s2,HashMap<String,String> parent,HashMap<String,Integer> rank){
        String p1=findParent(s1,parent);
        String p2=findParent(s2,parent);
        if(p1.equals(p2))
            return;
        int r1=rank.get(p1);
        int r2=rank.get(p2);
        if(r1>=r2){
            rank.put(p1,r1+r2);
            parent.put(p2,p1);
        }else{
            rank.put(p2,r1+r2);
            parent.put(p1,p2);
        }
    }
    public String findParent(String s,HashMap<String,String> parent){
        if(parent.getOrDefault(s,s).equals(s))
            return s;
        else{
            String p=findParent(parent.get(s),parent);
            parent.put(s,p);
            return p;
        }
    }
}