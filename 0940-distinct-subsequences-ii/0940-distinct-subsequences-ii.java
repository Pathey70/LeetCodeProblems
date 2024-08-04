class Solution {
    public int distinctSubseqII(String s) {
        HashMap<Character,Long> hm=new HashMap<>();
        long ans=0;
        int mod=(int)1e9+7;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            long prev=hm.getOrDefault(c,0l);
            long append=(ans-prev+1)%mod;
            ans+=append;
            ans%=mod;
            hm.put(c,append+prev);
        }
        return (int)(ans+mod)%mod;
    }
}