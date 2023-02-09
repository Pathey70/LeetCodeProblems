class Solution {
    public long distinctNames(String[] ideas) {
       /* HashSet<String> hs=new HashSet<String>();
        int dp[]=new int[26];
        for(int i=0;i<ideas.length;i++)
        {
            hs.add(ideas[i]);
            dp[(int )ideas[i].charAt(0)-97]++;
        }
        long n=ideas.length;
        long ans=(n)*(n-1);
        for(int i=0;i<ideas.length;i++)
        {
            int p1=(int )ideas[i].charAt(0)-97;
            for(int j=0;j<26;j++)
            {
                if(dp[j]==0)
                    continue;
                if(j==p1)
                {
                    ans=(ans-dp[j]+1);   
                }
                else
                {
                    String s1=Character.toString((char)(j+97))+ideas[i].substring(1);
                    if(hs.contains(s1))
                    {
                        System.out.println("found");
                        ans=(ans-dp[j]);
                    }
                }
                
            }
           // dp[(int )ideas[i].charAt(0)-97][idea[i].length()-1]++;
        }
        return ans;*/
        List<HashSet<String>> map=new ArrayList<>();
        for(int i=0;i<26;i++){
            map.add(new HashSet<String>());
        }
        for(String idea:ideas){
            int prefix=(int)idea.charAt(0)-97;
            String suffix=idea.substring(1);
            HashSet<String> hs=map.get(prefix);
            hs.add(suffix);
        }
        long ans=0;
        for(int i=0;i<map.size();i++){
            HashSet<String> hs=map.get(i);
            for(int j=i+1;j<map.size();j++){
                HashSet<String> hs1=map.get(j);
                int count=0;
                for(String s:hs){
                    if(hs1.contains(s)){
                        count++;
                    }
                }
                ans+=2*(hs.size()-count)*(hs1.size()-count);
            }
        }
        
        return ans;
    }
}