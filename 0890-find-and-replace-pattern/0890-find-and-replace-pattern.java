class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<String>();
        for(String word:words){
            HashMap<Character,Character> hm=new HashMap<>();
            HashMap<Character,Character> hm1=new HashMap<>();
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                char c0=pattern.charAt(i);
                char c1=word.charAt(i);
                if(c1!=hm.getOrDefault(c0,c1)||c0!=hm1.getOrDefault(c1,c0))
                {
                    flag=false;
                    break;
                }
                hm1.put(c1,c0);
                hm.put(c0,c1);
            }
            if(flag)
                ans.add(word);
        }
        return ans;
    }
}