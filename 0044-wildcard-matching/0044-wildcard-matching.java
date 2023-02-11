class Solution {
    HashMap<String,Boolean> hm;
    public boolean isMatch(String s, String p) {
        hm=new HashMap<>();
        return match(s,p,0,0);
    }
    public boolean match(String s,String p,int i,int j){
        if(i==s.length()&&j==p.length())
            return true;
        if(i==s.length())
        {
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*')
                    return false;
            }
            return true;
        }
        if(j==p.length())
            return false;
        String st=convert(i,j);
        if(hm.containsKey(st))
            return hm.get(st);
        boolean ans=false;
        if(p.charAt(j)=='?')
            ans=match(s,p,i+1,j+1);
        else if(p.charAt(j)=='*')
            ans=match(s,p,i+1,j+1)||match(s,p,i,j+1)||match(s,p,i+1,j);
        else 
            ans=(s.charAt(i)==p.charAt(j))&&match(s,p,i+1,j+1);
        hm.put(st,ans);
        return ans;
    }
    public String convert(int i,int j){
        return Integer.toString(i)+" "+Integer.toString(j);
    }
}