class Solution {
    public boolean rotateString(String s, String goal) {
        
        for(int i=0;i<s.length();i++)
        {
            String s1=s.substring(0,i);
            String s2=s.substring(i);
            if((s2+s1).equals(goal))
                return true;
        }
        return false;
    }
}