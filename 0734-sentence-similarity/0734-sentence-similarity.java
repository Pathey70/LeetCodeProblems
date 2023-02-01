class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        HashMap<String,HashSet<String>> hm=new HashMap<>();
        for(List<String> li:similarPairs){
            String s1=li.get(0);
            String s2=li.get(1);
            HashSet<String> hs1=hm.getOrDefault(s1,new HashSet<String>());
            HashSet<String> hs2=hm.getOrDefault(s2,new HashSet<String>());
            hs1.add(s2);
            hs2.add(s1);
            hm.put(s1,hs1);
            hm.put(s2,hs2);
        }
        if(sentence1.length!=sentence2.length)
            return false;
        for(int i=0;i<sentence1.length;i++){
            String s1=sentence1[i];
            String s2=sentence2[i];
            if(!s1.equals(s2)&&!hm.getOrDefault(s1,new HashSet<String>()).contains(s2)){
                return false;
            }
        }
        return true;
    }
}