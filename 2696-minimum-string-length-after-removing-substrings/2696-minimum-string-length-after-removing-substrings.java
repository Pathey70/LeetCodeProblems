class Solution {
    public int minLength(String s) {
        
        while(s.indexOf("AB")!=-1||s.indexOf("CD")!=-1)
        {
            if(s.indexOf("AB")!=-1)
            {
                s=s.substring(0,s.indexOf("AB"))+s.substring(s.indexOf("AB")+2,s.length());
            }
            if(s.indexOf("CD")!=-1)
            {
                s=s.substring(0,s.indexOf("CD"))+s.substring(s.indexOf("CD")+2,s.length());
            }
        }
        return s.length();
        
    }
}