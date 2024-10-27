class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        int i=0;
        int j=0;
        if(Math.abs(s.length()-t.length())>1)
            return false;
        boolean opDone=false;
        while(i<s.length()&&j<t.length())
        {
            char c1=s.charAt(i);
            char c2=t.charAt(j);
            if(c1!=c2)
            {
                if(opDone)
                    return false;
                opDone=true;
                if(s.length()>t.length())
                {
                    j--;
                }
                else if(t.length()>s.length()){
                    i--;
                }
            }
            i++;
            j++;
        }
        if(opDone)
        {
            if(i==s.length()&&j==t.length())
                return true;
            else
                return false;
        }
        else{
            if(s.length()-i==1||t.length()-j==1)
                return true;
            else
                return false;
        }
        //return true;
    }
}